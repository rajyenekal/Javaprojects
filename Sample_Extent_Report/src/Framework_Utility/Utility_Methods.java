package Framework_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Utility_Methods  extends Basetest {
	//utility methods
	public static void Enter_Value_In_Edit_Field(WebElement element,String value){
		
		element.sendKeys(value);
		
	}
	public static void click_Element(WebElement element) {
		
		element.click();
		
	}
	public static void dropdownby_index(WebElement element,int index){
	
		Select sele=new Select(element);
		sele.selectByIndex(index);
		
		
	}
	public static void dropdownby_Value(WebElement element,String val){
		
		Select sele=new Select(element);
		sele.selectByValue(val);
		
		
	}
	public static void dropdownby_Text_(WebElement element,String text){
		
		Select sele=new Select(element);
		sele.selectByVisibleText(text);
		
		
	}
	public static String Test_Configuration() throws IOException {
		
		String filepath="./Test_Configuration/TestConfiguration.properties";
		FileInputStream fis =new FileInputStream(filepath);
		
		//creating an object for Properties class
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("URL");
		return url;
	}
	
	//Utility method to get the testdata
	public static Object[][] getTestData(String sheetname) throws IOException{
		//file path
		String filepath="./Testdata/ADVsearch.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		
		//create object for excel file
		Workbook book=new XSSFWorkbook(fis);
		
		//Access the sheet
		Sheet sheet=book.getSheet(sheetname);
		
		//get row,col count 
		int rowcount=sheet.getPhysicalNumberOfRows();
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[rowcount-1][colcount];
		
		//print all the rows and columns
		for(int row=1;row<=rowcount-1;row++) {
			for(int col=0;col<=colcount-1;col++) {
				data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
			}
			//System.out.println();
		}
		book.close();
		
		return data;
		
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
