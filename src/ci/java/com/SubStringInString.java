/**
 * count of occurances of a substring
 */

package ci.java.com;

public class SubStringInString {
	
	public static int strstr(String haystack, String needle) {
        if (haystack == null || needle == null)
                return -1;
        if (needle.length() == 0)
                return 0;
        for (int i = 0; i < haystack.length(); i++)
                for (int j = 0; j < needle.length() && (i + j) < haystack.length(); j++)
                        if (needle.charAt(j) != haystack.charAt(i + j))
                                break;
                        else if (j == needle.length() - 1)
                                return i;

        return -1;
}


	public static void main(String[] args) {
		String str = "elloslkhellodjladfjhello";
		String findStr = "hello";
		int lastIndex = 0;
		int count =0;

		while(lastIndex != -1){

		       lastIndex = str.indexOf(findStr,lastIndex);

		       if( lastIndex != -1){
		             count ++;
		             lastIndex+=findStr.length();
		      }
		}
		System.out.println(count);
		int j = strstr(str, findStr);
		System.out.println("Occurance starts at " + j);

	}

}
