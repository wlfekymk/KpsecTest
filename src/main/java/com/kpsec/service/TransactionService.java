package com.kpsec.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kpsec.exception.BrCode404Exception;
import com.kpsec.model.dto.TransactionGetBranchSumAmtData;
import com.kpsec.model.dto.TransactionGetNotTransClientData;
import com.kpsec.model.dto.TransactionGetSumMaxTotalData;
import com.kpsec.model.dto.TransactionGetYearByBranchSumAmtData;
import com.kpsec.repository.AccountRepository;
import com.kpsec.repository.mapper.TransactionRepositoryMapper;

@Service
@Transactional
public class TransactionService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransactionRepositoryMapper transactionRepositoryMapper;
    
    
    @Autowired
    private AccountRepository accountRepository;
    
    /**
     *  API 1번
     *  1.	2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
     * @return
     */

    public List<TransactionGetSumMaxTotalData> getSumMaxTotalData(){
    	return transactionRepositoryMapper.getSumMaxTotalData();
    }
    
    /**
     * API 2번 
     *  2.	2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발.	(취소여부가 ‘Y’ 거래는 취소된 거래임)
     *   문의 및 참고 사항 : 취소 된 거래는 거래가 없는 사람으로 확인
     * @return
     */
    public List<TransactionGetNotTransClientData> getNotTransClientData(){
    	return transactionRepositoryMapper.getNotTransClientData();
    }
    
    /**
     * API 3번
     *   3.	연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임)
     * @return
     */
    public List<TransactionGetYearByBranchSumAmtData> getYearByBranchSumAmtData() {
    	List<Long> yearList = transactionRepositoryMapper.getYearData(); 
    	List<TransactionGetYearByBranchSumAmtData> result = new ArrayList();
    	for(Long year : yearList) {
    		List<TransactionGetBranchSumAmtData> sqlResult = transactionRepositoryMapper.getBranchSumAmtByYearData(year);
    		TransactionGetYearByBranchSumAmtData yearData = new TransactionGetYearByBranchSumAmtData();
    		yearData.setGetYear(year);
    		yearData.setGetDataList(sqlResult);
			result.add(yearData);
    	}
    	return result;
    }

    /**
     * API 4번
     *   4.	분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 
     *   지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
     * @return
     * @throws BrCode404Exception 
     */
    	//분당점과 판교점을 통폐합하여 판교점으로 관리점 이관데이터 업데이트 
    public TransactionGetBranchSumAmtData getBranchSumAmtData(String brName) throws BrCode404Exception {
    	TransactionGetBranchSumAmtData result = transactionRepositoryMapper.getBranchSumAmtByBrNameData(brName);
    	if(result==null) {
    		throw new BrCode404Exception();
    	}
		return result;
	}
    
    
    public int updateMoveBranch() {
    	return accountRepository.updateMoveBranch();
    }

}
