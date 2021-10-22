package com.kpsec.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TransactionGetYearByBranchSumAmtData {
	private long getYear;
	private List<TransactionGetBranchSumAmtData> getDataList;
}
