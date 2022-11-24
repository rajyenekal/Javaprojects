package Framework_Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basetest_Flipcart {
	public static WebDriver driver;
	@BeforeClass
	public void launch() throws IOException{
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		String url=Utility_Methods.Test_Configuration();
		driver.get(url);
		driver.manage().window().maximize()	;
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	    }
		@AfterClass
		public void teardown() {
		driver.quit();
	}
	

}
