import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FindCharInString {
	
	/**
	 * takes in the list of words and the character and returns the set of words
	 * @param list - list of words
	 * @param c - character we are looking for
	 * @return - set of words which has the character
	 * @throws Exception
	 */
	public static HashSet<String> containsChar(ArrayList<String> list, char c) throws Exception	{
		if(list.size() <= 0) throw new Exception("List is empty");
		HashMap<Character, HashSet<String>> hm = new HashMap<Character, HashSet<String>>();
		HashSet<String> words = new HashSet<String>();
		for(String s : list){
			if(s != null){

				for(int i = 0; i < s.length(); i++){
					if(hm.containsKey(s.charAt(i))){
						hm.get(s.charAt(i)).add(s); // if it exists just add to the set

					} else{
						words = new HashSet<String>(); // else create a new hashset
						words.add(s);
						hm.put(s.charAt(i), words);
					}

				}
			}else{
				throw new Exception();
			}
		}

		if(hm.containsKey(c))
			words = hm.get(c);

		return words;
	}
	
	/**
	 * function to print out the contents of the set
	 * @param list of words
	 */
	public static void printList(HashSet<String> list)	{
		Iterator<String> iterator = list.iterator(); 
	      
	      // check values
		 System.out.print("Words in the list: {");
	      while (iterator.hasNext()){
	         System.out.print(iterator.next() + ", ");  
	      }
	      System.out.print("}");
	}

	public static void main(String[] args) throws Exception {
		ArrayList<String> words = new ArrayList<String>();
		words.add("string");
		words.add("apple");
		words.add("degree");
		words.add("vertices");
		words.add("application");
		words.add("collection");
		words.add("arraylist");
		words.add("array");
		words.add("double");
		printList(containsChar(words, 'd'));
	}

}
