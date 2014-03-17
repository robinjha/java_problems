/**
 * binary search time complexity : O(log(n))
 */

package com.java.arrays;

public class FindNumberInUnknownLengthArray {
	
	public static int searchArray(int[] arr, int num){
		int index = 0, exp = 0, left = 0, right = 0, mid = 0;
		
		while(true){
			try{
				if(arr[index] == num){
					return index;
				}else if(arr[index] < num){
					index = (int) Math.pow(2, exp);
					exp+=1;
				}else
					break;
				
			}catch(Exception ex){
				break;
			}
		}
		
		left = (index /2)+1;
		right = index -1;
		
		while(left <= right){
			try{
				mid = left + (right - left) /2;
				if(num > arr[mid])
					left = mid + 1;
				else if(num < arr[mid])
					right = mid -1;
				else 
					return mid;
				
			}catch(Exception ex){
				right = mid -1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int key = 14;
		int value = searchArray(a,key);
		if(value != -1){
			System.out.println("The key " +key +" was found at index:" + value);
		}else{
			System.out.println("The key values was not found:" + value);
		}


	}

}
