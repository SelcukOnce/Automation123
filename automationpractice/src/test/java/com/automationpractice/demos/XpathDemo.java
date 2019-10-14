package com.automationpractice.demos;

import org.openqa.selenium.By;

import driver_factory.Driver;

public class XpathDemo extends Driver{
	
	
	
	public static void main(String[] args) {
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Terms and conditions of use')])[1]")).click();
		
	}
	

}
