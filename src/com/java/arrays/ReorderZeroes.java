/**
 * shift zeroes to the right and non-zeroes to the left
 */

package com.java.arrays;

import java.util.Arrays;

public class ReorderZeroes {
	
	//input = [1, 0, 2, -1, 0, 0, 3, 9, 0, 0, 0]

	//		output = [1, 2, -1, 3, 9, 0, 0, 0, 0, 0, 0]


			public static int[] reorder(int[] input) {

			       for(int i = 0, j = 0; j < input.length; j++){
			           if(input[j] != 0){
			               if(i < j){
			                   swap(input, i, j);
			               }//if closes
			               i++;
			           }//outer if closes
			           
			       }

			    return input;
			}
			
			public static void swap(int[] a, int i, int j){
				int swap = a[i];
		        a[i] = a[j];
		        a[j] = swap;
			}

	public static void main(String[] args) {
		int[] input = {1, 0, 2, -1, 0, 0, 3, 9, 0, 0, 0};
		System.out.println(Arrays.toString(reorder(input)));

	}

}
