
public class Solution12 {
	
	public static void fibonacci(int n){
//	    boolean isCapital = false;
//	    String[] words = {"this","is","a","test"};
//
//	 
//	        if(words[0].length() > 0 && Character.isUpperCase(words[0].charAt(0))){
//	            isCapital = true;
//	            
//	        }else{
//	            isCapital = false;
//	        }
//	    
//	    return isCapital;
		int fibonacci = 0;
	    int fNum = 0;
	    int sNum = 1;
	for(int i = 0; i < n ; i++){
	        fibonacci = fNum + sNum;
	        fNum = sNum;
	        sNum = fibonacci;

	}
	System.out.println(fNum);

		
	}
	
	public static boolean isCapital(String str){  
	    if((int) str.charAt(0) >= 65 && (int) str.charAt(0) <= 90  ){
	        return true;
	    }else{
	        return false;
	    }

	}



	public static void main(String[] args) {
		System.out.println(isCapital("this is a test"));
		System.out.println((int)'a' +""+(int)'A');
	
		//System.out.println("Mod " + 12%4 + "div " + 12/4);
	}

}
