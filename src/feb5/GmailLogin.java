package feb5;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GmailLogin {
WebDriver driver;
@Test
public void login() 
{
System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
driver=new ChromeDriver();
driver.get("https://gmail.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.findElement(By.name("identifier")).sendKeys("pranga2010");
driver.findElement(By.className("CwaK9")).click();
driver.findElement(By.name("password")).sendKeys("test123456");
}
}
