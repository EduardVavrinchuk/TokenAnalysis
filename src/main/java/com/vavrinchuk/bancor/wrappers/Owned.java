package main.java.com.vavrinchuk.bancor.wrappers;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public final class Owned extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60008054600160a060020a033316600160a060020a031990911617905561022f8061003b6000396000f3006060604052600436106100615763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166379ba509781146100665780638da5cb5b1461007b578063d4ee1d90146100aa578063f2fde38b146100bd575b600080fd5b341561007157600080fd5b6100796100dc565b005b341561008657600080fd5b61008e610183565b604051600160a060020a03909116815260200160405180910390f35b34156100b557600080fd5b61008e610192565b34156100c857600080fd5b610079600160a060020a03600435166101a1565b60015433600160a060020a039081169116146100f757600080fd5b6000546001547f343765429aea5a34b3ff6a3785a98a5abb2597aca87bfbb58632c173d585373a91600160a060020a039081169116604051600160a060020a039283168152911660208201526040908101905180910390a1600180546000805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03841617909155169055565b600054600160a060020a031681565b600154600160a060020a031681565b60005433600160a060020a039081169116146101b957fe5b600054600160a060020a03828116911614156101d457600080fd5b6001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790555600a165627a7a72305820483fbb6c09da235ac406b9bba3abd176b970fbecd3a1c016aa359ccee73168390029";

    private Owned(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Owned(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<OwnerUpdateEventResponse> getOwnerUpdateEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnerUpdate", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnerUpdateEventResponse> responses = new ArrayList<OwnerUpdateEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnerUpdateEventResponse typedResponse = new OwnerUpdateEventResponse();
            typedResponse._prevOwner = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse._newOwner = (Address) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnerUpdateEventResponse> ownerUpdateEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnerUpdate", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnerUpdateEventResponse>() {
            @Override
            public OwnerUpdateEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnerUpdateEventResponse typedResponse = new OwnerUpdateEventResponse();
                typedResponse._prevOwner = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse._newOwner = (Address) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> acceptOwnership() {
        Function function = new Function(
                "acceptOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Address> newOwner() {
        Function function = new Function("newOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(Address _newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(_newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Owned> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Owned.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Owned> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Owned.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Owned load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Owned(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Owned load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Owned(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class OwnerUpdateEventResponse {
        public Address _prevOwner;

        public Address _newOwner;
    }
}
