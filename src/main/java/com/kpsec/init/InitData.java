package com.kpsec.init;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.kpsec.model.dto.Account;
import com.kpsec.model.dto.Branch;
import com.kpsec.model.dto.Transaction;
import com.kpsec.repository.AccountRepository;
import com.kpsec.repository.BranchRepostiory;
import com.kpsec.repository.TransactionRepository;

@Component
public class InitData {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static String DATA_ACCOUNT_DATA_PATH = "과제1_데이터_계좌정보.csv";
	private static String DATA_TRANSACTION_DATA_PATH = "과제1_데이터_거래내역.csv";
	private static String DATA_BRANCH_DATA_PATH = "과제1_데이터_관리점정보.csv";

	private static String CSV_REGEX = ",";
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	BranchRepostiory branchRepostiory;

	@PostConstruct
	public void initAccount() throws IOException {
		logger.info("init Account!!!");
		if (accountRepository.count() == 0) {
			Resource resource = new ClassPathResource(DATA_ACCOUNT_DATA_PATH);
			List<Account> accountList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8).stream()
					.skip(1).map(line -> {
						String[] split = line.split(CSV_REGEX);
						return Account.builder()
								.accountNo(split[0])
								.accountName(split[1])
								.branchCode(split[2])
								.build();
					}).collect(Collectors.toList());
			accountRepository.saveAll(accountList);
		}
		
		
	}
	
	
	@PostConstruct
	public void initTransaction() throws IOException {
		logger.info("initTransaction!!!");
		if (transactionRepository.count() == 0) {
			Resource resource = new ClassPathResource(DATA_TRANSACTION_DATA_PATH);
			List<Transaction> transactionDetailList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8).stream()
					.skip(1).map(line -> {
						String[] split = line.split(CSV_REGEX);
						return Transaction.builder()
								.transactionDate(split[0])
								.accountNo(split[1])
								.transactionNo(split[2])
								.price(Long.valueOf(split[3]))
								.fees(split[4])
								.cancelYN(split[5])
								.build();
					}).collect(Collectors.toList());
			transactionRepository.saveAll(transactionDetailList);
		}
	}
	
	@PostConstruct
	public void initBranch() throws IOException {
		logger.info("initBranch!!!");
		if (branchRepostiory.count() == 0) {
			Resource resource = new ClassPathResource(DATA_BRANCH_DATA_PATH);
			List<Branch> branchList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8).stream()
					.skip(1).map(line -> {
						String[] split = line.split(CSV_REGEX);
						return Branch.builder()
								.branchCode(split[0])
								.branchName(split[1])
								.build();
					}).collect(Collectors.toList());
			branchRepostiory.saveAll(branchList);
		}
	}
}
