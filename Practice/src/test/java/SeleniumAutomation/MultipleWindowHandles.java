package SeleniumAutomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandles {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	static String ParentWindow;
	static Set<String> windowHandles;
	static List<String> windowList;
	
	
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
	}
	public static void NewWindow() {
		ParentWindow = driver.getWindowHandle();
		WebElement newwindowButton = driver.findElement(By.xpath("//button[text()='New Window']"));
		newwindowButton.click();
		
		windowHandles = driver.getWindowHandles();
		windowList = new ArrayList<>(windowHandles);
		
		for(int i=0;i<windowList.size();i++) {
			String window = windowList.get(i);
			if(!window.equals(ParentWindow)) {
				driver.switchTo().window(window);
				System.out.println("Switched to new window: " + driver.getTitle());
				WebElement text = driver.findElement(By.xpath("//main/div[@class='container']"));
				String WebText = text.getText();
				String SampleText = WebText.replace("New Window", "").trim();
				System.out.println(SampleText);
				driver.close();
			}
		}
		driver.switchTo().window(ParentWindow);
		driver.quit();
	}
	public static void NewTab() throws InterruptedException {
	   
	    WebElement NewTabButton = driver.findElement(By.xpath("//button[text()='New Tab']"));
	    NewTabButton.click();

	    ParentWindow = driver.getWindowHandle();

	    Thread.sleep(2000);  
	    
	    windowHandles = driver.getWindowHandles();
	    windowList = new ArrayList<>(windowHandles);

	    for(int i=0;i<windowList.size();i++) {
			String window = windowList.get(i);
			if(!window.equals(ParentWindow)) {
	            driver.switchTo().window(window);
	            System.out.println("Switched to New Tab: " + driver.getTitle());
	            driver.close();  
	            break;
	        }
	    }
	    driver.switchTo().window(ParentWindow);
	    System.out.println("Switched back to Parent Window: " + driver.getTitle());
	    driver.quit();
	}

	public static void main(String[] args)throws InterruptedException {
		OpenBrowswer();
		//NewWindow();
		NewTab();

	}

}
