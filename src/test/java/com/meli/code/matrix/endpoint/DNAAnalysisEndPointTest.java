package com.meli.code.matrix.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.meli.code.matrix.model.DNASample;
import com.meli.code.matrix.model.DNASampleBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DNAAnalysisEndPointTest {
	
    @Autowired
    private MockMvc mvc;

	@Mock
	private DNAAnalysisEndPoint endPoint;
	
	@Test
	public void test_isSimian_true() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		
		MvcResult res = mvc.perform(MockMvcRequestBuilders.post("/simian").content(sample.toString()).contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		Assert.assertEquals(200, res.getResponse().getStatus());
	}
	
	@Test
	public void test_isSimian_false() throws Exception {
		DNASample sample = new DNASampleBuilder().getHuman().get();
		
		MvcResult res = mvc.perform(MockMvcRequestBuilders.post("/simian").content(sample.toString()).contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		Assert.assertEquals(403, res.getResponse().getStatus());
	}
	
	@Test
	public void test_isSimian_error() throws Exception {
		String[] array = {"AH", "HA", "TE"};
		DNASample sample = new DNASampleBuilder().setDna(array).get();
		
		MvcResult res = mvc.perform(MockMvcRequestBuilders.post("/simian").content(sample.toString()).contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		Assert.assertEquals(500, res.getResponse().getStatus());
	}
	
}
