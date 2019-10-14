package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.EDriver;
import utils.AppProperties;

import static utils.Common.*;

public class JavaScriptDemo extends EDriver {
	
	int timeOutInSeconds = 15;
	
	@Test
	public void calculator () {
		driverHelper.openUrl("http://www.anaesthetist.com/mnm/javascript/calc.htm");
		
		driverHelper.click(By.name("two"), timeOutInSeconds);
		
		driverHelper.click(By.name("add"), timeOutInSeconds);
		
		driverHelper.click(By.name("two"), timeOutInSeconds);
		
//		driverHelper.click(By.name("result"), timeOutInSeconds);
		
		//js = it a casted driver of type JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Calculate()");
		
//		String actualResult = driverHelper.getElement(By.name("Display"), timeOutInSeconds).getAttribute("value");
//		js.executeScript("arguments[0].style.border='3px dotted red'", 
//				driverHelper.getElement(By.xpath("//*[@name='Display']"), timeOutInSeconds));
		
		driverHelper.highlightElement(By.name("Display"));
		driverHelper.validateEquals(By.name("Display"), "4");
				
		sleep(4);
	}
	
	@Test
	public void jsAlert () {
		String alertText = "My name is " + getRandomFirstName() + " "
			+ getRandomLastName();
		driverHelper.openUrl(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		
		/*
		 * reloads the current web page on browser
		 * driver.navigate().refresh();
		 * driver.navigate().to("url");
		 * driver.navigate().back();
		 * driver.navigate().forward();
		 */
		
		
		sleep(2);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("alert('" + alertText + "')");
		
		sleep(2);
		
		String actualAlertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		sleep(2);
		Assert.assertEquals(actualAlertText, alertText);
	}
	
	@Test
	public void scollToElement () {
		driverHelper.openUrl(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		driverHelper.click(By.linkText("Sign in"), timeOutInSeconds);
		driverHelper.scrollToElement(By.linkText("Ecommerce software by PrestaShop™"));
	}
	
	/*
	 * document.title --> Get page title 
	 * history.go(0); --> reloads the web page
	 * 
	 */
	
}








