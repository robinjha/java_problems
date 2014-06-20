package ci.java.com;

public class Solution {
	
	public static void countPairs(int current_page, int total_pages)
	 {
		int NUM_VISIBLE_PAGES = 11;
		StringBuilder sb = new StringBuilder();
		int val = 0;
	    for(int i = 0 ; i < total_pages; i++){
	    	if(i == current_page){
	    		sb.append("[");
	    		sb.append(i);
	    		sb.append("]");
	    		val++;
	    	}else{
	    		if(val == NUM_VISIBLE_PAGES-1){
	    			
	    		}else{
	    			
	    		}
	    	}
	    }
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,5};
		//System.out.println(countPairs(arr, arr.length, 4));

	}

}
