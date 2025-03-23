package SeleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
	}
	public static void Login() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select")));
	    Select dd = new Select(dropDown);
	    dd.selectByIndex(5);
	    String selectedValue = dd.getFirstSelectedOption().getText();
        System.out.println("Selected Dropdown Value: " + selectedValue);
	}


	public static void main(String[] args) {

		OpenBrowswer();
		Login();		
	}

}
