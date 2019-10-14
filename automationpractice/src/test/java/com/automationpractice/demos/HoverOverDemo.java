package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import driver_factory.EDriver;
import utils.AppProperties;
import utils.Common;

public class HoverOverDemo extends EDriver {
	
	private int timeOutInSeconds = 15;
	
	@Test
	public void hoverOverTest1 () {
		driverHelper.openUrl(AppProperties.THE_INTERNET_BASE_URL + "/hovers");
		Actions actions = new Actions(driver);
		
		WebElement image1 = driverHelper.getElement(By.cssSelector(".figure > img"), timeOutInSeconds);
		actions.moveToElement(image1).perform();
		
		Common.sleep(1);
		driverHelper.click(By.cssSelector(".figure a"), timeOutInSeconds);
		
		/* alternative way to click on the link */
		driverHelper.jsClick(By.cssSelector(".figure a"));
		Common.sleep(5);
	}

}
