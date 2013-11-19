package ci.java.com;

public class IsRotation {
	
	public static boolean isRotation(String original, String rotated){
		int strLength = original.length();
		if(strLength == rotated.length() && strLength > 0){
			String combined = original+original;
			return isSubstring(combined, rotated);
		}
		return false;
	}

	private static boolean isSubstring(String combined, String rotated) {
		if(combined.indexOf(rotated) >= 0){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is Rotation of Original String :"+isRotation("water", "erwat"));

	}

}
