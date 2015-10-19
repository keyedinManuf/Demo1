package pak1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) {
		
		
	}
	public static void ImplicitWait()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://somedomain/url_that_delays_loading");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("Submit")).click();
	}
	
	public static void ExplicitWait()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://somedomain/url_that_delays_loading");
		driver.findElement(By.id("Submit")).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
	}
}
