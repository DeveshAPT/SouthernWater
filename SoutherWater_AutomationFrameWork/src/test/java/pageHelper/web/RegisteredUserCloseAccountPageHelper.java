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
import pageFunctions.web.CloseAccountFunctions;
import pageFunctions.web.MoveInFunction;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class RegisteredUserCloseAccountPageHelper {

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public CloseAccountFunctions closeAcc;
	
	PropertyReader prpertyreader = new PropertyReader();
	String dueAmount;
	
		public RegisteredUserCloseAccountPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
			closeAcc=new CloseAccountFunctions(webDriver);
			
		}
		
		public RegisteredUserCloseAccountPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			closeAcc=new CloseAccountFunctions(webDriver);
			
		}
		
		/*@Given("^I have SouthernWater Login Page on Browser$")
		public void I_haveSouthernWater_Login_Page_on_Browser() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);	
		}
		
		@When("I Enter my Account EmailID and Password$")
		public void I_Enter_Account_EmailIDAS() throws InterruptedException, IOException, DocumentException
		{
			Thread.sleep(5000);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),prpertyreader.readproperty("UserEmail"));
			Thread.sleep(2000);
			System.out.println(prpertyreader.readproperty("UserPassword"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),prpertyreader.readproperty("UserPassword"));
		}
		
		@And("^I Click on Login Button On Page$")
		public void I_Click_on_Login_Button_On_Page() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(7000);
		}
		
		@Then("^I Should Login to SouthernWater Portal$")
		public void I_ShouldLoginToSouthernWater_Portal() throws DocumentException, InterruptedException
		{
			Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/DashBoardName")), "Not able to Login");
		}
		
		//Test
		
		@Given("^I Am at Close Account page From Dashboard$")
		public void i_Am_at_Close_Account_page_From_Dashboard() throws Throwable 
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/CloseAccount")));
		}

		@When("^I Click Back Button of Close Account page$")
		public void i_Click_Back_Button_of_Close_Account_page() throws Throwable 
		{
			webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/RegisteredBackButton")));
		}

		@Then("^I Should move back to Dashboard$")
		public void i_Should_move_back_to_Dashboard() throws Throwable 
		{
			Assert.assertTrue(webDriver.IsPresent(loginLoct.getlocator("//locators/DashBoardName")), "Not able to Login");
		}
		
		//Test 2
		

		@Given("^I have open Close My Account from Dashboard$")
		public void i_have_open_Close_My_Account_from_Dashboard() throws Throwable 
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/CloseAccount")));
			Thread.sleep(7000);
		}*/

		@And("^I Enter the MoveOut Date$")
		public void i_Enter_the_MoveOut_Date() throws Throwable 
		{
			closeAcc.EnterMoveOutDate();
		}

		@And("^I Click On Continue of Move Out Step$")
		public void i_Click_On_Continue_of_Move_Out_Step() throws Throwable 
		{
			closeAcc.ContinueClick();
			//webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
			//Thread.sleep(5000);
		}

		@And("^I Click On Continue of Final Bill Step$")
		public void i_Click_On_Continue_of_Final_Bill_Step() throws Throwable 
		{
			closeAcc.ContinueClick();
			//webDriver.Clickon(webDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
			//Thread.sleep(5000);
		}

		@And("^I Enter Post Code as ([^\"]*)$")
		public void i_Enter_Post_Code_as(String PostCode) throws Throwable 
		{
			closeAcc.EnterPostCode(PostCode);
		
		}

		@And("^I Click on Find Address$")
		public void i_Click_Find_Address_as() throws Throwable 
		{
			closeAcc.FindAddressClick();
		}

		@And("^I Select ([^\"]*) from Address List$")
		public void i_Select_Address_from_Address_List(String Address) throws Throwable 
		{
			closeAcc.SelectAddress(Address);	
		}

		@And("^I Click Continue of Forwarding Address$")
		public void i_Click_Continue_of_Forwarding_Address() throws Throwable 
		{
			closeAcc.MoveOutContinue();
		}

		@And("^I Click Confirm and Close Account$")
		public void i_Click_Confirm_and_Close_Account() throws Throwable 
		{
			closeAcc.ConfirmClick();
		}

		@Then("^My Account Should Close$")
		public void my_Account_Should_Close() throws Throwable 
		{
			closeAcc.AccountShouldClose();
		}

		@And("^I Can See Closing Message$")
		public void i_Can_See_Closing_Message() throws Throwable 
		{
			closeAcc.ClosingMessage();
		}
		
		@And("^I Click Close your account from you are moving$")
		public void i_Click_Close_your_account_from_you_are_moving() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			closeAcc.ClickCloseYourAccount();
		}
	}
