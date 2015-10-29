package pak1;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSalesOrder extends KeyedID_Login{

	public static String OrderNum;
	public static void main(String[] args) throws IOException 
	{
		
		dr.manage().window().maximize();
		Login1();
		NewSalesOrder();
		Businessunit();
		//Click To Create New Sales Order
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
		Check();
		SearchOrder();
	}
	
	public static void NewSalesOrder() throws IOException
	{
		try{
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Form/Create/70");
		
		WebDriverWait wait = new WebDriverWait(dr, 20);
		WebElement WW1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/label"));
		wait.until(ExpectedConditions.textToBePresentInElement(WW1, "Customer"));
		//Client
		dr.findElement(By.id("select2-chosen-2")).click();
		dr.findElement(By.id("s2id_autogen2_search")).sendKeys("Test");
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> LW1 = dr.findElements(By.xpath("/html/body/div[5]/ul/li"));
		
		String S1 = "/html/body/div[5]/ul/li[";
		String S2 = "]";
		Random ran = new Random();
		int i = ran.nextInt(LW1.size());
		if(i==0)
		{
			int j = 6;
			Random ran1 = new Random();
			int j1 = ran.nextInt(j);
			i =i+j;
			dr.findElement(By.xpath(S1+2+S2)).click();
			dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		else
		{
			System.out.println("Else : "+i);
			dr.findElement(By.xpath(S1+i+S2)).click();
		}
				
		//SO Status
		dr.findElement(By.id("select2-chosen-4")).click();
		dr.findElement(By.id("s2id_autogen4_search")).sendKeys("Test");
		List<WebElement> LW2 = dr.findElements(By.xpath("/html/body/div[6]/ul/li"));
		String S3 = "/html/body/div[6]/ul/li/div/span";
		String S4 = "]/div/span";
		Random ran2 = new Random();
		int i1 = ran.nextInt(LW1.size());
		if(i1==0)
		{
			int j = 1;
			Random ran3 = new Random();
			int j1 = ran.nextInt(j);
			i1 =i1+j;
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			dr.findElement(By.xpath(S3)).sendKeys(Keys.TAB);
		}
    	    
		}catch (NoSuchElementException e){System.out.println(e);}
	}
	
	public static String Businessunit()
	{
		try
		{
			System.out.println("BusinessUnit Selection");
			dr.findElement(By.id("select2-chosen-6")).click();
			dr.findElement(By.id("s2id_autogen6_search")).sendKeys("Test");
			WebDriverWait wait = new WebDriverWait(dr, 35);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("select2-results-6")));
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dr.findElement(By.id("s2id_autogen6_search")).sendKeys(Keys.TAB);
			dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
			System.out.println("New Order is created successfully");
			WebDriverWait wait1 = new WebDriverWait(dr, 20);
			wait1.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/label/em"), "Sales Order"));
			WebElement WW2 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
			OrderNum = WW2.getText();
			System.out.println("Created Order Number is: "+OrderNum);
			
			
		}catch(IllegalArgumentException e){System.out.println(e);}
		return OrderNum;
	}
	
	public static void Check()
	{
		String Str1 = "is required.";
		String Str2 = dr.getPageSource();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(Str2.contains(Str1))
		{
			WebElement WBB1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/div[1]/p/a"));
			System.out.println("Mandatory Field - "+WBB1.getText()+ " is Missing");
		}
		else
		{
			System.out.println("New Order is created successfully");
		}
		dr.close();		
	}
	
	public static void SearchOrder()
	{
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[3]/div[1]/a[3]")).click();
		dr.findElement(By.id("Name")).sendKeys("1190");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[9]/button[1]")).click();
		System.out.println("Entered Order Number is filtered in the below list");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/div/a")).click();
		try {
			Runtime.getRuntime().exec("D:/4_Others/3_Backup/AutoIT/Export.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}