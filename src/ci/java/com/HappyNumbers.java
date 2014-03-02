/**
 * http://en.wikipedia.org/wiki/Happy_number
 * 
 * this program finds if a number is happy or not
 */

package ci.java.com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HappyNumbers {
	
	public static Integer[] getDigits(int num){
		List<Integer> digits = new ArrayList<Integer>();
		collectDigits(num, digits);
		return digits.toArray(new Integer[]{});	
	}
	
	public static void collectDigits(int num, List<Integer> digits) {
		if(num/10 > 0)
			collectDigits(num/10, digits);
		digits.add(num%10);	
	}

	public static boolean isHappy(int value, Integer[] digits){
		if(value <= 0) return false;
		if(value == 1) return true;// base case
		int newDigit = 0;
		for(Integer i : digits)
			newDigit+=Math.pow(Integer.valueOf(i), 2);
		return isHappy(newDigit,getDigits(newDigit));
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer[] digits = getDigits(sc.nextInt());
		System.out.println(Arrays.toString(digits));
		System.out.println("Is Happy: "+isHappy(sc.nextInt(), digits));

	}

}
