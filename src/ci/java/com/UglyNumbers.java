package ci.java.com;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * There are 2 non-negative integers: i and j. Given the following equation, find an (optimal) solution to iterate over i and j in such a way that the output is sorted.

	2^i * 5^j
	
	So the first few rounds would look like this:
	
	2^0 * 5^0 = 1
	2^1 * 5^0 = 2
	2^2 * 5^0 = 4
	2^0 * 5^1 = 5
	2^3 * 5^0 = 8
	2^1 * 5^1 = 10
	2^4 * 5^0 = 16
	2^2 * 5^1 = 20
	2^0 * 5^2 = 25

 * numbers which has only 2,3 and 5 as prime factors are considered ugly numbers. 
 * @author robin
 *
 */


public class UglyNumbers {
	
	public static int[] uglyNum(int n){
		
		int[] val = new int[n];
		val[0] = 1;
		
		int index2 = 0;
		int index5 = 0;
		
		int nextIndex2 = 2 * val[index2];
		int nextIndex5 = 5* val[index5];
		
		for(int i = 1; i < n ; i++){
			int m = Math.min(nextIndex2, nextIndex5);
			//System.out.print(m + "\t");
			
			val[i] = m;
			
			if(nextIndex2 == m){
				++index2;
				nextIndex2 = 2*val[index2];
			}
			
			if(nextIndex5 == m){
				++index5;
				nextIndex5 = 5*val[index5];
			}
		}
		return val;
	}
	
	public static TreeSet<Long> uglyNum2(int num){
		
		SortedSet<Long> set = new TreeSet<Long>();
		set.add((long)1);
		
		long curr = 0;
		for(int i = 0; i < num; i++){
			curr = set.first();
			System.out.println("number " + (i + 1) + ":   " + curr);
			
			set.add(2*curr);
			set.add(3*curr);
			set.add(5*curr);
			set.remove(curr);

		}
		return (TreeSet<Long>) set;
	}
	
	/**
	 * 2^x * 3^y * 5^z
	 */
	public static void uglyNum3(int num){
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		long[] result = new long[num];
		result[0] = 1;
		for(int i = 1; i < num; i++){
			long prev = result[i - 1];
			while(2*result[i2] <= prev)
				++i2;
			while(3*result[i3] <= prev)
				++i3;
			while(5*result[i5] <= prev)
				++i5;
			
			long val1 = 2*result[i2];
			long val2 = 3*result[i3];
			long val3 = 5*result[i5];
			
			result[i] = Math.min(val1, Math.min(val2, val3));
		}
		System.out.println(result[num - 1]);
	}

	public static void main(String[] args) {
		
		
		//System.out.println(Arrays.toString(uglyNum(5)));
		//System.out.println(uglyNum2(5));
		//uglyNum2(20);
		uglyNum3(5);
	}

}
