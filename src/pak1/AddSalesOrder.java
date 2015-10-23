package pak1;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSalesOrder extends KeyedID_Login{

	public static void main(String[] args) throws IOException 
	{
		Login1();
		NewSalesOrder();
	}
	
	public static void NewSalesOrder() throws IOException
	{
		try{

		dr.get("http://kimdev01.keyedinuat.com/Dev03/Form/Create/70");
		
		WebDriverWait wait = new WebDriverWait(dr, 20);
		WebElement WW1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/label"));
		wait.until(ExpectedConditions.textToBePresentInElement(WW1, "Customer"));
		
		dr.findElement(By.id("select2-chosen-2")).click();
		dr.findElement(By.id("s2id_autogen2_search")).sendKeys("Test");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> LW1 = dr.findElements(By.id("select2-results-2"));
		
		String S1 = "/html/body/div[5]/ul/li[";
		String S2 = "]";
		/*Random ran = new Random();
		int i = ran.nextInt(LW1.size());*/
		dr.findElement(By.xpath(S1+2+S2)).click();
				
		System.out.println("Success");    	    
		}catch (NoSuchFrameException e){System.out.println(e);}
	}
}
