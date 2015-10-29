package pak1;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class KeyedID_AddSalesOrder extends KeyedID_Login
{
	
	public static void main(String[] args) throws IOException
	{
		KeyedID_Login.Login1();
		Test();
	}
	
	public static void Test() throws IOException
	{
		dr.findElement(By.xpath(Attributes().getProperty("SO"))).click();
		dr.findElement(By.xpath(Attributes().getProperty("AddSOrder"))).click();
		//WindowHandle for the Add Sales Order screen
		String Win1 = dr.getWindowHandle();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.xpath(Attributes().getProperty("C1"))).click();
		//Get all available open window handles
		Set<?> s = dr.getWindowHandles();

		Iterator<?> ite = s.iterator();
		while(ite.hasNext())
		            {
		String popupHandle=ite.next().toString();
		if(!popupHandle.contains(Win1))
		{
		dr.switchTo().window(popupHandle);
		}
		}
		dr.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
	}
	
	public static void G4() throws IOException {
		try{
		dr.findElement(By.xpath(Attributes().getProperty("SO"))).click();
		dr.findElement(By.xpath(Attributes().getProperty("AddSOrder"))).click();
		dr.findElement(By.xpath(Attributes().getProperty("C1"))).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElement(By.cssSelector("i.glyphicon.glyphicon-search")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		dr.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();	
		System.out.println("Success");
		}catch(NoSuchElementException e)
		{
			return;
		}
	}
}
