package com.java.dynamicprogramming;

/**
 * From two sequences, find the length of longest subsequence present in both of them. 
 * The sequence that appears in the same relative order, 
 * but does not have to be contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”
 *
 */


	/**
	 * recursive implementation
	 * run time is O(2^n)
	 * @author robin
	 *
	 */
	public class LongestCommonSubsequence {
		public static int[][] arr;
		
		public static int lcs(String s1, String s2, int m, int n){
			if(m == 0 || n == 0)
				return 0;
			else if(s1.charAt(m-1) == s2.charAt(n-1)){
				return 1+lcs(s1,s2,m-1, n-1);
			}else{
				return Math.max(lcs(s1,s2, m,n-1),lcs(s1,s2,m-1, n));
			}
		}
	
	/**
	 * DP implementation 
	 * @return

	public static int subproblems(int i, int j){
		if(arr[i][j] < 0){	
			if(arr[i].equals('\0') || arr[j].equals('\0'))
				return 0;
			else if(arr[i-1] == arr[j-1]){
				return 1+lcs(s1,s2,m-1, n-1);
			}else{
				return Math.max(lcs(s1,s2, m,n-1),lcs(s1,s2,m-1, n));
			}
        }
	}*/
	
	public static int lcsDP(String s1, String s2, int m, int n){
		arr = new int[m][n];
		return 0;
	}
	

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(lcs(s1,s2,s1.length(),s2.length()));

	}

}
