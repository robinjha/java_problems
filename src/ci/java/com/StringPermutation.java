package ci.java.com;

import java.util.Arrays;

public class StringPermutation {
	
	public boolean isPermutation(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		else{
			char[] chStr1 = str1.toCharArray();
			char[] chStr2 = str2.toCharArray();
			Arrays.sort(chStr1);
			Arrays.sort(chStr2);
			
			for(int i = 0; i < chStr1.length ; i++ ){
					if(chStr1[i] != chStr2[i]){
						return false;
				}
			}
			
			return true;
		}
	}

	public static void main(String[] args) {
		String str1 = "god";
		String str2 = "dag";
		StringPermutation test = new StringPermutation();
		System.out.println(" Is permutation:"+test.isPermutation(str1, str2));

	}

}
