package main.java.com.vavrinchuk.bancor.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionObject;
import org.web3j.protocol.http.HttpService;

import main.java.com.vavrinchuk.bancor.common.dao.TokenDAOService;
import main.java.com.vavrinchuk.bancor.common.entity.TransferEvent;
import main.java.com.vavrinchuk.bancor.common.interfaces.ITokenController;
import main.java.com.vavrinchuk.bancor.common.statistic.FileGenerator;
import main.java.com.vavrinchuk.bancor.wrappers.SmartToken;

public class TokenController implements ITokenController{
	private static final String LOCALHOST = "http://localhost:8545";
	private static final String CONTRACT_ADDRESS = "0x1F573D6Fb3F13d689FF844B4cE37794d79a7FF1C".toLowerCase();
	private static final String PASSWORD = "149814981498a";
	private static final String PATH_TO_WALLET_FILE = "/home/eduard/.ethereum/keystore/"
			+ "UTC--2017-12-14T09-06-23.506887741Z--8ec7cd3d03b8366f93995d5e2d3a1206180822ac";
	private static final Logger logger = Logger.getLogger(TokenController.class.getName());
	
	
 	private Web3j web3j;
 	private Credentials credentials;
	private SmartToken token;	
		
	private static final long START_BLOCK = 4225068L;
	private static final long END_BLOCK = 4730830L;
		
	private static TokenDAOService tokenDAOService = new TokenDAOService();	
		
	public void setWeb3j() {
		web3j = Web3j.build(new HttpService(LOCALHOST));
	}
		
	public void setCredentials() {
		try {
			credentials = WalletUtils.loadCredentials(PASSWORD, PATH_TO_WALLET_FILE);
		} catch (IOException | CipherException e) {
			logger.log(Level.SEVERE, "ERROR! Credentials was not loaded !\n" + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
		
	public void loadContract() {
		token = SmartToken.load(CONTRACT_ADDRESS, web3j, credentials, SmartToken.GAS_PRICE, SmartToken.GAS_LIMIT);
	}
		
	public void loadTransactions() {
		logger.info("Start of transactions downloading");
		web3j.replayBlocksObservable(
			new DefaultBlockParameterNumber(START_BLOCK), 
			new DefaultBlockParameterNumber(END_BLOCK), 
			true)
			.doOnError(TokenController::logError)
			.doOnCompleted(TokenController::generateFile)
			.subscribe(block -> {
				block.getBlock()
					.getTransactions()
					.stream()
					.map(transaction -> TransactionObject.class.cast(transaction))
					.filter(transaction -> CONTRACT_ADDRESS.equals(transaction.getTo()) || CONTRACT_ADDRESS.equals(transaction.getFrom()))
					.forEach(transaction -> {
						logger.info("Remain blocks: " + (END_BLOCK - transaction.getBlockNumber().longValue()));
						web3j.ethGetTransactionReceipt(transaction.getHash())
							.sendAsync()
							.thenAccept(transactionReceipt -> {
								token.getTransferEvents(transactionReceipt.getResult())
									.forEach(event -> {
										TransferEvent transferEvent = new TransferEvent();
										transferEvent.setReceiver(event._to.getValue().toString());
										transferEvent.setSender(event._from.getValue().toString());
										transferEvent.setValue(event._value.getValue().doubleValue());
										transferEvent.setBlockNumber(transactionReceipt.getResult().getBlockNumber().longValue());
										transferEvent.setTransactionHash(transactionReceipt.getResult().getTransactionHash());
										transferEvent.setContractAddress(transactionReceipt.getResult().getContractAddress());
										transferEvent.setCreationDate(new Timestamp(block.getBlock().getTimestamp().longValue() * 1000));
										tokenDAOService.insert(transferEvent);
									});
								
							});
					});
			});
	}
	
	public static void generateFile() {	
		FileGenerator fileGenerator = new FileGenerator();
		boolean response = fileGenerator.generateFile(tokenDAOService.ShowAll());
		
		if(response == true) {
			logger.info("File generated.");
		}
	}	
	public static void logError(Throwable throwable) {
		logger.log(Level.SEVERE, "Error during transactions loading\n" + throwable.getMessage());
		throwable.getStackTrace();
	}	
}
