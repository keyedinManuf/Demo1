package pak1;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SalesOrder_2 extends KeyedID_Login {
	
		public static void main (String args[]) throws IOException
		{
			Login1();
			SearchSalesOrderNumber();
			SearchSalesOrderAccount();
		}
	
		public static void SearchSalesOrderNumber() throws IOException
		{
			try{
				dr.get(Attributes().getProperty("URL"));
				dr.findElement(By.id("Name")).sendKeys(TestData().getProperty("SONum"));
				
				//Start & End Date
				dr.findElement(By.id("Name")).sendKeys(Keys.TAB + "6/24/2015"+ Keys.TAB + "6/24/2015");
				
				}catch(ArrayIndexOutOfBoundsException e) {System.out.println(e);}
		}
		
		public static void SearchSalesOrderAccount() throws IOException
		{	
			//Account
			dr.findElement(By.id("select2-chosen-2")).click();
			dr.findElement(By.id("s2id_autogen2_search")).click();
			dr.findElement(By.id("s2id_autogen2_search")).sendKeys(TestData().getProperty("SOAcc1"));
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> WW1 = dr.findElements(By.id("select2-results-2"));

			Random rand = new Random(System.currentTimeMillis());
			WebElement link = WW1.get(rand.nextInt(WW1.size()));
			link.click();
			
			//State
			dr.findElement(By.id("Billing_StateProvince")).sendKeys(TestData().getProperty("State"));
			
			//Business Unit
			dr.findElement(By.id("select2-drop-mask")).click();
			dr.findElement(By.id("s2id_autogen4_search")).click();
			dr.findElement(By.id("s2id_autogen4_search")).sendKeys(TestData().getProperty("BUnit"));
			List<WebElement> WW2 = dr.findElements(By.id("select2-results-4"));
			Random rand2 = new Random();
			WebElement link2 = WW2.get(rand2.nextInt(WW2.size()));
			link2.click();
			
			//Business Unit
			dr.findElement(By.id("select2-chosen-6")).click();
			dr.findElement(By.id("s2id_autogen6_search")).click();
			dr.findElement(By.id("s2id_autogen6_search")).sendKeys(TestData().getProperty("Status"));
			List<WebElement> WW3 = dr.findElements(By.id("select2-results-6"));
			Random rand3 = new Random();
			WebElement link3 = WW3.get(rand3.nextInt(WW3.size()));
			link3.click();	
			
			dr.findElement(By.xpath(Attributes().getProperty("Search"))).click();
		}
}
