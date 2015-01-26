import java.util.Random;


public class charGen {
	public static void main(String[] args){
		Random r = new Random();
		String alphabet = "123xyz";
		for (int i = 0; i < 502; i++) {
			//System.out.print(alphabet.charAt(r.nextInt(alphabet.length())));
		} // prints 50 random characters from alphabet
		
		String test = "A B";
		String[] arr = test.split(" ");
		System.out.println(arr[0] + " "+  arr[1]);
	}
}
