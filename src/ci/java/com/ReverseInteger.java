/**
 * 
 * 
 * 1. Taking the input integer and modding (%) by 10 will extract off the rightmost digit. example: (1234 % 10) = 4

 * 2. Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (5 * 10) = 50

 * 3. Dividing an integer by 10 will remove the rightmost digit. (75 / 10) = 7


 *Pseudocode:
 *a. Extract off the rightmost digit of your input number. (1234 % 10) = 4
 *b. Take that digit (4) and add it into a new reversedNum.
 *c. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the right of your (4).
 *d. Divide the input by 10, (removing the rightmost digit). (1234 / 10) = 123
 *e. Rinse lather and repeat. 
 
 * edge cases: 
 * 1. output for numbers ending in 0
 * 2. negative numbers
 * 3. non-integers
 * 4. 
 * 
 */

package ci.java.com;

public class ReverseInteger {
	
	public static int reversedInt(int input){
		
		long reversedNum = 0;
		
		while(input != 0){
			
			reversedNum = reversedNum * 10 + input % 10;
			input = input / 10;
			
		}
		
		if(reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE){
			throw new IllegalArgumentException();
		}
		
		return (int) reversedNum;
	}

	public static void main(String[] args) {
		int val = 79001;
		//System.out.println((val%10+""+val/10));
		
		System.out.println(reversedInt(val));

	}

}
