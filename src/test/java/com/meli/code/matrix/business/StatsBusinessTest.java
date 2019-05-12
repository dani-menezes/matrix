package com.meli.code.matrix.business;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.meli.code.matrix.model.Analysis;
import com.meli.code.matrix.model.StatsDTO;
import com.meli.code.matrix.repository.AnalysisRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatsBusinessTest {
	
	@Autowired
	private StatsBusiness business;
	
	@MockBean
	private AnalysisRepository repository;
	
	@Test
	public void test_saveStats() throws Exception {
		String[] sample = {"CA", "GT"};
		Analysis resultExpected = new Analysis("hash", sample.toString(), false);
		
		Mockito.when(repository.save(Mockito.any(Analysis.class))).thenReturn(resultExpected);
		Analysis result = business.saveStats(sample, false);
		
    	assertEquals(resultExpected.getHash(), result.getHash());
	}
	
	@Test
	public void test_calculate() throws Exception {
		Analysis an01 = new Analysis("hash1", "dna1", true);
		Analysis an02 = new Analysis("hash2", "dna2", false);
		Analysis an03 = new Analysis("hash3", "dna3", true);
		Analysis an04 = new Analysis("hash4", "dna4", false);
		Analysis an05 = new Analysis("hash5", "dna5", true);
		Analysis an06 = new Analysis("hash6", "dna6", false);
		Analysis an07 = new Analysis("hash7", "dna7", false);
		Analysis an08 = new Analysis("hash8", "dna8", true);
		Analysis an09 = new Analysis("hash9", "dna9", false);
		Analysis an10 = new Analysis("hash10", "dna10", false);
		Analysis an11 = new Analysis("hash11", "dna11", false);
		Analysis an12 = new Analysis("hash12", "dna12", false);
		Analysis an13 = new Analysis("hash13", "dna13", false);
		Analysis an14 = new Analysis("hash14", "dna14", false);
		List<Analysis> list = Arrays.asList(an01, an02, an03, an04, an05, an06, an07, an08, an09, an10, an11, an12, an13, an14);
		
		StatsDTO stats = this.business.calculate(list);

		assertEquals( new Long(10), stats.getCountHumanDna());
		assertEquals(new Long(4), stats.getCountMutantDna());
		assertEquals(new BigDecimal(0.4).setScale(1, RoundingMode.HALF_UP), stats.getRatio());
	}
	
	@Test
	public void test_calculate_division_by_0() throws Exception {
		Analysis an02 = new Analysis("hash2", "dna2", false);
		List<Analysis> list = Arrays.asList(an02);
		
		StatsDTO stats = this.business.calculate(list);
		
		assertEquals( new Long(1), stats.getCountHumanDna());
		assertEquals(new Long(0), stats.getCountMutantDna());
		assertEquals(BigDecimal.ZERO.setScale(1), stats.getRatio().setScale(1));
	}
	
}
