package ci.java.com;

public class CompressedString {

	/**
	 * @param args
	 */
	
	/**
	 * takes in string and compresses it
	 * counts the occurances of the characters and shortens them by
	 * putting the # of against each new character
	 * @param str
	 * @return
	 */
	
	public String compression(String str){
		int position = 0;
		char[] strArr = new char[str.length()];
		for(int i = 0; i < str.length(); i++){
			if(str[i] != str[i+1]){
				position = i;
				strArr[i] = str[i];
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "aabbcedddd";
		CompressedString cs = new CompressedString();
		cs.compression(test);
		

	}

}
