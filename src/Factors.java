/**
 * @author - Robin Jha
 * This program takes a positive integer and prints out all ways to multiply smaller integers 
 * that equal the original number, without repeating sets of factors. 
 */

import java.util.Scanner;

public class Factors {
	
	public static void printFactors(int num, int carryNum, String subString) {
		int carry = carryNum;
		for (int x = num - 1; x >= 2; x--) {

			if (num % x == 0) { 
				if (carry > x) {
					carry = x;
				}
				
				if ((num /x <= x)&&(num /x <= carryNum)&&(x <= carryNum)) {
					System.out.println(subString + x + " * " + (num /x));
					carry = num / x; 
				}

				if (x <= carryNum) {
					printFactors(num / x, carry, subString + x + " * ");
				}
				
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.print("Enter the number you want to factor: ");
		Scanner sc = new Scanner(System.in);
	    int val;
	    while(sc.hasNext()){
	    	do {
	    		System.out.print("\nPlease enter a positive number: ");
	    		while (!sc.hasNextInt()) {
	    			System.out.print("\nThat's not a positive number! Enter a positive integer: ");
	    			sc.next(); 
	    		}
	    		val = sc.nextInt();
	    	} while (val <= 0);
	    	System.out.println("\n"+val + " * " + 1);
	    	printFactors(val, val , " ");
	    	System.out.print("\nEnter another number to factor: ");
	    }
	}

}
