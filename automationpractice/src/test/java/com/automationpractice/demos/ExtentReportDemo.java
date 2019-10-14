package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import driver_factory.EDriver;
import utils.Reporter;

public class ExtentReportDemo extends EDriver{
	
	@Test
	public void t1() {
		driverHelper.openUrl("http://www.amazon.com");
		driverHelper.click(By.id("dsdsdsdsd"), 2);
	}
	
	
	@Test
		public void Login_with_invalid_userid() {
//		Reporter.createTest("login with invalid userid and password");
		
		driver.get("http://www.automationpractice.com");
		
		driver.findElement(By.className("loginff")).click();
		
//		driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
		driverHelper.sendKeys(By.id("email"), "myunknowxaad@mailinator.com", 2);
		
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		String errorMessage = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		Assert.assertEquals(errorMessage, "There is 1 error");
			
	}
	
	
}
