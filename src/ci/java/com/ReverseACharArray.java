package ci.java.com;

public class ReverseACharArray {
	
	private static void reverseIT(char[] list) {
		  int index = 0;
		  for(int i = list.length -1 ; i <= 0 ; i++){
			  char temp = list[i];
			  list[i] = list[index];
			  list[index] = temp;
			  index++;
		  }

		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vals = {'a','b','e','i','o','u'};
			reverseIT(vals);

		  System.out.println(vals);

		  }

	}
