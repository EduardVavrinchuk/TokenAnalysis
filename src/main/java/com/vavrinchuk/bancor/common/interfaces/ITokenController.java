package main.java.com.vavrinchuk.bancor.common.interfaces;

public interface ITokenController {
	void setWeb3j();
	
	void setCredentials();
		
	void loadContract();
		
	void loadTransactions();
	
}
