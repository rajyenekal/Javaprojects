package Sample_Test_Report;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Workin_With_Extent_Report {
	WebDriver driver;
	@Test
	public void ReportDemo() throws IOException {
		//create a HTML report template
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/Executionreport.html");
		
		//Attach the report to the HTML template
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(reporter);
		
		//create a test with testcases
		ExtentTest tests=reports.createTest("Demo Web Shop Regression");
		
		//Teststeps
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		tests.log(Status.PASS, "Application launched successfully");
		//capture screenshot
		tests.pass("application launched").addScreenCaptureFromPath(Capture_Screen_shot("Application_launched"));
		
		driver.findElement(By.id("small-searchterms")).sendKeys("books");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		tests.log(Status.PASS, "Product search is unsuccessful");
		tests.log(Status.INFO, "search is completed");
		driver.close();
		
		reports.flush();
	}
	//Method to capture Screenshot
	public String Capture_Screen_shot(String stepname)throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destpath="./Snapshots/"+stepname+".png";
		FileHandler.copy(src,new File(destpath));
		
		return "."+destpath;
	}

}
