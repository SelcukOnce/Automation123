package com.automationpractice.user_registration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;
/**
 * September, 22 2019
 * @author TechCenture
 *
 */
public class UserRegistration extends NonStaticDriver {
    
    private final int timeOutInSeconds = 15;
    @Test
    public void userRegistration () {
        sDriver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
        
        driverHelper.click(By.linkText("Sign in"), timeOutInSeconds);
//      driver.findElement(By.linkText("Sign in")).click();
        
        String firstName = Common.getRandomFirstName();
        String lastName = Common.getRandomLastName();
        String email = Common.getRandomEmail(firstName, lastName);
        
        driverHelper.sendKeys(By.id("email_create"), email, timeOutInSeconds);
//      driver.findElement(By.id("email_create")).sendKeys(email);
        driverHelper.click(By.id("SubmitCreate"), timeOutInSeconds);
//      driver.findElement(By.id("SubmitCreate")).click();
        
        driverHelper.takeScreenshot();
        driverHelper.waitForElementVisibility(
                By.xpath("//h1[text()='Create an account']"), timeOutInSeconds);
        /*
         * If you ask selenium wait for element with particular text
         * it will not make sense to assert it with the same text again
         */
//      Assert.assertEquals("CREATE AN ACCOUNT", 
//              driverHelper.getText(By.xpath("//h1[text()='Create an account']"), 
//                      timeOutInSeconds));
        
        
        Common.sleep(4);
    }

}
