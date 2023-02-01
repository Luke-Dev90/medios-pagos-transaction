package com.lchalela.medios.pagos.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class NewTransactionDTO {
	private String accountOrigin;
	private String aliasDestination;
	private String cbuDestination;
	private String AccountDestination;
	private String paymentMethod;
	@Temporal(TemporalType.TIME)
	private LocalDateTime createAt;
	private String reason;
	private BigDecimal amount;
}
