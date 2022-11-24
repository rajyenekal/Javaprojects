package Sample_Test_Report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework_Utility.Basetest;
import Framework_Utility.Utility_Methods;

public class Workingon_Computer_Accessories extends Basetest {
	@Test
	public void Computer() {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"))).perform();
		WebElement click= driver.findElement(By.xpath("(//a[contains(text(),'Accessories')])[1]"));
		Utility_Methods.click_Element(click);
	}

}
