package com.kpsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpsec.exception.BrCode404Exception;
import com.kpsec.model.AccountResult;
import com.kpsec.model.dto.Request;
import com.kpsec.model.dto.TransactionGetBranchSumAmtData;
import com.kpsec.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Account")
@RestController
@RequestMapping("/")
public class AccountController {

	@Autowired
    AccountService accountService;
	
    @ApiOperation(value = "sample")
    @GetMapping(value = "/acount")
    public List<AccountResult> getAccountInfo(String branchCode) {
        return accountService.getAccountByBranchCode(branchCode);
    }

}
