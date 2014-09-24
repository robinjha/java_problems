package com.java.collection;

import java.util.LinkedList;
import java.util.List;
import static java.util.Arrays.asList;



/**
 * Given an input list of lists.. flatten the list. For e.g.

	{{1,2}, {3}, {4,5}} ... Output should be {1, 2, 3, 4, 5}
 * @author robin
 *
 */


public class FlattenList {

	
	public static List<Object> flatten(List<?> l){
		List<Object> retVal = new LinkedList<Object>();
		flatten(l, retVal);
		return retVal;
	}
	
	
	public static void flatten(List<?> l, List<Object> retVal) {
		for(Object obj: l){
			if(obj instanceof List<?>){
				flatten((List<?>) obj, retVal);
			}else{
				retVal.add(obj);
			}
		}
		
	}
	
	private static List<Object> a(Object... a) {
		return asList(a);
	}

	public static void main(String[] args) {
		List<Object> treeList = a(a(1), 2, a(a(3, 4), 5), a(a(a())), a(a(a(6))), 7, 8, a());
		List<Object> flatList = flatten(treeList);
		System.out.println(treeList);
		System.out.println("flatten: " + flatList);
	}

}
