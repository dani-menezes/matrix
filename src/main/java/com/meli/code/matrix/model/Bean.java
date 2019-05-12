package com.meli.code.matrix.model;

import com.google.gson.Gson;

public class Bean {
	
	public String toString() {
		return new Gson().toJson(this, this.getClass());
	}
}
