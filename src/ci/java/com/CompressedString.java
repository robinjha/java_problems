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
	 * 
	 * test cases
	 * aaaabbcdd
		a4b2c1d2
		
		11223444
		
		Testcases:
		1) aabaa 
		
		2) abc
		a1b1c1
		
		3) Empty string ""
		
		4) aaa-1b# 
		
		5) AaabbBB
		
		6) "aaaa  bbb ccc"
		
		7) "!!!!!@@@$$"
		    !6@3$2
		    
		8) 22333
		   2233
		   
		   111111111111111
		   112
		   abababab 
		   
		
		abc    a1b1c1
		aabaa a2b1a2
	 * 
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
