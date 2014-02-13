package com.java.dynamicprogramming;

import java.util.Scanner;

public class MakeChange {
	
	public static int getChange(int n , int[] denom, int index){
		if(index == denom.length)return 1;
		int combs = 0;
		for(int i = 0; i < n; i++){
			combs += 
		}
	}

	public static int getChangeWays(int n){
		int[] denom = {1,5,10,25};
		return getChange(n,denom,0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		getChangeWays(sc.nextInt());
	}

}
