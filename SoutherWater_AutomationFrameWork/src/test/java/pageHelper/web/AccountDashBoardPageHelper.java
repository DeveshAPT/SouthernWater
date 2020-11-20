package pageHelper.web;
import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import core.apiHelper;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class AccountDashBoardPageHelper 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public String enteredName,  enteredCustomerNumber, enteredEmailID,newEmail, firstSecurityQuest;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
	
		public AccountDashBoardPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
		}
		
		public AccountDashBoardPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		}	
		
		 @Given("^I am accessing Login Page of SouthernWater Portal$")
		 public void AccessingSouthernLoginPage() throws Exception
		 {
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			//webDriver.VerifyTitle("My account");
		 }
		 
		 @When("^I Enter my Login credentials ([^\"]*) and ([^\"]*)$") 
		 public void LoginWithSouthernAccessCredentials(String email, String password ) throws InterruptedException, IOException, DocumentException
		 {
			Thread.sleep(5000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);
		 }
		 
		 @And("^Click on Login Button on Portal$")
		 public void ClickOnSouthernWaterLoginButton() throws InterruptedException, DocumentException, Exception
		 {
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();	
		 }
		 
		 @Then("^I should Login into Portal$")
		 public void IshouldLogin() throws DocumentException, InterruptedException
		 {
			 Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/LoginButton")), "Not able to Login");
		 }
		 
		 @And("^I Should See Logout Button$")
		 public void IshouldSeeLogout() throws DocumentException, InterruptedException
		 {
			 Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/LogOut")), "Logout Button not Present on Dashboard");
			
		 }
		 
		 @And("^I Should See Make Payment Button$")
		 public void IShouldSeeMakePayment() throws DocumentException, InterruptedException
		 {
			 Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/LoginMakeaPayment")), "Make Payment Button not Present on Dashboard");
		 }
		 
		 @And("^I Should See Submit Meter Reading Button$")
		 public void IShouldSeeSubmitMeterReading() throws DocumentException, InterruptedException
		 {
			 Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/SubmitMeterReading")), "Submit Meter Reading Button not Present on Dashboard");
		 }
		 
		 @And("^I Should See Close your Account Button$")
		 public void IShouldSeeCloseAccountButton() throws DocumentException, InterruptedException
		 {
			 Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/CloseAccount")), "Close Your Account Button not Present on Dashboard");
		 }
		    
		  
	
}
