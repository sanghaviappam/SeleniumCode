package SeleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://letcode.in/draggable");
	}
	public static void dragOperation() {
		actions = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement DragEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sample-box")));
		actions.clickAndHold(DragEle).moveByOffset(20, 30).release().build().perform();

		
		
	}
	public static void main(String[] args) {
		OpenBrowswer();
		dragOperation();
	}

}
