package SeleniumAutomation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrokenLink {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
	}
	public static void BrokenOperation() {
		List<WebElement> ListLink = driver.findElements(By.tagName("a"));
		for(WebElement link : ListLink) {
			String url = link.getAttribute("href");
			
			if(url!=null && !url.isEmpty()) {
				verifyLink(url);
			}
			else {
				System.out.println("Invalid or empty URL: " + url);
			}
		}
		}
	public static void verifyLink(String url) {
		try {
		URL link = new URL(url);
		HttpURLConnection httpConnec = (HttpURLConnection) link.openConnection();
		httpConnec.setRequestMethod("HEAD");
		httpConnec.connect();
		int responsecode=httpConnec.getResponseCode();
		if(responsecode>=400) {
			System.out.println(url + " is a **BROKEN LINK** with status: " + responsecode);
		}else {
			System.out.println(url + " is a valid link with status: " + responsecode);
		}
		
	}
		catch(MalformedURLException e ) {
			 System.out.println("Invalid URL: " + url);
		}
		catch(IOException e) {
            System.out.println("Could not connect to: " + url);
        }
	}
	public static void main(String[] args) {
		OpenBrowswer();
		BrokenOperation();

	}

}
