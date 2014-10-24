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

	public static void main(String[] args) {
		String[] str = {"aaa","bb","cc","ddddd"};
		String txt = "aaa bb cc ddddd";
		lineWrap(txt);
	}

}
