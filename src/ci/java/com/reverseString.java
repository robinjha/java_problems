package ci.java.com;

public class reverseString {
	
	
	public static String revStr(String str){
		int count = 0;
		char[] strChars = new char[str.length()];
		for(int i = str.length() -1 ; i >= 0 ; i--){
			
				strChars[count] = str.charAt(i);
				count++;

		}
		String test = new String(strChars);
		System.out.println(test);
		return test;
	}
	
	public static String revRecursively(String str){
		if(str.length() < 2) return str;
		
		return revRecursively(str.substring(1)) + str.charAt(0);
	}
	
	public static char[] stringReverseInPlace(char[] string) {
		  for(int i = 0, j = string.length - 1; i < string.length / 2; i++, j--) {
		    char c = string[i];
		    string[i] = string[j];
		    string[j] = c;
		  }
		  return string;
		}
	
	public static void main(String[] args){
		String test = "This is a test";
		revStr(test);
		System.out.println(stringReverseInPlace(test.toCharArray()));
		System.out.println("Reversed string recursively :"+revRecursively(test));
	}

}
