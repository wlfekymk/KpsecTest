package com.kpsec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kpsec.model.AccountResult;
import com.kpsec.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    public List<AccountResult> getAccountByBranchCode(String branchCode){
        List<AccountResult> aa = accountRepository.getAccountByBranchCode(branchCode);
        return aa;
    }

}
