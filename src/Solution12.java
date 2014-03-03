
public class Solution12 {

	public static void main(String[] args) {
		int numbers[] = {4,2,5,4,5,6,7,8,1,10,11,12,13,14,9};

		for (int pos = 1; pos < numbers.length; pos++)
		{
		  numbers[pos] = numbers[pos] ^ numbers[pos-1] ;
		  System.out.println("XOR value is :" + numbers[pos]);
		}

		System.out.println("Duplicate is : " + numbers[numbers.length-1]);





	}

}
