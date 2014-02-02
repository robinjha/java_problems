package com.java.dynamicprogramming;
//set{1,2} -> subsets {{},{1},{2},{1,2}}
import java.util.ArrayList;

public class SubsetsOfSet {

	//TODO - complete this method
	public static ArrayList<ArrayList<Integer>> listSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> subSetsList;
		if(set.size() == index){
			subSetsList = new ArrayList<ArrayList<Integer>>();
			subSetsList.add(new ArrayList<Integer>());
		}else{
			
		}
		return null;
	}
	
	public static void subsets(String s, String prefix){
		System.out.println("Prefix: " + prefix);
		for(int i = 0; i < s.length(); i++){
			System.out.println("Substring: "+ s.substring(i+1)+" Prefix: "+ prefix+s.charAt(i));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			subsets(s.substring(i+1), prefix+s.charAt(i));
			
		}
	}
	
	public static void main(String[] args) {
		String set = "abc";
		subsets(set, "");
	}

}
