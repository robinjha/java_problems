
package com.java.discountoffers;

import java.util.Arrays;

public class DiscountOffersTest {
	private static float[][] weight;
	private static float[][] maskMatrix;
	private static int[][] path;
	private static int[] rowVector;
	private static int[] colVector;
	private static int[] primesInRow;
	private static int[] rowColPrimedZeroes;
	private static int[] rowColUncoveredZero;
	private static int value = 0;
	
	
	public DiscountOffersTest(){
		createWeightMatrix();
		maskMatrix = new float[HelperFunctions.getCustomers().length][HelperFunctions.getProducts().length];
		rowVector = new int[maskMatrix.length];
		colVector = new int[maskMatrix[0].length];
		primesInRow = new int[maskMatrix.length];
		rowColPrimedZeroes = new int[2];
		rowColUncoveredZero = new int[2];
		path = new int[maskMatrix.length*maskMatrix[0].length+2][2];
		Arrays.fill(primesInRow, -1);
		value = 1;
	}
	
	/**
	 * 
	 * find the smallest element in each row and subtract it from every element in that row
	 * followed by smallest element of each column from all elements of the column.
	 * @param weightMatrix
	 */
	private static int reduceMatrix(float[][] weightMatrix, int level){
		for(int i = 0; i < weightMatrix.length; i++){
			float rowMinVal = Float.MAX_VALUE;
			for(int j = 0; j < weightMatrix[i].length; j++){
				if(rowMinVal > weightMatrix[i][j]){
					rowMinVal = weightMatrix[i][j];
				}
			}
			for(int j = 0; j < weightMatrix[i].length; j++){
				weightMatrix[i][j]-=rowMinVal;
			}
		}
		
		for (int i = 0; i < weightMatrix[0].length; i++) {
            float minValInCol = Float.MAX_VALUE;
            for (int j = 0; j < weightMatrix.length; j++) {
                if (minValInCol > weightMatrix[j][i]) {
                    minValInCol = weightMatrix[j][i];
                }
            }

            for (int j = 0; j < weightMatrix.length; j++) {
                weightMatrix[j][i] -= minValInCol;
            }

        }
		System.out.println("\n~~~~~~~~~~~~STEP 2~~~~~~~~~~~~~");
		printWeightMatrix(weightMatrix,"AFTER REDUCING THE MATRIX");
		return 2;
	}
	
	/**
	 *
	 * find the first zero in the matrix. If there is no zero in the row or column, star it.  
	 * @param weightMatrix
	 * @param rowStars
	 * @param colStars
	 */
	private static int initStarredZeroes(float[][] weightMatrix, float[][] maskMatrix, int[] rowStarredZeroes, int[] colStarredZeroes, int level){
		for(int r = 0; r < weightMatrix.length; r++){
			for(int c = 0; c < weightMatrix[r].length; c++){
				if(weightMatrix[r][c] == 0 && rowStarredZeroes[r] == 0 && colStarredZeroes[c] == 0){
					maskMatrix[r][c] = 1;
					rowStarredZeroes[r] = 1;
					colStarredZeroes[c] = 1;
				}
			}
		}
		
		for(int r = 0; r < weightMatrix.length; r++)
			rowStarredZeroes[r] = 0;
		
		for(int c = 0; c < weightMatrix[0].length; c++)
			colStarredZeroes[c] = 0;
		
		printArray(colStarredZeroes, "COL VECTOR");
		printArray(rowStarredZeroes, "ROW VECTOR");
		
		return 3;
	}
	
	/**
	 *  Cover each column containing a starred zero.Ê If k = min(n.m), where n and m are
	 *  the dimensions of the matrix, columns are covered, 
	 *  the starred zeros describe a complete set of unique assignments.Ê 
	 * @param colVector
	 * @param maskMatrix
	 * @param level
	 * @return
	 */
	private static int coverColumnWithStarredZeroes(int[] colVector, float[][] maskMatrix, int level){
		for(int m = 0; m < maskMatrix.length; m++){
			for(int n = 0; n < maskMatrix[m].length; n++){
				if(maskMatrix[m][n] == 1)
					colVector[n] = 1;
			}
			
		}
		
		int colCheck = 0;
		for(int i = 0; i < colVector.length; i++){
			colCheck+=colVector[i];
		}
		System.out.println("\n~~~~~~~~~~~~STEP 3~~~~~~~~~~~");
		printWeightMatrix(maskMatrix, "MASK MATRIX");
		printArray(colVector, "COL VECTOR");
		
		if(weight.length <= colCheck){
			return 7;
		}else{
			return 4;
		}
	}
	
