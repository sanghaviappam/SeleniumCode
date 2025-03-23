package SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        // Switch to the iframe that contains the drag-and-drop elements
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]")));
    }

    public static void drag() throws InterruptedException {
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        // Wait for elements to be visible
        WebElement drag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras']")));
        WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='trash']")));

        // Perform Drag and Drop
        Actions act = new Actions(driver);
        
        act.dragAndDrop(drag, drop).perform();
        Thread.sleep(1000);
        System.out.println("Drag and Drop action performed successfully!");
        
        WebElement drag1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras 2']")));
        act.dragAndDropBy(drag1, 447, 7).build().perform();
        Thread.sleep(1000);
        System.out.println("Drag and Drop action performed successfully! with offset");
        
        
        WebElement drag2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras 3']")));
        act.clickAndHold(drag2).moveByOffset(447, 7).release().build().perform();
        Thread.sleep(1000);    
        System.out.println("Drag and Drop action performed successfully! with Mouse Action");
        
        WebElement drag3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras 4']")));
        act.clickAndHold(drag3).moveToElement(drop).release().perform();
        Thread.sleep(1000);    
        System.out.println("Drag and Drop action performed successfully! with Mouse MoVeToElemenet Action");
    
    
    
    }

   
    public static void main(String[] args)throws InterruptedException {
        openBrowser();
        drag();
        //driver.quit();
    }
}
