/**
 * Compares: N^2/4 , Exchanges: N^2/4 
 */

package com.java.sort;

public class InsertionSort {

	public static boolean less(Comparable a, Comparable b){
		return (a.compareTo(b) > 0);
	}

	public static void swap(Object[] arr, int i, int j){
		Object swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}

	public static void sort(Comparable[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j > 0; j--){
				if(less(arr[j - 1], arr[j])){
					swap(arr, j-1, j);
				}
			}
		}
	}

	public static void print(Comparable[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		String[] a = {"test","is","a","cat"};
		InsertionSort.sort(a);
		print(a);

	}

}
