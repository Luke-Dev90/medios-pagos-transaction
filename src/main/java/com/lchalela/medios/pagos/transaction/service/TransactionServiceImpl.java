package com.lchalela.medios.pagos.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lchalela.medios.pagos.transaction.clients.AccountRest;
import com.lchalela.medios.pagos.transaction.dto.AccountDTO;
import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;
import com.lchalela.medios.pagos.transaction.dto.TransactionDTO;
import com.lchalela.medios.pagos.transaction.mapper.TransactionMapper;
import com.lchalela.medios.pagos.transaction.model.Transaction;
import com.lchalela.medios.pagos.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	private TransactionRepository transactionRepository;
	private TransactionMapper transactionMapper;
	
	@Autowired
	private AccountRest accountRest;
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository,
			TransactionMapper transactionMapper) {
		this.transactionRepository = transactionRepository;
		this.transactionMapper = transactionMapper;
	}
	
	@Override
	public List<TransactionDTO> getAllTransactionByNumberAccount(String accountOrigin) {
			List<Transaction> transaction = 
					this.transactionRepository.findTransactionByAccountOrigin(accountOrigin);
			
		return null;
	}

	@Override
	public NewTransactionDTO registerTransaction(NewTransactionDTO transactionDTO) {
		System.out.println("in register: " +  transactionDTO);
		this.transactionRepository.save( this.transactionMapper.transactionDtoToEntity(transactionDTO));
		return transactionDTO;
	}
	
	@Override
	public void transaction(NewTransactionDTO transaction) {
		System.out.println(transaction);
		
		AccountDTO  account = this.accountRest.checkAccounts(transaction);
		
		transaction.setAccountDestination(account.getAccountDestination());
		transaction.setAccountOrigin( account.getAccountOrigin() );
		
		this.registerTransaction(transaction);
	}
	
	@Override
	public List<TransactionDTO> findTransactionByDateRegister(String dateStart, String dateEnd) {
		List<Transaction> listTransaction =  null;
				//this.transactionRepository.findTransactionByCreateAt(dateStart, dateEnd);
		return null;
	}

}
