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
import org.web3j.abi.datatypes.Bool;
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
public final class SmartToken extends Contract {
    private static final String BINARY = "606060405260408051908101604052600981527f546f6b656e20302e310000000000000000000000000000000000000000000000602082015260009080516200004d9291602001906200020d565b506020604051908101604052600081526001908051620000729291602001906200020d565b506020604051908101604052600081526002908051620000979291602001906200020d565b506003805460ff19169055600060045560408051908101604052600381527f302e32000000000000000000000000000000000000000000000000000000000060208201526009908051620000f09291602001906200020d565b50600a805460ff1916600117905534156200010a57600080fd5b60405162001165380380620011658339810160405280805182019190602001805182019190602001805191508390508282600083511180156200014e575060008251115b15156200015a57600080fd5b60018380516200016f9291602001906200020d565b506002828051620001859291602001906200020d565b506003805460ff191660ff92909216919091179055505060078054600160a060020a03191633600160a060020a0316179055600682511115620001c757600080fd5b7ff4cd1f8571e8d9c97ffcb81558807ab73f9803d54de5da6a0420593c82a4a9f030604051600160a060020a03909116815260200160405180910390a1505050620002b2565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200025057805160ff191683800117855562000280565b8280016001018555821562000280579182015b828111156200028057825182559160200191906001019062000263565b506200028e92915062000292565b5090565b620002af91905b808211156200028e576000815560010162000299565b90565b610ea380620002c26000396000f3006060604052600436106101115763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306fdde038114610116578063095ea7b3146101a05780631608f18f146101d657806318160ddd146101f057806323b872dd14610215578063313ce5671461023d57806354fd4d50146102665780635a3b7e42146102795780635e35359e1461028c57806370a08231146102b457806379ba5097146102d3578063867904b4146102e65780638da5cb5b1461030857806395d89b4114610337578063a24835d11461034a578063a9059cbb1461036c578063bef97c871461038e578063d4ee1d90146103a1578063dd62ed3e146103b4578063f2fde38b146103d9575b600080fd5b341561012157600080fd5b6101296103f8565b60405160208082528190810183818151815260200191508051906020019080838360005b8381101561016557808201518382015260200161014d565b50505050905090810190601f1680156101925780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101ab57600080fd5b6101c2600160a060020a0360043516602435610496565b604051901515815260200160405180910390f35b34156101e157600080fd5b6101ee6004351515610553565b005b34156101fb57600080fd5b61020361057d565b60405190815260200160405180910390f35b341561022057600080fd5b6101c2600160a060020a0360043581169060243516604435610583565b341561024857600080fd5b610250610629565b60405160ff909116815260200160405180910390f35b341561027157600080fd5b610129610632565b341561028457600080fd5b61012961069d565b341561029757600080fd5b6101ee600160a060020a0360043581169060243516604435610708565b34156102bf57600080fd5b610203600160a060020a036004351661080f565b34156102de57600080fd5b6101ee610821565b34156102f157600080fd5b6101ee600160a060020a03600435166024356108c8565b341561031357600080fd5b61031b6109d6565b604051600160a060020a03909116815260200160405180910390f35b341561034257600080fd5b6101296109e5565b341561035557600080fd5b6101ee600160a060020a0360043516602435610a50565b341561037757600080fd5b6101c2600160a060020a0360043516602435610b1a565b341561039957600080fd5b6101c2610bbe565b34156103ac57600080fd5b61031b610bc7565b34156103bf57600080fd5b610203600160a060020a0360043581169060243516610bd6565b34156103e457600080fd5b6101ee600160a060020a0360043516610bf3565b60018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561048e5780601f106104635761010080835404028352916020019161048e565b820191906000526020600020905b81548152906001019060200180831161047157829003601f168201915b505050505081565b600082600160a060020a03811615156104ae57600080fd5b8215806104de5750600160a060020a03338116600090815260066020908152604080832093881683529290522054155b15156104e957600080fd5b600160a060020a03338116600081815260066020908152604080832094891680845294909152908190208690557f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259086905190815260200160405180910390a35060019392505050565b60075433600160a060020a0390811691161461056b57fe5b600a805460ff19169115919091179055565b60045481565b600a5460009060ff16151561059457fe5b61059f848484610c55565b15156105a757fe5b30600160a060020a031683600160a060020a0316141561061f57600160a060020a03831660009081526005602052604090819020805484900390556004805484900390557f9a1b418bc061a5d80270261562e6986a35d995f8051145f277be16103abd34539083905190815260200160405180910390a15b5060019392505050565b60035460ff1681565b60098054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561048e5780601f106104635761010080835404028352916020019161048e565b60008054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561048e5780601f106104635761010080835404028352916020019161048e565b60075433600160a060020a0390811691161461072057fe5b82600160a060020a038116151561073657600080fd5b82600160a060020a038116151561074c57600080fd5b8330600160a060020a031681600160a060020a03161415151561076e57600080fd5b85600160a060020a031663a9059cbb86866000604051602001526040517c010000000000000000000000000000000000000000000000000000000063ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b15156107e457600080fd5b6102c65a03f115156107f557600080fd5b50505060405180519050151561080757fe5b505050505050565b60056020526000908152604090205481565b60085433600160a060020a0390811691161461083c57600080fd5b6007546008547f343765429aea5a34b3ff6a3785a98a5abb2597aca87bfbb58632c173d585373a91600160a060020a039081169116604051600160a060020a039283168152911660208201526040908101905180910390a1600880546007805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03841617909155169055565b60075433600160a060020a039081169116146108e057fe5b81600160a060020a03811615156108f657600080fd5b8230600160a060020a031681600160a060020a03161415151561091857600080fd5b61092460045484610d75565b600455600160a060020a03841660009081526005602052604090205461094a9084610d75565b600160a060020a03851660009081526005602052604090819020919091557f9386c90217c323f58030f9dadcbc938f807a940f4ff41cd4cead9562f5da7dc39084905190815260200160405180910390a183600160a060020a031630600160a060020a0316600080516020610e588339815191528560405190815260200160405180910390a350505050565b600754600160a060020a031681565b60028054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561048e5780601f106104635761010080835404028352916020019161048e565b60075433600160a060020a03908116911614610a6857fe5b600160a060020a038216600090815260056020526040902054610a8b9082610d8b565b600160a060020a038316600090815260056020526040902055600454610ab19082610d8b565b600455600160a060020a03308116908316600080516020610e588339815191528360405190815260200160405180910390a37f9a1b418bc061a5d80270261562e6986a35d995f8051145f277be16103abd34538160405190815260200160405180910390a15050565b600a5460009060ff161515610b2b57fe5b610b358383610d9d565b1515610b3d57fe5b30600160a060020a031683600160a060020a03161415610bb557600160a060020a03831660009081526005602052604090819020805484900390556004805484900390557f9a1b418bc061a5d80270261562e6986a35d995f8051145f277be16103abd34539083905190815260200160405180910390a15b50600192915050565b600a5460ff1681565b600854600160a060020a031681565b600660209081526000928352604080842090915290825290205481565b60075433600160a060020a03908116911614610c0b57fe5b600754600160a060020a0382811691161415610c2657600080fd5b6008805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600083600160a060020a0381161515610c6d57600080fd5b83600160a060020a0381161515610c8357600080fd5b600160a060020a0380871660009081526006602090815260408083203390941683529290522054610cb49085610d8b565b600160a060020a038088166000818152600660209081526040808320339095168352938152838220949094559081526005909252902054610cf59085610d8b565b600160a060020a038088166000908152600560205260408082209390935590871681522054610d249085610d75565b600160a060020a0380871660008181526005602052604090819020939093559190881690600080516020610e588339815191529087905190815260200160405180910390a350600195945050505050565b600082820183811015610d8457fe5b9392505050565b600081831015610d9757fe5b50900390565b600082600160a060020a0381161515610db557600080fd5b600160a060020a033316600090815260056020526040902054610dd89084610d8b565b600160a060020a033381166000908152600560205260408082209390935590861681522054610e079084610d75565b600160a060020a038086166000818152600560205260409081902093909355913390911690600080516020610e588339815191529086905190815260200160405180910390a350600193925050505600ddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3efa165627a7a72305820702aecccfd02a11d936e70b90c0743d83dc3f5cf02c4741ef219a19e09f307c30029";

