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
	
	public static int[] merge(int[] a, int[] b) {

	    int[] answer = new int[a.length + b.length];
	    int i = 0, j = 0, k = 0;
	    while (i < a.length && j < b.length)
	    {
	        if (a[i] < b[j])
	        {
	            answer[k] = a[i];
	            i++;
	        }
	        else
	        {
	            answer[k] = b[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < a.length)
	    {
	        answer[k] = a[i];
	        i++;
	        k++;
	    }

	    while (j < b.length)
	    {
	        answer[k] = b[j];
	        j++;
	        k++;
	    }

	    return answer;
	}
	/*
	 * test code
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int smallArr[] = new int[]{0,2,4,6,8}; //n = 5
		int largeArr[] = new int[12];//{1,3,5,7,9,11,13};  m = 7 (m+n) = 11
		int[] arrA = {};
		int[] arrB = {2,4,6};
		int counter = 0;
		
		for(int i = 1; i <= 13; i=i+2){
				largeArr[counter] = i;
				counter++;
		}
		
		
		//merge(smallArr, largeArr, counter);
		int[] arrResult = merge(arrA, arrB);
		System.out.println(Arrays.toString(arrResult));
	}

}
