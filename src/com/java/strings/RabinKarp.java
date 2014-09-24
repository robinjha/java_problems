package com.java.strings;

public class RabinKarp {
	
	private String pattern;
	private long pattHash;
	private String text;
	private int textLen;
	private int pattLen;
	private int prime;
	private int radix;
	private long RM;
	private int h; 
	
	
	public RabinKarp(String pat, String txt){
		this.pattern = pat;
		this.text = txt;
		this.pattLen = pat.length();
		this.textLen = txt.length();
		this.prime = longRandomPrime();
		this.radix = 256;
		this.h = 1;
	}
	
	
	public void search(String patt, String text){
		 int i, j;
		 int pHash = 0;
		 int tHash = 0;
		 
		 for(i = 0; i < pattLen-1; i++){
			 h = (h*radix)%prime;
		 }
		 
		 for(i = 0; i < pattLen; i++){
			 pHash = (radix*pHash + patt.charAt(i)) % prime;
			 tHash = (radix*tHash + text.charAt(i)) % prime;
		 }
		 
		 for(i = 0; i < textLen - pattLen; i++){
			 if(pHash == tHash){
				 for(j = 0; j < pattLen; j++){
					 if(text.charAt(i+j) != patt.charAt(j)){
						 break;
					 }
				 }
				 
				 if(j == pattLen)
					 System.out.println("Pattern found at index:" + i);
			 }
			 
			 if(i < textLen - pattLen){
				 tHash = (radix*(tHash - text.charAt(i)*h) + text.charAt(i+pattLen))%prime;
				 
				 if(tHash < 0){
					 tHash = tHash+prime;
				 }
			 
			 }
		 }
		 
		 
	}
	

	public long hash(String pat, int pattLen2) {
		long h = 0;
		for(int i = 0; i < pattLen2; i++){
			h = (radix * h + pat.charAt(i)) % prime; 
		}
		return 0;
	}

	public static int longRandomPrime() {
		
		return 101;
	}
	
	

	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
	    String pat = "AABA";
	    RabinKarp s = new RabinKarp(pat,txt);
	    s.search(pat, txt);
	    
	}

}
