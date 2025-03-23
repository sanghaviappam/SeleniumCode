package SeleniumAutomation;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeDemo {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
	       
	}
	public static void totalframe() throws InterruptedException {
		List<WebElement> listFrame = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames are " + listFrame.size());
	
		for(WebElement frames:listFrame) {
			System.out.println("Values " + frames.getAttribute("height"));
			String val = frames.getAttribute("height");
			String org ="155px";
			if(val.equals(org)){
				WebElement frame1 = driver.findElement(By.xpath("//h2[text()='Iframe 1']/following-sibling::iframe[1]"));
				driver.switchTo().frame(frame1);
				driver.findElement(By.xpath("//a[@class='external-link']")).click();
				System.out.println("switched to Frame 1");
				driver.switchTo().defaultContent();
				break;
				
			}else {
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    WebElement frame2 = driver.findElement(By.xpath("//h2[text()='Iframe 2']/following-sibling::iframe"));
			    js.executeScript("arguments[0].scrollIntoView(true);", frame2);  
			   

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame2));  

			    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='external-link']")));
			    js.executeScript("arguments[0].scrollIntoView(true);", link);  
			   
			    js.executeScript("arguments[0].click();", link);  

			    System.out.println("Switched to Frame 2");

			    driver.switchTo().defaultContent();
			    break;
			}
		}

	}

	public static void FrameOperation1() {
		WebElement frame1 = driver.findElement(By.xpath("//h2[text()='Iframe 1']/following-sibling::iframe[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//a[@class='external-link']")).click();
		
	}
	public static void main(String[] args)throws InterruptedException {
		OpenBrowswer();
		totalframe();
		//FrameOperation1();
	}

}
