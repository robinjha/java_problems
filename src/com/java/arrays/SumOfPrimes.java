/**
 * Problem : Sum of Primes

write a function to test whether a given 3x3 matrix fulfills the following conditions:

#1) Every entry in the matrix is a unique prime number
#2) The two main diagonals sum to the same prime number

For example, m = 

  01   03   07
  23   05   19
  17   11   13

returns false 

because all the entries are unique prime numbers, and 

main diagonal1 = 17 + 5 + 7 = 19
main diagonal2 = 1 + 5 + 13 = 19
 */

package com.java.arrays;

import java.util.HashSet;
import java.util.Set;

public class SumOfPrimes {
	
	public static boolean sumOfPrimes(int[][] arr){
		
		boolean isSumOfPrimes = false;
		int diagonal1 = 0;
		int diagonal2 = 0;
		int count = arr.length - 1;
		for(int i = 0; i < arr.length; i++){
			diagonal1 += arr[i][i];
			diagonal2 += arr[i][count];
			count--;
		}
		System.out.println("Sum of Digonal elements are  :" + diagonal1 + " and "
                + diagonal2);

		if(diagonal1 == diagonal2){
			isSumOfPrimes = true;
		}else{
			isSumOfPrimes = false;
		}
			
		return isSumOfPrimes;
	}
	
	public static boolean isPrime(int n){
		for(int i = 1 ; i < n ; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isUnique(int[][] arr){
		Set<Integer> numSet = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if((!numSet.contains(arr[i][j])) && isPrime(arr[i][j])){
					numSet.add(arr[i][j]);
				}else{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		int[][] m = { { 01, 03, 07 }, { 23, 05, 19 }, { 17, 11, 13 } };
		System.out.println(sumOfPrimes(m));

	}

}
