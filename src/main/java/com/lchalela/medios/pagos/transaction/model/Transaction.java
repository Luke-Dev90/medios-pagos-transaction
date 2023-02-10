package com.lchalela.medios.pagos.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reason;
	private String paymentMethod;
	
	private Boolean isProgrammed;
	private LocalDateTime dateAcreditation;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm hh:mm:ss")
	private LocalDateTime createAt;
	private String accountDestination;
	private String accountOrigin;
	private BigDecimal amount;
	
	@PrePersist
	public void createAtGenerated() {
		this.createAt = LocalDateTime.now();
		System.out.println(this.createAt);
	}
}
