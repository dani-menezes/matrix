package com.meli.code.matrix.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meli.code.matrix.model.DNASample;
import com.meli.code.matrix.model.DNASampleBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNAOperationsBusinessTest {
	
	@Autowired
	private DNAAnalysisBusiness business;
	@Autowired
	private DNAOperationsBusiness operation;
	
	@Test
	public void test_checkXup_ok() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s02().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXup(matrix, 4, 0, 0);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void test_checkXup_false() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s02().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXup(matrix, 8, 3, 0);
		
		assertEquals(result, 0);
	}
	
	@Test
	public void test_checkXdown_ok() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s02().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXdown(matrix, 4, 0, 3);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void test_ccheckXdown_false() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s02().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXdown(matrix, 8, 3, 0);
		
		assertEquals(result, 0);
	}
	
	@Test
	public void test_checkXdownYup_ok() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXdownYup(matrix, 8, 4, 3);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void test_checkXdownYup_false() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXdownYup(matrix, 8, 7, 1);
		
		assertEquals(result, 0);
	}
	
	@Test
	public void test_checkXupYdown_ok() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXupYdown(matrix, 8, 7, 0);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void test_checkXupYdown_false() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkXupYdown(matrix, 8, 7, 1);
		
		assertEquals(result, 0);
	}
	
	@Test
	public void test_checkYup_ok() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkYup(matrix, 8, 3, 7);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void test_checkYup_false() throws Exception {
		DNASample sample = new DNASampleBuilder().getSimian_s01().get();
		int [][] matrix = this.business.parseMatrix(sample.getDna());
		
		int result = operation.checkYup(matrix, 8, 3, 6);
		
		assertEquals(result, 0);
	}
	
    @Test
    public void test_checkYdown_ok() throws Exception {
    	DNASample sample = new DNASampleBuilder().getSimian_s01().get();
    	int [][] matrix = this.business.parseMatrix(sample.getDna());
    	
    	int result = operation.checkYdown(matrix, 8, 0, 7);
    	
    	assertEquals(result, 1);
    }
    
    @Test
    public void test_checkYdown_false() throws Exception {
    	DNASample sample = new DNASampleBuilder().getSimian_s01().get();
    	int [][] matrix = this.business.parseMatrix(sample.getDna());
    	
    	int result = operation.checkYdown(matrix, 8, 1, 7);
    	
    	assertEquals(result, 0);
    }
    
    @Test
    public void test_checkXupYup_ok() throws Exception {
    	DNASample sample = new DNASampleBuilder().getSimian_s03().get();
    	int [][] matrix = this.business.parseMatrix(sample.getDna());
    	
    	int result = operation.checkXupYup(matrix, 4, 0, 0);
    	
    	assertEquals(result, 1);
    }
    
    @Test
    public void test_checkXupYup_false() throws Exception {
    	DNASample sample = new DNASampleBuilder().getSimian_s03().get();
    	int [][] matrix = this.business.parseMatrix(sample.getDna());
    	
    	int result = operation.checkXupYup(matrix, 4, 1, 1);
    	
    	assertEquals(result, 0);
    }
    
    @Test
    public void test_checkXdownYdown_ok() throws Exception {
    	DNASample sample = new DNASampleBuilder().getSimian_s03().get();
    	int [][] matrix = this.business.parseMatrix(sample.getDna());
    	
    	int result = operation.checkXdownYdown(matrix, 4, 3, 3);
    	
    	assertEquals(result, 1);
    }
    
    @Test
    public void test_checkXdownYdown_false() throws Exception {
    	DNASample sample = new DNASampleBuilder().getSimian_s03().get();
    	int [][] matrix = this.business.parseMatrix(sample.getDna());
    	
    	int result = operation.checkXdownYdown(matrix, 4, 1, 1);
    	
    	assertEquals(result, 0);
    }

}
