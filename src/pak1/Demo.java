package pak1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

	public static String Str;
	public static void main(String[] args)
	{
		G1();
		G2();
	}
	
	public static void G1()
	{
		WebDriver dr = new FirefoxDriver();
		Str = "TestNG";
	}

	public static void G2()
	{
		System.out.println("Val: "+Str);
	}
}
