package main.java.com.vavrinchuk.bancor.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jtemplate.sql.Parameters;

import main.java.com.vavrinchuk.bancor.common.entity.TransferEvent;
import main.java.com.vavrinchuk.bancor.common.interfaces.ITokenDAOService;

public class TokenDAOService implements ITokenDAOService{
	private static final String QUERY_SELECT_ALL ="SELECT * FROM transfer_event";
	private static final String QUERY_INSERT ="INSERT INTO transfer_event(receiver, sender, value, block_number, transaction_hash, contract_address, creation_date)"
			+ "VALUES(:receiver, :sender, :value, :blockNumber, :transactionHash, :contractAddress, :creationDate)";
	
	private static final String URL = "jdbc:mysql://localhost:3306/bancor_token";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "0905";
	private static final Logger logger = Logger.getLogger(TokenDAOService.class.getName());
	
	private static Connection connection;	
	
	public TokenDAOService() {
		setConnection();
	}
	
	private static void setConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				logger.log(Level.SEVERE, "ERROR! Connection to DB failed\n" + e.getMessage());
				e.getStackTrace();
			}
	}
	
	@Override
	public List<TransferEvent> ShowAll(){
		try {
			List<TransferEvent> transferEvenList = new ArrayList<>();
			PreparedStatement statement = connection.prepareStatement(QUERY_SELECT_ALL);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				transferEvenList.add(TransferEvent.getTransferEvent(resultSet));
			}
			
			return transferEvenList;
		}catch (SQLException e){
			logger.log(Level.SEVERE, "Error during getting data from DB\n" + e.getMessage());
			e.getStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Integer insert(TransferEvent transferEvent) {
		try {
			Parameters parameters = Parameters.parse(QUERY_INSERT);
			PreparedStatement preparedStatement = connection.prepareStatement(parameters.getSQL(), Statement.RETURN_GENERATED_KEYS);
			
			parameters.put("receiver", transferEvent.getReceiver());
			parameters.put("sender", transferEvent.getSender());
			parameters.put("value", transferEvent.getValue());
			parameters.put("blockNumber", transferEvent.getBlockNumber());
			parameters.put("transactionHash", transferEvent.getTransactionHash());
			parameters.put("contractAddress", transferEvent.getContractAddress());
			parameters.put("creationDate", transferEvent.getCreationDate());
			parameters.apply(preparedStatement);
			preparedStatement.execute();
					
			ResultSet generatedId = preparedStatement.getGeneratedKeys();
			generatedId.next();
				
			return generatedId.getInt(1);
			
		}catch (SQLException e) {
			logger.log(Level.SEVERE, "ERROR! Transfer event was not inserted\n" + e.getMessage());
			e.getStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}