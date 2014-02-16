/**
 * An Elephant Number (E) is:

A positive integer with an even number of digits n.
Is the product of 2 integers called tusks, x and y each of which has n/2 digits
	X and Y do not both have trailing 0's.
E contains all the digits of x and y in any order (with nothing in x and y remaining)

1260 is an elephant number

125460 = 204 X 615 = 246 X 510 elephant number with multiple tusks.

 */



package ci.java.com;

public class Elephant {
	
	public static int[] factors(int n){
		int[] arr = new int[100];
		for(int i = 2; i*i <=n; i++){
			while(n % i == 0){
				n = n/i;
				
			}
			arr[i] = n;
		}
		return arr;
	}

	public static boolean elephant(int elephant) throws InterruptedException{
		
		int length = (int) (Math.log10(elephant)+1);
		if(!((length % 2) == 0) ){
			return false;
		}
		
		int tusk1 = 1;
		int tuskLen = 1;

		int[] a = new int[100];
		a= factors(elephant);
		for(int i: a){
			System.out.println(i);
		}
		Thread.sleep(100000);
		for(int j = 0; j < a.length; j++){
			while(tuskLen != length/2){
				tusk1 = tusk1*a[j];
				tuskLen = (int) (Math.log10(tusk1)+1);
				System.out.println("Tusk: " +tusk1+" Tusk Len: "+ tuskLen);
			}
		}	
		
		
		return false;
	}
	public static void main(String[] args) throws InterruptedException{
		
		int length = (int) (Math.log10(1230)+1);
		System.out.println(length);
		elephant(1230);
	}

}
