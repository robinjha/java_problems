package com.java.abnb;


/*
 * Complete the function below.
 */

/* Write your custom functions here */
static void mergeArray(int []a, int []b, int M ){
}

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int _a_cnt = 0;
	int[] _a = new int[100001];
	int[] _b = new int[200002];
	
	try {
		_a_cnt = sc.nextInt();
	}catch (Exception e) {
		 System.out.println("Here: " + e.getMessage()); 
	} 

for( int i = 0;i < _a_cnt;i++ ){			_a[i] = sc.nextInt();		
}
for( int i = 0;i < _a_cnt;i++ ){
		_b[i] = sc.nextInt();		
	}	
	mergeArray(_a ,_b,_a_cnt);
	for( int i = 0;i < 2 * _a_cnt;i++ ){
		System.out.print(_b[i] + " ");		
	}
}
}
public class MergeArray {

}
