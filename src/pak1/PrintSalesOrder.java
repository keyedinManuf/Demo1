package pak1;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrintSalesOrder extends KeyedID_Login{

	public static void main(String[] args) throws IOException 
	{
		Login1();
		ReportSOListing();
		/*SODListing();
		SODAck();*/
	}
	
	public static void ReportSOListing() throws IOException
	{
		//Active Sales Order Report
		dr.get(Attributes().getProperty("URL"));
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[4]/div[1]/a[3]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset/div/div/div/div/div/div/div/div[2]/div/div[1]/div/input")).sendKeys("10/26/2015");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[3]")).click();
		//dr.navigate().back();
	}

	public static void ReportSOAckListing() throws IOException
	{
		//Active Sales Order Acknowledge Report
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[5]/div[1]/a[3]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset/div/div/div/div/div/div/div/div[2]/div/div[1]/span/div/ul/li/input")).click();
	
		WebElement WD1 = dr.findElement(By.xpath("/html/body/div[5]"));
		List<WebElement> LWD1 = WD1.findElements(By.xpath("/html/body/div[5]/ul/li"));
		Random rand = new Random();		
	}
	
	public static void SODListing() throws IOException
	{
		dr.get(Attributes().getProperty("URL"));
		//dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		
		dr.findElement(By.xpath(".//*[@id='select2-chosen-2']")).click();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> options = dr.findElements(By.xpath("html/body/div[5]/ul/li[1]/div"));
		Iterator i = options.iterator();
		 while(i.hasNext()){
			 WebElement row= (WebElement) i.next();
			 System.out.println("Randomly selected value is :"+row.getText());
			 row.click();
		}
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/div/a")).click();
		System.out.println("Sales order delivery listing done Succesfully");
	}
	
	public static void SODAck() throws IOException
	{
		dr.get(Attributes().getProperty("URL"));
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		dr.findElement(By.xpath(".//div[@data-label='Sales Order Acknowledgement - Sales Order Deliveries']")).click();
		dr.findElement(By.xpath(".//*[@id='s2id_autogen2']")).click();
		dr.findElement(By.xpath(".//*[@id='s2id_autogen2']")).sendKeys("1005");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[5]/ul/li[1]/div")).click();
		dr.findElement(By.xpath(".//*[@id='s2id_autogen2']")).click();
		dr.findElement(By.xpath(".//*[@id='s2id_autogen2']")).sendKeys("1008");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[5]/ul/li/div/span")).click();
		dr.findElement(By.xpath(".//*[@id='MainWrapper']/div/form/div[3]/div/button[1]")).click();
		System.out.println("Sales order Acknowledgement done successfully");
	}
}
