package feb5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GmailLogin1 {
WebDriver driver;
@Test
public void login() 
{
System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
driver=new ChromeDriver();
driver.get("https://gmail.com");
driver.manage().window().maximize();
WebDriverWait wait=new WebDriverWait(driver, 400);
//wait until username textbox is visible
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
driver.findElement(By.name("identifier")).sendKeys("pranga2010");
//wait until button is clickable
wait.until(ExpectedConditions.elementToBeClickable(By.className("CwaK9")));
driver.findElement(By.className("CwaK9")).click();
//wait until password textbox is visible
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
driver.findElement(By.name("password")).sendKeys("test123456");
}
}














