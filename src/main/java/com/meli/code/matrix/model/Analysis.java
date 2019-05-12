package com.meli.code.matrix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Analysis extends Bean {

	private String hash;
	private String dna;
	private Boolean isSimian;
	
	public Analysis() {}
	
	public Analysis(String hash, String dna, Boolean isSimian) {
		this.hash = hash;
		this.dna = dna;
		this.isSimian = isSimian;
	}

	@Id
	@Column(name="HASH_KEY")
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	@Column(name="IS_SIMIAN")
	public Boolean getIsSimian() {
		return isSimian;
	}
	public void setIsSimian(Boolean isSimian) {
		this.isSimian = isSimian;
	}
	
}
