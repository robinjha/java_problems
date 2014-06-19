/**
 *  test if a number is a power of 2
 *  http://en.wikipedia.org/wiki/Power_of_two#Fast_algorithm_to_check_if_a_positive_number_is_a_power_of_two
 *  
 *  You can test if a positive integer n is a power of 2 with something like

(n & (n - 1)) == 0

If n can be non-positive (i.e. negative or zero) you should use

(n > 0) && ((n & (n - 1)) == 0)

If n is truly a power of 2, then in binary it will look like:

10000000...

so n - 1 looks like

01111111...

and when we bitwise-AND them:

  10000000...
& 01111111...
  -----------
  00000000...
 */
package ci.java.com;

import java.util.Scanner;

public class IsPowerOfTwo {
	
	public static void isPowerOfTwo(int n){
		for (int i = 0; i <= n; i++) {
		    if ( i > 0 && ((i & (i - 1)) == 0))
		        System.out.println(i);
		}
		
		
	}

	public static void main(String[] args) {
		
		
		Scanner in=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = in.nextInt();
        isPowerOfTwo(num);

	}

}
