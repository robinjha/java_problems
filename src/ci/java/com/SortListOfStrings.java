package ci.java.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListOfStrings {
	
	/**
	 * using collection.sort method
	 * @param unsortedList
	 * @return
	 */
	public static List<String> sortedList(List<String> unsortedList){
		Collections.sort(unsortedList);
		return unsortedList;
	}
	
	
	
	public static void printCollection(List<String> collection){
		for(String str : collection){
			System.out.println(str);
		}
		
	}

	public static void main(String[] args) {
		List<String> unsortedList = new ArrayList<String>();
		unsortedList.add("kathmandu");
		unsortedList.add("new york");
		unsortedList.add("chicago");
		unsortedList.add("london");
		unsortedList.add("angara");
		sortedList(unsortedList);
		printCollection(sortedList(unsortedList));
	}

}
