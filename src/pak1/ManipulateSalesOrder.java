package pak1;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ManipulateSalesOrder extends KeyedID_Login 
{
	public static void main(String[] args) throws IOException 
	{
		Login1();
		EditSO();
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
		
		//Customer Selection
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
		dr.findElement(By.xpath(x5+Drop1+x6)).click();	
				
		//Save
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
		
		//Updated Message
		WebElement WB1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/label"));
		String OrderNum = WB1.getText();
		System.out.println(OrderNum+" is updated successfully");
	}
}