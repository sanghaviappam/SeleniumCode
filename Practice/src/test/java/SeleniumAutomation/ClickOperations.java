package SeleniumAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOperations {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
	}
	public static void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 3500);"); 

	}
	public static void Operations() {
		actions = new Actions(driver);
		WebElement doubleclick =driver.findElement(By.cssSelector("#doubleClickBtn"));
		actions.doubleClick(doubleclick).perform();
		System.out.println("Done Double Click");
	}
	public static void AlertOperation() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert Text : " + text);
		alert.accept();
		
	}
	public static void RightclickOp() {
		actions = new Actions(driver);
		WebElement rightclick = driver.findElement(By.cssSelector("#rightClickBtn"));
		actions.contextClick(rightclick).perform();
		System.out.println("Done Right Click");
	}

	public static void main(String[] args) {
			OpenBrowswer();
			ScrollDown();
			Operations();
			AlertOperation();
			RightclickOp();

	}

}
