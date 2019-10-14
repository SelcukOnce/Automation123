package driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;
import utils.Reporter;

public class NonStaticDriver {
	
	protected WebDriver sDriver;
	protected DriverHelper driverHelper;
	protected EventFiringWebDriver eDriver;
	
	@BeforeSuite
	public void initializeReporter() {
		Reporter.initReporter();
	}
	
	@AfterMethod
	public void saveReport() {
		Reporter.saveReport();
	}
	
	@BeforeTest
	public void init() {
	if ( eDriver == null ) eDriver = (EventFiringWebDriver) getDriver(AppProperties.BROWSER_TYPE);
//		if ( driverHelper == null ) driverHelper = new DriverHelper(driver);
		Common.deleteFiles("/target/screenshots");
	}
	
	protected NonStaticDriver () {}
	
	protected WebDriver getDriver ( String browserType ) {
		WebDriver eDriver = null;
		switch ( browserType ) {
			case "chrome":
				eDriver = getChromeDriver();
//				eDriver.manage().window().maximize();
				break;
			case "firefox":
				eDriver = getFirefoxDriver();
				eDriver.manage().window().maximize();
				break;
			default: System.out.println("Browser type " + browserType + " invalid");
				break;
		}
		eDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		eDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driverHelper = new DriverHelper(eDriver);
		return  eDriver;
	}
	
	private ChromeDriver getChromeDriver () {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);
	}
	
	private  FirefoxDriver getFirefoxDriver () {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	@AfterTest
	public void closeBrowser() {
		eDriver.close();
		eDriver.quit();
	}
}
