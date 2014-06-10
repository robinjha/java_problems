/**
 * 
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
