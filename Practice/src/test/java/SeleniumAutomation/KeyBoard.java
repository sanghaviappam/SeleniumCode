package SeleniumAutomation;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoard {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.google.com");
	}
	public static void KeyOperations() throws InterruptedException {
		WebElement Search = driver.findElement(By.name("q"));
		Actions act = new Actions(driver);
		act.keyDown(Search, Keys.SHIFT).sendKeys("selenium").build().perform();
		
		Action action = act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
		action.perform();
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		action.perform();
		Action action1 = act.keyDown(Search,Keys.END).build();
		action1.perform();
		
		
		
	}
	public static void main(String[] args) throws InterruptedException{
		OpenBrowswer();
		KeyOperations();
	}

}
