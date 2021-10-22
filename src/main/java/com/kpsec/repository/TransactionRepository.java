package com.kpsec.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kpsec.model.dto.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
		   
}
