package feb6;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class DataProvider_readwrite {
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet ws;
	XSSFRow row;
	static WebDriver dr;
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		dr=new ChromeDriver();
	}
	@Test(dataProvider="supplydata")
	public void VerifyLogin(String username,String password)throws Throwable{
		dr.get("http://orangehrm.qedgetech.com/");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		dr.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		dr.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);
		if(dr.getCurrentUrl().contains("dashboard"))
		{
			Reporter.log("Login Success",true);		}
		else
		{
			String msg=dr.findElement(By.xpath("//span[@id='spanMessage']")).getText();
			Reporter.log(msg,true);
		}
		
	}
	@DataProvider
	public Object[][] supplydata() throws Throwable{
		fi=new FileInputStream("E:\\Logindata.xlsx");
		fo=new FileOutputStream("E:\\loginoutputdata.xlsx");
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheetAt(0);
		row=ws.getRow(0);
		int cc=row.getLastCellNum();
		int rc=ws.getLastRowNum();
		Reporter.log("No.of rows are="+rc,true);
		Object login[][]=new Object[rc][2];
		for(int i=1;i<=rc;i++)
		{
			login[i-1][0]=ws.getRow(i).getCell(0).getStringCellValue();
			login[i-1][1]=ws.getRow(i).getCell(1).getStringCellValue();
			if(dr.getCurrentUrl().contains("dashboard"))
			{
				ws.getRow(i).createCell(2).setCellValue("Login Success");
				ws.getRow(i).createCell(3).setCellValue("Pass");
			}
			else
			{
				ws.getRow(i).createCell(2).setCellValue("Login Fail");
				ws.getRow(i).createCell(3).setCellValue("Fail");
			}
			
		}
		wb.write(fo);
		return login;
		
}
	@AfterTest
	public void afterTest() {
		dr.close();
	}
}
















