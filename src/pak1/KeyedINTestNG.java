package pak1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class KeyedINTestNG 
{
  public static WebDriver dr = new FirefoxDriver();
  @Test
  public void f() 
  {
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  dr.get("http://kimdev01.keyedinuat.com/Dev03/User/SignIn");
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }

  @AfterTest
  public void afterTest()
  {
	  dr.quit();
  }

}
