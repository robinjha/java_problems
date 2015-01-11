import java.util.ArrayList;
import java.util.Stack;

/**
 * Question 2 / 2 (Sum-Zero)
 * Given a sequence of k integers (1 <= k <= 100000), each with a value between 0 and 10000, we want to find the longest contiguous subarray (in other words, a sub-sequence of consecutive elements) that sums to 0, and return its length. For instance:

"3 0 3" should return 1, because the 0 in the middle is a 1-element subarray that sums to 0.

"3 4 3" should return -1, because there is no sub-range of the array that sums to 0.

"1 5 4 -10" should return 4, because the entire array sums to 0.

The integers in the input will be separated by spaces, as shown above. Your solution should be as efficient as possible.
 *
 */

/**
 * Here at RelateIQ we crawl lots of emails from our users. In order to maintain records of which emails we have already crawled we have to deal with what we call the "Email Ranges Problem".

 

A "range" is just a pair of messages IDs, for  example  5:14 which means that we have crawled emails with ids between 5 and 14.

Crawlers crawl several ranges at a time and then hand those ranges off to another component called the EmailRangesHistory which just a way to keep track of which emails have been crawled and which haven't.

Problem Statement

Help us code this EmailRangesHistory component by implementing the main method. This method should take a String as input and must return a sorted and compacted history with no spaces.

A single range has the shape of A:B where A and B are numbers and A <= B always.

The input will contain multiple ranges which are not sorted.

Each range will be comma separated and there may spaces between the commas.

These are examples:

Example 1:

Input: 1:4  ,  5:10,11:20

Output: 1:20

Example 2:

Input: 5:10,1:2

Output: 1:2,5:10

public static String compressedString(String str){

}

 
 * @author robin
 *
 */
public class Solution {
	
	private double left;
    private double right;
	
	public Solution(double left, double right) {
        if (Double.isInfinite(left) || Double.isInfinite(right))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(left) || Double.isNaN(right))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        if (left <= right) {
            this.left  = left;
            this.right = right;
        }
        else throw new IllegalArgumentException("Illegal Solution");
    }



	public static ArrayList<Solution> insert(ArrayList<Solution> Solutions, Solution newSolution) {
		ArrayList<Solution> result=new ArrayList<Solution>();
		if (newSolution==null){
			return Solutions;
		}
		if (Solutions==null||Solutions.size()==0){
			result.add(newSolution);
			return result;
		}
		for (Solution temp: Solutions){
			if (temp.right<newSolution.left){
				result.add(temp);
			}
			else if (temp.left>newSolution.right){
				result.add(newSolution);
				newSolution=temp;
			}
			else{
				newSolution.left=Math.min(newSolution.left, temp.left);
				newSolution.right=Math.max(newSolution.right, temp.right);
			}
		}
		result.add(newSolution);
		return result;
	}
		

	/**
     * Count the maximum depth of parenthesis nesting, i.e. "abc(123(xyz)m(((n)))o)" -> 3.
     *
     case 1
     * LP - 1 +1 = 2
     
     
     * RP - 2
     
     
     * @param input
     *            any string
     * @return deepest parenthesization level
	 * @throws Exception 
     */
     
    
    public static int nestedParenthesisDepth(String input)
            throws Exception {
            if(input == null) throw new Exception();
            if(input.length() == 1) return -1;
            int maxcount = 0, count = 0;
            for(int i = 0; i < input.length();i++){
                if(input.charAt(i) == '('){
                    count++;
                }else if(input.charAt(i)==')'){
                    count--;
                    
                }
                if(count < 0 ){return -1;}
                if(count > maxcount){
                    maxcount = count;
                }
                
            }//for loop
            if(count != 0) return -1;
        return maxcount;
    }
	
    public static void main(String[] args) throws Exception{
    	System.out.println(nestedParenthesisDepth("abc(123(xyz)m(((n)))o)"));
    	System.out.println(nestedParenthesisDepth("a)b(c"));
    	System.out.println(nestedParenthesisDepth("a(b"));
    	
    }

}
