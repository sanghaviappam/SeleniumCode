package SeleniumAutomation;
import java.util.List;
import java.util.NoSuchElementException;
//import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorPractise {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	
	public static void OpenBrowswer() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	}
	public static void TextField() {
			driver.findElement(By.cssSelector("#name")).sendKeys("Jungkook jeon");
			driver.findElement(By.cssSelector("#email")).sendKeys("jk01@gmail.com");
		
	}
	public static void RadioSelection() {
			WebElement radio = driver.findElement(By.cssSelector("#gender"));
			if(radio.isDisplayed() && radio.isEnabled()) {
				if(radio.isSelected() == false) {
			}
				radio.click();
				if(radio.isSelected()==true) {
					System.out.println("Radio Button Selected");
				}else {
					System.out.println("Radio Button not Selected");
				}
			}
			else {
				System.out.println("Radio button is not avail");
			}
		}
	public static void MobileNumberValidation() {
			WebElement mob = driver.findElement(By.cssSelector("#mobile"));
			mob.sendKeys("9876543210");
			String mobval = mob.getAttribute("value");
			if(mobval.matches("\\d{10}")) {
				System.out.println("You are entered Correct mobile range");
			}
			else {
				System.out.println("You are not entered Correct mobile range");
			}
		}
	public static void OtherField() {
			driver.findElement(By.cssSelector("#dob")).sendKeys("01-09-1997");
			driver.findElement(By.cssSelector("#subjects")).sendKeys("Singing");
	}
	public static void CheckBox() {
		 String textValue=null;
		WebElement checkbox=null;
		WebElement label=null;
//			WebElement hobbie1 = driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input"));
//			if(hobbie1.isDisplayed() && hobbie1.isEnabled()) {
//				if(hobbie1.isSelected()==false) {
//					hobbie1.click();
//					if(hobbie1.isSelected()==true) {
//						System.out.println("Checkbox 1 Selected");
//					}
//					else {
//						System.out.println("Checkbox 1 Not Selected");
//					}
//				}
//				else {
//					System.out.println("Wrong Checkbox");
//				}
//			}
		List<WebElement> HobbieListsdriver = driver.findElements(By.xpath("//label[@for='hobbies']/following::div[1]/div/div/input"));
		System.out.println("Checkbox list : " + HobbieListsdriver.size());
		
		for(int i=0;i<HobbieListsdriver.size();i++)
			{
			checkbox = HobbieListsdriver.get(i);
			label = checkbox.findElement(By.xpath(".//following-sibling::label"));
			textValue = label.getText();
		
			if(textValue.equalsIgnoreCase("Sports")) {
				if (!checkbox.isSelected()) {  
	                checkbox.click();  
	                System.out.println("Sports checkbox selected.");  
	            } else {
	                System.out.println("Sports checkbox already selected.");  
	            }
			}
			if(textValue.equalsIgnoreCase("Music")) {
				if (!checkbox.isSelected()) {  
	                checkbox.click();  
	                System.out.println("Music checkbox selected.");  
	            } else {
	                System.out.println("Music checkbox already selected.");  
	            	}
				}
			}
		}
	public static void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); 

	}
	public static void DropDown() throws InterruptedException {
		WebElement state = driver.findElement(By.cssSelector("#state"));
		Thread.sleep(1000);
		//state.click();
		Select selectState = new Select(state);
		selectState.selectByIndex(3);
		
		
		WebElement city = driver.findElement(By.cssSelector("#city"));
		Thread.sleep(1000);

		Select selectCity = new Select(city);
		selectCity.selectByValue("Agra");
		
		WebElement CitySelected = selectCity.getFirstSelectedOption();
		System.out.println("Selected City Name: "+ CitySelected.getText());
		
		List<WebElement> AllStateList = selectState.getOptions();
		int totalStateCount = AllStateList.size();
		System.out.println("*******State Tot	al List:**************");
		for(int i=0;i<totalStateCount;i++) {
			WebElement listState = AllStateList.get(i);
			System.out.println(listState.getText());
		}
		List<WebElement> AllCityList = selectCity.getOptions();
		int total= AllCityList.size();
		System.out.println("*******City Total List:**************");
		for(int i=0;i<total;i++) {
			WebElement listCity = AllCityList.get(i);
			System.out.println(listCity.getText());
		
		}
		
	}
	public static void FileUpload() {
		actions = new Actions(driver);
		WebElement fileLocate = driver.findElement(By.xpath("//input[@id='picture']"));
		//actions.moveToElement(fileLocate).perform();
		fileLocate.sendKeys("C:\\Users\\HP\\Downloads\\id.jpg");
		String UploadedFilePath = fileLocate.getAttribute("value");
		String originalStr = "id.jpg";
		if(UploadedFilePath.contains(originalStr)) {
			System.out.println("File Uploaded");
		}else {
			System.out.println("File Not Uploaded");
		}
		
		
	}
	
	public static void CloseBroswer() {
		driver.quit();
	} 
	public static void main(String[] args)throws InterruptedException {
				OpenBrowswer();
				TextField();
				RadioSelection();
				MobileNumberValidation();
				OtherField();
				CheckBox();
				ScrollDown();
				DropDown();
				FileUpload() ;
				//CloseBroswer();
	}

}
