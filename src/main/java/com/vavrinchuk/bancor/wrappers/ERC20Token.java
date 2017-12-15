package main.java.com.vavrinchuk.bancor.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class ERC20Token extends Contract {
    private static final String BINARY = "606060405260408051908101604052600981527f546f6b656e20302e3100000000000000000000000000000000000000000000006020820152600090805161004b929160200190610139565b50602060405190810160405260008152600190805161006e929160200190610139565b506020604051908101604052600081526002908051610091929160200190610139565b506003805460ff19169055600060045534156100ac57600080fd5b60405161090e38038061090e8339810160405280805182019190602001805182019190602001805191506000905083511180156100ea575060008251115b15156100f557600080fd5b6001838051610108929160200190610139565b50600282805161011c929160200190610139565b506003805460ff191660ff92909216919091179055506101d49050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061017a57805160ff19168380011785556101a7565b828001600101855582156101a7579182015b828111156101a757825182559160200191906001019061018c565b506101b39291506101b7565b5090565b6101d191905b808211156101b357600081556001016101bd565b90565b61072b806101e36000396000f3006060604052600436106100a35763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306fdde0381146100a8578063095ea7b31461013257806318160ddd1461016857806323b872dd1461018d578063313ce567146101b55780635a3b7e42146101de57806370a08231146101f157806395d89b4114610210578063a9059cbb14610223578063dd62ed3e14610245575b600080fd5b34156100b357600080fd5b6100bb61026a565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100f75780820151838201526020016100df565b50505050905090810190601f1680156101245780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561013d57600080fd5b610154600160a060020a0360043516602435610308565b604051901515815260200160405180910390f35b341561017357600080fd5b61017b6103c5565b60405190815260200160405180910390f35b341561019857600080fd5b610154600160a060020a03600435811690602435166044356103cb565b34156101c057600080fd5b6101c86104fd565b60405160ff909116815260200160405180910390f35b34156101e957600080fd5b6100bb610506565b34156101fc57600080fd5b61017b600160a060020a0360043516610571565b341561021b57600080fd5b6100bb610583565b341561022e57600080fd5b610154600160a060020a03600435166024356105ee565b341561025057600080fd5b61017b600160a060020a03600435811690602435166106ba565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103005780601f106102d557610100808354040283529160200191610300565b820191906000526020600020905b8154815290600101906020018083116102e357829003601f168201915b505050505081565b600082600160a060020a038116151561032057600080fd5b8215806103505750600160a060020a03338116600090815260066020908152604080832093881683529290522054155b151561035b57600080fd5b600160a060020a03338116600081815260066020908152604080832094891680845294909152908190208690557f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259086905190815260200160405180910390a35060019392505050565b60045481565b600083600160a060020a03811615156103e357600080fd5b83600160a060020a03811615156103f957600080fd5b600160a060020a038087166000908152600660209081526040808320339094168352929052205461042a90856106d7565b600160a060020a03808816600081815260066020908152604080832033909516835293815283822094909455908152600590925290205461046b90856106d7565b600160a060020a03808816600090815260056020526040808220939093559087168152205461049a90856106e9565b600160a060020a03808716600081815260056020526040908190209390935591908816907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9087905190815260200160405180910390a350600195945050505050565b60035460ff1681565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103005780601f106102d557610100808354040283529160200191610300565b60056020526000908152604090205481565b60028054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103005780601f106102d557610100808354040283529160200191610300565b600082600160a060020a038116151561060657600080fd5b600160a060020a03331660009081526005602052604090205461062990846106d7565b600160a060020a03338116600090815260056020526040808220939093559086168152205461065890846106e9565b600160a060020a0380861660008181526005602052604090819020939093559133909116907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9086905190815260200160405180910390a35060019392505050565b600660209081526000928352604080842090915290825290205481565b6000818310156106e357fe5b50900390565b6000828201838110156106f857fe5b93925050505600a165627a7a7230582032ca39b1b8d4e2f51a522daff4d20994d2fa979dd189b2afb4f4ee270f6e4ad80029";

    private ERC20Token(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private ERC20Token(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse._from = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._to = (Address) eventValues.getIndexedValues().get(1);
            typedResponse._value = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse._from = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._to = (Address) eventValues.getIndexedValues().get(1);
                typedResponse._value = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse._owner = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._spender = (Address) eventValues.getIndexedValues().get(1);
            typedResponse._value = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse._owner = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._spender = (Address) eventValues.getIndexedValues().get(1);
                typedResponse._value = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public RemoteCall<Utf8String> name() {
        Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> approve(Address _spender, Uint256 _value) {
        Function function = new Function(
                "approve", 
                Arrays.<Type>asList(_spender, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> totalSupply() {
        Function function = new Function("totalSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transferFrom(Address _from, Address _to, Uint256 _value) {
        Function function = new Function(
                "transferFrom", 
                Arrays.<Type>asList(_from, _to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint8> decimals() {
        Function function = new Function("decimals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> standard() {
        Function function = new Function("standard", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> balanceOf(Address param0) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transfer(Address _to, Uint256 _value) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(_to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> allowance(Address param0, Address param1) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(param0, param1), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<ERC20Token> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Utf8String _name, Utf8String _symbol, Uint8 _decimals) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_name, _symbol, _decimals));
        return deployRemoteCall(ERC20Token.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC20Token> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Utf8String _name, Utf8String _symbol, Uint8 _decimals) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_name, _symbol, _decimals));
        return deployRemoteCall(ERC20Token.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static ERC20Token load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20Token(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ERC20Token load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20Token(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TransferEventResponse {
        public Address _from;

        public Address _to;

        public Uint256 _value;
    }

    public static class ApprovalEventResponse {
        public Address _owner;

        public Address _spender;

        public Uint256 _value;
    }
}
