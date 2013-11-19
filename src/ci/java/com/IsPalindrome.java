package ci.java.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class IsPalindrome {
	
	public static boolean isPalindromeIter(String inputString){
		int start = 0;
		int end = inputString.length() -1;
		int mid = (start+end) /2;
		
		int i;
		for(i = start; i <= mid; i++ ){
			if(inputString.charAt(i) == inputString.charAt(end)){
				i++;
				end --;
			}else{
				break;
			}
		}
		
		if(i == mid+1){
			System.out.println("Is a palindrome");
			return true;
		}else{
			System.out.println("Not a palindrome");
			return false;
		}
		
	}
	
	public static boolean isPalindromeRec(String inputString){
		boolean isPalindrome = false;
		if(inputString.length() <= 1)
			isPalindrome = true;
		else{
			if(inputString.charAt(0) == inputString.charAt(inputString.length()-1)){
				isPalindrome = isPalindromeRec(inputString.substring(1, inputString.length() -1));
			}
		}
		return isPalindrome;
	}
	
	public static boolean isPalindromeQS(String inputString){
		Queue<Character> q = new LinkedList<Character>();
		Stack<Character> s = new Stack<Character>();
		
		for(int i = 0; i <= inputString.length()-1; i++){
			q.add(inputString.charAt(i));
			s.push(inputString.charAt(i));
		}
		
		while(!s.isEmpty() && !q.isEmpty()){
			if(!s.pop().equals(q.remove())){
				System.out.println("Is not a palindrome");
				return false;
			}
		}
		System.out.println("Is a palindrome");
		return true;
	}
	
	public static void main(String[] args){
		String inputString;
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------Enter the string-----------");
		
		inputString = sc.nextLine();
		//isPalindromeIter(inputString);
		//isPalindromeQS(inputString);
		System.out.println(inputString +" is Palindrome :" +isPalindromeRec(inputString));
	}

}
