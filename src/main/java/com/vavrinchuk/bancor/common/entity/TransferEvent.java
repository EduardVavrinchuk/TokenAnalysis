package main.java.com.vavrinchuk.bancor.common.entity;

public class TransferEvent {
	
	private int id;
	private String receiver;
	private String sender;
	private Integer value;
	private Integer blockNumber;
	private String transactionHash;
	private String contractAddress;
	private Long creationDate;
	
	public TransferEvent() {
		
	}
	
	public TransferEvent(
			String receiver,
			String sender,
			Integer value,
			Integer blockNumber,
			String TransactionHash,
			String contractAddress,
			Long CreationDate
			) {
		this.receiver = receiver;
		this.sender = sender;
		this.value = value;
		this.blockNumber = blockNumber;
		this.transactionHash = TransactionHash;
		this.contractAddress = contractAddress;
		this.creationDate = CreationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(Integer blockNumber) {
		this.blockNumber = blockNumber;
	}

	public String getTransactionHash() {
		return transactionHash;
	}

	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}

	public String getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
	
}
