package ci.java.com;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInString {
	
	public static String removeDuplicates(String str){
		StringBuffer test = new StringBuffer("");
		Set<Character> charSet = new HashSet<Character>();//constant time performance for add, remove, contains, size
		for(int i = 0 ; i < str.length(); i++){
			if(!charSet.contains(str.charAt(i))){
				test.append(str.charAt(i));
				charSet.add(str.charAt(i));
			}
		}
		return test.toString();
	}

	public static void main(String[] args) {
		String test = "tree traversal";
		System.out.println("Duplicates removed String :" +removeDuplicates(test));

	}

}
