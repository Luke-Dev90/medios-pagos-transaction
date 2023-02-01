package com.lchalela.medios.pagos.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;
import com.lchalela.medios.pagos.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/new")
	public ResponseEntity<?> registerTransaction(@RequestBody NewTransactionDTO transactionDto){
		this.transactionService.transaction(transactionDto);
		return new ResponseEntity<>("Transaction successful", HttpStatus.CREATED);
	}
	
	
}
