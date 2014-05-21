package com.java.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//[1, 2, 3, [1, 2, 3]]

public class PrettyPrint {
	
	public static void main(String[] args){
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.addAll(al);
		System.out.println(al);
	}

}
