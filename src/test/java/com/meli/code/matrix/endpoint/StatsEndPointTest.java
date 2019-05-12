package com.meli.code.matrix.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatsEndPointTest {
	
    @Autowired
    private MockMvc mvc;

	@Mock
	private DNAAnalysisEndPoint endPoint;
	
	@Test
	public void test_isSimian_true() throws Exception {
		MvcResult res = mvc.perform(MockMvcRequestBuilders.get("/stats")).andReturn();
		
		Assert.assertEquals(200, res.getResponse().getStatus());
	}
	
}
