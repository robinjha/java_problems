/**
 * 
 * @author robin
 * 
 */
public class ParseInt {
	
	/**
	 * function takes in integer string as param and returns integer value 
	 * @param s - integer as a string
	 * @return integer value of the string
	 */
	public static int parseInt(String s){
		
		if (s == null) {
	        throw new NumberFormatException("null");
	    }
		
		int isNeg = 1;
		int result = 0;
		int start = 0;
		
		if (s.charAt(0) == '-')	{
			isNeg = -1;
			start = 1;
		} else	{
			start = 0;
		}
		
		for(int i = start; i < s.length(); i++){
			if(s.charAt(i) >= 48 && s.charAt(i) <= 59){
				result = result*10 + s.charAt(i) - 48;
			} else	{
				throw new NumberFormatException();
			}
		}
		
		return result*isNeg;
	}

	public static void main(String[] args) {
		
		System.out.print(parseInt("123"));

	}

}
