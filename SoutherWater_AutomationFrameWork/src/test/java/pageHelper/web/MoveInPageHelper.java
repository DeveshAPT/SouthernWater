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
import pageFunctions.web.MoveInFunction;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class MoveInPageHelper 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public MoveInFunction moveIN;
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
			moveIN=new MoveInFunction(webDriver);
		}
		
		public MoveInPageHelper(bddDriver contextSteps) throws Exception 
		{
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			moveIN=new MoveInFunction(webDriver);
		}
		
		@Given("^I am on create an account page$") 
		public void NavigateToMoveInAccountPage() throws Exception
		{
			moveIN.OpenMoveInPage();
		}
		
		@And("^I click on Start button$")
		public void ClickOnStartButton() throws InterruptedException, DocumentException, Exception
		{
			moveIN.StartClick();	
		}
		
		@When("^I fill all moving details$") 
		public void FillCustomerMoveInDetails() throws Exception
		{
			moveIN.FillMoveINDetails("SO22 5JN","10 GODWIN");
			
			moveIN.EnterMoveINDate();
			
			moveIN.EnterOccupant();
			
			moveIN.ContinueClick();
			
			moveIN.VerifyYourDetailsSteps();
		
			moveIN.EnterYourDetails("Mr",TestFirstName,TestMiddleName,TestLastName,"09/12/1980", "901590951",CustomerEmailAddress);
			
			moveIN.ContinueClick();
				
		}
		
		
		@And("^I fill all the payment details$")
		public void CustomerPaymentDetails() throws InterruptedException, DocumentException, Exception
		{
			moveIN.EnterCustomerPaymentDetails("testAccountHolderName","20","00","00",String.valueOf(AccountNumber));
			
			moveIN.ContinueClick();
		}
		
		@Then("^I Should be able to move in$") 
		public void CustomerIsAbleToMoveIn() throws InterruptedException, DocumentException, Exception
		{
			moveIN.VerifyMoveINDetails(TestFirstName, TestMiddleName, TestLastName, CustomerEmailAddress, String.valueOf(NumberOfOccupants), String.valueOf(AccountNumber));
			
			moveIN.ConfirmDetailButton();

		}
		
		//Scenario: Verify that user is able to move to Moving details page
		@Given("^I am on a create an account page$") 
		public void NavigateToCreateAccountPage() throws Exception
		{
			moveIN.OpenMoveInPage();
		}
		
		@When("^I click on Start button to Moving details page$")
		public void ClickOnStartButton3() throws InterruptedException, DocumentException, Exception
		{
			moveIN.StartClick();		
		}
		
		@Then("^I should be able to move to Moving details page$") 
		public void VerifyMovingDetailsPage() throws Exception
		{
			moveIN.VerifyMoveInDetailPageLoaded();
		}
		
		//Scenario: Verify that user will get error messages on Moving details page for not filling any values
		@Given("^I am on Moving details page$") 
		public void NavigateToMovingDetailsPage() throws Exception
		{
			moveIN.OpenMoveInPage();
			moveIN.StartClick();	
			moveIN.VerifyMoveInDetailPageLoaded();
			
		}
		
		@When("^I clicked on Continue button$")
		public void ClickOnContinueButton() throws InterruptedException, DocumentException, Exception
		{
			moveIN.ContinueClick();
		}
		
		@Then("^I should be able to see error messages on Moving details page for not filling any values$") 
		public void VerifyErrorMessagesOnMovingDetailsPage() throws Exception
		{
			moveIN.VerifyMandatoryFieldsMessage();
		}
		
		//Scenario Outline: Verify that user will get error message on Moving details page for not entering valid value in postcode
		@Given("^I am on the Moving details page$") 
		public void MoveToDetailsPage() throws Exception
		{
			moveIN.OpenMoveInPage();
			moveIN.StartClick();	
			moveIN.VerifyMoveInDetailPageLoaded();
		}
		
		@When("^I enter invalid ([^\"]*) in Enter the postcode$")
		public void EnterInvalidPostcode(String postcode) throws InterruptedException, DocumentException, Exception
		{
			moveIN.EnterPostCode(postcode);
		}
		
		@And("^I click on Find address button$")
		public void ClickOnFindAddressButton() throws InterruptedException, DocumentException, Exception
		{
			moveIN.FindAddressClick();
		}
		
		@Then("^I should be able to see error messages on Moving details page for invalid postcode$") 
		public void VerifyErrorMessagesOnMovingDetailsPageForInvalidPostcode() throws Exception
		{
			moveIN.InValidAddressMessage();
		}
		
		
		//Scenario: Verify that user will get error messages on Moving details page for not selecting an address
		@Given("^I am on the moving details page$") 
		public void MovingToDetailsPage() throws Exception
		{
			moveIN.OpenMoveInPage();
			moveIN.StartClick();	
			moveIN.VerifyMoveInDetailPageLoaded();
		}
		
		@When("^I am not selecting the address$")
		public void DoNotSelectAddress() throws InterruptedException, DocumentException, Exception
		{
			Thread.sleep(2000);
			moveIN.EnterPostCode("SO22 5JN");
			moveIN.FindAddressClick();
			moveIN.VerifyEnterAddressManually();
			
		}
		
		@And("^I clicked on the Continue button$")
		public void ClickedOnContinueButton() throws InterruptedException, DocumentException, Exception
		{
			moveIN.ContinueClick();
		}
		
		@Then("^I should be able to see error messages on Moving details page$") 
		public void ErrorMessagesOnMovingDetailsPage() throws Exception
		{
			Thread.sleep(2000);
			webDriver.WaitforPageToBeReady();
			moveIN.PleaseSelectAddressAndOtherErrorMessage();	
		}
}
