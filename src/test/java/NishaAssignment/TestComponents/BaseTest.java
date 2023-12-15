package NishaAssignment.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import NishaAssignment.PageObjects.LandingPage;

public class BaseTest {
	
protected WebDriver driver;
public LandingPage landingPage;

public WebDriver  InitalizeWebDriver() throws IOException
{
	
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//NishaLearning//Resources//GlobalData.Properties");
prop.load(fis);
String browserName = prop.getProperty("browser");
if(browserName.equalsIgnoreCase("Chrome"))
{
	 driver = new ChromeDriver();
}
else if (browserName.equalsIgnoreCase("Firefox"))
{
	driver = new FirefoxDriver();
}
//LandingPage landingPage = new LandingPage(driver);	
//landingPage.goTo();
driver.manage().window().maximize();
return driver;
}

@BeforeMethod
public LandingPage launchApplication() throws IOException 
{
	WebDriver driver = InitalizeWebDriver();
	landingPage = new LandingPage(driver);
	landingPage.goTo();
	driver.manage().window().maximize();
	return landingPage;
	
}
public List<HashMap<String, String>> readJsonData(String filePath) throws Throwable
{
String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	ObjectMapper objectMapper = new ObjectMapper();
	List<HashMap<String,String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	
}
			


}



	


