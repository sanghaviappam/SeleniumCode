package TestNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBroswer {
	WebDriver driver;
	
	@Test
	public void BrowsersSetUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.google.com");
	}
	
	
	@Test
	public void EdgeBroswer() {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
	        driver.get("https://www.google.com");
			
		}
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
	}


