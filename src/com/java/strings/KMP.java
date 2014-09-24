package com.java.strings;

public class KMP {
	
	private static final int RADIX = 256;
	
	public static void search(String patt, String txt){
		int i, j;
		int h = 1;
		int prime = 101;
		int pHash = 0, tHash = 0;
		
		
		for(i = 0; i < patt.length() - 1; i++){
			h = (h*RADIX) % prime;
		}
		
		for(i = 0; i < patt.length(); i++){
			tHash = (RADIX*tHash + txt.charAt(i))%prime;
			pHash = (RADIX*pHash + patt.charAt(i))%prime;
		}
		
		for(i = 0; i < txt.length() - patt.length(); i++){
			if(pHash == tHash){
				for(j = 0; j < patt.length(); j++){
					if(txt.charAt(i+j) != patt.charAt(j)){
						break;
					}
					
				}
				if(j == patt.length()){
					System.out.println("The matching index is at "+ i);
				}
			}
			
			if(i < txt.length() - patt.length()){
				tHash = (RADIX*(tHash - txt.charAt(i) * h)+txt.charAt(i+patt.length()))%prime;
				
				if(tHash < 0){
					tHash = tHash+prime;
				}
			}
		}
	}

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
	    String patt = "AABA";
		
		search(patt, text);

	}

}
