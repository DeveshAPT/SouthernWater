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
import pageFunctions.web.AccountDashBoardFunctions;
import pageFunctions.web.LoginFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class AccountDashBoardPageHelper 
{

	public  webHelper webDriver;
	public AccountDashBoardFunctions dashBoard;
	public LoginFunctions login;
	private bddDriver DriverInstance;
	public String enteredName,  enteredCustomerNumber, enteredEmailID,newEmail, firstSecurityQuest;
	PropertyReader prpertyreader = new PropertyReader();
	
	public AccountDashBoardPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
			dashBoard=new AccountDashBoardFunctions(webDriver);
			login=new LoginFunctions(webDriver);
		}
		
	public AccountDashBoardPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			dashBoard=new AccountDashBoardFunctions(webDriver);
			login=new LoginFunctions(webDriver);
		}	
	
	
	//New Functions
	@Then("^I Should see Your Account link on the Page$")
	public void i_Should_see_Your_Account_link_on_the_Page() throws Throwable 
	{
		dashBoard.YourAccountDisplayed();
	}

	
	@And("^Click on 'Your Account' Option$")
	public void click_on_Your_Account_Option() throws Throwable 
	{
		dashBoard.YourAccountClick();   
	}

	@Then("^I Should see 'Dashboard' Option$")
	public void i_Should_see_Dashboard_Option() throws Throwable 
	{
		dashBoard.DashBoardHead();
	}

	@And("^I Should See 'Logout' Option$")
	public void i_Should_See_Logout_Option() throws Throwable 
	{
		dashBoard.LogoutOption();
	}

	@And("^I Should See 'Make a payment' Option$")
	public void i_Should_See_Make_a_payment_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Make a payment");  
	}

	@And("^I Should See 'Billing history' Option$")
	public void i_Should_See_Billing_history_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Billing history");   
	}

	@And("^I Should See 'Close your account' Option$")
	public void i_Should_See_Close_your_account_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Close your account");   
	}

	@And("^I Should See 'Set up a Direct Debit' Option$")
	public void i_Should_See_Set_up_a_Direct_Debit_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Set up a Direct Debit"); 
	}

	@And("^I Should See 'Paperless settings' Option$")
	public void i_Should_See_Paperless_settings_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Paperless settings");     
	}

	@And("^I Should See 'Your profile' Option$")
	public void i_Should_See_Your_profile_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Your profile"); 
	   
	}

	@And("^I Should See 'Account statement' Option$")
	public void i_Should_See_Account_statement_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Account statement");   
	}

	@And("^I Should See 'Submit a meter reading' Option$")
	public void i_Should_See_Submit_a_meter_reading_Option() throws Throwable 
	{
		dashBoard.DashBoardOptionsVerification("Submit a meter reading"); 
	   
	}
	
	
	@Given("^I am on Account DashBoard Using Login Credentials ([^\"]*) and ([^\"]*)$")
	public void i_am_on_Account_DashBoard_Using_Login_Credentials_devesh_kumar_southernwater_co_uk_and_Logica(String email, String password) throws Throwable 
	{
		login.OpenLoginPage();
		login.EnterEmailAndPassword(email, password);
		login.ClickOnLogin();
		dashBoard.YourAccountClick();   
		
	}

	@When("^I Click on Logout from Dashboard$")
	public void i_Click_on_Logout_from_Dashboard() throws Throwable 
	{
		dashBoard.LogoutClick();  
	}

	@Then("^I Should See 'Thank You' Message after Logout$")
	public void i_Should_See_Thank_You_Message_after_Logout() throws Throwable 
	{
		dashBoard.LogoutSuccessfully();      
	}

	@Then("^I am not able to see 'Your Account' Option$")
	public void i_am_not_able_to_see_Your_Account_Option() throws Throwable 
	{
		dashBoard.YourAccountShouldNotVisible();    
	}
	
	@When("^I Click on 'Submit a meter reading' from Dashboard$")
	public void i_Click_on_Submit_a_meter_reading_from_Dashboard() throws Throwable 
	{
		dashBoard.DashBoardOptionsClick("Submit a meter reading");       
	}

	@Then("^I Should Move to Submit Meter Reading Page$")
	public void i_Should_Move_to_Submit_Meter_Reading_Page() throws Throwable 
	{
		//Need to update when page is updated   
	}

	@When("^I Click on 'Make a payment' from Dashboard$")
	public void i_Click_on_Make_a_payment_from_Dashboard() throws Throwable 
	{
		dashBoard.DashBoardOptionsClick("Make a payment");       
	}

	@Then("^I Should Move to Payment Page$")
	public void i_Should_Move_to_Payment_Page() throws Throwable 
	{
		//Need to update when page is updated
	}

	@When("^I Click on 'Close your account' from Dashboard$")
	public void i_Click_on_Close_your_account_from_Dashboard() throws Throwable 
	{
		dashBoard.DashBoardOptionsClick("Close your account");       
	}

	@Then("^I Should Move to Close Account Page$")
	public void i_Should_Move_to_Close_Account_Page() throws Throwable 
	{
	  //Need to update when page is updated
	}

}
