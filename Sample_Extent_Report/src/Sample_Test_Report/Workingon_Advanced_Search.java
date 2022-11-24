package Sample_Test_Report;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework_Utility.Basetest;
import Framework_Utility.Utility_Methods;

public class Workingon_Advanced_Search extends Basetest {
	
	@DataProvider(name="advancesearch")
	
	public Object[]testadvancesearch() throws IOException{
		
		Object[][]data=Utility_Methods.getTestData("Adv search");
		
		//data[0][0]="computers";
		//data[0][1]="1000";
		//data[0][2]="90000";
		//data[0][3]="Electronics >> Camera, photo";
		//data[0][4]="3";
		
		return data;
	}
	
	@Test(dataProvider="advancesearch")
	
	public void demo(String search, String from, String to,String text,String valu ) {
		
	//search computers
	WebElement Element=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
	Utility_Methods.Enter_Value_In_Edit_Field(Element,search);
	
	//click on search
	WebElement click= driver.findElement(By.xpath("//input[@value='Search']"));
	Utility_Methods.click_Element(click);
	
	//click on advanced search
	WebElement click2= driver.findElement(By.xpath("//label[@for='As']"));
	Utility_Methods.click_Element(click2);
	
	//seectbyindex
	//Workingon_Utility_Methods.dropdownby_index(driver.findElement(By.xpath("//select[@id='Mid']")), data);
	
	//selectby text
	Utility_Methods.dropdownby_Text_(driver.findElement(By.xpath("//Select [@id='Cid']")),text);
	
	//click on automatic search
	WebElement click3= driver.findElement(By.xpath("//input[@id=\'Isc\']"));
	Utility_Methods.click_Element(click3);
	
	//selectbyvalue
	Utility_Methods.dropdownby_Value(driver.findElement(By.xpath("//select[@id='Mid']")), valu);
	
	//starting range
	WebElement value= driver.findElement(By.xpath("//input[@id='Pf']"));
	Utility_Methods.Enter_Value_In_Edit_Field(value, from);
	
	//ending range
	WebElement value2= driver.findElement(By.xpath("//input[@id='Pt']"));
	Utility_Methods.Enter_Value_In_Edit_Field(value2, to);
	
	//click on search
	WebElement click4= driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
	Utility_Methods.click_Element(click4);
	
	} 

}