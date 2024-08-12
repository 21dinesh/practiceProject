package Generic;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameter;

import POM.CraeteWithNameOrg;
import POM.Login_Logout;

public class BaseClass {
	protected ExcelUtility efile=new ExcelUtility();
	protected CraeteWithNameOrg org;
	
	public Login_Logout log;
	public WebDriver driver;
	FileUtiity file=new FileUtiity();
	WebDriverUtility web=new WebDriverUtility();
	@BeforeSuite
	public void databaseconnection() {
		System.out.println("data Base Connection");
	}
	@BeforeTest
	public void paralell() {
		System.out.println("Execution ||  ");
	}
	@BeforeClass
	public void nevigateandlaunch() throws IOException {
		String browser=file.getdatafromeproperty("browser");
		String url=file.getdatafromeproperty("url");
		
		long time=Long.parseLong(file.getdatafromeproperty("time"))  ;
		WebDriver rdriver=web.launch(driver, url, time, browser);
		driver=rdriver;
	}
	@BeforeMethod
	public void login() throws IOException {
		log=new Login_Logout(driver);
		String username=file.getdatafromeproperty("username");
		String password=file.getdatafromeproperty("password");
		log.getUser().sendKeys(username);
		log.getPass().sendKeys(password,Keys.ENTER);
		org=new CraeteWithNameOrg(driver);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(4000);
		web.moveToElement(driver, log.getMouselogout());
		log.getLogout().click();
		
		
	}
	@AfterClass
	public void closebrowser() {
		
	}
	@AfterSuite
	public void closedb() {
		
	}
	
	
}
