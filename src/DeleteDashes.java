import java.util.Scanner;

/**
 * 
 * @author robin
 * Consider that, for a given number k [0 <= k <= 15], you take a string of 3k dashes and repeatedly delete the middle third of each segment, until you have only single dashes remaining. For instance, if k = 2, you would start with this:

---------

and turn it into this:

- -   - -

Similarly, for k = 3, the process would be as follows:

---------------------------

---------         ---------

- -   - -         - -   - -

Let's call the string that you produce through this process a "C string." Write a function that, given a number k, produces the C string of order k.
 *
 */
public class DeleteDashes {
	
	public static StringBuilder dashes(StringBuilder sb){
		StringBuilder modString = new StringBuilder();
		
		
		return modString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("-");
		Scanner sc = new Scanner(System.in);
		int val = (int) Math.pow(3,sc.nextInt());
		for(int i = 0; i < val; i++){
			sb.append('-');
		}
		dashes(sb);
	}

}
