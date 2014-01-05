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
		if(str.length() == 0)
			return null;
		
		if(str.length() == 1)
			return str;
		
		StringBuilder sb = new StringBuilder("");
		char start = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == start)
				count++;
			else{
				sb.append(start);
				sb.append(count);
				start = str.charAt(i);
				count = 1;
			}
		}
		sb.append(start);
		sb.append(count);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "aabbcedddd";
		CompressedString cs = new CompressedString();
		System.out.println(cs.compression(test));
		

	}

}











