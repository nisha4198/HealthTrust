package NishaAssignment.Tests;

import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NishaAssignment.PageObjects.CarrierPage;
import NishaAssignment.PageObjects.LandingPage;
import NishaAssignment.PageObjects.JobPage;
import NishaAssignment.TestComponents.BaseTest;

public class jobSearch extends BaseTest {

	
@Test
	public void JobSearchById() throws InterruptedException
	{
		LandingPage lp = new LandingPage(driver);
		CarrierPage cp = new CarrierPage(driver);
		JobPage jp = new JobPage(driver);	
		lp.acceptCookies();	
		lp.goToCareers();
		lp.searchOppurtunity();
		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}
		cp.enterJobSearchDetails();
		cp.searchJob();
		jp.categoryFilter();
		jp.selectDirectorManager();
	WebElement Jobid =	jp.FindJobByid("1634725");
	Assert.assertTrue(Jobid.isDisplayed(),
	"Position ID  not found. Test case failed.");
			
	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
	     List<HashMap<String,String>> data =readJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\NishaAssignment\\Data\\data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	

}