    private SmartToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SmartToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<NewSmartTokenEventResponse> getNewSmartTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewSmartToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewSmartTokenEventResponse> responses = new ArrayList<NewSmartTokenEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewSmartTokenEventResponse typedResponse = new NewSmartTokenEventResponse();
            typedResponse._token = (Address) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewSmartTokenEventResponse> newSmartTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewSmartToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewSmartTokenEventResponse>() {
            @Override
            public NewSmartTokenEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewSmartTokenEventResponse typedResponse = new NewSmartTokenEventResponse();
                typedResponse._token = (Address) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<IssuanceEventResponse> getIssuanceEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Issuance", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<IssuanceEventResponse> responses = new ArrayList<IssuanceEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            IssuanceEventResponse typedResponse = new IssuanceEventResponse();
            typedResponse._amount = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<IssuanceEventResponse> issuanceEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Issuance", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, IssuanceEventResponse>() {
            @Override
            public IssuanceEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                IssuanceEventResponse typedResponse = new IssuanceEventResponse();
                typedResponse._amount = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<DestructionEventResponse> getDestructionEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Destruction", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DestructionEventResponse> responses = new ArrayList<DestructionEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DestructionEventResponse typedResponse = new DestructionEventResponse();
            typedResponse._amount = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DestructionEventResponse> destructionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Destruction", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DestructionEventResponse>() {
            @Override
            public DestructionEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DestructionEventResponse typedResponse = new DestructionEventResponse();
                typedResponse._amount = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
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

    public RemoteCall<TransactionReceipt> disableTransfers(Bool _disable) {
        Function function = new Function(
                "disableTransfers", 
                Arrays.<Type>asList(_disable), 
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

    public RemoteCall<Utf8String> version() {
        Function function = new Function("version", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> standard() {
        Function function = new Function("standard", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> withdrawTokens(Address _token, Address _to, Uint256 _amount) {
        Function function = new Function(
                "withdrawTokens", 
                Arrays.<Type>asList(_token, _to, _amount), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> balanceOf(Address param0) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> acceptOwnership() {
        Function function = new Function(
                "acceptOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> issue(Address _to, Uint256 _amount) {
        Function function = new Function(
                "issue", 
                Arrays.<Type>asList(_to, _amount), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> destroy(Address _from, Uint256 _amount) {
        Function function = new Function(
                "destroy", 
                Arrays.<Type>asList(_from, _amount), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transfer(Address _to, Uint256 _value) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(_to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Bool> transfersEnabled() {
        Function function = new Function("transfersEnabled", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Address> newOwner() {
        Function function = new Function("newOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> allowance(Address param0, Address param1) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(param0, param1), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(Address _newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(_newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<SmartToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Utf8String _name, Utf8String _symbol, Uint8 _decimals) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_name, _symbol, _decimals));
        return deployRemoteCall(SmartToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<SmartToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Utf8String _name, Utf8String _symbol, Uint8 _decimals) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_name, _symbol, _decimals));
        return deployRemoteCall(SmartToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static SmartToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SmartToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SmartToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SmartToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class NewSmartTokenEventResponse {
        public Address _token;
    }

    public static class IssuanceEventResponse {
        public Uint256 _amount;
    }

    public static class DestructionEventResponse {
        public Uint256 _amount;
    }

    public static class OwnerUpdateEventResponse {
        public Address _prevOwner;

        public Address _newOwner;
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