	private static int[] noncoveredZero(float[][] weight,int[] rowVector, int[] colVector, int[] rowColUncoveredZero){
		boolean done = true;
		int m = 0;
		while(!done){
			int n = 0;
			while(n < weight[m].length){
				if(colVector[n] == 0 && rowVector[m] == 0 && weight[m][n] == 0){
					rowColUncoveredZero[0] = m;
					rowColUncoveredZero[1] = n;
					done = false;
				}
			}
			m+=1;
			if(m >= weight.length){
				done = false;
			}
		}
		return rowColUncoveredZero;
		
	}
	
	 /**
     * finds some uncovered zero and primes it
     * @param matrix
     * @param primesByRow
     * @param coveredRows
     * @param coveredCols
     * @return
     */
    private static int primeNonCoveredZero(float[][] weightMatrix, float[][] maskMatrix, int[] rowStarredZeroes, int[] colStarredZeroes, int level){
       
    	System.out.println("\n~~~~~~~~STEP 4~~~~~~~~~");
    	// find an uncovered zero and prime it
    	boolean done = true;
    	
    	while(!done){
    		rowColUncoveredZero = noncoveredZero(weight, rowVector, colVector, rowColUncoveredZero);
    		
    		if(rowColUncoveredZero[0] == -1){
    			done = false;
    			value = 6;
    		}else{
    			maskMatrix[rowColUncoveredZero[0]][rowColUncoveredZero[1]] = 2;
    			boolean isStarInRow = false;
    			
    			for(int i = 0; i < maskMatrix[rowColUncoveredZero[0]].length; i++){
    				 if(maskMatrix[0][i] == 1){
    					 isStarInRow = true;
    					 rowColUncoveredZero[1] = i;
    				 }
    			}
    			
    			if(isStarInRow == true){
    				rowVector[rowColUncoveredZero[0]] = 1;
    				colVector[rowColUncoveredZero[1]] = 0;
    			}else{
    				rowColPrimedZeroes[0] = rowColUncoveredZero[0];
    				rowColPrimedZeroes[1] = rowColUncoveredZero[1];
    				done = false;
    				value = 5;
    			}
    			
    		}
    	}
        printWeightMatrix(maskMatrix, "MASK MATRIX");
        printArray(rowVector,"ROW VECTOR");
        printArray(colVector,"COL VECTOR");
        printArray(rowColPrimedZeroes,"ZERO POSITIONS");
    	return value;
    }
    
    public static int countStarsInCol(float[][] maskMatrix, int col) {
    	int c = 0;
    	for(int i = 0; i < maskMatrix.length; i++){
    		if(maskMatrix[i][col] == 1){
    			c = i;
    		}
    	}
		return c;
	}
    
    public static int countPrimesInRow(float[][] maskMatrix, int row) {
    	int c = 0;
    	for(int i = 0; i < maskMatrix[row].length; i++){
    		if(maskMatrix[row][i] == 2){
    			c = i;
    		}
    	}
		return c;
	}
    
    public static void deletePrimes(float[][] maskMatrix){
    	for(int m = 0; m < maskMatrix.length; m++){
    		for(int n = 0; n < maskMatrix[m].length; n++){
    			if(maskMatrix[m][n] == 2){
    				maskMatrix[m][n] = 0;
    			}
    		}
    	}
    }
    
    public static void deleteCovers(int[] colVector, int[] rowVector){
    	for(int i = 0; i < rowVector.length; i++){
    		rowVector[i] = 0;
    	}
    	
    	for(int j = 0; j < colVector.length; j++){
    		colVector[j] = 0;
    	}
    }
    
    public static void modifyPath(int[][] path, float[][] maskMatrix, int value){
    	for(int m = 0; m <= value; m++){
    		if(maskMatrix[path[m][0]][path[m][1]] == 1){
    			maskMatrix[path[m][0]][path[m][1]] = 0;
    		}else{
    			maskMatrix[path[m][0]][path[m][1]] = 1;
    		}
    	}
    }

	public static int constructPrimeAndStarredZeroes(float[][] maskMatrix, int[] rowColUncoveredZero, int[] rowVector, int[] colVector, int level, int[][] path){
		int num = 0;
		path[num][0] = rowColUncoveredZero[0];
		path[num][1] = rowColUncoveredZero[1];
		
		boolean finished = true;
		
		while(!finished){
			int count = countStarsInCol(maskMatrix, path[num][1]);
			
			if(count >= 0){
				num+=1;
				path[num][0] = path[num - 1][0];
				path[num][1] = count;
			}
			
		}
		modifyPath(path, maskMatrix, num);
		deleteCovers(colVector, rowVector);
		deletePrimes(maskMatrix);
		
		System.out.println("\n~~~~~~~~~~~STEP 5~~~~~~~~~~~~~~");
		printWeightMatrix(maskMatrix, "MASK MATRIX");
		printArray(colVector,"COL VECTOR");
		printArray(rowVector,"ROW VECTOR");
		
		return 3;
	}
	
