package com.herokuapp.testLeaf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import junit.framework.Assert;
import utils.AppProperties;
import utils.Common;

/**
 * October, 06 2019
 * 
 * @author TechCenture
 *
 */
public class Window extends NonStaticDriver {

	private int timeOutInSeconds = 5;

	@Test
	public void windowTest1() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL + "/pages/Window.html");
		driverHelper.click(By.id("home"), timeOutInSeconds);
		Set<String> windows = eDriver.getWindowHandles();
		for (String window : windows) {
			eDriver.switchTo().window(window);
			String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);

			if (header.equals("Locators and Selenium Interactions")) {
				String title = eDriver.getTitle();
				Assert.assertEquals("TestLeaf - Selenium Playground", title);
				eDriver.close();
			}
			Common.sleep(4);
			
			
			eDriver
			.switchTo()
			.window(windows
					.iterator()
					.next());
			
			header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			Assert.assertEquals("Work with Windows", header);
		}
	}

	@Test
	public void windowTest2 () {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		driverHelper.click(By.xpath("//button[contains(text(),'Open Multiple Windows')]"), timeOutInSeconds);
		
//		Set<String> windows = driver.getWindowHandles();
		
		String name = "Mushfig";
		Integer letters = name.length();
		
		Set<Integer> windows = new HashSet<Integer>();
/* option 1 */ Iterator<Integer> it = windows.iterator();
		while ( it.hasNext() ) {
			Integer window = it.next();
			System.out.println(window);
		}
		
		
//		/* option 2 */ List<String> windowList = new ArrayList<String>(windows);
		
		System.out.println(windows.size() + " windows are opened");
//		ArrayList<String> tabs = new ArrayList<String>(windows);
//		System.out.println("Number of opened windows: " + tabs.size());
	}
	
	@Test
	public void windowTest3 () {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		driverHelper.click(By.id("color"), 1, timeOutInSeconds);
		
		Set<String> windows = eDriver.getWindowHandles();
		for ( String window : windows ) {
			eDriver.switchTo().window(window);
			String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);

			if ( !header.equals("Work with Windows") ) {
//				String title = driver.getTitle();
//				Assert.assertEquals("TestLeaf - Interact with Windows", title);
				eDriver.close();
			}
		}
		eDriver.switchTo().window(driverHelper.getMainWindowhandle());
//		driver.switchTo().window(windows.iterator().next());
		Common.sleep(4);
	}
	
	@Test
	public void windowTest4 () {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		driverHelper.click(By.id("color"), 2, timeOutInSeconds);
		
		Common.sleep(5);
		Set<String> windows = eDriver.getWindowHandles();
		for ( String window : windows ) {
			eDriver.switchTo().window(window);
			String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			
			if ( !header.equals("Work with Windows") )
				eDriver.close();
		}
		driverHelper.switchToMainWindow();
//		driver.switchTo().window(driverHelper.getMainWindowhandle());
//		driver.switchTo().window(windows.iterator().next());
		Common.sleep(4);
	}
}
