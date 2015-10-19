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
		MenuList("Test");
		MenuList();
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
		List<WebElement> LWB1 = dr.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul"));
		for(WebElement L1 : LWB1)
		{
			System.out.println("*** Menus Under Sales Order***");
			System.out.println(L1.getText());
		}

		List<WebElement> LWB2 = dr.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/ul"));
		for(WebElement L1 : LWB1)
		{
			System.out.println("*** Menus Under Sales Order Deliveries ***");
			System.out.println(L1.getText());
		}
	}
}
