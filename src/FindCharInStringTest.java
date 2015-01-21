import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class FindCharInStringTest {
	
	private Set<String> setA;
	private ArrayList<String> words;
	@Before
	public void setUp() {
		words = new ArrayList<String>();
		words.add("string");
		words.add("apple");
		words.add("degree");
		words.add("vertices");
		words.add("application");
		words.add("collection");
		words.add("arraylist");
		words.add("array");
		words.add("double");
    }

	@Test
	public void testZero() throws Exception {
		setA = new HashSet<String>();
		setA.add("degree");
		setA.add("double");
		//assertEquals(setA, FindCharInString.containsChar(words, 'c'));
		assertThat(FindCharInString.containsChar(words, 'c'), hasItems("degree","double"));
	}
	
	

}
