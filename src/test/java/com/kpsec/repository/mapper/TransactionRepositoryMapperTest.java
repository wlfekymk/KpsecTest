package com.kpsec.repository.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kpsec.model.dto.TransactionGetBranchSumAmtData;


@RunWith(SpringRunner.class)
@MybatisTest
public class TransactionRepositoryMapperTest {

	@Mock
	private TransactionRepositoryMapper mapper;

	@Before
	public void init() throws IOException {

	}

	@Test
	public void testGetSumMaxTotalData() {
		TransactionGetBranchSumAmtData data = mapper.getBranchSumAmtByBrNameData("강남점");
		assertThat(data.getGetBrCode()).isEqualTo("C");
		assertThat(data.getGetBrName()).isEqualTo("강남점");
		assertThat(data.getGetSumAmt()).isEqualTo(39732867);
	}

}
