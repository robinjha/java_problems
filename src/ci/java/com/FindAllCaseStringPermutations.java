package ci.java.com;

public class FindAllCaseStringPermutations {

	public static void stringPerms(String prefix, String  origString ){
		if(origString.length() == 0) System.out.println(prefix);
		else{
			for(int i= 0; i < origString.length(); i++){
				stringPerms(prefix+origString.charAt(i), origString.substring(0, i)+origString.substring(i+1, origString.length()));
			}

		}
	}



	public static void printPermutations(String text) {
		char[] chars = text.toCharArray();
		for (int i = 0, n = (int) Math.pow(2, chars.length); i < n; i++) {
			char[] permutation = new char[chars.length];
			for (int j =0; j < chars.length; j++) {
				permutation[j] = (isBitSet(i, j)) ? Character.toUpperCase(chars[j]) : chars[j];
			}
			System.out.println(permutation);
		}
	}

	public static boolean isBitSet(int n, int offset) {
		int value = (n >> offset & 1);
		return (n >> offset & 1) != 0;
	}

	public static void main(String[] args) {
		String test = "ab";
		//stringPerms("",test);
		printPermutations(test);

	}

}
