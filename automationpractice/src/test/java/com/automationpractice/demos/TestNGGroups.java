package com.automationpractice.demos;

import org.testng.annotations.Test;

public class TestNGGroups {

	
	@Test(groups= {"functional"})
	public void testOne() {

	}

	@Test(groups= {"functional","integration"})
	public void testTwo() {

	}

	@Test
	public void testThree() {

	}

	@Test
	public void testFour() {

	}

	@Test
	public void testFive() {

	}

}
