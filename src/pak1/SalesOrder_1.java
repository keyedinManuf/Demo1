package pak1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesOrder_1 extends KeyedID_Login
{
	public static String Str1 = "Sales Order";
	public static void main (String[] args) throws IOException
	{
		Login1();
		MenuList("Test");
		MenuList(); 
		Pagination1();
		Pagination2();
		//Sortorder();
	}

	public static String MenuList(String Menu) throws IOException
	{		
		try{
		WebElement WB1 = dr.findElement(By.xpath(Attributes().getProperty("L1")));
		
		List<WebElement> L1 = WB1.findElements(By.tagName("a"));
		for(WebElement W1 : L1)
		{
			if(W1.getText().length()!=0)
			{
				if(W1.getText().contains(Str1))
				{
					System.out.println("******************** Scenario 1 ***********************");
					System.out.println("Sales Order Menu is displayed in the Menu list");
					Menu = WB1.getText();								
				}
			}			
		}		
		}catch (NoSuchElementException e){System.out.println("Invalid Element: "+e);}
		return Menu;
	}
	
	public static void MenuList() throws IOException
	{
		dr.findElement(By.xpath(Attributes().getProperty("SO"))).click();
		List<WebElement> LWB1 = dr.findElements(By.xpath(Attributes().getProperty("LWB1")));
														  
		for(WebElement L1 : LWB1)
		{
			System.out.println("******************** Scenario 1b ***********************");
			System.out.println("Menus Under Sales Order");
			System.out.println("-----------------------------------");
			System.out.println(L1.getText());
		}
	
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/73");
		List<WebElement> LWB2 = dr.findElements(By.xpath(Attributes().getProperty("LWB1")));
		
		for(WebElement L1 : LWB2)
		{
			System.out.println("******************** Scenario 1c ***********************");
			System.out.println("Menus Under Sales Order Deliveries");
			System.out.println("-----------------------------------");
			System.out.println(L1.getText());
		}
	}
	
	public static void Pagination1() throws IOException
	{
		dr.get(Attributes().getProperty("URL"));
		int rowCount=dr.findElements(By.xpath(Attributes().getProperty("Pagination1"))).size();
		if(rowCount==50)
		{
			System.out.println("******************** Scenario 2b ***********************");
			System.out.println("Pagination of records for each page in Sales Order Listing screen are: "+rowCount);
		}
		else
		{
			System.out.println("Pagination of records are changed from 50 and the current count is : "+rowCount);
		}
	}
	
	public static void Pagination2() throws IOException
	{
		dr.findElement(By.xpath(Attributes().getProperty("MassPrint"))).click();
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/label/em"), "Sales Order Listing"));
		int rowCount=dr.findElements(By.xpath(Attributes().getProperty("Pagination2"))).size();
		if(rowCount==50)
		{
			System.out.println("******************** Scenario 4a ***********************");
			System.out.println("Pagination of records for each page in Mass Print Sales Order Acknowledgments screen are: "+rowCount);
		}
		
		else
		{
			System.out.println("Pagination of records are changed from 50 and the current count is : "+rowCount);
		}
	}
	
	public static void Sortorder() throws IOException
	{
		try{
		dr.get(Attributes().getProperty("URL"));
		List<WebElement> LWB3 = dr.findElements(By.tagName("th"));
		int Len = LWB3.size();
		System.out.println("Size: "+ Len);
		
		List<WebElement> LWB4 = dr.findElements(By.tagName("td"));
		for(WebElement L2 : LWB4)
		{
			if(L2.getText().contains("Sales Order Date"))
			{
				String M1 = L2.getText();   
				List<String> ml = new ArrayList<String>();
				ml.add(M1);
				System.out.println("Values Values Values: "+M1);
			}
		}	
		}catch(StaleElementReferenceException e){System.out.println(e);}
		 System.out.println("rest of the code...");  
	}
}