	public static float getSmallest(int[] colVector, int[] rowVector, float[][] weightMatrix){
		float min = Float.MAX_VALUE;
		for(int i = 0; i < weightMatrix.length; i++){
			for(int j = 0; j < weightMatrix[i].length; j++){
				if ((min > weightMatrix[i][j]) && colVector[j]==0 && rowVector[i]==0 ){
					min = weightMatrix[i][j];
				}
			}
		}
		return min;
	}
	
	public static int findSmallestUncoveredValue(int[] colVector, int[] rowVector, int value, float[][] weightMatrix){
		float min = getSmallest(colVector, rowVector, weightMatrix);
		
		for(int m = 0; m < rowVector.length; m++){
			for(int n = 0; n < colVector.length; n++){
				if(rowVector[m] == 1){
					weightMatrix[m][n]+= min;
				}
				if(colVector[n] == 0){
					weightMatrix[m][n]-= min;
				}
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~STEP 6~~~~~~~~~~~~~~");
		printWeightMatrix(weightMatrix, "WEIGHT MATRIX");
		printArray(rowVector,"ROW VECTOR");
		printArray(colVector, "COL VECTOR");
		return 4;
	}
	
	

	/**
	 * calculates the ss score
	 * @param customer
	 * @param product
	 * @return
	 */
	public static float score(String customer, String product) {
		float score = 0;
		if (product.length() % 2 == 0) {
			// Even
			score = 1.5f * HelperFunctions.numberOfVowels(customer);
		} else {
			// Odd
			score = HelperFunctions.numberOfConsonants(customer);
		}
		int gcd = HelperFunctions.gcd(product.length(), customer.length());
		if (gcd != 1) {
			score = score * 1.5f;
		}
		return score;
	}

	private static void createWeightMatrix(){
		weight = new float[HelperFunctions.getCustomers().length][HelperFunctions.getProducts().length];
		for(int i = 0; i < HelperFunctions.getCustomers().length; i++){
			for(int j = 0; j < HelperFunctions.getProducts().length; j++){
				weight[i][j] = score(Arrays.asList(HelperFunctions.getCustomers()).get(i), Arrays.asList(HelperFunctions.getProducts()).get(j));
			}
		}
	}
	
	private static void printWeightMatrix(float[][] weight, String step){
		System.out.println(String.format("------" +"%s"+"-----",step));
		for(int i = 0; i < weight.length; i++){
			for(int j = 0; j < weight[i].length; j++){
				System.out.print(weight[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void printArray(int[] arr, String step){
		System.out.println(String.format("------" +"%s"+"-----",step));
		System.out.print("[\t");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.print("]\n");
	}
	
	private static void assignProducts(){
		boolean done = false;
		while(!done){
			switch(value){

			case 1:
				value = reduceMatrix(weight, value);
				break;
			case 2: 
				value = initStarredZeroes(weight, maskMatrix, rowVector, colVector, value );
				break;
			case 3:
				value = coverColumnWithStarredZeroes(colVector,maskMatrix,value);
				break;
			case 4:
				value = primeNonCoveredZero(weight, maskMatrix, rowVector, colVector, value );
				break;
			case 5:
				value = constructPrimeAndStarredZeroes(maskMatrix, rowColUncoveredZero, rowVector, colVector, value, path);
				break;
			case 6:
				value = findSmallestUncoveredValue(colVector, rowVector, value, weight);
				break;
			case 7:
				done = true;
				break;
			}
		}

	}

	public static void main(String[] args) {
		String fileName = "/Users/robin/Documents/workspace/java_problems/src/com/java/discountoffers/testTwo.txt";
		/*
		 * 
		 * 	System.out.println("Please enter the filename : ");	
InputStreamReader input = new InputStreamReader(System.in);
BufferedReader reader = new BufferedReader(input);
String fileName = reader.readLine();

FileRead filer = new FileRead(fileName);
filer.FileReadInitial();
		 * 
		 * String fileName = null;
		if (args.length > 0) {
			try {
				fileName = args[0];
			} catch (Exception e) {
				System.err.println("Argument" + args[0] + " must be an string.");
				System.exit(1);
			}
		}*/
		HelperFunctions.populateProductsAndCustomers(fileName);
		DiscountOffersTest discountOffers = new DiscountOffersTest();
		createWeightMatrix();
		printWeightMatrix(weight,"ORIGINAL MATRIX");
		assignProducts();
	}

}
