package com.lchalela.medios.pagos.transaction.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;
import com.lchalela.medios.pagos.transaction.dto.TransactionDTO;
import com.lchalela.medios.pagos.transaction.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	Transaction transactionDtoToEntity(NewTransactionDTO transactionDTO);
	TransactionDTO entityToTransactionDTO(Transaction transaction);
	List<TransactionDTO> listToListDTO(List<Transaction> transaction);
	NewTransactionDTO transactionToEntity(Transaction transaction);
}
