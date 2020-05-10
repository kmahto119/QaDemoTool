package toolaQaDDL;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	 ExtentTest logger;
	 ExtentReports extent;
	 static WebDriver driver;

	 
	 public void takescrenshot() throws IOException{
		 EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		 File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		    ExtentTest logger2=extent.createTest("Logoff Test");
		    String imgPath=System.getProperty("user.dir")+new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			 FileUtils.copyFile(srcFile, new File(imgPath));
		    logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

	 }
	@BeforeClass
	public void beforeConfig(){
		   // Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
        // I used (.) in path where represent the current working directory
    ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\learn_automation1.html");
        // Create object of ExtentReports class- This is main class which will create report
     extent = new ExtentReports();
        // attach the reporter which we created in Step 1
    extent.attachReporter(reporter);
        // call createTest method and pass the name of TestCase- Based on your requirement
     logger=extent.createTest("LoginTest");
	}
	
	@AfterClass
	public static void endTest()
	{
	driver.quit();
	}
}
