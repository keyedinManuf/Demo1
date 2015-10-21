package pak1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SalesOrder_1 extends KeyedID_Login
{
	public static String Str1 = "Sales Order";
	public static void main (String[] args) throws IOException
	{
		Login1();
		/*MenuList("Test");
		MenuList(); 
		Pagination();*/
		Sortorder();
	}

	public static String MenuList(String Menu) throws IOException
	{		
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
		return (Menu);
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
	
	public static void Pagination() throws IOException
	{
		dr.get(Attributes().getProperty("URL"));
		int rowCount=dr.findElements(By.xpath(Attributes().getProperty("Pagination"))).size();
		if(rowCount==50)
		{
			System.out.println("******************** Scenario 2b ***********************");
			System.out.println("For Pagination count of records in each page: "+rowCount);
		}
	}
	
	public static void Sortorder() throws IOException
	{
		dr.manage().window().maximize();
		dr.get(Attributes().getProperty("URL"));
		List<WebElement> LWB3 = dr.findElements(By.tagName("th"));
		int Len = LWB3.size();
		System.out.println("Size: "+ Len);
		String St1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/thead/tr/th[";
		String St2 = "]";
		for(int i=2;i<=Len;i++)
		{
			String Value = dr.findElement(By.xpath(St1+i+St2)).getText();
			System.out.print(Value);
			dr.findElement(By.xpath(St1+i+St2)).click();
			
		}
		
		
		
		/*for(WebElement WE1 : LWB3)
		{
			String Str1 = WE1.getText();
			System.out.println("Sort Order Column: "+Str1);
		}*/
	}
}
