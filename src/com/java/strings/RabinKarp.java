package com.java.strings;

public class RabinKarp {
	
	private String pattern;
	private long pattHash;
	private static int pattLen;
	private long hashVal;
	private int radix;
	private long RM;
	
	
	
	public RabinKarp(String pat){
		this.pattern = pat;
		this.radix = 256;
		this.pattLen = pat.length();
		hashVal = longRandomPrime();
		
		RM = 1;
		for(int i = 0; i < pattLen; i++){
			RM = (radix * RM) % hashVal;
		}
		pattHash = hash(pat, pattLen);
	}

	public long hash(String pat, int pattLen2) {
		long h = 0;
		for(int i = 0; i < pattLen2; i++){
			h = (radix * h + pat.charAt(i)) % hashVal; 
		}
		return 0;
	}

	public long longRandomPrime() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
	    String pat = "ABA";
	   
	    
	}

}
