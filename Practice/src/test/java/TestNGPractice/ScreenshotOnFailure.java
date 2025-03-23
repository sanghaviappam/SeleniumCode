package TestNGPractice;
import ru.yandex.qatools.ashot.AShot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import javax.imageio.ImageIO;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOnFailure {

	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
       
        
	}
	@Test(priority=1)
	public void BroswerSetup() {
		WebElement element = driver.findElement(By.id("nonExi"));
        element.click();
	
	}
	
	@AfterMethod()
	public void captureScreenshotOnFailure(ITestResult result) {
		
		if(result.getStatus()==result.FAILURE)
		{
			TakesScreenshot ss = (TakesScreenshot) driver;
			File source = ss.getScreenshotAs(OutputType.FILE);
					
			File Destination = new File(System.getProperty("user.dir") +"\\ScreenShots\\"+result.getName()+".png");
			try {
				FileUtils.copyFile(source, Destination);
			}
			catch(Exception e){
				e.getMessage();
			}
		}
		Qui();
		
	}
	@Test(priority=2)
	public void SpecificEle() throws Exception {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg' and contains(@class, 'gb_F')]")));
		
		 Screenshot  ss = new AShot()
				 .coordsProvider(new WebDriverCoordsProvider())
				 .takeScreenshot(driver, ele);
		File output = new File(System.getProperty("user.dir") +"\\ScreenShots\\File1.png");
		ImageIO.write(ss.getImage(),"PNG",output);
		 System.out.println("SVG Screenshot saved at: " + output.getAbsolutePath());
		
	}
	
	public void Qui() {
		driver.quit();
	}
	
	
}

