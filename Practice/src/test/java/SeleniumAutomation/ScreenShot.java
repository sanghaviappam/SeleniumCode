package SeleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	
	static WebDriver driver;
	public static void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		takingScreenshot(driver,"screenshot11"); //here used driver arg for RetryAnalyzer for screebshot of failed tests
		
	}
	public static void search() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
		takingScreenshot(driver,"screenshot13");
		driver.quit();
	}
	public static void takingScreenshot(WebDriver driver,String FileName) {
		TakesScreenshot  screenshot = (TakesScreenshot) driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		
		File Destination = new File(System.getProperty("user.dir") + "\\ScreenShots\\"+FileName+".png");
		try {
			FileUtils.copyFile(Source, Destination);
		} catch (IOException e) {
			
			e.getMessage();
		}
	}
	public static void main(String[] args) {
		OpenBrowser();
		search();

	}

}
