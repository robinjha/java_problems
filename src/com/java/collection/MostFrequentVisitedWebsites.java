package com.java.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MostFrequentVisitedWebsites {
	
	public static void populateMap(File f){
		BufferedReader br = null;
		SortedMap<String, Integer> webMap = new TreeMap<String, Integer>();
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
				printMap(webMap);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}


	}
	
	public static void findMostVisited(int numOfTopSites, SortedMap<String, Integer> webMap){
		List list = new ArrayList(webMap.entrySet());
		Collections.sort(list, new Comparator(){
			@Override
			  public int compare(Entry e1, Entry e2) {
			    return ((File) e1.getValue()).compareTo(e2.getValue());
			  }
			 
			});
		}
	}
	
	public static void printMap(SortedMap<String, Integer> webMap){
		for(String key: webMap.keySet()){
			 System.out.println("key :" + key + " value: " + webMap.get(key));
		}
	}

	public static void main(String[] args) {
		File f = new File("/Users/robin/Documents/workspace/java_problems/src/com/java/collection/logFile.txt");
		populateMap(f);

	}

}
