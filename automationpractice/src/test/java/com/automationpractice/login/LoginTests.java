package com.automationpractice.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import driver_factory.NonStaticDriver;

public class LoginTests extends NonStaticDriver{
	
	@Test(groups = {"functional","integration"})
	public void testOne() {
		sDriver.get("integration");
	}
	
	@Test(groups = "functional")
	public void Login_with_invalid_userid() {
	
//			Go to http://www.automationpractice.com
			sDriver.get("http://www.automationpractice.com");
		
//			Click Sign in button from top right corner of the page
			sDriver.findElement(By.className("login")).click();
			
//			Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
			sDriver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
//			Click Sign in button
			sDriver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
			
//			Verify error message displayed 'There is 1 error'
			String errorMessage = sDriver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
			
//			System.out.println(errorMessage);
			
			Assert.assertEquals(errorMessage, "There is 1 error");
			
			
			
//			Verify error message displayed 'Password is required.'

		
	}
	@Test
	public void Login_with_invalid_userid_2() {
	
//			Go to http://www.automationpractice.com
			sDriver.get("http://www.automationpractice.com");
		
//			Click Sign in button from top right corner of the page
			sDriver.findElement(By.className("login")).click();
			
//			Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
			sDriver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
//			Click Sign in button
			sDriver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
			
//			Verify error message displayed 'There is 1 error'
			String errorMessage = sDriver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
			
//			System.out.println(errorMessage);
			
			Assert.assertEquals(errorMessage, "There is 1 error");
			
			
			
//			Verify error message displayed 'Password is required.'

		
	}
	
	
	//
	
	//
	
	

}
