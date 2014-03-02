/**
 * 
 * @author robin
 * 
 * 
Question 1 / 2 (Cantor)

Consider that, for a given number k [0 <= k <= 15], you take a string of 3k dashes and repeatedly delete the middle third of each segment, until you have only single dashes remaining. For instance, if k = 2, you would start with this:

---------

and turn it into this:

- -   - -

Similarly, for k = 3, the process would be as follows:

---------------------------

---------         ---------

- -   - -         - -   - -

Let's call the string that you produce through this process a "C string." Write a function that, given a number k, produces the C string of order k.

 *
 */
import java.io.*;
import java.util.ArrayList;
public class Cantor {
	
	private static StringBuilder sb;
	private ArrayList<String> subLists = new ArrayList<String>();
	private int power;
	
	public Cantor(){
		
	}
	
	public Cantor(int power){
		if(power < 0){
			try {
				throw new Exception("Only positive integer values are allowed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			this.power = power;
		}
	}
	
    public StringBuilder init(int power) {
    	sb = new StringBuilder("-");
		int val = (int) Math.pow(3,power);
		for(int i = 0; i < val; i++){
			sb.append("- ");
		}
		System.out.println(sb.toString());
		return sb;
	}
    
    public String deleteDashes(String sb, int index){
    	for(int i = 0; i < sb.length(); i++){
    		String[] part1 = new String[sb.length()/2];
    		String[] part2 = new String[sb.length()/2];
    		
    		
    	}
    	return null;
    }
    
    public void deleteDashes(String[] sb){
    	if(sb.length == 1)
    		subLists.add(sb[0]);
    	else{
    		int val = sb.length/3;
    		
    	}
    }

	public static void main(String args[] ) throws Exception {
		System.out.print("Enter a positive integer value: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);  
        Cantor c = new Cantor(N);
        c.init(N);
        //deleteDashes();
    }

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public ArrayList<String> getSubLists() {
		return subLists;
	}

	public void setSubLists(ArrayList<String> subLists) {
		this.subLists = subLists;
	}

	public static StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		Cantor.sb = sb;
	}
}
