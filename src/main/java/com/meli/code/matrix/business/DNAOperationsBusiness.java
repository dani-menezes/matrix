package com.meli.code.matrix.business;

import org.springframework.stereotype.Service;

@Service
public class DNAOperationsBusiness {
	
	public int checkXup(int[][] matrix, int n, int i, int j) {
		if ( j+3 < n && matrix[i][j] == matrix[i][j+1] && matrix[i][j] == matrix[i][j+2] &&  matrix[i][j] == matrix[i][j+3] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkXdown(int[][] matrix, int n, int i, int j) {
		if ( j-3 >= 0 && matrix[i][j] == matrix[i][j-1] && matrix[i][j] == matrix[i][j-2] && matrix[i][j] == matrix[i][j-3] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkYup(int[][] matrix, int n, int i, int j) {
		if ( i-3 >= 0 && matrix[i][j] == matrix[i-1][j] && matrix[i][j] == matrix[i-2][j] && matrix[i][j] == matrix[i-3][j] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkYdown(int[][] matrix, int n, int i, int j) {
		if ( i+3 < n && matrix[i][j] == matrix[i+1][j] && matrix[i][j] == matrix[i+2][j] && matrix[i][j] == matrix[i+3][j] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkXupYup(int[][] matrix, int n, int i, int j) {
		if ( i+3 < n && j+3 < n && matrix[i][j] == matrix[i+1][j+1] && matrix[i][j] == matrix[i+2][j+2] && matrix[i][j] == matrix[i+3][j+3] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkXdownYdown(int[][] matrix, int n, int i, int j) {
		if ( i-3 >= 0 && j-3 >=0 && matrix[i][j] == matrix[i-1][j-1] && matrix[i][j] == matrix[i-2][j-2] && matrix[i][j] == matrix[i-3][j-3] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkXupYdown(int[][] matrix, int n, int i, int j) {
		if ( i-3 >= 0 && j+3 < n && matrix[i][j] == matrix[i-1][j+1] && matrix[i][j] == matrix[i-2][j+2] && matrix[i][j] == matrix[i-3][j+3] ) {
			return 1;
		}
		return 0;
	}
	
	public int checkXdownYup(int[][] matrix, int n, int i, int j) {
		if ( i+3 < n && j-3 >= 0 && matrix[i][j] == matrix[i+1][j-1] && matrix[i][j] == matrix[i+2][j-2] && matrix[i][j] == matrix[i+3][j-3] ) {
			return 1;
		}
		return 0;
	}
}
