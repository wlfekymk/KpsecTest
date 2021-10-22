package com.kpsec.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TransactionController transactionController;
	
	JSONObject requestJsonBody;
	
	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
	}
	
	@Test
	public void testGetSumMaxTotalData200IsOk() throws Exception {
		mockMvc.perform(get("/transaction/sumMaxTotalData").contentType(MediaType.APPLICATION_JSON))  
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void  testGetNotTransClientData200IsOk() throws Exception {
		mockMvc.perform(get("/transaction/notTransClientData").contentType(MediaType.APPLICATION_JSON))  
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void  testGetYearByBranchSumAmtData200IsOk() throws Exception {
		mockMvc.perform(get("/transaction/notTransClientData").contentType(MediaType.APPLICATION_JSON))  
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void  testGetBranchSumAmtData200IsOk() throws Exception {
		Map<String, String> jsonDataBody = new HashMap<String, String>();
		jsonDataBody.put("brName", "판교점");
		requestJsonBody = new JSONObject(jsonDataBody);
		mockMvc.perform(put("/transaction/branchSumAmtData").contentType(MediaType.APPLICATION_JSON).content(requestJsonBody.toString()))    
				.andExpect(status().isOk())
				.andDo(print());
	}
	

}
