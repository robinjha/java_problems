/**
 * Given a list of words, find the longest common prefix between them.
 * 
 * Complexity:  If the list has n elements and the length of the word is m
 * the upper bound is O(n*m)
 * 
 */

package ci.java.com;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
	
	public static String findLongestCommonPrefix(List<String> wordList){
		String longestPrefix = "";
		
		if(!wordList.isEmpty())
			longestPrefix = wordList.get(0);
	
		for(int i = 1; i < wordList.size(); i++){
			int j = 0;
			for(; j < wordList.get(i).length(); j++){
				if(longestPrefix.charAt(j) != wordList.get(i).charAt(j)){
					break;
				}
			}
			longestPrefix = wordList.get(i).substring(0, j);
		}
		return longestPrefix;
	}
	
	
	public static void main(String[] args){
		List<String> wordList = new ArrayList<String>();
		//wordList.add("word");
		//wordList.add("wordList");
		wordList.add("Substance");
		wordList.add("Substancial");
		wordList.add("Substinence");
		System.out.println(findLongestCommonPrefix(wordList));
	}

}
