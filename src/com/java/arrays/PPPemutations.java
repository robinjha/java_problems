package com.java.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PPPemutations {
	
	public static Map<Integer, String> hm = new HashMap<Integer, String>();
	
	public static ArrayList<String> getWords(String num){
		ArrayList<String> words = new ArrayList<String>();
		
		for(int i = 0; i < num.length(); i++){
			getWords(num, i, hm, words);
		}
		return words;
	}
	
	public static void getWords(String num, int index, Map<Integer, String> hm, ArrayList<String> words){
		
	}

	public static void main(String[] args) {
		String num = "44";
		getWords(num);

	}

}
