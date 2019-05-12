package com.meli.code.matrix.model;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class StatsDTO extends Bean {

	@SerializedName("count_mutant_dna")
	private Long countMutantDna;
	@SerializedName("count_human_dna")
	private Long countHumanDna;
	
	private BigDecimal ratio;

	public StatsDTO() {}

	public Long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(Long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public Long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(Long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public BigDecimal getRatio() {
		if (this.ratio == null) {
			return BigDecimal.ZERO;
		}
		return this.ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

}
