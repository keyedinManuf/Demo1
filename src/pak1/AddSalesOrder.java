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

	public static void main(String[] args) throws IOException 
	{
		dr.manage().window().maximize();
		Login1();
		NewSalesOrder();
		Businessunit();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
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
		//List<WebElement> LW1 = dr.findElements(By.id("select2-results-2"));
		List<WebElement> LW1 = dr.findElements(By.xpath("/html/body/div[5]/ul/li"));
		
		String S1 = "/html/body/div[5]/ul/li[";
		String S2 = "]";
		Random ran = new Random();
		int i = ran.nextInt(LW1.size());
		System.out.println("Client Main Value : "+i);
		if(i==0)
		{
			System.out.println("If : "+i);
			int j = 6;
			Random ran1 = new Random();
			int j1 = ran.nextInt(j);
			i =i+j;
			System.out.println("Client If Modified : "+i);
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
		//List<WebElement> LW2 = dr.findElements(By.id("select2-results-4"));
		List<WebElement> LW2 = dr.findElements(By.xpath("/html/body/div[6]/ul/li"));
		String S3 = "/html/body/div[6]/ul/li[";
		String S4 = "]";
		Random ran2 = new Random();
		int i1 = ran.nextInt(LW1.size());
		System.out.println("SO Status Main Value : "+i1);
		if(i1==0)
		{
			System.out.println("If : "+i1);
			int j = 1;
			Random ran3 = new Random();
			int j1 = ran.nextInt(j);
			i1 =i1+j;
			System.out.println("SO Status If Modified : "+i1);
			dr.findElement(By.xpath(S3+1+S4)).click();
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			dr.findElement(By.xpath(S3+1+S4)).sendKeys(Keys.TAB);
		}
		
		else
		{
			System.out.println("SO Status Else : "+i1);
			dr.findElement(By.xpath(S3+i1+S4)).click();
		}	
		
		System.out.println("Success");    	    
		}catch (NoSuchElementException e){System.out.println(e);}
	}
	
	public static void Businessunit()
	{
		try
		{
			System.out.println("BusinessUnit Selection");
			dr.findElement(By.id("select2-chosen-6")).click();
			dr.findElement(By.id("s2id_autogen6_search")).sendKeys("Test");
			System.out.println("Start WAIT");
			//dr.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(dr, 40);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("select2-results-6")));
			
			System.out.println("STOP WAIT");
			dr.findElement(By.id("s2id_autogen6_search")).sendKeys(Keys.TAB);
			
			
		}catch(IllegalArgumentException e){System.out.println(e);}
	}
}
