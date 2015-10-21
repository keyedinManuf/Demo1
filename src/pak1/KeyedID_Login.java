package pak1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyedID_Login 
{
	public static WebDriver dr = new FirefoxDriver();
	public static void main(String[] args) throws IOException, BiffException 
	{
		Login1();		
	}
	
	public static Properties Attributes() throws IOException
	{
		//This file contains Field's attributes
		FileReader ff = new FileReader("D:/test/0_KeyedIN/src/pak2/KeyedIN_Attributes");
		Properties pp = new Properties();
		pp.load(ff);
		return(pp);
	}

	public static Properties TestData() throws IOException
	{
		//This file contains User credentials
		FileReader ff = new FileReader("D:/test/0_KeyedIN/src/pak2/KeyedIN_TestData");
		Properties pp = new Properties();
		pp.load(ff);
		return(pp);
	}
	
	public static void Login1() throws IOException
	{
		try{
		
		dr.get(Attributes().getProperty("URL"));
		dr.findElement(By.xpath(Attributes().getProperty("UN"))).sendKeys(TestData().getProperty("UN"));
		dr.findElement(By.xpath(Attributes().getProperty("Pwd"))).sendKeys(TestData().getProperty("Pwd"));
		dr.findElement(By.xpath(Attributes().getProperty("Click"))).click();
		String Str1 = dr.getPageSource();
		String Str2 = "User Name";
		if(Str1.contains(Str2))
		{
			System.out.println("Yet To Login");
		}
		else
		{
			System.out.println("Logged In Successfully");
		}	
		dr.findElement(By.xpath(Attributes().getProperty("Home"))).click();
		
		
		
		}catch(NullPointerException e){
			System.out.println(e);
			System.out.println("rest of the code...");
		}
	}
	
	public static void Login2() throws BiffException, IOException
	{
		dr.get(Attributes().getProperty("URL"));
		FileInputStream fileinput = new FileInputStream("D:\\KeyedIN Credentials.xls");
		Workbook wb = Workbook.getWorkbook(fileinput);
		Sheet ss = wb.getSheet(0);
		String TT[][] = new String[ss.getRows()][ss.getColumns()];
		
			for(int i=0;i<ss.getRows();i++)
			{
				for(int j=0;j<ss.getColumns();j++)
				{
					TT[i][j] =ss.getCell(j, i).getContents();
					if(j==0)
						{
							dr.findElement(By.xpath(Attributes().getProperty("UN"))).sendKeys(TT[i][j]);
							System.out.println("I= "+i+"; J= "+j+"; Val= "+TT[i][j]);
						}
						else
						{
							dr.findElement(By.xpath(Attributes().getProperty("Pwd"))).sendKeys(TT[i][j]);
							System.out.println("I= "+i+"; J= "+j+"; Val= "+TT[i][j]);
							dr.findElement(By.xpath(Attributes().getProperty("Click"))).click();
							dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						}
				}				
			}			
	}
}