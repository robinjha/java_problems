package com.java.arrays;

public class BooleanMatrix {
	
	public BooleanMatrix(int[][] a, int m, int n) {
		super();
		this.a = a;
		this.m = m;
		this.n = n;
	}

	private  int[][] a;
	private  int m;
	private  int n;



	public  int scanColumn(int j){
		int allZero = 0;
		for(int k = 0; k < m; k++){
			if(a[k][j] == 1){
				allZero = 1;
				break;
			}
		}
		return allZero;
	}

	public int scanRow(int i){
		int allZero = 0;
		for(int k = 0; k < n ; k++){
			if(a[i][k] == 1){
				allZero = 1;
				break;
			}
		}
		return allZero;
	}

	public void setRowToOnes(int i){
		for(int k = 0; k < n; k++){
			a[i][k] = 1;
		}
	}

	public void setColToOnes(int j){
		for(int k = 0; k < m; k++){
			a[k][j] = 1;
		}
	}

	public void transformMatrix(){
		//we're going to use the first row and column
		// of the matrix to store row and column scan values,
		// but we need aux storage to deal with the overlap
		int firstRow = scanRow(0);
		int firstCol = scanColumn(0);

		//scan each column and store result in 1st row - O(mn)
		for(int k = 0; k < n; k++){
			a[0][k] = scanColumn(k);
		}

		//do the same for rows into column 0 - O(mn)
		for(int k = 0; k < m; k++){
			a[k][0] = scanRow(k);
		}

		//a[0][0] = firstRow|firstCol;

		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				a[i][j] = a[0][j] | a[i][0];
			}
			//System.out.println();
		}

		if (firstRow == 1) {
			setRowToOnes(0);
		}

		if (firstCol == 1) 
			setColToOnes(0);


	}
	
	/* A utility function to print a 2D matrix */
	static void printMatrix(int[][] arr)
	{
	    int i, j;
	    for (i = 0; i < arr.length; i++)
	    {
	        for (j = 0; j < arr[i].length; j++)
	        {
	            System.out.print(arr[i][j]+",");
	        }
	        System.out.println("\n");
	    }
	    System.out.println("=================");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i< m;i++) {
			for(int j = 0;j < n;j++) {
				sb.append(a[i][j] + ", ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int[][] a = {{1, 1, 0, 1, 0}, {0, 0, 0, 0, 0},{0, 1, 0, 0, 0},{1, 0, 1, 1, 0}};
		printMatrix(a);
        BooleanMatrix mt = new BooleanMatrix(a, 4, 5);
        mt.transformMatrix();
        System.out.println(mt);

	}

}
