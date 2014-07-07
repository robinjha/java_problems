/**
 * Print out a Christmas tree to console
 * @author robin

 * For Ex: 
	*
   ***
  *****
 *******
    *
*/
package ci.java.com;

import java.util.Scanner;

public class PrintChristmasTree {
	
	/**
	 * prints * in a christmas tree pattern  
	 * @param height - the height of the tree
	 */
	public static void printTree(int height){
		
		if(height <= 0) return;
		int totalAstLastLine = (height - 1)*2 + 1;
		int spaces = totalAstLastLine/2;
		int count = 1;
		
		for(int i = 0; i < height ; i++){ 
			for(int j = 0; j <= spaces ; j++ ){
				System.out.print(" ");
			}
			
			for(int k = 0; k < count ; k++ ){
				System.out.print("*");
			}
			System.out.println();
			spaces--;
			count+=2;
			
		}
		for(int m =0; m<=totalAstLastLine/2; m++) 
        {
            System.out.print(" ");
        }
        System.out.println("*"); 
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print("Enter an integer for the height of the tree (ex: 3,5, etc): ");
			while (!sc.hasNextInt()){
				System.out.println("Not a valid integer. Try again.");
				sc.next();
			}
			int val = sc.nextInt();
			printTree(val);
			System.out.print("Do you want to continue? Type y/n: ");
		}while(!sc.next().equalsIgnoreCase("n"));

	}

}
