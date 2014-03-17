/**
 *
 * @author robin
 * date - 03/02/2014
 * Given two strings str1 and str2, write a function that prints all interleavings of the given two strings. 
 * You may assume that all characters in both strings are different

Example:

Input: str1 = "AB",  str2 = "CD"
Output:
    ABCD
    ACBD
    ACDB
    CABD
    CADB
    CDAB

Input: str1 = "AB",  str2 = "C"
Output:
    ABC
    ACB
    CAB

An interleaved string of given two strings preserves the order of characters in individual strings.
 For example, in all the interleavings of above first example, ÔAÕ comes before ÔBÕ and ÔCÕ comes before ÔDÕ.
 
 O(m+n) where m & n are lengths of the strings.
 *
 */

public class StringInterleaving {
	
	public static boolean isInterleaved(String str1, String str2, String newString){
		if(str1.length() == 0 && str2.length() == 0 && newString.length() == 0)
			return true;
		if(newString.length() == 0 || newString == null)
			return false;
		
		return (str1.charAt(0) == newString.charAt(0) && isInterleaved(str1.substring(1),str2, newString.substring(1))
				|| str2.charAt(0) == newString.charAt(0) && isInterleaved(str1, str2.substring(1), newString.substring(1)));
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "def";
		String newString = "deabcf";
		System.out.println(isInterleaved(str1, str2, newString));

	}

}
