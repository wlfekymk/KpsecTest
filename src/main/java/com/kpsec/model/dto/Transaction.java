package com.kpsec.model.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor @AllArgsConstructor @Entity
@IdClass(Transaction.class)
public class Transaction implements Serializable {

	@Id
	private String transactionDate;
	@Id
	private String accountNo;
	@Id
	private String transactionNo;
	private long price;
	private String fees;
	private String cancelYN;
	
}
