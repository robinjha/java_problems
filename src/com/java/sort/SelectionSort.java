package com.java.sort;


public class SelectionSort{
	
	private SelectionSort(){}
	
	private static boolean less(Comparable a, Comparable b){
		return (a.compareTo(b) < 0);
	}
	
	public static void swap(Object[] arr, int i,int j){
		Object ex = arr[i];
		arr[i] = arr[j];
		arr[j] = ex;
	}
	
	public static void sort(Comparable[] arr){
		for(int i = 0; i < arr.length; i++){
			int min = i;
			for(int j = i+1; j < arr.length; j++){
				if(less(arr[j], arr[min])){
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}
	
	public static void print(Comparable[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args){
		String[] a = {"test","is","a","cat"};
		SelectionSort.sort(a);
		print(a);
	}

}
