package com.automationpractice.demos;

import java.util.Set;

import org.testng.annotations.Test;

import driver_factory.Driver;

public class WebDriverSwitchWindow extends Driver{
	
	
	@Test
	public void switchWindowAndPerformActionInNewWindow() {
		driverHelper.openUrl("http://testleaf.herokuapp.com/pages/Window.html");
		
		driverHelper.clickById("home",2);
		
		driverHelper.switchToNewWindow();
		
		driverHelper.clickByXpath("//h5[text()='Table']", 2);
		
	}
	
	

}
