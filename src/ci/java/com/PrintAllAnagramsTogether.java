/**
 * Given an array of words, print all anagrams together. 
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, 
 * then output may be “cat tac act dog god”.
 * 
 * Time Complexity: Let there be N words and each word has maximum M characters. The upper bound is O(NMLogM).
 * Sorting a word takes maximum O(MLogM) time. So sorting N words takes O(NMLogM) time. 
 */

package ci.java.com;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class PrintAllAnagramsTogether {
	
	public static void printAllAnagrams(List<String> wordList){
		Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
		
		try{
			for(String word: wordList){
				char[] w = word.toCharArray();
				Arrays.sort(w);
				String sortedWord = new String(w);
				
				if(!wordMap.containsKey(sortedWord)){
					ArrayList<String> arr = new ArrayList<String>();
					arr.add(word);
					wordMap.put(sortedWord, arr);
				}else{
					wordMap.get(sortedWord).add(word);
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			 for(String key : wordMap.keySet()){
				 System.out.println("key :" + key + " value: " + wordMap.get(key));
			 }
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> wordList = new ArrayList<String>();
		wordList.add("abc");
		wordList.add("god");
		wordList.add("cab");
		wordList.add("dog");
		printAllAnagrams(wordList);

	}

}
