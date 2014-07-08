

package com.java.strings;

public class ConvertStringToInt {
	
	public static int stringToInt(String str) throws Exception{
		
		/**
		 * 

			To convert a string into an int, use:
			
			String str = "1234";
			int num = Integer.parseInt(str);
			
			To convert a number into a string, use:
			
			int num = 1234;   
			String str = String.valueOf(num);


		 */
		boolean isNegative = false;
		int len = str.length();
		int i = 0;
		int num = 0;
		//int test = 0;
		//check for negative sign; if it's there, set the isNegative flag
		if(str.charAt(0) == '-'){
			isNegative = true;
			i = 1;
		}
		//process each char of the string
		while(i < len){
			num *= 10;
			//test *= 10;
			num+=str.charAt(i++) - '0';//minus the ASCII code of '0' to get the value of the charAt(i++)
			//test+=str.charAt(i++) - '0';
			System.out.println(num);
		}
		
		if(isNegative)
			num = -num;
		
		if(!(num == Integer.parseInt(str))){
			throw new Exception("The values don't match");
		}
		return num;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(stringToInt("56546"));

	}

}
