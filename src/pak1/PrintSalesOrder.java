package pak1;

import java.io.IOException;
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
}
