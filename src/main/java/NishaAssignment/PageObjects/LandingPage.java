package NishaAssignment.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NishaAssignment.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	@FindBy(css=".cky-btn-accept")
	WebElement btn_acceptAllCookies;

	@FindBy(xpath = "//a[@href='https://healthtrustpg.com/careers/']")
	WebElement link_carrierLink;
	
	@FindBy(xpath = "//a[@href='https://careers.hcahealthcare.com/pages/healthtrust']")
	WebElement link_searchOpp;
	
	By cookies = By.cssSelector(".cky-btn-accept");
	By carrier = By.xpath("//a[@href='https://healthtrustpg.com/careers/']");
	By lp_search =  By.xpath("//a[@href='https://careers.hcahealthcare.com/pages/healthtrust']");


	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		driver.get("https://healthtrustpg.com");
	

		
	//	btn_acceptAllCookies.click();
	}
	public void acceptCookies()
	
	{
		waitForElementToAppear(cookies);
			
		btn_acceptAllCookies.click();
	}
	
	public void goToCareers()
	
	{
		waitForElementToAppear(carrier);
		link_carrierLink.click();
		
	}
	
	public void searchOppurtunity()
	{
		waitForElementToAppear(lp_search);
		link_searchOpp.click();
		
	
	}
	
	
	public void switchWindow(WebDriver driver,String WindowTitle)
	{
		switchToWindowByTitle(driver, WindowTitle);
	}

}
