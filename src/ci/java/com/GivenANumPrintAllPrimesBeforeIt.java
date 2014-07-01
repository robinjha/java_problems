package ci.java.com;

import java.util.ArrayList;

public class GivenANumPrintAllPrimesBeforeIt {
	
	public static ArrayList<Integer> findPrimes(int num){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i = 2; i <= num; i++){
			if(isPrime(i)){
				primes.add(i);
				
			}
		}
		return primes;
		
	}
	
	public static boolean isPrime(int num){
		
		for(int i = 2; i < num; i++){
			if(num % i == 0){
				return false; 
			}
		}
		return true;
	}
	
	public static void print(ArrayList<Integer> primes){
		for(Integer p: primes)
			System.out.println(p);
		
	}

	public static void main(String[] args) {
	
		print(findPrimes(10));

	}

}
