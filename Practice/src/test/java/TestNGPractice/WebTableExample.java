package TestNGPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample {
	WebDriver driver;
	@BeforeClass
	public void OpenBroswer() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		driver.manage().window().maximize();
		System.out.println("Browser Opened Successfully");
	}
	@Test(priority=1,description="This gives tables Header details")
	public void Headers() {
		List<WebElement> header=driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/thead/tr/th"));
		System.out.println("Number of headers " + header.size());
		for(WebElement h:header) {
			
			System.out.println("Header name:" + h.getText());
		}
		
	}
	
	@Test(priority=2,description="Count number of rows and columns")
	public void NumberOfRowsAndColumns() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr"));
		System.out.println("Number of Rows are: " + rows.size());
		List<WebElement> col = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[1]/td"));
		System.out.println("Number of Columns are: " + col.size());
	}
	
	@Test(priority=3,description="based on value find column")
	public void ColumnValue() {
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr/td"));
		for(int i=1;i<=row.size();i++) {
			//WebElement ele = driver.findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr["+i+"]));
		}
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
}
