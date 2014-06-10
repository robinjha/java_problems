package ci.java.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

	@Test
	public void testCase01() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(1, r.reversedInt(1));
	}
	
	@Test
	public void testCase02() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(123, r.reversedInt(321));
		assertEquals(213, r.reversedInt(312));
		assertEquals(231, r.reversedInt(132));
	}
	
	@Test
	public void testCase03() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(-5, r.reversedInt(-5));
	}
	
	@Test
	public void testCase04() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(-52, r.reversedInt(-25));
	}

	@Test
	public void testCase05() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(0, r.reversedInt(0));
	}

	@Test
	public void testCase06() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(123456789, r.reversedInt(987654321));
	}

	@Test
	public void testCase07() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(-123456789, r.reversedInt(-987654321));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCase08()
	{
		ReverseInteger r = new ReverseInteger();
		r.reversedInt(2147483647);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCase09()
	{
		ReverseInteger r = new ReverseInteger();
		r.reversedInt(-2147483648);
	}
	
	@Test
	public void testCase10() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(11111, r.reversedInt(11111));
	}
	
	@Test
	public void testCase11() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(1, r.reversedInt(10000));
	}
	
	@Test
	public void testCase12() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(1, r.reversedInt(00001));
	}
	
	@Test
	public void testCase13() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(-11111, r.reversedInt(-11111));
	}
}
