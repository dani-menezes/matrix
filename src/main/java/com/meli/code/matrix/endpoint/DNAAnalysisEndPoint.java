package com.meli.code.matrix.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.code.matrix.business.DNAAnalysisBusiness;
import com.meli.code.matrix.model.DNASample;


@RestController
public class DNAAnalysisEndPoint {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DNAAnalysisBusiness business;
	
	@RequestMapping(method={RequestMethod.POST}, value="/simian", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> isSimianCheck(@RequestBody DNASample dna) {
		logger.info("[{}][{}]", "isSimianCheck", dna);
		try {
			if (dna != null && business.executeAnalysis(dna.getDna())) {
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.status(403).build();
		} catch (Exception e) {
			logger.error("Error on isSimianCheck [{}][{}]", e.getMessage(), e.getCause());
			return ResponseEntity.status(500).build();
		}
	}
	
}
