package pageHelper.web;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class UnRegisteredUserCloseAccountPageHelper 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader CloseAccLoct=new xmlreader("src\\test\\resources\\locators\\CloseAccount.xml");
	PropertyReader prpertyreader = new PropertyReader();
	String dueAmount;
	
		public UnRegisteredUserCloseAccountPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
			
		}
		
		public UnRegisteredUserCloseAccountPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			
		}
		
		@Given("^I have Open UnRegisterd User Close Account Page$")
		public void I_have_Open_UnRegisterd_User_Close_Account_Page() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("CloseAccount"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
		}
		
		@And("^I Click on Start Button of Close Account Page$")
		public void I_Click_on_Start_Button_of_Close_Account_Page() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/CloseAccountStart")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(7000);
		}
		
		@And("^I Enter CustomerNumer ([^\"]*) Payment Reference ([^\"]*) Last Name ([^\"]*)$")
		public void I_Enter_CustomerNumer_Payment_Reference_LastName(String CustomerName, String PaymentRef, String LastName) throws InterruptedException, IOException, DocumentException
		{
			
			webDriver.SendKeys(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/CustomerNumber")),CustomerName);
			webDriver.SendKeys(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/PaymentReference")),PaymentRef);
			webDriver.SendKeys(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/LastName")),LastName);
			
		}
		
		@And("^I Click On Continue of Close Account Your Detail Step$")
		public void I_Click_On_Continue_of_Close_Account_Your_Detail_Step() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
			Thread.sleep(5000);
		}
	
		@And("^I Enter Moving Out Date of Close Account$")
		public void I_Enter_Moving_Out_Date_of_Close_Account() throws InterruptedException, IOException, DocumentException
		{
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
			webDriver.SendKeys(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutDateInput")),date1+Keys.TAB);
		}
		
		@And("^I Click On Continue of Close Account Moving Date Step$")
		public void I_Click_On_Continue_of_Close_Account_Moving_Date_Step() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
			Thread.sleep(5000);
		}
		
		@And("^I Click On Continue of Close Account Final Bill Step$")
		public void I_Click_On_Continue_of_Close_Account_Final_Bill_Step() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
			Thread.sleep(5000);
		}
		
		@And("^I Enter Address Post Code as ([^\"]*) on Forwarding Address Step$")
		public void I_Enter_Post_Code_as_on_Forwarding_Address(String PostCode) throws InterruptedException, IOException, DocumentException
		{
			webDriver.SendKeys(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/PostCodeInput")),PostCode);
		}
		
		@And("^I Click on Find Address Forwarding Address Step$")
		public void I_Click_on_Find_Address_Forwarding_Address() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/FinalAddress")));
			Thread.sleep(5000);
		}
		
		@And("^I Select ([^\"]*) from Address List on Forwarding Address Step$")
		public void I_Select_from_Address_List_on_Forwarding_Address(String Address) throws InterruptedException, DocumentException
		{
			Select Question=new Select(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/SelectAddress")));
			Question.selectByVisibleText(Address);
		}
		
		@And("^I Click Continue on Forwarding Address Step$")
		public void I_Click_Continue_on_Forwarding_Address() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
			Thread.sleep(5000);
		}
		
		@When("^I Click Confirm and Close Account on check and confirm Step$")
		public void I_Click_Confirm_and_Close_Account_on_check_and_confirm_step() throws InterruptedException
		{
			//webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/ConfirmCloseAccount")));
			Thread.sleep(5000);
		}
		
		@Then("^I Should see Account Close$")
		public void I_Should_see_Account_Close()
		{
			
		}
		@And("^I Should See Account Closing Message$")
		public void I_Should_See_Account_Closing_Message()
		{
			
		}
}
