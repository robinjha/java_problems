package com.java.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MostFrequentVisitedWebsites {
	
	private static SortedMap<String, Integer> webMap = null;
	
	public static void populateMap(File f){
		BufferedReader br = null;
		webMap = new TreeMap<String, Integer>();
		int count = 0;
		try{
			String currLine = null;
			
			br = new BufferedReader(new FileReader(f));

			while((currLine = br.readLine()) != null ){
				if(!webMap.containsKey(currLine)){
					count++;
					webMap.put(currLine, count);
					count = 0;
				}else{
					webMap.put(currLine, webMap.get(currLine) + 1);
					
				}
			}

		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(br != null) br.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}


	}
	
	public static Map findMostVisited( SortedMap<String, Integer> webMap){
		List list = new LinkedList(webMap.entrySet());
		int count = 0;
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		
		// put sorted list into map again
        //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for(Iterator it = list.iterator(); it.hasNext();){
			//if(count <= numOfTopSites){
				//count++;
				Map.Entry entry = (Map.Entry)it.next();
				sortedMap.put(entry.getKey(), entry.getValue());
			//}
		}
		return sortedMap;
	}
	
	public static void printMap(Map<String, Integer> webMap, int numOfTopSites){
		int count = 0;
		for(String key: webMap.keySet()){
			if(count < numOfTopSites){
				count++;
				System.out.println("key :" + key + " value: " + webMap.get(key));
			}
		}
	}

	public static void main(String[] args) {
		File f = new File("/Users/robin/Documents/workspace/java_problems/src/com/java/collection/logFile.txt");
		populateMap(f);
		printMap(findMostVisited(webMap),3);
		

	}

}
