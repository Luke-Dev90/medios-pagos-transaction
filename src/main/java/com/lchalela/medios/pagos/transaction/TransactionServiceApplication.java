package com.lchalela.medios.pagos.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.lchalela.medios.pagos.transaction.clients.AccountRest;

@SpringBootApplication
@EnableFeignClients(clients = {AccountRest.class})
public class TransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

}
