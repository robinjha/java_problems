package ci.java.com;

import java.util.StringTokenizer;

public class WordWrap {
	
	private static final int DEFAULT_LINE_WIDTH = 6;
	private static final int DEFAULT_SPACE_WIDTH = 1;
	
	public static void lineWrap(String text){
		greedyWrap(text, DEFAULT_LINE_WIDTH);
	}
	
	public static void greedyWrap(String str, int lineWidth){
		StringTokenizer st = new StringTokenizer(str);
		int spaceLeft = lineWidth;
		int spaceWidth = DEFAULT_SPACE_WIDTH;
		while(st.hasMoreTokens()){
			String word = st.nextToken();
			if((word.length() + spaceWidth) > spaceLeft){
				System.out.print("\n" + word +" ");
				spaceLeft = lineWidth - word.length();
			}else{
				System.out.print(word+ " ");
				spaceLeft -= (word.length() + spaceWidth);
			}
		}
	}
	
	/**
	 * Time Complexity: O(n^2)
	 * Auxiliary Space: O(n^2) 
	 * @param str
	 * @param lineWidth
	 * @param l
	 */
	public static void dynamicWrap(String str,int lineWidth, int[] l){
		StringTokenizer st = new StringTokenizer(str);
		int[][] extraSpaces = new int[st.countTokens()+1] [st.countTokens()+1];
		int[][] lineCost = new int[st.countTokens()+1] [st.countTokens()+1];
		int[] totalCost = new int[st.countTokens()+1];
		int[] sol = new int[st.countTokens()+1];
		
		int i, j;
		
		for(i = 1; i <= l.length; i++){
			extraSpaces[i][i] = DEFAULT_LINE_WIDTH - l[i - 1];
			for(j = i+1; j <= l.length; j++){
				extraSpaces[i][j] = extraSpaces[i][j-1] -l[j-1] - 1;
			}
		}
		
		//calculate line cost
		for(i = 1; i <=l.length ; i++){
			for(j = i; j <= l.length; j++){
				if(extraSpaces[i][j] < 0){
					lineCost[i][j] = Integer.MAX_VALUE;
				}else if(j == l.length && extraSpaces[i][j] >= 0){
					lineCost[i][j] = 0;
				}else{
					lineCost[i][j] = extraSpaces[i][j] * extraSpaces[i][j];
				}
			}
		}
		
		totalCost[0] = 0;
		for(j = 1; j <= l.length; j++){
			totalCost[j] = Integer.MAX_VALUE;
			for(i = 1; i <= j; i++){
				if(totalCost[i-1] != Integer.MAX_VALUE && lineCost[i][j] != Integer.MAX_VALUE && (totalCost[i-1]+lineCost[i][j] < totalCost[j])){
					totalCost[j] = totalCost[i-1] + lineCost[i][j];
					sol[j] = i;
				}
			}
		}
		printSol(sol, l.length);
	}

	public static int printSol(int[] sol, int len) {
		int i;
		if(sol[len] == 1)
			i = 1;
		else
			i = printSol(sol,sol[len] - 1) +1;
		System.out.println("Line number  "+i+ ": From word no. " +sol[len]+ " to " + len);
		return i;
	}

	public static void main(String[] args) {
		String[] str = {"aaa","bb","cc","ddddd"};
		int[] arr = {3,2,2,5};
		String txt = "aaa bb cc ddddd";
		//lineWrap(txt);
		dynamicWrap(txt,6, arr);
	}

}
