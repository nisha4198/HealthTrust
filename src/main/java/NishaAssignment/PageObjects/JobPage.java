package NishaAssignment.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NishaAssignment.AbstractComponents.AbstractComponent;

public class JobPage extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(xpath ="//a[contains(@class, 'facet-item__heading') and contains(text(), 'Category')]")
	WebElement sel_FilterCategory;
	
	@FindBy(xpath = "//input[@name='a11y-issues' and @value='Directors and Managers']")
	WebElement chk_DirectorManager;
	

	By jp_categoryfilter = By.xpath("//a[contains(@class, 'facet-item__heading') and contains(text(), 'Category')]");
	By jp_selectDirectorManager = By.xpath("//input[@name='a11y-issues' and @value='Directors and Managers']");
	
	public JobPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void categoryFilter()
	{
		waitForElementToAppear(jp_categoryfilter);
		sel_FilterCategory.click();
	}
	
	public void selectDirectorManager()
	{
		waitForElementToAppear(jp_selectDirectorManager);
		chk_DirectorManager.click();
	}
	public WebElement FindJobByid(String i)
	{
		
        String dynamicXPath = "//div[contains(text(), 'Job ID: " + i + "')]";
        return driver.findElement(By.xpath(dynamicXPath));
		
	}
	

}
