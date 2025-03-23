package SeleniumAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LunchBroswer {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	public static void Login() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        user.sendKeys("Admin");

        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        pass.sendKeys("admin123");
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        System.out.println("Login Successful");
        
        String title = driver.getTitle();
        
        System.out.println("Page Title: " + title);
		
	}
	public static void logout() {

        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        logout.click();
        WebElement out = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")));
        out.click();
        System.out.println("Logout Successful");
	}
	
	public static void CloseBrowser() {
		driver.quit();
		System.out.println("Browser Closed");
		
	}
	public static void main(String[] args) throws InterruptedException {
		OpenBrowswer();
		 Login();
		 logout(); 
		 CloseBrowser();
	}

}
