package com.java.strings;

public class ConvertIntToString {
	
	public static String intToString(int i){
		boolean isNegative = false;
		if(i < 0)
			isNegative = true;
		else
			isNegative = false;
		StringBuilder str = new StringBuilder();
		while(i != 0){
			str.append(i%10);
			i /= 10;
		}
		
		if(isNegative)
			str.append('-');
		
		str.reverse();
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(intToString(-56));

	}

}
