/**
 * 
 * This algorithm is called Vampire Number:http://en.wikipedia.org/wiki/Vampire_number
 * 
 * An Elephant Number (E) is:

A positive integer with an even number of digits n.
Is the product of 2 integers called tusks, x and y each of which has n/2 digits
	X and Y do not both have trailing 0's.
E contains all the digits of x and y in any order (with nothing in x and y remaining)

1260 is an elephant number

125460 = 204 X 615 = 246 X 510 elephant number with multiple tusks.

 */



package ci.java.com;

import java.util.ArrayList;

public class VampireNumber {
	
	public static int numLength(int num){
		return (int) (Math.log10(num)+1);
	}
	
	public static ArrayList<Integer> factors(int n){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i = 2; i*i <=n; i++){
			while(n % i == 0){
				factors.add(i);
				n = n/i;
			}
			
		}
		if(n > 1){
			factors.add(n);
		}
		return factors;
	}

	public static boolean fangs(int num) throws InterruptedException{
		if(!((numLength(num) % 2) == 0) ){
			return false;
		}
		
		ArrayList<Integer> f = new ArrayList<Integer>();
		f= factors(num);
		
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException{
		ArrayList<Integer> fac = new ArrayList<Integer>();
		fac = factors(125460);
		System.out.print("Factors of "+ 125460 +": ");
		for(int i: fac){
			System.out.print(" "+ i);
		}
	}

}

