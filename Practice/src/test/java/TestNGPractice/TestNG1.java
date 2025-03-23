package TestNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG1 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest(description="This method will SetUp broswer")
	public void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        System.out.println("Launch Broswers");
	}
	@Test(priority=1,description="This method will get Title of page")
	public void GetTitle() {
		System.out.println("Page Title Name: " + driver.getTitle());
		Assert.fail("Login Failed!");
	}
	@Test(priority=-1,description="This method will get Current Url",invocationCount=2)
	public void GetURL() {
		System.out.println("Page URL: " + driver.getCurrentUrl());
	}
	
	@Test(priority=2,description="This method will Login to Website", dependsOnMethods= {"GetTitle","GetURL"}, alwaysRun=true)
	public void Login() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		username.sendKeys("Admin");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		password.sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
//	@AfterTest(description="This Method will Close Broswer")
//	public void CloseBrowser() {
//		driver.quit();
//	}
}
