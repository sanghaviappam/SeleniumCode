package SeleniumAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowserTest {
	static WebDriver driver;
	public static void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		System.out.println("Title of Page is : " + driver.getTitle());
		takingScreenshot("HeadlessSS");
		driver.quit();
	}
	public static void takingScreenshot(String FileName) {
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
	
	}
}
