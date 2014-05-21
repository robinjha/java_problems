package ci.java.com;

public class SwappingNumbersWithoutTmpVar {

	public static void main(String[] args) {
		int a = 2;
		int b = 4;
		
		System.out.println("value of a and b before swapping [ a :" + a + " b :" + b + "]");
		
		a = a^b;
		System.out.println("value of a : " + a);
		b = a^b;
		System.out.println("value of b: " + b);
		a = a^b;
		System.out.println("value of a: " + a);
		
		System.out.println("after swapping values using xor [ a: " + a + " b :" + b+']');
		

	}

}
