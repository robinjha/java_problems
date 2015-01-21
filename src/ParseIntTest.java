import static org.junit.Assert.*;

import org.junit.Test;


public class ParseIntTest {

	@Test
	public void negativeNum() {
		assertEquals(-1, ParseInt.parseInt("-1"));
	}
	
	@Test
	public void positiveNum() {
		assertEquals(1, ParseInt.parseInt("1"));
	}
	
	@Test
	public void testZero() {
		assertEquals(0, ParseInt.parseInt("0"));
	}

	@Test
	public void negativeNum1() {
		assertEquals(-123, ParseInt.parseInt("-123"));
	}
}
