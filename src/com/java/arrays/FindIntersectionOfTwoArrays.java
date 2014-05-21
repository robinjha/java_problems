package com.java.arrays;

import java.util.ArrayList;
import java.util.Hashtable;

public class FindIntersectionOfTwoArrays {
	
	public static ArrayList<Integer> getIntersection(ArrayList<Integer> aList1, ArrayList<Integer> aList2){

	    Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    if(aList1.size() == 0 || aList2.size() == 0 ){
	        return null;
	    }
	    /*
	    if(aList1.size() > aList2.size()){
	        for(Integer i: aList2)
	           if(!ht.containsKey(aList2.get(i))
	               ht.put(aList1.get(i),"blah");
	    
	    }else{
	        for(Integer i: aList1)
	           if(!ht.containsKey(aList1.get(i))
	               ht.put(aList1.get(i),"blah");
	    }*/
	    for(Integer i: aList2){//~4
	           if(!ht.containsKey(aList2.get(i))){
	               ht.put(aList1.get(i),"blah");
	           }
	    }
	               
	    for(Integer i: aList1){
	        if(ht.containsKey(aList1.get(i))){
	            result.add(aList1.get(i));
	        
	        }
	     }   
	    
	    return result;
	        

	}
	
	public static void main(String[] args){
		ArrayList<Integer> aList1 = new ArrayList<Integer>();
		ArrayList<Integer> aList2 = new ArrayList<Integer>();
		aList1.add(1);
		aList1.add(2);
		aList1.add(3);
		aList2.add(4);
		aList2.add(5);
		aList2.add(1);
		getIntersection(aList1, aList2);
		
	}

}
