package com.lchalela.medios.pagos.transaction.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lchalela.medios.pagos.transaction.dto.AccountDTO;
import com.lchalela.medios.pagos.transaction.dto.NewTransactionDTO;

@FeignClient(name = "account-service", url ="localhost:8083")
public interface AccountRest {
	@PostMapping("/account/check")
	public AccountDTO checkAccounts(@RequestBody NewTransactionDTO transaction) throws Exception;
}
