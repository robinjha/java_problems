/**
 * @author robin
 * date: 02/12/2014
 * 
 * given k files, each of them
- has two columns: key (String), value (integer)
- within each file, sorted by keys
- within each file, there’s no duplicate keys
- files are large, so we do not have enough memory to load files in memory (files are of multiple GB, and you have 300MB memory for jvm)

write a function to merge join the k files, and calculate for each key, sum(value), output to a file

for example:

File 1        File 2     File 3        File 4
aaa    1    bbb    1     aaa    5      ttt    1 *
bbb    2    ccc    2 *   ccc    1 *    uuu    5
ccc    8 *  ddd    6     ddd    2      vvv    2

output:
aaa    6
bbb    3
ccc    11
ddd    8
….

 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class MergeFiles {
	
	public static Map<String,Integer> hm;
	static Map<String, Integer> treeMap;
	
	@SuppressWarnings("resource")
	public static Map<String, Integer> merge(ArrayList<String> files) throws IOException{
		BufferedReader file = null;
	    hm = new TreeMap<String, Integer>();
	    for(String s : files){
	    	System.out.println("FileURL :" + s);
	    	file = new BufferedReader(new FileReader(s));
	    	String line = null;
	    	while((line = file.readLine()) != null){
	    		String[] parts = line.split(" ");
	    		if(hm.containsKey(parts[0])){
	    			hm.put(parts[0],Integer.parseInt(parts[1])+hm.get(parts[0]));
	    		}else{
	    			hm.put(parts[0],Integer.parseInt(parts[1]));
	    		}
	    	}
	    }
	     //treeMap = new TreeMap<String, Integer>(hm);
		 return hm;//treeMap;
	}
	
	public static void printMap(Map<String, Integer> hm){
		
		for(Entry<String, Integer> entry : hm.entrySet()){
			System.out.println("Key: "+entry.getKey() +"  Value: " + entry.getValue());
		}
		
	}

	public static void main(String[] args) throws IOException{
		ArrayList<String> fileNames = new ArrayList<String>();
		fileNames.add("/Users/robin/Documents/workspace/java_problems/src/file1");
		fileNames.add("/Users/robin/Documents/workspace/java_problems/src/file2");
		printMap(merge(fileNames));
	}
}
