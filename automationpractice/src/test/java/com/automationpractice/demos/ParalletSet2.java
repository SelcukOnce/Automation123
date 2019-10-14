package com.automationpractice.demos;

import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;

public class ParalletSet2 extends NonStaticDriver{

	
	@Test
	public void testOne() {
		driverHelper.openUrl("http://www.amazon.com");
		
		
	}
	@Test
	public void testTwo() {
		driverHelper.openUrl("http://www.ebay.com");
		
		
	}
	@Test
	public void testThree() {
		driverHelper.openUrl("http://www.hotels.com");
		
		
	}
	
}
