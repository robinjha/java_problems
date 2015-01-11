package com.java.dynamicprogramming;

public class MinCostPath {
	
	
	/**
	 * recursive implementation
	 * @param cost
	 * @param i
	 * @param j
	 * @return
	 */
	public static int minCost(int cost[][], int i, int j){
		if(i < 0 || j < 0)
			return Integer.MAX_VALUE;
		else if(i == 0 && j == 0){
			return cost[i][j];
		}else{
			return cost[i][j]+Math.min(minCost(cost,i-1,j-1), Math.min(minCost(cost,i-1,j),minCost(cost,i,j-1)));
		}
	}
	
	/**
	 * 
	 * DP implementation - complexity O(mn)
	 * @param args
	 */
	public static int minCostDP(int cost[][], int row, int col ){
		int costVals[][] = new int[cost.length][cost[0].length];
		costVals[0][0] = cost[0][0];
		int i, j;
		//initialize first row and col values.cost matrix,
		//for formula "min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1])" 
		//we need to have i-1 and j-1 values. Thats why we need to initialize the first row and column.
		for(i = 1; i <= row; i++){
			costVals[i][0] = costVals[i-1][0]+cost[i][0]; 
		}
		
		for(j = 1; j <= col; j++){
			costVals[0][j] = cost[0][j]+ costVals[0][j-1];
		}
		
		for(i = 1; i <= row; i++){
			for(j = 1; j <= col; j++){
				costVals[i][j] = Math.min(costVals[i][j-1],Math.min(costVals[i-1][j-1], costVals[i-1][j])) + cost[i][j];
			}
		}
		
		
		return costVals[row][col];
	}
	
	
	public static void main(String[] args) {
		
		int[][] cost = {{1,2,3},{4,8,2},{1,5,3}};
		System.out.println(minCost(cost,2,2));
		System.out.println("Min Cost with Dynamic programming:" + minCostDP(cost, 2,2));
	}

}
