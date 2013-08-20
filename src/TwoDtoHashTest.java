import java.util.HashMap;


public class TwoDtoHashTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[][] test = {{"key1","value1"},{"key2","value2"},{"key3","value3"}};
		// TODO Auto-generated method stub
		
		HashMap<String, String> hash = new HashMap<String, String>();
		for(String[] i:test){
				hash.put(i[0],i[1]);
			}
		System.out.println("HashMap contains values:" + hash.values()+"and keys:"+hash.keySet());
		
		System.out.println("HashMap is :" + hash.toString());

	}

}
