package com.kpsec.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kpsec.model.dto.TransactionGetBranchSumAmtData;
import com.kpsec.model.dto.TransactionGetNotTransClientData;
import com.kpsec.model.dto.TransactionGetSumMaxTotalData;


@Mapper
public interface TransactionRepositoryMapper {

	public List<TransactionGetSumMaxTotalData> getSumMaxTotalData();
	public List<TransactionGetNotTransClientData> getNotTransClientData();
	public List<TransactionGetBranchSumAmtData> getBranchSumAmtByYearData(Long year); 
	public List<Long> getYearData();
	public TransactionGetBranchSumAmtData getBranchSumAmtByBrNameData(String brName);
	   
}
