package com.lchalela.medios.pagos.transaction.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lchalela.medios.pagos.transaction.clients.AccountRest;
import com.lchalela.medios.pagos.transaction.dto.AccountDTO;
import com.lchalela.medios.pagos.transaction.dto.CbuDTO;
import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;
import com.lchalela.medios.pagos.transaction.dto.TransactionDTO;
import com.lchalela.medios.pagos.transaction.mapper.TransactionMapper;
import com.lchalela.medios.pagos.transaction.model.Transaction;
import com.lchalela.medios.pagos.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	private TransactionRepository transactionRepository;
	private TransactionMapper transactionMapper;
	private AccountRest accountRest;

	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper,
			AccountRest accountRest) {
		this.transactionRepository = transactionRepository;
		this.transactionMapper = transactionMapper;
		this.accountRest = accountRest;
	}

	@Override
	public List<TransactionDTO> getAllTransactionByCbu(CbuDTO accountOrigin) {
		logger.info("Request get transaction by cbu: " + accountOrigin.getAccountOrigin());
		List<Transaction> transaction = this.transactionRepository.findByAccountOriginOrAccountDestination(accountOrigin.getAccountOrigin() , accountOrigin.getAccountOrigin());
		return this.transactionMapper.listToListDTO(transaction);
	}

	@Override
	public NewTransactionDTO registerTransaction(NewTransactionDTO transactionDTO) {
		logger.info("Persist and mapper new transaction dto " + transactionDTO.toString());
		this.transactionRepository.save(this.transactionMapper.transactionDtoToEntity(transactionDTO));
		return transactionDTO;
	}

	@Override
	public void transaction(NewTransactionDTO transaction) {

		AccountDTO account;

		try {
			logger.info("Init request to MS account");
			account = this.accountRest.checkAccounts(transaction);
			transaction.setAccountDestination(account.getAccountDestination());
			transaction.setAccountOrigin(account.getAccountOrigin());

			logger.info("Call method register");
			this.registerTransaction(transaction);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public List<TransactionDTO> findTransactionByDateRegister(String dateStart, String dateEnd) {
		List<Transaction> listTransaction = null;
		// this.transactionRepository.findTransactionByCreateAt(dateStart, dateEnd);
		return null;
	}

}
