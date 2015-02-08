package com.java.dynamicprogramming;

public class LongestPalindromicSubsequence {
	/**
	 * time complexity - exponential
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static int lps(String str, int start, int end){
		if(str == null) throw new NullPointerException();
		if(str.length() == 0) return 0;
		if(start == end) return 1; // single character 
		
		if(start+1 == end && str.charAt(start) == str.charAt(end)){
			return 2;
		}
		
		if(str.charAt(start) == str.charAt(end)){
			return lps(str, start+1, end-1)+2;
		}else{
			return Math.max(lps(str, start-1, end), lps(str, start, end-1));
		}
		
	}
	
	/**
	 * time complexity O(n^2)
	 * dynamic programmming approach to solve the longest palindromic subsequence 
	 * @param str
	 * @return
	 */
	public static int lpsDP(String str){
		int max = 0;
		int i, j, len;
		int[][] length = new int[str.length()][str.length()];
		
		//string for length 1
		for(i = 0; i < str.length(); i++){
			length[i][i] = 1;
		}
		
		//populate the array
		for(len = 2; len <= str.length(); len++){
			for(i = 0; i < str.length()-len+1; i++){
				j = len+i-1;
				if(str.charAt(i) == str.charAt(j) && len == 2){
					length[i][j] = 2;
				}else if(str.charAt(i) == str.charAt(j)){
					length[i][j] = length[i+1][j-1]+2;
				}else{
					length[i][j] = Math.max(length[i][j-1], length[i+1][j]);
				}
				
			}
		}
		return length[0][str.length()-1];
	}

	public static void main(String[] args) {
		String test = "BBBABBB";
		System.out.println(lps(test, 0, test.length()-1));
		System.out.println(lpsDP(test));

	}

}
