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

public class MoveInPageHelper 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader MoveInLoct=new xmlreader("src\\test\\resources\\locators\\MoveIn.xml");
	String TestFirstName = "TestFirstName";
	String TestMiddleName = "TestMiddleName";
	String TestLastName ="TestLastName";
	String CustomerEmailAddress = "neeraj.m@360logica.com";
	Integer NumberOfOccupants = 3;
	Integer AccountNumber = 55779911;
		public MoveInPageHelper(WebDriver driver) throws IOException 
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
		}
		
		public MoveInPageHelper(bddDriver contextSteps) throws Exception 
		{
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		}
		
		@Given("^I am on create an account page$") 
		public void NavigateToMoveInAccountPage() throws Exception
		{
			Thread.sleep(3000);
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/AcceptCokies")));
			webDriver.OpenURL(prpertyreader.readproperty("MoveInUrl"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/CreateAnAccountHeading")), "Create an account");
			//webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
		}
		
		@And("^I click on Start button$")
		public void ClickOnStartButton() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/StartButton")));
			//webDriver.VerifyTitle("My account");			
		}
		
		@When("^I fill all moving details$") 
		public void FillCustomerMoveInDetails() throws Exception
		{
			Thread.sleep(3000);
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")), "Moving details");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/CustomerPostCode")), "SO22 5JN"+Keys.TAB);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/FindAddressButton")));
			Thread.sleep(3000);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
			Thread.sleep(2000);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")), "10 GODWIN");
			Thread.sleep(3000);
            // For selecting move-out date
			// Create object of SimpleDateFormat class and decide the format
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY "); 
			//get current date time with Date()
			Date currentDate = new Date();
			System.out.println("Today's date:::"+currentDate);
			// convert date to calendar
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			// manipulate date
			c.add(Calendar.DATE, 15); 
			// convert calendar to date
			Date currentDatePlusOne = c.getTime();
			// Now format the date
			String date1= dateFormat.format(currentDatePlusOne); 					 
			// Print the Date
			System.out.println(date1);
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/YourMovingDateLabel")), "Your moving date");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/MoveOutDate")),date1+Keys.TAB);
			Thread.sleep(2000);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupants")),String.valueOf(NumberOfOccupants)+Keys.TAB);
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));
			Thread.sleep(2000);
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/YourDetailsHeader")), "Your details");
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")));
			Thread.sleep(2000);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")), "Mr");
			Thread.sleep(2000);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/FirstName")), TestFirstName);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/MiddleName")), TestMiddleName);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/LastName")), TestLastName);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/DateOfBirth")),"09/12/1980"+Keys.TAB);
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/UserMobileNumber")), "901590951");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/UserEmailAddress")), CustomerEmailAddress);
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));			
		}
		
		
		@And("^I fill all the payment details$")
		public void CustomerPaymentDetails() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/PaymentDeatils")), "Payment details");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/AccountHolderName")), "testAccountHolderName");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeOne")), "20");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeTwo")), "00");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeThree")), "00");
			webDriver.SendKeys(webDriver.getwebelement(MoveInLoct.getlocator("//locators/BankAccountNumber")), String.valueOf(AccountNumber));
			Thread.sleep(2000);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));	
			//webDriver.VerifyTitle("My account");			
		}
		
		@Then("^I Should be able to move in$") 
		public void CustomerIsAbleToMoveIn() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/CheckAndConfirmHeader")), "Check and confirm");
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyName")), TestFirstName +" "+ TestMiddleName + " "+TestLastName);
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyEmail")), CustomerEmailAddress);
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyNumberOfOccupants")), String.valueOf(NumberOfOccupants));
			Thread.sleep(3000);
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/AccountNumberLabel")), "Account number");
			Thread.sleep(3000);
			webDriver.VerifyText(webDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyAccountNumber")), String.valueOf(AccountNumber));
			Thread.sleep(3000);
			webDriver.Clickon(webDriver.getwebelement(MoveInLoct.getlocator("//locators/ConfirmDetailsButton")));
			Thread.sleep(5000);
		}
}
