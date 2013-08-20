
public class comparison {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 ="This is a test";
		String test2 ="This is a test";
		String test3 = "This is also a test";
		
		if(test1.equals(test2)){
			System.out.println("They are equal");
		}
		else{
			System.out.println("They are not equal");
		}
		
		if(test1 == test2){
			System.out.println("They are equal");
		}
		else{
			System.out.println("They are not equal");
		}
		
		if(test1.equals(test3)){
			System.out.println("They are equal");
		}
		else{
			System.out.println("They are not equal");
		}
			

	}

}
