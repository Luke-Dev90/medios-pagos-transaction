package com.lchalela.medios.pagos.transaction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lchalela.medios.pagos.transaction.dto.CbuDTO;
import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;
import com.lchalela.medios.pagos.transaction.dto.TransactionDTO;
import com.lchalela.medios.pagos.transaction.service.TransactionService;

@RestController
@RequestMapping("/v1")
public class TransactionController {
	
	private Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/new")
	public ResponseEntity<?> registerTransaction(@RequestBody NewTransactionDTO transactionDto) throws Exception{
		logger.info("init new register transaction");
		this.transactionService.transaction(transactionDto);
		return new ResponseEntity<>("Transaction successful", HttpStatus.CREATED);
	}
	
	@PostMapping("/all")
	public ResponseEntity<?> getAllTransactionByCbu(@RequestBody CbuDTO cbu){
		logger.info("init request all transaction by cbu");
		List<TransactionDTO> list = this.transactionService.getAllTransactionByCbu(cbu);
		return new ResponseEntity<>( list,HttpStatus.OK);
	}
	
	
}
