package com.java.dynamicprogramming;

import java.util.Scanner;

public class CoinChange {
	
	
		static int coinCount(int Am, int v[])
	    {
	       int[] M;
	       int[] sol, mySol;
	       int j, k, min;

	       M = new int[Am+1];
	       sol = new int[v.length];
	       mySol = new int[v.length];

	       /* ---------------------------
		  Base cases
		  --------------------------- */
	       M[0] = 0;	// 0 coins needed to make change for $0

	       /* ---------------------------------------------------
		  The other cases (starting from 1 to M.length - 1)
		  --------------------------------------------------- */
	       for ( j = 1; j <= Am; j++ )
	       {

	          if ( Am < 20 )
	             System.out.println("\nComputing M[" + j + "]");


	          /* --------------------------------------------------------
	             Try every denomination k = 1,2,..,C for the last coin
	             -------------------------------------------------------- */
	          for ( k = 0; k < v.length; k++ )
	             mySol[k] = -1;                   // Initialize mySol[]

	          for ( k = 0; k < v.length; k++ )
	          {
	             /* --------------------------------------------
	                Check if we can use the k-th denomination
	                -------------------------------------------- */
	             if ( v[k] <= j )
	             {
	                /* ------------------------
	                   Divide step
	                   ------------------------ */
	                sol[k] = M[j - v[k]];     // Use coin v[k] as last coin
	                mySol[k] = sol[k] + 1;    // Solution to make change for $j
	             }
	          }

	          /* --------------------------------------------------------
	             Find the minimum
	             -------------------------------------------------------- */
	          M[j] = -1;

	          for ( k = 0; k < v.length; k++ )
	          {
	             if ( mySol[k] >= 0 )
	             {
	                if ( M[j] == -1 || mySol[k] < M[j] )
	                   M[j] = mySol[k];
	             }
	          }

	          if ( M.length < 20 )
	             System.out.println("=====> M[" + j + "] = " + M[j]);
	       }

	       return( M[Am] );
	   }
	

	public static void main(String[] args) {
		int c, minCoin;
		int[] values = {1,3,9,19,26};
		System.out.println("Value of Coins");
		for(int i = 0; i < values.length; i++){
			System.out.println(values[i]+ ",");
		}
		System.out.println("\n");
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("Enter the amount you want to change: ");
			c = sc.nextInt();
			
			minCoin = coinCount(c,values);
			
			System.out.println("Min # of coins needed to make the change for " + c + " = " + minCoin);
			System.out.println("******************************************************");
		}

	}

	

}
