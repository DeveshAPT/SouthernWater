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
import pageFunctions.web.SubmitmeterReadingFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class SubmitMeterReadings 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public SubmitmeterReadingFunctions subMeter;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	Integer meterReadingValue = null;
	String EnteredReading;
	//core.baseDriverHelper baseDriverHelperFunctions = null;
		public SubmitMeterReadings(WebDriver driver) throws IOException 
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
			subMeter=new SubmitmeterReadingFunctions(webDriver);
		}
		
		public SubmitMeterReadings(bddDriver contextSteps) throws Exception 
		{
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			subMeter=new SubmitmeterReadingFunctions(webDriver);
		}
		
		@Given("^I am on meter submit reading pages$") 
		public void SouthernWaterSumbitMeterReading() throws Exception
		{
			subMeter.AccessUnauthSubmitMeterReading();
		}
		
		@When("^I click on Having trouble link$") 
		public void TroubleLinkverification() throws Exception
		{
			subMeter.ClickTroubleLink();
		}
		
		@Then("^I Should move to how to find your meter page$") 
		public void VerifyHowtofindYourMeterPageOpen() throws InterruptedException, DocumentException
		{
			
			subMeter.VerifyFindMeterOnpage();
		}
		
		
		//Test 2
		
		@Given("^I am on how to find your meter page$") 
		public void VerifySubmitonline() throws Exception
		{
			
			subMeter.AccessUnauthSubmitMeterReading();
			subMeter.ClickTroubleLink();
			subMeter.VerifyFindMeterOnpage();
		}
		
		@When("^I click on Submit Meter link") 
		public void ClickSubmitonline() throws Exception
		{
			subMeter.SubmitOnlineClick();
		}
		
		@Then("^I Should move to Submit meter reading page") 
		public void VerifySumbitMeterReadingOpen() throws Exception
		{
			subMeter.VerifyMoveBackToSubmitMeterReadingPage();
			
		}
		
		//Scenario: I Want to Verify customer meter reading details	
		@Given("^I am on submit meter reading page$") 
		public void VerifySubmitMeterReadingPage() throws Exception
		{			
			subMeter.AccessUnauthSubmitMeterReading();
			subMeter.StartClick();
		}
		
		@When("^I submit all the details of customer") 
		public void ClickOnSubmitButtonAfterSubmitingCustomerDetails() throws Exception
		{
			subMeter.EnterCustomerDetails("21301653", "4505530617", "Updahyll", "test@gmail.com");
			subMeter.ContinueClick();
		}
		
		@Then("^I Should able to verify all the details of customer") 
		public void VerifySumbitMeterReadingDetailsOfgCustomer() throws Exception
		{
			/*webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/CheckYourDetailsHeader")), "Check your details");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel")), "Your meter reading");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyCustomerNumber")), "21301653");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyPaymentReferenceNumber")), "0004505530617");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyLastName")), "Updahyll");*/
			
			subMeter.VerifyCustomerDetails("21301653","0004505530617", "Updahyll");
			
			/*webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueHyperLink")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);*/
			subMeter.ContinueHyperlink();
			
			subMeter.EnterMeterReading();
						
			//scroll screen at the bottom
			/*WebDriver driver = new ChromeDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");			
			Thread.sleep(2000);*/
			subMeter.ContinueClickOnMeterReading();
			
			subMeter.ConfirmMeterReading();
			
			//subMeter.BackButtonClick();
			
			subMeter.ConfirmeterReadingClick();
			
			/*webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingValue")), String.valueOf(meterReading3));
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);*/
			
			
			/*webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
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
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmReadingButton")));*/
		}
		
		
		
		
		// Meter Reading after login - scenario-1
		@Given("^I have logged in with ([^\"]*) and ([^\"]*)$")
		public void LoginInByEnterEmailAndPassword(String email, String password) throws Exception
		{
			Thread.sleep(2000);
			//webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
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
			//webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
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
			//webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
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
			//webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(2000);
			webDriver.GetTitle();	
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
			System.out.println(meterReadingValue);
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
			String MeaterReadingNew = webDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValueOfYourReadingPage")).getText();
			System.out.println(MeaterReadingNew.toString());
			meterReadingValue =Integer.parseInt(MeaterReadingNew) +150;
			//meterReadingValue = meterReadingValue +50;
			System.out.println(meterReadingValue);
			webDriver.CleasrAndSendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),meterReadingValue.toString());
			Thread.sleep(2000);
		}
		
		@And("^I can click to continue Button of Your meter reading page$")
		public void ClickToContinueButtonOfYourMeterReadingPage() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");		
			//Thread.sleep(2000);
		}
		
		@And("^I can view updated meter reading on Confirm meter reading$")
		public void ViewUpdatedMeterReadingValue() throws Exception
		{
			Thread.sleep(5000);
			System.out.println(meterReadingValue);
			WebElement el=webDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel3"));
			String NewReading=el.getText();
			System.out.println(NewReading);
			//Assert.assertTrue(NewReading.equals(meterReadingValue.toString()), "New Meter Reading Not matched with Submit Meter Reading");
		}
		
		 @Given("I am on Unregistered Submit meter Reading page")
		 public void I_am_on_Unregistered_Submit_meter_Reading_page() throws Exception
		 {
			 	Thread.sleep(5000);
				//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
				webDriver.OpenURL(prpertyreader.readproperty("MeterReading"));
				webDriver.WaitforPageToBeReady();
				System.out.println(webDriver.GetTitle());
		 }
		 
		 @When("I Click on Start Button")
		 public void I_Click_on_Start_Button() throws Exception
		 {
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		 }
		 
		 @And("I Enter CustomerNumber <CustomerNumber> Payment Reference <PayRef> and LastName <LastName>")
		 public void I_Enter_CustomerNumber_Payment_Reference__and_LastName(String CustNumb, String PayRef, String LastName ) throws InterruptedException, IOException
		 {
			 webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerNumber']"),CustNumb);
			 webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerRefNumber']"),PayRef);
			 webDriver.SendKeys(webDriver.getwebelement("//input[@id='inpName']"),LastName);
			 
		 }
		 
		 @And("I Click on Continue")
		 public void I_Click_on_Continue() throws InterruptedException, Exception
		 {
			 webDriver.Clickon(webDriver.getwebelement("//button[@type='submit']"));
			 webDriver.WaitforPageToBeReady();
			 Thread.sleep(5000);
		 }
		 
		 @And("I Click again on  Continue")
		 public void I_Click_again_on_Continue() throws Exception
		 {
			 webDriver.Clickon(webDriver.getwebelement("//a[text()='Continue']"));
			 webDriver.WaitforPageToBeReady();
			 Thread.sleep(5000);
		 }
		 
		 @Then("I Can Enter Updated Meter Reading")
		 public void I_Can_Enter_Updated_Meter_Reading() throws InterruptedException, IOException
		 {
			WebElement el=webDriver.getwebelement("//h3[text()='Last meter reading']/following-sibling::p");
		    String NewReading=el.getText();
		    int temp=Integer.parseInt(NewReading);
		    temp=temp+100;
		    NewReading=Integer.toString(temp);
		    EnteredReading=NewReading;
		    webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerMeterReading']"),NewReading+Keys.TAB);
		  
		 }
		 
		 @And("I can click to continue Button of Your meter reading page")
		 public void I_can_click_to_continue_Button_of_Your_meter_reading_page() throws InterruptedException, Exception
		 {
			 webDriver.Clickon(webDriver.getwebelement("//button[text()='Continue']"));
			 webDriver.WaitforPageToBeReady();
			 Thread.sleep(5000);
		 }
		 
		 @And("I can view updated meter reading on Confirm meter reading") 
		 public void I_can_view_updated_meter_reading_on_Confirm_meter_reading() throws InterruptedException
		 {
			 WebElement el=webDriver.getwebelement("//h3[text()='Meter reading']/following-sibling::p");
			 String NewReading=el.getText();
		 }
}
