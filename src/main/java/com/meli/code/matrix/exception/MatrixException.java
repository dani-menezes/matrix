package com.meli.code.matrix.exception;

public class MatrixException extends Exception {

	private static final long serialVersionUID = 7383837609116819621L;

	public MatrixException(String message) {
		super(message);
	}
	
	public MatrixException(String message, Throwable cause) {
		super(message, cause);
	}


}