package com.herokuapp.testLeaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.Common;
public class Alert extends Driver {
    
    @Test
    public void alert1 () {
    	WebDriver driver= Driver.getDriver("chrome");
    	driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        
        WebElement headerElement = driver.findElement(By.tagName("h1"));
        webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));
        
        String header = headerElement.getText();
        Assert.assertEquals(header, "Handle Alerts", "Header validation is failed");
        
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Alert Box']")));
        driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
        
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am an alert box!");
        
        Common.sleep(2);
        driver.switchTo().alert().accept();
        Common.sleep(3);
        driver.quit();
    }
    
    @Test
    public void alert2 () {
       
    	WebDriver driver= Driver.getDriver("chrome");
    	driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        
        WebElement headerElement = driver.findElement(By.tagName("h1"));
        webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));
        String header = headerElement.getText();
        Assert.assertEquals(header, "Handle Alerts", "Header validation is failed");
        
        
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm Box']")));
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
        driver.switchTo().alert().accept();
        String text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, "You pressed OK!");
        
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
        driver.switchTo().alert().dismiss();
        text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, "You pressed Cancel!");
        Common.sleep(3);
        driver.quit();
    }
    
    @Test
    public void alert3 () {
        
    	WebDriver driver= Driver.getDriver("chrome");
    	driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        
        WebElement headerElement = driver.findElement(By.tagName("h1"));
        webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));
        String header = headerElement.getText();
        Assert.assertEquals(header, "Handle Alerts", "Header validation is failed");
        
        
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Prompt Box']")));
        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your training institute name");
        
        String inputText = "Tech Centure Academy";
        
        driver.switchTo().alert().sendKeys(inputText);
        driver.switchTo().alert().accept();
        
        
        String text = driver.findElement(By.id("result1")).getText();
        Assert.assertEquals(text, "You should not have enjoyed learning at " + inputText + " as compared to TestLeaf! Right?");
        Common.sleep(3);
        driver.quit();
    }


}
