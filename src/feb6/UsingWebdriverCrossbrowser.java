package feb6;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsingWebdriverCrossbrowser {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com/";
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String brw)throws Throwable
	{
		if(brw.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		else if(brw.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "E://geckodriver.exe");
		driver=new FirefoxDriver();	
		driver.get(url);	
		}
	}
	@Test
	public void login() throws Throwable
	{
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().contains("dash"))
		{
			System.out.println("Login Success");
		}
		else

		{
			System.out.println("Login Fail");
		}
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}


















