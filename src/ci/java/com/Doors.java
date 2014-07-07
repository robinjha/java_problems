/**
 * Given a number of doors, initially all of them are closed. 
 * You start by opening all 100 doors. next every other locker. 
 * find out how many doors are open. 
 */

package ci.java.com;

public class Doors {
	
	public static void isPerfectSquare(int n){
		int count = 0;
		for(int i = 1; i <= n; i++){
			double sqrt = Math.sqrt(i);
			if(sqrt != (int)sqrt){
				//System.out.println("Door # " + i + " is closed.");
			}else{
				count++;
				System.out.println("Door # " + i + " is open.");
			}
			
		}
		System.out.println("Total number of doors open are :" + count);
	}

	public static void main(String[] args) {
		isPerfectSquare(100);

	}

}
