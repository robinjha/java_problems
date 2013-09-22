package com.java.rubyquiz;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RandomPointInACircleTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		RandomPointInACircle rpc = new RandomPointInACircle(-3.0, 0.0, 0.0);
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Negative value for radius not allowed"); 
	}
	
	@Test
	public void testisWithinNegative(){
		RandomPointInACircle rpc = new RandomPointInACircle(3.0, 0.0, 0.0);
		Point2D.Double point = new Point2D.Double(0.0, 0.0);
		assertEquals("Point must be outside, value false", false, rpc.isWithin(point, 5.0, 5.0, 3.0));
	}

	// edge case 1 : Point(0.0, 3.0)
	@Test
	public void testisWithinPositiveOne() {
		RandomPointInACircle rpc = new RandomPointInACircle(3.0, 0.0, 0.0);
		Point2D.Double point = new Point2D.Double(0.0, 0.0);
		assertEquals("Point must be on the circle, value true", true, rpc.isWithin(point, 0.0, 3.0, 3.0));
	}

	// edge case 2 : Point(-3.0, 0.0)
	@Test
	public void testisWithinPositiveTwo() {
		RandomPointInACircle rpc = new RandomPointInACircle(3.0, 0.0, 0.0);
		Point2D.Double point = new Point2D.Double(0.0, 0.0);
		assertEquals("Point must be on the circle, value true", true, rpc.isWithin(point, 0.0, 3.0, 3.0));
	}

	// edge case 3 : Point(0.0, -3.0)
	@Test
	public void testisWithinPositiveThree() {
		RandomPointInACircle rpc = new RandomPointInACircle(3.0, 0.0, 0.0);
		Point2D.Double point = new Point2D.Double(0.0, 0.0);
		assertEquals("Point must be on the circle, value true", true, rpc.isWithin(point, 0.0, -3.0, 3.0));
	}

	// edge case 4 : Point(3.0, 0.0)
	@Test
	public void testisWithinPositiveFour() {
		RandomPointInACircle rpc = new RandomPointInACircle(3.0, 0.0, 0.0);
		Point2D.Double point = new Point2D.Double(0.0, 0.0);
		assertEquals("Point must be on the circle, value true", true, rpc.isWithin(point, 3.0, 0.0, 3.0));
	}
}
