package NishaAssignment.AbstractComponents;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear(By cookies)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) cookies));
	}
	public void waitForElementToDisppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public static void switchToWindowByTitle(WebDriver driver, String windowTitle)
	{
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(windowTitle)) {
                
                break;
            }
        }
    }

}
