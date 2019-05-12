package com.meli.code.matrix.model;

public class DNASampleBuilder {
	
	private DNASample bean;
	
	public DNASampleBuilder(){
		this.bean = new DNASample();
	}

	public DNASampleBuilder setDna(String[] dna) {
		this.bean.setDna(dna);
		return this;
	}
		
	public DNASampleBuilder getHuman() {
		String[] array = {"CATG", "CTAT", "TTAT", "AATT"};
		this.bean.setDna(array);
		return this;
	}
	
	public DNASampleBuilder getSimian_s01() {
		String[] array = {"CATGAGAT", "CTATATTT", "TTATTGTT", "AATATGGT", "TCCATATA", "TCACTGAT", "GAGCTGAT", "AGCGCTGT"};
		this.bean.setDna(array);
		return this;
	}
	
	public DNASampleBuilder getSimian_s02() {
		String[] array = {"CCCC", "CACG", "GCAT", "TGAC"};
		this.bean.setDna(array);
		return this;
	}
	
	
	public DNASampleBuilder getSimian_s03() {
		String[] array = {"TAAT", "ATTA", "ATTA", "TAAT"};
		this.bean.setDna(array);
		return this;
	}
	
	public DNASample get() {
		return this.bean;
	}
	
}
