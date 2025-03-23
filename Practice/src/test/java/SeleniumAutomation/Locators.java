package SeleniumAutomation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement id =driver.findElement(By.id("user-name"));
		System.out.println("Using Id Locator: " + id);
		
		WebElement name =driver.findElement(By.name("user-name"));
		System.out.println("Using name Locator: " + name);
		
		List<WebElement> ClassName = driver.findElements(By.className("login_credentials_wrap"));
		System.out.println("Using ClassName Locator: " + ClassName +"\n" + "size " + ClassName.size());
		
	
		List<WebElement> tagname = driver.findElements(By.tagName("input"));
		System.out.println("Using TagName Locator: " + tagname +"\n" + "size " + tagname.size());
	//	driver.close();
		
			
}

}

