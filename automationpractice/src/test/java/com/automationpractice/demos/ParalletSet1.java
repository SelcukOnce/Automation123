package com.automationpractice.demos;

import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;

public class ParalletSet1 extends NonStaticDriver {

	
	@Test
	public void testOne() {
		driverHelper.openUrl("http://www.cnn.com");
		
		
	}
	@Test
	public void testTwo() {
		driverHelper.openUrl("http://www.bbc.com");
		
		
	}
	@Test
	public void testThree() {
		driverHelper.openUrl("http://www.facebook.com");
		
		
	}
	
}
