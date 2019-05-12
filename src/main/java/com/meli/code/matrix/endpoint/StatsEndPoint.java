package com.meli.code.matrix.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.code.matrix.business.StatsBusiness;


@RestController
public class StatsEndPoint {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StatsBusiness business;
	
	@RequestMapping(method={RequestMethod.GET}, value="/stats", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> stats() {
		logger.info("[{}]", "stats");
		try {
			return ResponseEntity.ok(business.getStats().toString());
		} catch (Exception e) {
			logger.error("Error on stats [{}][{}]", e.getMessage(), e.getCause());
			return ResponseEntity.status(500).build();
		}
	}
	
}
