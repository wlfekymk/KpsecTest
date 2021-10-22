package com.kpsec.model.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class TransactionGetNotTransClientData {
	long getYear;
	String getName;
	String getaccNo;
}
