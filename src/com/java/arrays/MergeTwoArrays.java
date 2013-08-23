package com.java.arrays;

import java.util.Arrays;


//[2,4,6,8] = 4
//[, , ,3, ,5,7, ,9] = 9
public class MergeTwoArrays {

	public static void merge(int[] smallArr, int[] largeArr, int counter){
		int smallArrIndex = smallArr.length - 1;
		int largeArrIndex = counter - 1;
		int currPosition = counter+ smallArr.length -1;
		
		while(smallArrIndex >= 0){
			if(largeArr[largeArrIndex] > smallArr[smallArrIndex]){	
				largeArr[currPosition] = largeArr[largeArrIndex];
				--largeArrIndex;
			}else{
				largeArr[currPosition] = smallArr[smallArrIndex];
				--smallArrIndex;
			}
			--currPosition;
		}
		System.out.println("Merged Array is :" + Arrays.toString(largeArr));
	}
	/*
	 * test code
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int smallArr[] = new int[]{0,2,4,6,8}; //n = 5
		int largeArr[] = new int[12];//{1,3,5,7,9,11,13};  m = 7 (m+n) = 11
		int counter = 0;
		
		for(int i = 1; i <= 13; i=i+2){
				largeArr[counter] = i;
				counter++;
		}
		
		
		merge(smallArr, largeArr, counter);
	}

}
