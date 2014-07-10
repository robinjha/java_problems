package com.java.strings;

public class ReverseStringAndWords {
	
	public static void reverse(char[] arr){
		
	}
	
	public static void reverseSentence(String str){
		StringBuilder sb = new StringBuilder();
		int end = str.length();
		int counter = str.length() - 1;
		
		for(int i = str.length() -1 ; i >= 0; i--){
			if(str.charAt(i) == ' ' || i == 0){
				if(i != 0){
					sb.append(str.substring(i+1, end));
					sb.append(" ");
				}else{
					sb.append(str.substring(i, end));
				}
				end = counter;
			}
			counter-- ;
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		String str = "this is a test";
		char[] arr = str.toCharArray();
		
		reverse(arr);
		reverseSentence(str);
	}

}
