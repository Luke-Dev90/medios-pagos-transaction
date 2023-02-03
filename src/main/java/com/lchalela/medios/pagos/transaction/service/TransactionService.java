package com.lchalela.medios.pagos.transaction.service;

import java.util.List;

import com.lchalela.medios.pagos.transaction.dto.CbuDTO;
import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;
import com.lchalela.medios.pagos.transaction.dto.TransactionDTO;

public interface TransactionService {
	List<TransactionDTO> getAllTransactionByCbu(CbuDTO cbuaccountOrigin);
	public NewTransactionDTO registerTransaction(NewTransactionDTO transactionDTO);
	public void transaction(NewTransactionDTO transaction);
	List<TransactionDTO> findTransactionByDateRegister(String dateStart, String dateEnd);
}
