package com.kpsec.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class TransactionGetSumMaxTotalData {
	long getYear;
	String getName;
	String getAccNo;
	long getSumAmt;

}
