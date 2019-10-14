package utils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class Reporter {
    
    static ExtentHtmlReporter extentHtmlReporter;
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    public static ExtentTest step;
    
    public static void initReporter() {
        if(extentReports ==null) {
            extentHtmlReporter = new ExtentHtmlReporter("automation-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);
        }
    }
    
    public static void createClass(String className) {
        extentTest=extentReports.createTest(className);
    }
    public static void createTest(String testName) {
        step=extentTest.createNode(testName);
    }
    
 public static void verify(String expected, String actual) {
        
        if(expected.equals(actual)) {
            //pass
            step.pass("Verification sucess. Expected: ["+expected+"] Actual: ["+actual+"]");
        }else {
            //fail
            step.fail("Verification failed. Expected: ["+expected+"] Actual: ["+actual+"]");
        }
        
    }

       
    public static void saveReport() {
        extentReports.flush();
    }

	
}




