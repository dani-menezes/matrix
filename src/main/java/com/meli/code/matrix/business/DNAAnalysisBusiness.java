package com.meli.code.matrix.business;

import java.util.Arrays;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.code.matrix.exception.MatrixException;

@Service
public class DNAAnalysisBusiness {
	
	@Autowired
	private DNAOperationsBusiness operations;
	
	@Autowired
	private StatsBusiness statsBusiness;
	
	/**
	 * Método que realiza o processamento do DNA
	 * 1 - Realiza o parser do array de String para Matriz[][] de int.
	 * 2.- Processa o dna.
	 * 3 - Salva a Análise
	 */
	public boolean executeAnalysis(String[] sample) throws MatrixException {
		int[][] matrix = this.parseMatrix(sample);
		Boolean isSimian = this.checkIfMatrixIsSimian(matrix);
		statsBusiness.saveStats(sample, isSimian);
		return isSimian;
	}
	
	/**
	 * Realiza o parser do array de String.
	 * Converte cada String em uma linha da Matriz, percorrendo pelos caracteres e criando os elementos com o valor int do char.
	 */
	public int[][] parseMatrix(String[] sample) throws MatrixException {
		if (sample != null && sample.length > 0) {
			Integer n = sample.length;
			int[][] result = new int[n][n];
			for (int i = 0; i < n; i++) {
				if (sample[i].length() != n) {
					throw new MatrixException("Error at parse [Wrong sample]");
				}
				for (int j =0; j < n; j++) {
					result[i][j] = this.parseElement(sample[i].charAt(j));
				}
			}
			return result;
		}
		return null;
	}
	
	public char parseElement(char element) throws MatrixException {
		switch (element) {
			case 'A':
			case 'C':
			case 'T':
			case 'G':
				return element;
		}
		throw new MatrixException("Error at parse [Wrong element]");
	}
	
	public boolean checkIfMatrixIsSimian(int[][] matrix) {
		int n = matrix[0].length;
		if (n < 4) {
			return false;
		}
		int count = 0;
		// Iteração simples, para facilitar a obtenção do i e do j.
		for (int i = 0; i < n; i++) {
			for (int j =0; j < n; j++) {
				count += this.operations.checkXup(matrix, n, i, j);
				count += this.operations.checkXdown(matrix, n, i, j);
				count += this.operations.checkYup(matrix, n, i, j);
				count += this.operations.checkYdown(matrix, n, i, j);
				count += this.operations.checkXupYup(matrix, n, i, j);
				count += this.operations.checkXdownYdown(matrix, n, i, j);
				count += this.operations.checkXupYdown(matrix, n, i, j);
				count += this.operations.checkXdownYup(matrix, n, i, j);
			}
		}
		return  count > 3 && count % 2 ==0;
	}
	
	/**
	 * Método auxiliar, para ajudar no debug da construção do algoritimo.
	 * @param matrix Array 2D de int representando o DNA
	 */
	public void printMatrix(int[][] matrix) {
		Consumer<int[]> printRow = (row) -> {
			Arrays.stream(row).forEach((el) -> System.out.print(" " + ((char)el) + " "));
			System.out.println();
		};
		
		Arrays.stream(matrix).forEach((row) -> printRow.accept(row));
	}
}

