package com.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PhoneKeyPadPermutations {
	public static void main(String[] args) {
		for (String sb : letterCombinations("43")) {
			System.out.println(sb);
		}
	}


	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		getLetters(digits, 0, new String(), result, getMap());
		return result;

	}


	private static void getLetters(String digits, int index, String sofar,
			ArrayList<String> result, HashMap<Character, String> map) {

		if (index == digits.length()) {
			result.add(sofar);
		}
		else if (digits.charAt(index) == '1' || digits.charAt(index) == '0') {
			getLetters(digits, index+1, sofar, result, map);
		}
		else {
			String letters = map.get(digits.charAt(index));
			for (int i = 0; i < letters.length(); i++) {
				getLetters(digits, index+1, sofar + letters.charAt(i), result, map);
			}
		}
	}


	private static HashMap<Character, String> getMap() {
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', " ");
		return map;
	}

}
