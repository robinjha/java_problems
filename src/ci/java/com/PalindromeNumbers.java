/**
 * @author robin
 * This program calculates every palindrome between start and end values which the user is prompted to enter. 
 * 
 */
package ci.java.com;

import java.util.Scanner;

public class PalindromeNumbers {
	
	/**
	 * Check if a number is palindrome or not. 
	 * @param input - takes a number as an input
	 * @return - true if a number is palindrome, false otherwise
	 */
	public static boolean checkPalindrome(int input){
		int reversedNum = 0;
		int origNum = input;

		while(input != 0){

			reversedNum = reversedNum * 10 + input % 10;
			input = input / 10;

		}

		if(reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE){
			throw new IllegalArgumentException();
		}

		if(origNum == reversedNum){
			return true;
		}else{
			return false;
		}

	}
	
	/**
	 * Prints out the total number of palindromes given a start and end value.
	 * @param start - beginning of the range you want to find palindromes for
	 * @param end - end of the range you want to find palindromes for
	 */
	public static void findPalindromes(int start, int end){
		int count = 0;
		for(int i = start; i <= end ; i++){
			if(checkPalindrome(i)){
				//System.out.println("The palindrome number is :" + i);
				count++;
			}
		}
		System.out.println("Total palindrome numbers between " +start + " and "+ end +" is " + count);
	}
	
	/**
	 * This function takes input for start and end values and makes sure 
	 * they are integer values.
	 * @return - integer array with start and end values
	 */
	public static int[] getInput(){
		int[] arr = new int[2];
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter start value: ");
	    while (!sc.hasNextInt()){
	    	System.out.println("Not a valid integer. Try again.");
	    	sc.next();
	    }
	    int num1 = sc.nextInt();
	    int num2;
	    System.out.print("Enter end value: ");
	    do {
	        while (!sc.hasNextInt()){
	        	System.out.println("Not a valid integer. Try again.");
	        	sc.next();
	        }
	        num2 = sc.nextInt();
	    } while (num2 < num1);
	    arr[0] = num1;
	    arr[1] = num2;
	    //System.out.println(num1 + " " + num2);
		return arr;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			int[] input = getInput();
			findPalindromes(input[0], input[1]);
			System.out.println("========================================");
			System.out.print("Do you want to continue? Type y/n : ");
		}while(!sc.next().equalsIgnoreCase("n"));
	}

}
