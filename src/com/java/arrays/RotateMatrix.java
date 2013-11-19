package com.java.arrays;

public class RotateMatrix {
	
	/**
	 * @param matrix
	 * @return the transposed matrix
	 */
	
	public static int[][] transposeMatrix(int[][] matrix){
		int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				transposedMatrix[j][i] = matrix[i][j];
			}
		}
		return transposedMatrix;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tMatrix = {{01,02,03,04},{05,06,07,8},{9,1,0,2},{3,4,5,6}};
		
		for(int i = 0; i < tMatrix.length; i++){
			for(int j = 0; j < tMatrix[0].length; j++){
				System.out.print("  " +tMatrix[i][j]);
			}
			System.out.println();
		}
		tMatrix = transposeMatrix(tMatrix);
		System.out.println("---------TRANSPOSED MATRIX------------");
		for(int i = 0; i < tMatrix.length; i++){
			for(int j = 0; j < tMatrix[0].length; j++){
				System.out.print("  "+tMatrix[i][j]);
			}
			System.out.println();
		}

	}

}
