import java.util.Iterator;
import java.util.LinkedHashSet;


public class ContainsChars {
	
//	012345
//	string
//	['r','i','n','g'] -> true  [i i g g]
//	['n','i','g'] -> false     [ g] 
//
//	index = 2;
//	index1 = 3;
//	if(index1 > index )
//	{
//	}


	public static LinkedHashSet hSet(char[] arr){
		LinkedHashSet<Character> cSet = new LinkedHashSet<Character>();
		for(int i = 0; i < arr.length; i++){
			cSet.add(arr[i]);
		}
		return cSet;
	}

	public static boolean charsInOrder(String str, char[] arr){
		int index = 0;
		char start = arr[0];
		for(int i = 0; i < str.length(); i++){
			for(int j = 0; j < arr.length; j++){
				if(str.charAt(i) == start){
					index = i;
					break;
				}else{
					start = str.charAt(i);
					index = 1;
				}

			}
		}

	}

	public static void main(String[] args) {
		

	}

}
