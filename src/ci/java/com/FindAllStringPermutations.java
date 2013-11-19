package ci.java.com;

public class FindAllStringPermutations {
	
	public static void stringPerm(String prefix, String str){
		if(str.length() == 0) System.out.println(prefix);
		else{
			for(int i = 0; i < str.length(); i++){
				String pref = prefix+str.charAt(i);
				String passedStr = str.substring(0, i)+str.substring(i+1, str.length());
				stringPerm(prefix+str.charAt(i), str.substring(0, i)+str.substring(i+1, str.length()));
			}
		}
	}

	public static void main(String[] args) {
		String test = "ABC";
		stringPerm("",test);

	}

}
