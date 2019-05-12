package com.meli.code.matrix.model;

public class DNASample extends Bean {

	private String[] dna;
	
	public DNASample() {}
	
	public DNASample(String[] dna) {
		this.dna = dna;
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
}
