package ci.java.com;

/**
 * Print the numbers between 30 to 3000.
 * CONSTRAINT:
 * The numbers shouldnt contain digits either in incresing order or decreasing order.

  * FOLLOWING NOT ALLOWED
  * ##123,234,345,1234,2345##increasing order,
  * ##32,21,321,432,3210 etc##decresing order.

  * FOLLOWING ALLOWED:
  * 243,27,578,2344 etc., 
  
 * @author robin
 *
 */

public class SortedNumbers {
	
	public static void sortedNums(){
		String sortedNumbers = "123456789 987654321";
		for(int i = 31; i < 3000; i++){
			String s = ""+ i;
			if(!sortedNumbers.contains(s)){
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) {
		sortedNums();
	}

}
