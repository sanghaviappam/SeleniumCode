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

public class ToolTip {
	static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;
   

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/guide/verify-tooltip-in-selenium");
      }
    public static void toolOp() {
    	actions = new Actions(driver);
    	WebElement tooltip1 = driver.findElement(By.xpath("//div[@class='free-trial-btn bstack-mm-li']"));
    	actions.moveToElement(tooltip1).perform();
    	
        WebElement tooltip = driver.findElement(By.xpath("//div[@class='free-trial-btn bstack-mm-li']/descendant::a/span"));
    	System.out.println("TooTip Text: " + tooltip.getText());
    }

	public static void main(String[] args) {
		openBrowser();
		toolOp();

	}

}
