package com.java.strings;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToDecimal {
	
	static Map<Character, Integer> romanHmap = new HashMap<Character, Integer>();
	
	public static int romanToDecimal(String str){
		
	}

	public static void populateMap(){
		romanHmap.put('I', 1);
		romanHmap.put('V', 5);
		romanHmap.put('X', 10);
		romanHmap.put('L', 50);
		romanHmap.put('C', 100);
		romanHmap.put('D', 500);
		romanHmap.put('M', 1000);
	}
	
	
	public static void main(String[] args) {
		

	}

}
