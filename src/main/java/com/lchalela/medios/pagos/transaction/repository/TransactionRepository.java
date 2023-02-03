package com.lchalela.medios.pagos.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lchalela.medios.pagos.transaction.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByAccountOriginOrAccountDestination(String accountOrigin, String accountDestination);
	//List<Transaction> findTransactionByCreateAt(String dateStart, String dateEnd);
}
