package com.herokuapp.testLeaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver_factory.NonStaticDriver;
import utils.AppProperties;
import static org.testng.Assert.*;
import java.util.List;
/**
 * October, 06 2019
 * @author TechCenture
 *
 */
public class Table extends NonStaticDriver {
    
    private int timeOutInSeconds = 15;
    
    @BeforeClass
    void beforeClass () {
        driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL + "/pages/table.html");
    }
    
    /**
     * @author TechCenture
     * Get the count of number of columns
     */
    @Test
    void tabletest1 () {
        int numberOfColumns = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds).size();
        assertEquals(numberOfColumns, 3);
//      java.lang.AssertionError: expected [4] but found [3]
        
        
//      Assert.assertTrue(numberOfColumns == 3); expect true to pass the test
//      java.lang.AssertionError: expected [true] but found [false]
//      Assert.assertFalse(numberOfColumns == 3); expect false to pass the test
        
        WebElement tableElement = driverHelper.getElement(By.tagName("table"), numberOfColumns);
        int numberOfColumns1 = tableElement.findElements(By.tagName("th")).size();
//      System.out.println(numberOfColumns1);
    }
    
    /**
     * Get the count of number of rows
     */
    @Test
    void tableTest2 () {
        int numberOfRows = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds).size();
        assertEquals(numberOfRows, 4);
    }
    
    /**
     * Get the progress value of 'Learn to interact with Elements'
     */
    @Test
    void tableTest3 () {
        String progress = getCellValue("Learn to interact with Elements", "Progress").getText();
        assertEquals(progress, "80%");
    }
    
    /**
     * Check the vital task for the 'Learn to interact with Elements'.
     */
    @Test
    void tableTest4 () {
        WebElement webElement = getCellValue("Learn to interact with Elements", "Vital Task");
        webElement.click();
        assertTrue(webElement.findElement(By.tagName("input")).isSelected());
    }
    
    private WebElement getCellValue ( String rowName, String columnName ) {
        WebElement webElement = null;
//      String cellValue = "";
        int columnIndex = 0;
        List<WebElement> columnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds);
        for ( int index = 0; index < columnElements.size(); index++ ) {
            String actualColumnName = columnElements.get(index).getText();
            if ( actualColumnName.contains(columnName) ) {
                columnIndex = index + 1;
                break;
            }
        }
        
        List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds);
        for ( int index = 1; index < rowElements.size(); index++ ) {
//          parent element row -- > rowElements.get(index)
//          child element column of element row --> .findElement(By.tagName("td"))
            String actualRowName = rowElements.get(index).findElement(By.tagName("td")).getText();
            if ( actualRowName.contains(rowName) ) {
                webElement = rowElements.get(index).findElement(By.xpath(".//td[" + columnIndex + "]"));
            }
        }
        return webElement;
    }


}