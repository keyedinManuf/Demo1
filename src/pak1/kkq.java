package pak1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class kkq extends KeyedID_Login{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Login1();
		dr.get(Attributes().getProperty("URL"));
		try {
			Get1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*WebDriver dr= new FirefoxDriver();
		dr.findElement(By.name("username")).sendKeys("lizc-admin");
		dr.findElement(By.id("password")).sendKeys("password");
		dr.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();
		WebElement b=dr.findElement(By.xpath("/html/body/div[1]/ul[2]/li[2]/div")); 
		*/
		
	}

	public static void Get1() throws InterruptedException
	{
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		WebElement b= dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div"));
		Thread.sleep(50000);
		b.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/a[1]")).click();
		Thread.sleep(5000);
		System.out.println("test");
		dr.switchTo().frame(dr.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/iframe")));
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("window.scrollBy(0,250)", "");
		/*WebElement iFrame= dr.findElement(By.tagName("iframe"));
		iFrame.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table"));*/
		//WebElement c= dr.findElement(By.xpath("/html/body/div[1]/div"));
		System.out.println("test");
		dr.findElement(By.xpath("//td/a")).click();
		System.out.println("test@123");
		WebElement c=dr.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table"));
		List<WebElement> LW1 = dr.findElements(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table/tbody"));
		for(WebElement WW1 : LW1)
		{
			System.out.println("Val: "+WW1.getText());
		}
		
		dr.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
		
/*		for (int i=0;i<LW1.size();i++)
		{
			System.out.println("Val: "+LW1.);
		}*/
		/*WebElement c=dr.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table"));
		System.out.println("test");
		WebElement c1 = dr.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]"));
		System.out.println("test");
		c1.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/a")).click()*/;
				
	}
}
