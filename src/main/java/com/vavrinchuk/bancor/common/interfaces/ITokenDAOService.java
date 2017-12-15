package main.java.com.vavrinchuk.bancor.common.interfaces;

import java.util.List;

import main.java.com.vavrinchuk.bancor.common.entity.TransferEvent;

public interface ITokenDAOService {
	List<TransferEvent> ShowAll();
	
	Integer insert(TransferEvent transferEvent);
}
