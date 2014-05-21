import java.util.Arrays;


public class PascalTriangle {

	public static void printPascal(int level){
		int[][] pascal = new int[level][level];
		//Arrays.fill(pascal,0);
		pascal[0][0] = 1;
		pascal[1][0] = 1;
		pascal[1][1] = 1;
		
		for(int i = 2; i < level; i++){
			pascal[i][0] = 1;
			for(int j = 1; j <= i ; j++){
				pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				//System.out.print(pascal[i][j]+"\t");
			}
			//System.out.println();
		}
		System.out.println("Here");
		
		for(int i = 0; i < level ; i++){
			for(int j = 0; j < pascal[i].length; j++){
				System.out.print(pascal[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPascal(7);
	}

}
