package feb8;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
public class OrangeHRM {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	 @BeforeTest
	  public void setUp() {
		 report=new ExtentReports("./Reports/dataprovider.html");
	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	driver=new ChromeDriver();
	  }
  @Test(dataProvider = "datasupply")
  public void VerifyLogin(String username,String password) throws Throwable
  {
	  test=report.startTest("DataProvider");
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("txtUsername")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	Thread.sleep(4000);
	if(driver.getCurrentUrl().contains("dash"))
	{
		Reporter.log("Login Success",true);
		test.log(LogStatus.PASS, "Login Success");
	}
	else
	{
		Reporter.log("Login Fail",true);
		test.log(LogStatus.FAIL, "Login FAil");	
	}
  }
  @DataProvider
  public Object[][] datasupply() {
   Object [][] login=new Object[5][2];
   login[0][0]="Admin";
   login[0][1]="Qedge123!@#";
   
   login[1][0]="Admin";
   login[1][1]="test";
   
   login[2][0]="Admin";
   login[2][1]="test";
   
   login[3][0]="Admin";
   login[3][1]="Qedge123!@#";
   
   login[4][0]="Admin";
   login[4][1]="Qedge123!@#";
   return login;
  }
 
  @AfterTest
  public void tearDown() 
  {
	  report.endTest(test);
	  report.flush();
	  driver.close();
  }

}
















