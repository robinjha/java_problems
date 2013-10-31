package ci.java.com;

public class AllUniqueCharacters {
	
	public boolean isUniqueChars(String test){
		boolean[] ch = new boolean[256];
		int val = 0;
		
		if(test.length() > 256){
			System.out.println("The string has some chars repeated");
			return false;
		}
		
		for(int j = 0; j < test.length(); j++){
			val = test.charAt(j);
			if(ch[val]){
				return false;
			}
			ch[val] = true;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcdea";
		AllUniqueCharacters auc = new AllUniqueCharacters();
		System.out.println("Contains all unique characters :" + auc.isUniqueChars(test));
		
	}

}
