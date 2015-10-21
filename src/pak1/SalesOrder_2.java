package pak1;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SalesOrder_2 extends KeyedID_Login {
	
		public static void main (String args[]) throws IOException
		{
			Login1();
			//SearchSalesOrderNumber();
			SearchSalesOrderAccount();
		}
	
		public static void SearchSalesOrderNumber() throws IOException
		{
			try{
				dr.get(Attributes().getProperty("URL"));
				dr.findElement(By.id("Name")).sendKeys(Attributes().getProperty("SONum"));
				dr.findElement(By.xpath(Attributes().getProperty("Search"))).click();
				String Str1 = dr.getPageSource();
				if(Str1.contains(Attributes().getProperty("SONum")))
				{
					System.out.println("Entered Sales Order is displayed in the below list");
				}
				}catch(ArrayIndexOutOfBoundsException e) {System.out.println(e);}
		}
		
		public static void SearchSalesOrderAccount() throws IOException
		{
			//dr.get(Attributes().getProperty("URL"));
			dr.findElement(By.id("select2-chosen-2")).click();
			dr.findElement(By.id("s2id_autogen2_search")).click();
			dr.findElement(By.id("s2id_autogen2_search")).sendKeys(Attributes().getProperty("SOAcc1"));
			List<WebElement> WW1 = dr.findElements(By.id("select2-results-2"));
			System.out.println("Start Random");
			Random rand = new Random();
			WebElement link = WW1.get(rand.nextInt(WW1.size()));
			link.click();
			dr.findElement(By.xpath(Attributes().getProperty("Search"))).click();
		}
}
