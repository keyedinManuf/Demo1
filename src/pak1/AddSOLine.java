package pak1;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSOLine extends KeyedID_Login{

	public static String Str;
	public static WebDriver dr = new FirefoxDriver();
	public static void main(String[] args) throws IOException 
	{
		Login1();
		NewSalesOrder();
		test();	
	}

	public static void NewSalesOrder() throws IOException
	{
		System.out.println("************** SALES ORDER CREATION **************");
		dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		dr.findElement(By.xpath(".//a[@href='/Dev03/Form/Create/70']")).click();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("Test");
		dr.findElement(By.xpath("html/body/div[5]/ul/li[2]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[5]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[6]/div/input")).sendKeys("KI Bikes");
		dr.findElement(By.xpath("html/body/div[6]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[7]/div/input")).sendKeys("CAD - Canadian Dollars");
		dr.findElement(By.xpath("html/body/div[7]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[8]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[8]/div/input")).sendKeys("Mark B");
		dr.findElement(By.xpath("html/body/div[8]/ul/li[1]/div")).click();
		dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		WebElement WE1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		Str = WE1.getText();
		System.out.println("New Sales Order Created Succesfully & Order Number is: "+Str);		

		/*//Search
		System.out.println("************** SALES ORDER SEARCH **************");
		dr.get(Attributes().getProperty("URL"));
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).sendKeys("2000");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[9]/button[1]")).click();
		System.out.println("Wait Start");
		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement V1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div/a"));
		Dimension C1 = V1.getSize();
		//String Val = V1.getText();
		System.out.println("V1: "+C1);
			if(C1==null)
			{
				System.out.println("Entered Order Number "+ Str +" is filtered in the below list");
			}
			else
			{
				System.out.println("Entered Order Number "+ Str +" is not filtered in the below list");
			}	*/	
	}
	
	public static void AddSalesOrderLine()
	{
		System.out.println("************** ADD SALES ORDER LINE **************");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[3]")).click();
		
			//		* Part Number
			dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[3]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
			String Str1 = "/html/body/div[5]/ul/li[";
			String Str2 = "]";
			
			WebElement WL1 = dr.findElement(By.xpath("/html/body/div[5]"));
			List<WebElement> L1 = WL1.findElements(By.xpath("/html/body/div[5]/ul/li"));
			int Size = L1.size();
			System.out.println("Size: "+Size);
			Random rand = new Random(System.currentTimeMillis());
			int rval = rand.nextInt(Size)+1;		
			System.out.println("R Val: "+rval);
			dr.findElement(By.xpath(Str1+rval+Str2)).click();

			//		Default Delivery Address
			System.out.println("Default Delivery Address");
			dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
			String Str3 = "/html/body/div[6]/ul/li[";
			String Str4 = "]";
			WebElement WL2 = dr.findElement(By.xpath("/html/body/div[6]"));
			List<WebElement> L2 = WL2.findElements(By.xpath("/html/body/div[6]/ul/li"));
			int Size1 = L2.size();
			System.out.println("Size: "+Size1);
			Random rand1 = new Random(System.currentTimeMillis());
			int rval1 = rand1.nextInt(Size1)+1;		
			System.out.println("R Val: "+rval1);
			dr.findElement(By.xpath(Str3+rval1+Str4)).click();		
	}		
	
	public static void EditSO() throws IOException
	{
		dr.get(Attributes().getProperty("URL"));
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[2]";
		
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size()-1;
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("R Order: "+rval);
			
		dr.findElement(By.xpath(x1+rval+x2)).click();
		
/*		//Customer Selection
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		String x3 = "/html/body/div[5]/ul/li[";
		String x4 = "]";
		
		WebElement WE1 = dr.findElement(By.xpath("/html/body/div[5]/ul"));
		List<WebElement> WB2 = WE1.findElements(By.xpath("/html/body/div[5]/ul/li"));
		int DropdownVal1 = WB2.size();
		Random r1 = new Random(System.currentTimeMillis());
		int Drop = r1.nextInt(DropdownVal1)+1;
		System.out.println("R DropDown: "+Drop);
		dr.findElement(By.xpath(x3+Drop+x4)).click();
		
		//Status
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[4]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		String x5 = "/html/body/div[5]/ul/li[";
		String x6 = "]";
		
		WebElement WE2 = dr.findElement(By.xpath("/html/body/div[5]/ul"));
		List<WebElement> WB3 = WE2.findElements(By.xpath("/html/body/div[5]/ul/li"));
		int DropdownVal2 = WB3.size();
		Random r2 = new Random(System.currentTimeMillis());
		int Drop1 = r2.nextInt(DropdownVal2)+1;
		System.out.println("R DropDown: "+Drop1);
		dr.findElement(By.xpath(x5+Drop1+x6)).click();	*/
				
		//Save
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
		String S1 = "Some of the items in this list are not valid";
		String S2 = dr.getPageSource();
		
		if(S2.contains(S1))
		{
			System.out.println("Unable to Update Sales Order due to invalid Sales Order Items");
		}
		else
		{	
			WebElement WB1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/label"));
			String OrderNum = WB1.getText();
			System.out.println(OrderNum+" is updated successfully");
		}
	}
	
	public static void ViewSO() throws IOException
	{
		System.out.println("************** SALES ORDER VIEW **************");
		dr.get(Attributes().getProperty("URL"));
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[6]";
		String x3 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x4 = "]/td[1]/div[2]/ul/li[3]";
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size()-1;
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("R Order: "+rval);
		dr.findElement(By.xpath(x1+rval+x2)).click();
		dr.findElement(By.xpath(x3+rval+x4)).click();		
		WebElement WW2 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		System.out.println("Order Number is: "+WW2.getText());
	}
	
	public static void DeleteSO() throws IOException
	{
		System.out.println("************** SALES ORDER DELETE **************");
		dr.get(Attributes().getProperty("URL"));
		//Random Order Navigate
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[6]";
		//Random Delete Button
		String x3 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x4 = "]/td[1]/div[2]/ul/li[5]";
		//Random Order Number
		String x5 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x6 = "]/td[3]/div/a";
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size()-1;
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("R Order: "+rval);
		dr.findElement(By.xpath(x1+rval+x2)).click();
		String S1 = dr.findElement(By.xpath(x5+rval+x6)).getText();
		System.out.println("Order Number to be Delete : "+S1);
		dr.findElement(By.xpath(x3+rval+x4)).click();	
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[1]")).click();	
	}
	
	public static void test() throws IOException
	{
		System.out.println("************** SALES ORDER SEARCH **************");
		dr.get(Attributes().getProperty("URL"));
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).sendKeys(Str);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[9]/button[1]")).click();
		System.out.println("Wait Start");
		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement V1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]/div/a"));
		Dimension C1 = V1.getSize();
		String Val = Str;
		System.out.println("V1: "+C1);
			if(C1==null)
			{
				System.out.println("Entered Order Number is filtered in the below list");
			}
			else
			{
				System.out.println("Entered Order Number is not filtered in the below list");
			}
	}
}
