package com.java.sort;

public class MergeSort {
	
	public static boolean less(Comparable a, Comparable b){
		return (a.compareTo(b) < 0); //negative less than
	}
	
	public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
		for(int i = lo; i <= hi; i++){
			aux[i] = arr[i];
		}
		
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++){
			if(less(arr[i],arr[j])){
				aux[k] = arr[j++];
			}else{
				aux[k] = arr[i++];
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
		MergeSort.merge(arr, aux, lo, mid, hi);
		print(a);

	}

}
