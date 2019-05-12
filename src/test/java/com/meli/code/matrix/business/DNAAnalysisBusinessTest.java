package com.meli.code.matrix.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meli.code.matrix.exception.MatrixException;
import com.meli.code.matrix.model.DNASample;
import com.meli.code.matrix.model.DNASampleBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNAAnalysisBusinessTest {
	
	@Autowired
	private DNAAnalysisBusiness business;
	
    @Test
    public void test_parseMatrix_should_return_2D_int_array() throws Exception {
    	String[] array = {"CA", "GT"};
    	
    	int [][] matrix = this.business.parseMatrix(array);
    	
    	assertEquals((char)matrix[0][0], 'C');
    	assertEquals((char)matrix[0][1], 'A');
    	assertEquals((char)matrix[1][0], 'G');
    	assertEquals((char)matrix[1][1], 'T');
    }
    
    @Test
    public void test_parseMatrix_with_wrong_element_should_throw_exception() throws Exception {
    	String[] array = {"CA", "GT", "AT"};
    	
    	try {
    		this.business.parseMatrix(array);
    	} catch (MatrixException e) {
    		assertEquals(e.getMessage(), "Error at parse [Wrong sample]");
		}
    }
    
    @Test
    public void test_parse_element_should_return_char() throws Exception {
    	char element = this.business.parseElement('C');
    	
		assertEquals(element, 'C');
    }
    
    @Test
    public void test_parse_element_should_throw_exception() throws Exception {
    	try {
    		this.business.parseElement('B');
    	} catch (MatrixException e) {
    		assertEquals(e.getMessage(), "Error at parse [Wrong element]");
    	}
    }
    
    @Test
    public void test_checkMatrix_isSimian() throws Exception {
    	DNASample dna = new DNASampleBuilder().getSimian_s01().get();
    	int[][]matrix = this.business.parseMatrix(dna.getDna());
    	
    	Boolean isSimian = this.business.checkIfMatrixIsSimian(matrix);
    	
    	assertTrue("Check Simian", isSimian);
    }
    
    @Test
    public void test_checkMatrix_isHuman() throws Exception {
    	DNASample dna = new DNASampleBuilder().getHuman().get();
    	int[][]matrix = this.business.parseMatrix(dna.getDna());
    	
    	Boolean isSimian = this.business.checkIfMatrixIsSimian(matrix);
    	
    	assertFalse("Check Human", isSimian);
    }

}
