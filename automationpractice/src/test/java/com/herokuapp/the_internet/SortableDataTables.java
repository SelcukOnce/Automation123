package com.herokuapp.the_internet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import driver_factory.EDriver;
import utils.AppProperties;
/**
 * October, 12 2019
 * @author TechCenture
 *
 */
public class SortableDataTables extends EDriver {
    
    private int timeOutInSeconds = 15;
    
    @Test
    public void example1Table () {
        driverHelper.openUrl(AppProperties.THE_INTERNET_BASE_URL + "/tables");
        
        String tableXpath = "//table[@id='table1']";
        int numberOfColumns = driverHelper.getElements(By.xpath(tableXpath + "/thead//th"), 15).size();
        int numberOfRows = driverHelper.getElements(By.xpath(tableXpath + "/tbody/tr"), 15).size();
        
        for ( int row = 1; row <= numberOfRows; row++ ) {
            String actualLastName = driverHelper.getText(By.xpath("(" + tableXpath + "/tbody/tr)[" + row + "]//td[1]"), 15);
            if ( actualLastName.equals("Bach") ) {
                WebElement actionColumnElement = driverHelper.getElement(
                        By.xpath("(" + tableXpath + "/tbody/tr)[" + row + "]//td[" + numberOfColumns + "]"), 15);
                
                WebElement editLinkElement = actionColumnElement.findElement(By.linkText("edit"));
                editLinkElement.click();
                break;
            }
        }
        
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.endsWith("#edit"));
    }
    
    /**
     * Fix the issue in the method   *(*&*&^&&()(*&^%&^$*^%^*&&(*&(&*^&^$^^%%#$%&&*
     * cant get all rows?? only read 3
     */
    @Test
    public void example2Table () {
        /*
         * Navigate to sortable tables page
         * print values of each cell of the 2nd table
         */
        driverHelper.openUrl(AppProperties.THE_INTERNET_BASE_URL + "/tables");
        WebElement tableElement = driverHelper.getElement(By.id("table2"), timeOutInSeconds);
        int numberOfRows = tableElement.findElements(By.tagName("tr")).size();
        int numberOfColumns = tableElement.findElements(By.tagName("th")).size();
        
        for ( int row = 1; row <= numberOfRows; row++ ) {
            for ( int column = 1; column <= numberOfColumns; column++ ) {
                String cellValue = row == 1 ?
                        tableElement.findElement(By.xpath(".//tr[" + row + "]/th[" + column + "]")).getText()
                        : tableElement.findElement(By.xpath(".//tr[" + row + "]/td[" + column + "]")).getText();
                System.out.print(cellValue);
            }
            System.out.println();
        }
    }
}

