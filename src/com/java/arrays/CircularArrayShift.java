package com.java.arrays;

/**
 * Given an integer array perform circular right shift by n. 
 * @author robin
 *
 */

public class CircularArrayShift {
	
	/**
	 * Time complexity O(n)
	 * Auxiliary Space: O(d)
	 * @param arr
	 * @param size
	 * @param shiftFactor
	 */
	public static void shiftUsingTempArray(int[] arr, int size, int shiftFactor){
		int[] temp = new int[shiftFactor];
		
		for(int i = 0; i < shiftFactor; i++){
			temp[i] = arr[i];
		}
		
		for(int i = 0; i < arr.length-shiftFactor; i++){
			arr[i] = arr[i+2];
		}
		
		for(int i = 0; i < temp.length; i++){
			arr[size - shiftFactor+i] = temp[i];
		}
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	/**
	 * Time complexity: O(n*d)
     * Auxiliary Space: O(1)
	 * @param arr
	 * @param size
	 * @param shiftFactor
	 */
	public static void leftRotate(int[] arr, int size, int shiftFactor){
		for(int i = 0; i < shiftFactor; i++){
			leftRotateByFactOfOne(arr, size);
		}
	}

	
	public static void leftRotateByFactOfOne(int[] arr, int size) {
		int temp, i;
		temp = arr[0];
		for(i = 0; i < size - 1; i++)
			arr[i] = arr[i+1];
		arr[i] = temp;
		
	}
	
	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+ "  ");
		}
	}
	
	public static int gcd(int a, int b){
		
		if(b == 0){
			return a;
		}else{
			return gcd(b,a%b);
		}
	}
	
	/**
	 * Time complexity: O(n)
	 * Auxiliary Space: O(1)
	 * @param arr
	 * @param n
	 * @param d
	 */
	public static void leftRotate2(int arr[], int n, int d){
		int i, j, k, temp;
		for(i = 0; i < gcd(d, n); i++){
			temp = arr[i];
			j = i;
			while(true){
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;


		}
	}

	public static void shiftLeft(){
		
		
	}
	
	public static void rightShift(int[] arr, int n, int d){
		if(n <= 1)
			System.out.println("Array should have more than one integer");
		
		else{
			System.out.println("---BEFORE SHIFT----");
			printArray(arr);
			int[] outArr = new int[n];
			int i = 0;
			
			while(i < n){
				int k = (i+d) % n;
				outArr[k] = arr[i];
				i++;
			}
			
			System.out.println("\n---AFTER SHIFT----");
			printArray(outArr);
		}
	}
	
	public static void inPlaceRightShift(){
		
	}
	
	public static void inPlaceLeftShift(){
		
	}
	
	public static void main(String[] args) {
		int[] arr= {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12};
		//shiftUsingTempArray(arr,7,2);
		//leftRotate2(arr, 12,3);
		//printArray(arr);
		rightShift(arr, 12,3);
	}

}
