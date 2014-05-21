package ci.java.com;

import java.util.ArrayList;

public class Qwerty {

	public static String largestWord(ArrayList<String> largestWordList){
		String longestWord = "";
		int maxLength = 0;
		for(int i = 0; i < largestWordList.size(); i++){
			if(largestWordList.get(i).length() > maxLength){
				maxLength = largestWordList.get(i).length();
				longestWord = largestWordList.get(i);
			}
		}
		return longestWord;

	}

	public static String smallestWord(ArrayList<String> smallestWordList){

		String smallestWord = "";
		int minLength = 0;
		for(int i = 0; i < smallestWordList.size(); i++){
			if(smallestWordList.get(i).length() < minLength){
				minLength = smallestWordList.get(i).length();
				smallestWord = smallestWordList.get(i);
			}
		}
		return smallestWord;

	}



	public static void qwerty(String leftHandWords, String rightHandWords, ArrayList<String> inputWords){

		if(inputWords == null || inputWords.size() == 0){
			System.out.println("You entered an invalid value for the word list");// business decision to throw and exception
		}

		//check if the lhs and rhs words are correct

		ArrayList<String> lhs = new ArrayList<String>();

		ArrayList<String> rhs = new ArrayList<String>();

		char[] arr1 = leftHandWords.toCharArray();
		char[] arr2 = rightHandWords.toCharArray();

		
		for(int i = 0; i < inputWords.size(); i++){//every word in the array list
			int count = 0;
			char[] arr3 = inputWords.get(i).toCharArray();
			for(int j = 0; j < arr3.length; j++){
				for(int n = 0; n < arr1.length; n++){
					if(arr3[j] != arr1[n] ){
						break;
					}
					if(arr3.length == j){
						lhs.add(inputWords.get(j));
					}
					//another closing bracket
				}


				for(int k = 0; k < arr3.length;k++){ // look
					for(int m = 0; m < arr2.length; m++){ // poiulkjmn
						if(arr2[m] == arr3[k]){
							count++;
						}

						if(arr3.length == count){
							rhs.add(inputWords.get(k));
						}

					}



				}// closes for loop

			}
		}
		
		System.out.println("Smallest word rhs : "+ smallestWord(rhs));
		System.out.println("Largest word rhs : " + largestWord(rhs));



	}

	public static void main(String[] args) {
		ArrayList<String> inputWords = new ArrayList<String>();
		inputWords.add("look");
		inputWords.add("was");
		inputWords.add("park");
		inputWords.add("site");
		qwerty("qwerasdfzxcvt", "poiulkjhmnb", inputWords);

	}

}
