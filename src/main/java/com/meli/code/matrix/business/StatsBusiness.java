package com.meli.code.matrix.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.meli.code.matrix.model.Analysis;
import com.meli.code.matrix.model.StatsDTO;
import com.meli.code.matrix.repository.AnalysisRepository;

@Component
public class StatsBusiness {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Gson gson = new Gson();

	@Autowired
	private AnalysisRepository repository;

	private MessageDigest md;

	public StatsBusiness() {
		try {
			this.md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			logger.error("[{}][{}]", e.getMessage(), e.getCause());
		}
	}

	public Analysis saveStats(String[] sample, Boolean isSimian) {
		String matrixJson = this.gson.toJson(sample);
		String hash = DatatypeConverter.printHexBinary(this.md.digest(matrixJson.getBytes())).toUpperCase();
		Analysis analysis = new Analysis(hash, matrixJson, isSimian);
		return this.repository.save(analysis);
	}

	public StatsDTO getStats() {
		List<Analysis> list = this.repository.findAll();
		return this.calculate(list);
	}
	
	public StatsDTO calculate(List<Analysis> analysisList) {
		StatsDTO stats = new StatsDTO();
		if (analysisList != null && analysisList.size() > 0) {
			List<Boolean> results = analysisList.stream().map(item -> item.getIsSimian()).collect(Collectors.toList());
			Map<Boolean, Long> counted = results.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			Long humans = counted.get(false) != null ? counted.get(false) : 0l;
			Long mutant = counted.get(true) != null ? counted.get(true) : 0l;
			
			stats.setCountHumanDna(humans);
			stats.setCountMutantDna(mutant);
			
			BigDecimal num = new BigDecimal(mutant);
			BigDecimal den = new BigDecimal(humans);
			if (den != BigDecimal.ZERO) {
				stats.setRatio(num.divide(den, 1, RoundingMode.HALF_UP));
			} else {
				stats.setRatio(BigDecimal.ZERO.setScale(1));
			}
		}
		return stats;
	}

}
