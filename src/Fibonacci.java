
public class Fibonacci {
	
	public static int[] arr; 
	
	public static void initArr(){
		arr = new int[1000];
		for(int i = 0; i < arr.length; i++){
			arr[i] = Integer.MIN_VALUE;
		}
	}
	
	public static int fibTopDown(int n){
		
		if(arr[n] == Integer.MIN_VALUE){
			if(n <= 1)
				arr[n] = n;
			else
				arr[n] = fibTopDown(n-1) + fibTopDown(n-2);
		}
		return arr[n];
	}
	
	public static int fibBottomUp(int n){
		int[] arr = new int[n+1];
		int i;
		arr[0] = 0; arr[1] = 1;
		
		for(i = 2; i <=n ; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}

	public static void main(String[] args) {
		int n = 9;
		initArr();
		System.out.println("Top Down approach -> Fibonacci number " + n + " is :" + fibTopDown(n));
		System.out.println("Bottom Up approach -> Fibonacci number " + n + " is :" + fibBottomUp(n));
	}

}
