package ci.java.com;

/**
 * Looks for pattern in a text in a brute force way
 * 
 * @author robin
 * AAABABAA
 * BABA
 */
public class BruteSubStringSearch {
	
	public static int patternIndex(String pattern, String text){
		int tLen = text.length();
		int pLen = pattern.length();

		for(int i = 0; i <= tLen - pLen; i++){
			int j;
			for(j = 0; j < pLen; j++){
				if(text.charAt(i+j) != pattern.charAt(j)){
					break;
				}
			}
			if(j == pLen) return i;
		}
		return tLen;
	}

	public static void main(String[] args) {
		String text = "AAABABAA";
		String pattern = "BABA";
		
		System.out.println("Pattern starts at: " +patternIndex(pattern, text));
	}

}
