package ci.java.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class StringPermutation {
	
	public boolean isPermutation(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		else{
			char[] chStr1 = str1.toCharArray();
			char[] chStr2 = str2.toCharArray();
			Arrays.sort(chStr1);
			Arrays.sort(chStr2);
			
			for(int i = 0; i < chStr1.length ; i++ ){
					if(chStr1[i] != chStr2[i]){
						return false;
				}
			}
			
			return true;
		}
	}
	
	public static boolean isPermutation2(String str1, String str2){
		char[] chStr1 = str1.toCharArray();
		char[] chStr2 = str2.toCharArray();
		int count = 0;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for(char c: chStr1){
			count = 1;
			if(hm.containsKey(c)){
				count = hm.get(c);
				count++;
			}
			hm.put(c, count);
		}
		
		for(char c: chStr2){
			if(hm.containsKey(c)){
				count = hm.get(c);
				count--;
			}
			hm.put(c, count);
		}
		
		Iterator it = hm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pairs = (Entry) it.next();
			if(!pairs.getValue().equals(0)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "god";
		String str2 = "dog";
		StringPermutation test = new StringPermutation();
		System.out.println(" Is permutation:"+test.isPermutation2(str1, str2));

	}

}
