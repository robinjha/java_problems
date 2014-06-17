/**
 *  Algorithm: 
    Guess some value g for y and test it.
    Compute x / g.
    If x / g is close enough to g, return g. Otherwise, try a better guess. 
 */

package ci.java.com;

public class FindSqrtOfANumber {
	
	public static double sqrt(double x) {
		   return test(x, 1);
		}
	
	public static double test(double x, double g){
		
		if(closeEnough(x/g,g)){
			return g;
		}else{
			return test(x, betterGuess(x,g));
		}
	}

	public static double betterGuess(double x, double g) {
		   return ((g + x/g) / 2);
	}

	public static boolean closeEnough(double d, double g) {
		return (Math.abs(d - g) < (d * 0.001));
	}

	public static void main(String[] args) {
		System.out.println(sqrt(81));
	}

}
