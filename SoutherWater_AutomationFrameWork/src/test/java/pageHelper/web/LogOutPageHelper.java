package pageHelper.web;
import java.util.List;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.xmlreader;

public class LogOutPageHelper 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	String EmailID=null;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	xmlreader regiLoct=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	PropertyReader prpertyreader = new PropertyReader();
	
	public LogOutPageHelper(WebDriver driver)  
	{
		webDriver=new baseDriverHelper(driver);
		System.out.println("First Constructor");
	}
	
	public LogOutPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		
		
	}
	@Given("^I have Logged in ([^\"]*) and([^\"]*) into SothernWater$")
	public void I_have_LoggedIn(String email,String password ) throws Exception
	{
		Thread.sleep(5000);
		//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		webDriver.WaitforPageToBeReady();
		webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
		webDriver.WaitforPageToBeReady();
		Thread.sleep(10000);
		webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
		webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);
		
		webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
		webDriver.WaitforPageToBeReady();	
		Thread.sleep(5000);
	}
	
	@When("^I click on Logout$")
	public void ClickOnLogOut() throws Exception
	{
		webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LogOut")));
		webDriver.WaitforPageToBeReady();
		Thread.sleep(5000);
	}
	
	@And("^I Should logout$")
	public void VerifyLogoutMessage() throws Exception
	{	
		webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/LogoutComplete")), "You have been logged out successfully");
		webDriver.WaitforPageToBeReady();	
	}
	
}