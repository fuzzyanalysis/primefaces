package com.fuzzyanalysis.editor.test;

import org.junit.Assert;
import org.junit.Test;

public class BasicViewTest {
	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {

	   // MyClass is tested
	   // Tests
	   Assert.assertEquals("10 x 0 must be 0", 0, 10*0);
	   Assert.assertEquals("0 x 10 must be 0", 0, 0*10);
	   Assert.assertEquals("0 x 0 must be 0", 0, 0*0);
	 } 
}
