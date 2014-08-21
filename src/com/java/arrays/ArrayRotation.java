package com.java.arrays;

public class ArrayRotation {
	
	public static int[] rotate(int[] arr, int d, int n){
		int[] tmp = new int[d];
		for(int i = 0; i < d; i++){
			tmp[i] = arr[i];
		}
		
		for(int j = 0; j < arr.length; j++){
			arr[j] = arr[j+d];
		}
		
		for(int k = arr.length; k > d ; k-- ){
			arr[k] = tmp[k];
		}
		return arr;
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print("\t"+i);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		rotate(arr,2,10);

	}

}
