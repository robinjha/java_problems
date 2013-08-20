package com.java.inheritance;

public class uniqueChars {

	/**
	 * @param args
	 */
	
	public static boolean isUniqueChars(String str){
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			System.out.println(str.charAt(i));
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a brown fox jumps over a lazy dog";
		if(isUniqueChars(str)){
			System.out.println("No chars are repeated!!!");
		}
		else{
			System.out.println("Chars are repeated!!");
		}

	}

}
