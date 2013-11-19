package ci.java.com;

public class ReplaceSpacesWithChars {

	/**
	 * @param args
	 */
	
	public static String replace(String str){
		char[] strIntoChars = str.toCharArray();
		int count = str.length()+ str.length();
		char[] strReplacedCharArray = new char[str.length()+ str.length()];
		
		for(int i = strIntoChars.length -1 ; i >= 0; i--){
			if(strIntoChars[i] == ' '){
				strReplacedCharArray[--count] = '0';
				strReplacedCharArray[--count] = '2';
				strReplacedCharArray[--count] = '%';
			}
			else{
				strReplacedCharArray[--count] = strIntoChars[i];
			}
		}
		String b = new String(strReplacedCharArray);// to convert char array into a string
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String test = "This is a test";
			System.out.println("Replaced String : "+replace(test));
	}

}
