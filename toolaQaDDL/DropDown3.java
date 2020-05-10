package toolaQaDDL;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DropDown3 extends TestBase {
	static ExtentTest test;
	static ExtentReports report;
	
	@Test
	public  void test() throws Throwable {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/selectmenu/");
	    logger.log(Status.INFO, "http://demoqa.com/selectmenu/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		List<WebElement> selwb=driver.findElements(By.xpath("//ul[contains(@class,'ui-menu ui-corner-bottom ui-widget ui-widget-content')]//li"));
		int i=0;
		for(WebElement wb:selwb){
			System.out.println(selwb.get(i));
			wb.click();
			WebElement ele2 = driver.findElement(By.xpath("(//span[contains(@class,'ui-selectmenu-text')])[1]"));
			JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor2.executeScript("arguments[0].click();", ele2);
		    logger.log(Status.PASS, selwb.get(i)+"clicked");
			i++;
			Thread.sleep(3000);
			takescrenshot();
		}
	    extent.flush();
	}
	

}
