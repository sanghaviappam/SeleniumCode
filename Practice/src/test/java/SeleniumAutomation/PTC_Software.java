package SeleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PTC_Software {
	static WebDriver driver;
	

	public static void openBrowser() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.google.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofHours(100));
	}
	public static void Search() {
		WebElement textSearch = driver.findElement(By.name("q"));
		textSearch.sendKeys("PTC Software");
		Actions action = new Actions(driver);
		textSearch.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'PTC: Global Leader in')]"))).click();
	}
	public static void main(String[] args) {
		openBrowser();
		Search();
		
	}
	
}
