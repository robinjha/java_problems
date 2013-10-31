package ci.java.com;

public class replaceSpacesWithChars {

	/**
	 * @param args
	 */
	
	public static String replace(String str){
		char[] strIntoChars = str.toCharArray();
		char[] strReplacedCharArray = new char[str.length()+ str.length()];
		int count = 0;
		for(int i = 0; i < strIntoChars.length; i++){
			if(strIntoChars[i] == ' '){
				strReplacedCharArray[i] = '%';
				strReplacedCharArray[i+1] = '2';
				strReplacedCharArray[i+2] = '0';
				count = i+3;
			}
			else{
				strReplacedCharArray[count] = strIntoChars[i];
				count++;
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
