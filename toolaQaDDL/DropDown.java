package toolaQaDDL;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDown {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/selectmenu/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@id='speed-button']")).click();
		
		
		WebElement findElement = driver.findElement(By.className("ui-selectmenu-menu ui-front ui-selectmenu-open"));
		
		Actions act=new Actions(driver);
		WebElement wb=driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper ui-state-active']"));
		act.moveToElement(wb);
		act.perform();
		act.click();
		WebElement wbFaster = driver.findElement(By.xpath("//div[text()='Faster']"));
		wbFaster.click();
		
		driver.findElement(By.xpath("//span[@id='speed-button']")).click();
		WebElement wbSlower = driver.findElement(By.xpath("//div[text()='Slower']"));
		wbSlower.click();
		driver.quit();
	}}
