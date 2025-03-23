package TestNGPractice;

import SeleniumAutomation.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert; 

public class RetryAnalyzerExample  {
	 WebDriver driver;
	@BeforeMethod()
	public  void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}
		
	
    
    @Test()
    public void test1() {
        System.out.println("test 1");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Assert.assertTrue(false);
        
    }
    
    @Test
    public void test2() {
        System.out.println("test 2");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Assert.assertTrue(true);
    }
    
    @AfterMethod
    public void Close(ITestResult result) {
    	if(result.FAILURE==result.getStatus())
    	{
    	ScreenShot.takingScreenshot(driver,result.getName());
    	}else {
    		driver.close();
    	}	
    }
}
