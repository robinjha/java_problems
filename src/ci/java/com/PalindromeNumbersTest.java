package ci.java.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumbersTest {
	
	PalindromeNumbers pNums = new PalindromeNumbers();

	@Test
	public void inputOneDigitNums() {
		assertEquals(true, pNums.checkPalindrome(1));
	}
	
	@Test
	public void inputTwoDigitNums() {
		assertEquals(true, pNums.checkPalindrome(99));
	}
	
	@Test
	public void inputTwoDigitNumsNeg() {
		assertEquals(false, pNums.checkPalindrome(10));
	}

	@Test
	public void inputThreeDigitNums() {
		assertEquals(true, pNums.checkPalindrome(101));
	}
	
	@Test
	public void inputNonInteger() {
		assertEquals(false, pNums.checkPalindrome('a'));
	}
	
}
