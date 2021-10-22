package com.kpsec.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpsec.exception.BrCode404Exception;
import com.kpsec.model.dto.Request;
import com.kpsec.model.dto.TransactionGetBranchSumAmtData;

import com.kpsec.model.dto.TransactionGetNotTransClientData;
import com.kpsec.model.dto.TransactionGetSumMaxTotalData;
import com.kpsec.model.dto.TransactionGetYearByBranchSumAmtData;
import com.kpsec.service.TransactionService;

import io.swagger.annotations.Api;

@Api(tags = "Transaction")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private TransactionService transactionService;

	
	
    @GetMapping(value = "/sumMaxTotalData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionGetSumMaxTotalData> getSumMaxTotalData(){
    	return transactionService.getSumMaxTotalData();
    }
    
    @GetMapping(value = "/notTransClientData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionGetNotTransClientData> getNotTransClientData(){
    	return transactionService.getNotTransClientData();
    }
    
    @GetMapping(value = "/yearByBranchSumAmtData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionGetYearByBranchSumAmtData> getYearByBranchSumAmtData(){
    	return transactionService.getYearByBranchSumAmtData();
    }
    
    
    @PostMapping(value = "/branchSumAmtData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TransactionGetBranchSumAmtData getBranchSumAmtData(@RequestBody Request requestDto) throws BrCode404Exception {
        return transactionService.getBranchSumAmtData(requestDto.getBrName());
    }
    
    @PutMapping(value = "/updateMoveBranch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateMoveBranch(@RequestBody Request requestDto)  {
        return transactionService.updateMoveBranch();
    }
    
}
