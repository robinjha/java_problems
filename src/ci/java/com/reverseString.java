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
	
	public static void main(String[] args){
		String test = "This is a test";
		revStr(test);
	}

}
