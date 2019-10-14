package com.herokuapp.testLeaf;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver_factory.Driver;
import utils.Common;

/**
 * 
 * 
 * @author onces
 *
 */
public class Frame extends Driver  {
	
	@Test
    public void frameTest () {
		WebDriver driver= Driver.getDriver("chrome");
		driver.get("http://testleaf.herokuapp.com/pages/frame.html");
        driver.switchTo().frame(0);
        
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Click")));
        driver.findElement(By.id("Click")).click();
        driver.switchTo().defaultContent();//navigates back to main HTML
        
//      driver.switchTo().frame(1);
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[2]")));
        driver.switchTo().frame("frame2");
        driver.findElement(By.id("Click1")).click();
        
        Common.sleep(3);
        
        /*
         * 3 ways to switch to frame
         * 1 --> by index --> driver.switchTo().frame(1);
         * 2 --> by id or name --> driver.switchTo().frame("iAmHere");
         * 3 --> by web element --> driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[2]")));
         */
        
        
    }

}
