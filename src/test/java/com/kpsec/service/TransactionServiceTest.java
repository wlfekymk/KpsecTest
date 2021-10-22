package com.kpsec.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.kpsec.exception.BrCode404Exception;
import com.kpsec.model.dto.TransactionGetBranchSumAmtData;
import com.kpsec.model.dto.TransactionGetNotTransClientData;

import com.kpsec.model.dto.TransactionGetSumMaxTotalData;
import com.kpsec.model.dto.TransactionGetYearByBranchSumAmtData;
import com.kpsec.repository.AccountRepository;
import com.kpsec.repository.mapper.TransactionRepositoryMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
	
	
	@Mock
	private TransactionService transactionService;

	@Mock
	private TransactionRepositoryMapper transactionRepositoryMapper;
	
	@Mock
    private AccountRepository accountRepository;
    
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetSumMaxTotalData() {
		transactionService = mock(TransactionService.class);
		transactionService.getSumMaxTotalData();
		verify(transactionService).getSumMaxTotalData();
	}
	
	@Test
	public void testGetNotTransClientData() {
		transactionService = mock(TransactionService.class);
		transactionService.getNotTransClientData();
		verify(transactionService).getNotTransClientData();
	}

	@Test
	public void testGetYearByBranchSumAmtData() {
		transactionService = mock(TransactionService.class);
		transactionService.getYearByBranchSumAmtData();
		verify(transactionService).getYearByBranchSumAmtData();
		
	}

	@Test
	public void testGetBranchSumAmtData() throws Exception {
		transactionService = mock(TransactionService.class);
		transactionService.getBranchSumAmtData("강남점");
		verify(transactionService).getBranchSumAmtData("강남점");

	}


}

