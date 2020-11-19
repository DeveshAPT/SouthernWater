package pageHelper.web;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class SubmitMeterReadings 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	Integer meterReadingValue = null;
	core.baseDriverHelper baseDriverHelperFunctions = null;
		public SubmitMeterReadings(WebDriver driver) throws IOException 
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
		}
		
		public SubmitMeterReadings(bddDriver contextSteps) throws Exception 
		{
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		}
		
		@Given("^I am on meter submit reading pages$") 
		public void SouthernWaterSumbitMeterReading() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.OpenURL(prpertyreader.readproperty("MeterReading"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
		}
		
		@When("^I click on Having trouble link$") 
		public void TroubleLinkverification() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/TroubleLink")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Should move to how to find your meter page$") 
		public void VerifyHowtofindYourMeterPageOpen() throws InterruptedException, DocumentException
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/FindMeter")), "How to find your water meter");
			
		}
		
		@Given("^I am on how to find your meter page$") 
		public void VerifySubmitonline() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.OpenURL(prpertyreader.readproperty("MeterReading"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/TroubleLink")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/FindMeter")), "How to find your water meter");
		}
		
		@When("^I click on Submit Meter link") 
		public void ClickSubmitonline() throws Exception
		{
			
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/SubmitOnline")));
			webDriver.WaitforPageToBeReady();
			
		}
		
		@Then("^I Should move to Submit meter reading page") 
		public void VerifySumbitMeterReadingOpen() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			
		}
		
		//Scenario: I Want to Verify customer meter reading details	
		@Given("^I am on submit meter reading page$") 
		public void VerifySubmitMeterReadingPage() throws Exception
		{			
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.OpenURL(prpertyreader.readproperty("CustomerMeterReadingUrl"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/YourDetailHeading")), "Your details");
		}
		
		@When("^I submit all the details of customer") 
		public void ClickOnSubmitButtonAfterSubmitingCustomerDetails() throws Exception
		{
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), "21301653"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), "4505530617"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")), "Updahyll"+Keys.TAB);
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), "test@gmail.com"+Keys.TAB);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Should able to verify all the details of customer") 
		public void VerifySumbitMeterReadingDetailsOfgCustomer() throws Exception
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/CheckYourDetailsHeader")), "Check your details");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel")), "Your meter reading");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyCustomerNumber")), "21301653");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyPaymentReferenceNumber")), "0004505530617");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyLastName")), "Updahyll");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueHyperLink")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReading")), "Last meter reading");
			System.out.println("meterReading started::: ");
			String meterReading =webDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValue")).getText();
			System.out.println("meterReading::: "+meterReading);
			int meterReading3 = Integer.valueOf(meterReading) +100;
			System.out.println("meterReading3::: "+meterReading3);
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),String.valueOf(meterReading3)+Keys.TAB);			
			//scroll screen at the bottom
			WebDriver driver = new ChromeDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");			
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingValue")), String.valueOf(meterReading3));
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/CheckYourDetailsHeader")), "Check your details");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueHyperLink")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");
			// This step is commented intentionally
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmReadingButton")));
		}
		
		// Meter Reading after login - scenario-1
		@Given("^I have logged in with ([^\"]*) and ([^\"]*)$")
		public void LoginInByEnterEmailAndPassword(String email, String password) throws Exception
		{
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyTitle("My account");	
			Thread.sleep(2000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
		}
		
		@When("^I click to submit meter reading$")
		public void ClickSubmitMeterReadingButton() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")));
		}
		
		@Then("^I can view Your meter reading page$")
		public void VerifyYourMeterReadingPage() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/YourMeterReadingPageHeading")), "Your meter reading");
		}
		
		// Meter Reading after login - scenario-2
		@Given("^I am on submit meter reading page with credentials ([^\"]*) and ([^\"]*)$")
		public void LoginByEnterEmailAndPassword(String email, String password) throws Exception
		{
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.VerifyTitle("My account");	
			Thread.sleep(2000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
		}
		
		@And("^I move to Your meter reading page$")
		public void MoveToYourMeterReadingPage() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")));
			webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/YourMeterReadingPageHeading")), "Your meter reading");			
		}
		
		@When("^I click to Back button of Your meter reading page$")
		public void ClickOnBackButton() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/BackButton")));
		}
		
		@Then("^I should navigate to my account dashboard$")
		public void VerifyCustomerCanViewMeterReadingPage() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();	
		}
		
		@And("^I can confirm a Submit a meter reading button$")
		public void MoveToYourMeterReadingPage2() throws Exception
		{
			webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")), "Submit a meter reading");			
		}
		
		// Meter Reading after login - scenario-3
		@Given("^I am on meter reading page using credentials ([^\"]*) and ([^\"]*)$")
		public void LoginByEmailAndPasswordToReachMeterReadingPage(String email, String password) throws Exception
		{
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			//webDriver.VerifyTitle("My account");	
			Thread.sleep(2000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")));
			webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/YourMeterReadingPageHeading")), "Your meter reading");	
		}
		
		@When("^I enter meter reading$")
		public void EnterMeterReading() throws Exception
		{
			meterReadingValue = Integer.valueOf(webDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValueOfYourReadingPage")).getText());
			meterReadingValue = meterReadingValue +100;
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),String.valueOf(meterReadingValue));
		}
		
		@And("^I click on Continue button$")
		public void ClickOnContinueButton() throws Exception
		{
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
		}
		
		@Then("^I should move to Confirm meter reading step$")
		public void ConfirmMeterReadingSteps() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");				
		}
		
		@And("^I can view updated Meter Reading$")
		public void ViewUpdatedMeterReading() throws Exception
		{
			Thread.sleep(2000);
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/MeterReading")), String.valueOf(meterReadingValue));			
		}
		
		@And("^I can view today date$")
		public void ViewTodaysDate() throws Exception
		{
			String CurrentDate = core.baseDriverHelper.GetCurrentDate();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/UpdatedDateForMeterReading")), CurrentDate);
			Thread.sleep(2000);
		}
		
		// Meter Reading after login - scenario-4
		@Given("^I am on Confirm meter reading page using credentials ([^\"]*) and ([^\"]*)$")
		public void LoginByEmailAndPasswordToReachConfirmMeterReadingPage(String email, String password) throws Exception
		{
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			//webDriver.VerifyTitle("My account");	
			Thread.sleep(2000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")));
			webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/YourMeterReadingPageHeading")), "Your meter reading");
			meterReadingValue = Integer.valueOf(webDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValueOfYourReadingPage")).getText());
			meterReadingValue = meterReadingValue +100;
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),String.valueOf(meterReadingValue));
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");	
		}
		
		@When("^I click Back button of Confirm meter reading page$")
		public void ClickBackButtonOfConfirmMeterMeterReadingPage() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
		}
		
		@Then("^I can update the new meter reading$")
		public void UpdateMeterReading() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();
			meterReadingValue = meterReadingValue +50;
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),String.valueOf(meterReadingValue));
			Thread.sleep(2000);
		}
		
		@And("^I can click to continue Button of Your meter reading page$")
		public void ClickToContinueButtonOfYourMeterReadingPage() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");		
			Thread.sleep(2000);
		}
		
		@And("^I can view updated meter reading on Confirm meter reading$")
		public void ViewUpdatedMeterReadingValue() throws Exception
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/MeterReading")), String.valueOf(meterReadingValue));			
			Thread.sleep(2000);
		}
}
