package com.lchalela.medios.pagos.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDTO {
	private String reason;
	private String paymentMethod;
	private LocalDateTime createAt;
	private String accountDestination;
	private String accountOrigin;
	private BigDecimal amount;
}
