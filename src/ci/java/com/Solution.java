package ci.java.com;

public class Solution {
	
	public static int countPairs(int[] array, int len, int diff)
	 {
	    int i = 0, j = 1, pairs = 0;    
	    while (j < len) {
	        for (; j < len; ++j) {
	            if (array[j] == array[i] + diff) {
	                pairs++;
	            }
	        }
	    }    
	    return pairs;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,5};
		System.out.println(countPairs(arr, arr.length, 4));

	}

}
