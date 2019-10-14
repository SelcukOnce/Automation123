package utils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public final class DriverHelper {
	
    private String mainWindowhandle;
    private WebDriver sDriver;
    private EventFiringWebDriver eDriver;
	
	public DriverHelper ( WebDriver driver ) { 
		this.sDriver = driver; 
		}
    
    public DriverHelper ( EventFiringWebDriver driver ) {
        this.eDriver = driver;
    }
    
    public void openUrl(String url) {
    	eDriver.get(url);
    	Reporter.step.info("Navigated to: "+ url);
    	mainWindowhandle = eDriver.getWindowHandle();
    }
    
    public String getMainWindowhandle () {
    	return mainWindowhandle;
    }
    
    public void waitForElementVisibility ( By by, int timeOutInSeconds ) {
        new WebDriverWait(eDriver, timeOutInSeconds).
        until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public WebElement getElement ( By by, int timeOutInSeconds ) {
        waitForElementVisibility(by, timeOutInSeconds);
        return eDriver.findElement(by);
    }
    
    public List<WebElement> getElements ( By by, int timeOutInSeconds ) {
        waitForElementVisibility(by, timeOutInSeconds);
        return eDriver.findElements(by);
    }
    
    public void click ( By by, int timeOutInSeconds ) {
        getElement(by, timeOutInSeconds).click();
//        Reporter.step.info("Clicked on element");
    }
    
    public void click ( By by, int index, int timeOutInSeconds ) {
    	//getElements return all web element
    	//.get(index) return an object of WebElement
        getElements(by, timeOutInSeconds).get(index - 1).click();
    }
    
    public void clickById ( String id, int timeOutInSeconds ) {
        getElement(By.id(id), timeOutInSeconds).click();
    }
    
    public void clickByXpath(String xpath, int timeOutInSeconds) {
    	getElement(By.xpath(xpath), timeOutInSeconds).click();
    }
    
    public void sendKeys ( By by, String text, int timeOutInSeconds ) {
        getElement(by, timeOutInSeconds).sendKeys(text);
        Reporter.step.info("Typed: "+ text);
    }
    
    public String getText ( By by, int timeOutInSeconds ) {
        return getElement(by, timeOutInSeconds).getText().replaceAll("\\s+", " ").trim();
    }
    
    public void takeScreenshot () {
        TakesScreenshot takesScreenshot = (TakesScreenshot) eDriver;
        // getScreenshotAs method to create image file
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            //Move image file to new destination
            //Copy file at destination
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")  + "/target/screenshots"
                    + "/FileName" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static String takeScreenshotForReporting (WebDriver driver) {
        	long ms =System.currentTimeMillis();
        	String path = System.getProperty("user.dir")  + "/target/screenshots"
                    + "/FileName" + ms;
        	
        	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            // getScreenshotAs method to create image file
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            try {
                //Move image file to new destination
                //Copy file at destination
                FileUtils.copyFile(file, new File(path + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return path+".png";
        }
   
    
	public void switchToNewWindow() {
		Set<String> handles=eDriver.getWindowHandles();
		
		for(String h:handles) {
			if(h.equals(mainWindowhandle)) {
				System.out.println("driver will not switch");
			}else {
				eDriver.switchTo().window(h);
			}
		}
	}
	
	public void switchToMainWindow() {
		eDriver.switchTo().window(mainWindowhandle);
	}
	
	private void executeJS ( String script, WebElement webElement ) {
		JavascriptExecutor js = (JavascriptExecutor) eDriver;
		js.executeScript(script, webElement);
	}
	
	public void click1 ( By by ) {
		try {
			click(by, 15);
		} catch ( WebDriverException e ) {
			Common.sleep(1);
			scrollToElement(by);
			click(by, 15);
		}
	}
	
	public void click2 ( By by ) {
		try {
			click(by, 15);
		} catch ( WebDriverException e ) {
			jsClick(by);
		}
	}
	
	public void jsClick ( By by ) {
		WebElement webElement = eDriver.findElement(by);
		executeJS("arguments[0].click()", webElement);
	}
	
	public void scrollToElement ( By by ) {
		WebElement webElement = getElement(by, 15);
		executeJS("arguments[0].scrollIntoView(true)", webElement);
//		JavascriptExecutor js = (JavascriptExecutor) eDriver;
//		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
	
	public void highlightElement ( By by ) {
		WebElement webElement = getElement(by, 15);
		executeJS("arguments[0].style.border='3px dotted red'", webElement);
	}
	
	public void validateEquals ( By by, String expectedText ) {
		if ( !getText(by, 15).equals(expectedText) ) {
			highlightElement(by);
			takeScreenshot();
			Assert.assertEquals(getText(by, 15), expectedText);
		}
	}
	
	public void validateEquals ( String actualText, String expectedText ) {
		if ( !actualText.equals(expectedText) ) {
//			JavascriptExecutor js = (JavascriptExecutor) eDriver;
//			js.executeScript("arguments[0].style.border='3px dotted red'", webElement);
			takeScreenshot();
			Assert.assertEquals(actualText, expectedText);
//			throw new AssertionError();
		}
	}
}