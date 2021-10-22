package com.kpsec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kpsec.model.AccountResult;
import com.kpsec.model.dto.Account;


public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT account_no as accountNo, account_name as accountName FROM account WHERE branch_code = :branchCode", nativeQuery = true)
    List<AccountResult> getAccountByBranchCode(@Param("branchCode") String branchCode);
    
    @Modifying
    @Query(value = "UPDATE account  SET branch_code = 'A'  WHERE  branch_code = 'B'", nativeQuery = true)
    int updateMoveBranch();
    
}
