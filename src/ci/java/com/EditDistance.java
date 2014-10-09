package ci.java.com;

/**
 * 
 * @author 
 */
public class EditDistance {
	
	public static int editDistanceRecursive(String first, String second){
		/*source - https://secweb.cs.odu.edu/~zeil/cs361/web/website/Lectures/styles/pages/editdistance.html*/
		if(first.length() == 0 || first == "")
			return second.length();
		else if(second.length() == 0 || second == "")
			return first.length();
		else{
			int addDist = editDistanceRecursive(first, second.substring(0, second.length() - 1)) + 1;
			int removeDist = editDistanceRecursive(first.substring(0,first.length()-1), second) + 1;
			int changeDist = editDistanceRecursive(first.substring(0, first.length()-1), second.substring(0, second.length()-1)) + 
					(first.charAt(first.length() - 1) == second.charAt(second.length() - 1) ? 0 : 1);
			
			return Math.min(Math.min(addDist, removeDist), changeDist);
		}
		
		
	}

	public static void main(String[] args) {
		System.out.println(editDistanceRecursive("Zeil","trials"));

	}

}
