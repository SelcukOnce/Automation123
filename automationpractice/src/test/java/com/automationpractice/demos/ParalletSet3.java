package com.automationpractice.demos;

import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;

public class ParalletSet3 extends NonStaticDriver{

	
	@Test
	public void testOne() {
		driverHelper.openUrl("http://www.buy.com");
		
		
	}
	@Test
	public void testTwo() {
		driverHelper.openUrl("http://www.walmart.com");
		
		
	}
	@Test
	public void testThree() {
		driverHelper.openUrl("http://www.target.com");
		
		
	}
	
}
