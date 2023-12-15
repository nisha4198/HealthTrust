package NishaAssignment.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NishaAssignment.AbstractComponents.AbstractComponent;

public class CarrierPage extends AbstractComponent {
	
	WebDriver driver;
	public CarrierPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}


	@FindBy(id ="search-form__keyword")
	WebElement txt_Search;
	
	@FindBy(xpath ="//input[@type='submit' and @value='Search']")
	WebElement btn_Submit;
	
	By cp_search = By.id("search-form__keyword");
	By cp_submit = By.xpath("//input[@type='submit' and @value='Search']");
	
	
	public void enterJobSearchDetails() 
	{
		waitForElementToAppear(cp_search);
		txt_Search.sendKeys("Director of Quality Assurance");
		
	}
	public void searchJob()
	{
		waitForElementToAppear(cp_submit);
		btn_Submit.click();
	}

}
