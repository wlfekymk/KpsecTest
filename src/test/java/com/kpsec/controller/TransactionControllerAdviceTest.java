package com.kpsec.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kpsec.exception.BrCode404Exception;
import com.kpsec.model.dto.Request;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerAdviceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TransactionController transactionController;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(transactionController).setControllerAdvice(new TransactionControllerAdvice()).build();
	}
	
	@Test(expected = BrCode404Exception.class )
	public void testGetBranchSumAmtData404IsNotFoundError() throws Exception {
		Request requestDto = new Request();
		requestDto.setBrName("분당점");
		
		when(transactionController.getBranchSumAmtData(requestDto)).thenThrow(new BrCode404Exception());
		mockMvc.perform(put("/transaction/branchSumAmtData").contentType(MediaType.APPLICATION_JSON)
				.content(requestDto.toString()))  
				.andExpect(status().isNotFound())
				.andExpect(result -> 
					assertThat(getApiResultExceptionClass(result)).isEqualTo(BrCode404Exception.class)
				);
	}
	
	private Class<? extends Exception> getApiResultExceptionClass(MvcResult result) {
		return Objects.requireNonNull(result.getResolvedException()).getClass();
	}
}
