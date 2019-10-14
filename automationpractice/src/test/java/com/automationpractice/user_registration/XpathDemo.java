package com.automationpractice.user_registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver_factory.Driver;
import utils.Common;

public class XpathDemo extends Driver{
    
    
    
    public static void main(String[] args) {
    	
    	
    	WebDriver driver = Driver.getDriver("chrome");
    	
    	driver.get("http://automationpractice.com/index.php");
    	
    	
    	Common.sleep(2);
    	
        driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Terms and conditions of use')])[1]")).click();
        
        Common.sleep(5);
        driver.quit();
    }
    

	
	
}


