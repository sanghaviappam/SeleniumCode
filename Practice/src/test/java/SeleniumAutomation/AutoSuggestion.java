package SeleniumAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion {
	static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;
    static String text;
   

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
      }
    public static void AutoSuggestionsOp() {
    	
    	actions = new Actions(driver);
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys("Selenium");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	List<WebElement> AutoSugg = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='erkvQe']/div/ul/li")));
    	for(int i=0;i<AutoSugg.size();i++) 
    	{
    		System.out.println("Auto Info: " + AutoSugg.get(i).getText());
    		text = AutoSugg.get(i).getText();
    		
    		if(text.equals("selenium download")) 
    		{
        	 AutoSugg.get(i).click();
        	break;
        		
        	}
    	}
    }
	public static void main(String[] args) {
		 openBrowser();
		 AutoSuggestionsOp();
		 
	}

}
