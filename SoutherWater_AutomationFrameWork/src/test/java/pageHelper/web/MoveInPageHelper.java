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

public class MoveInPageHelper {

	public webHelper webDriver;
	private bddDriver DriverInstance;
	public MoveInFunction moveIN;
	PropertyReader prpertyreader = new PropertyReader();
	String TestFirstName = "TestFirstName";
	String TestMiddleName = "TestMiddleName";
	String TestLastName = "TestLastName";
	String CustomerEmailAddress = "neeraj.m@360logica.com";
	Integer NumberOfOccupants = 3;
	Integer AccountNumber = 55779911;

	public MoveInPageHelper(WebDriver driver) throws IOException {
		webDriver = new baseDriverHelper(driver);
		System.out.println("First Constructor");
		moveIN = new MoveInFunction(webDriver);
	}

	public MoveInPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		moveIN = new MoveInFunction(webDriver);
	}

	@Given("^I am on create an account page$")
	public void NavigateToMoveInAccountPage() throws Exception {
		moveIN.OpenMoveInPage();
	}

	@And("^I click on Start button$")
	public void ClickOnStartButton() throws InterruptedException, DocumentException, Exception {
		moveIN.startClick();
	}

	@When("^I fill all moving details$")
	public void FillCustomerMoveInDetails() throws Exception {
		moveIN.fillMoveINDetails("SO22 5JN", "10 GODWIN");

		moveIN.enterMoveINDate();

		moveIN.enterOccupant();

		moveIN.commonContinue();

		moveIN.verifyYourDetailsSteps();

		moveIN.enterYourDetails("Mr", TestFirstName, TestMiddleName, TestLastName, "09/12/1980", "901590951",
				CustomerEmailAddress);

		moveIN.commonContinue();

	}

	@And("^I fill all the payment details$")
	public void CustomerPaymentDetails() throws InterruptedException, DocumentException, Exception {
		moveIN.enterCustomerPaymentDetails("testAccountHolderName", "20", "00", "00", String.valueOf(AccountNumber));

		moveIN.commonContinue();
	}

	@Then("^I Should be able to move in$")
	public void CustomerIsAbleToMoveIn() throws InterruptedException, DocumentException, Exception {
		moveIN.verifyMoveINDetails(TestFirstName, TestMiddleName, TestLastName, CustomerEmailAddress,
				String.valueOf(NumberOfOccupants), String.valueOf(AccountNumber));

		moveIN.confirmDetailButton();

	}

	// Scenario: Verify that user is able to move to Moving details page
	@Given("^I am on a create an account page$")
	public void NavigateToCreateAccountPage() throws Exception {
		moveIN.OpenMoveInPage();
	}

	@When("^I click on Start button to Moving details page$")
	public void ClickOnStartButton3() throws InterruptedException, DocumentException, Exception {
		moveIN.startClick();
	}

	@Then("^I should be able to move to Moving details page$")
	public void VerifyMovingDetailsPage() throws Exception {
		moveIN.verifyMoveInDetailPageLoaded();
	}

	// Scenario: Verify that user will get error messages on Moving details page for
	// not filling any values
	@Given("^I am on Moving details page$")
	public void NavigateToMovingDetailsPage() throws Exception {
		moveIN.OpenMoveInPage();
		moveIN.startClick();
		moveIN.verifyMoveInDetailPageLoaded();

	}

	@When("^I clicked on Continue button$")
	public void ClickOnContinueButton() throws InterruptedException, DocumentException, Exception {
		moveIN.commonContinue();
	}

	@Then("^I should be able to see error messages on Moving details page for not filling any values$")
	public void VerifyErrorMessagesOnMovingDetailsPage() throws Exception {
		moveIN.verifyMandatoryFieldsMessage();
	}

	// Scenario Outline: Verify that user will get error message on Moving details
	// page for not entering valid value in postcode
	@Given("^I am on the Moving details page$")
	public void MoveToDetailsPage() throws Exception {
		moveIN.OpenMoveInPage();
		moveIN.startClick();
		moveIN.verifyMoveInDetailPageLoaded();
	}

	@When("^I enter invalid ([^\"]*) in Enter the postcode$")
	public void EnterInvalidPostcode(String postcode) throws InterruptedException, DocumentException, Exception {
		moveIN.enterPostCode(postcode);
	}

	@And("^I click on Find address button$")
	public void ClickOnFindAddressButton() throws InterruptedException, DocumentException, Exception {
		moveIN.findAddressClick();
	}

	@Then("^I should be able to see error messages on Moving details page for invalid postcode$")
	public void VerifyErrorMessagesOnMovingDetailsPageForInvalidPostcode() throws Exception {
		moveIN.inValidAddressMessage();
	}

	// Scenario: Verify that user will get error messages on Moving details page for
	// not selecting an address
	@Given("^I am on the moving details page$")
	public void MovingToDetailsPage() throws Exception {
		moveIN.OpenMoveInPage();
		moveIN.startClick();
		moveIN.verifyMoveInDetailPageLoaded();
	}

	@When("^I am not selecting the address$")
	public void DoNotSelectAddress() throws InterruptedException, DocumentException, Exception {
		Thread.sleep(2000);
		moveIN.enterPostCode("SO22 5JN");
		moveIN.findAddressClick();
		moveIN.verifyEnterAddressManually();

	}

	@And("^I clicked on the Continue button$")
	public void ClickedOnContinueButton() throws InterruptedException, DocumentException, Exception {
		moveIN.commonContinue();
	}

	@Then("^I should be able to see error messages on Moving details page$")
	public void ErrorMessagesOnMovingDetailsPage() throws Exception {
		Thread.sleep(2000);
		webDriver.WaitforPageToBeReady();
		moveIN.pleaseSelectAddressAndOtherErrorMessage();
	}

	// New Test Cases

	@Given("^I have open the move-in page$")
	public void i_have_open_the_move_in_page() throws Throwable {
		moveIN.OpenMoveInPage();
	}

	@And("^I enter Address post code ([^\"]*)$")
	public void i_enter_Address_post_code_devesh_kumar_southernwater_co_uk(String postcode) throws Throwable {
		moveIN.enterPostCode(postcode);
	}

	@And("^I Select my Address ([^\"]*) from address list$")
	public void i_Select_my_Address_Logica_from_address_list(String address) throws Throwable {
		System.out.print(address);
		moveIN.selectAddress(address);
	}

	@And("^I Enter my  moving date$")
	public void i_Enter_my_moving_date() throws Throwable {
		moveIN.enterMoveINDate();
	}

	@And("^I Select Correspondence address yes$")
	public void i_Select_Correspondence_address_yes() throws Throwable {
		// moveIN.SelectAddress(address);
	}

	@And("^I Enter Number of occupant$")
	public void i_Enter_Number_of_occupant() throws Throwable {
		moveIN.enterOccupant();
	}

	@And("^I Click Continue in MoveIN$")
	public void i_Click_Continue_MoveIN() throws Throwable {
		moveIN.commonContinue();
	}

	@And("^I Enter NameTitle ([^\"]*) FirstName ([^\"]*) MName ([^\"]*) LName ([^\"]*) Date of Birth([^\"]*) PhoneNumber ([^\"]*) email ([^\"]*)$")
	public void i_Enter_Title_Mr_FirstName_FTest_LName_LTest_Date_of_Birth_PhoneNumber_email_test_yahoo_com(
			String NTitle, String FName, String MName, String LName, String DOB, String PNumber, String email)
			throws Throwable {
		moveIN.enterYourDetails(NTitle, FName, MName, LName, DOB, PNumber, email);
	}

	@And("^Select Direct Debit as Yes$")
	public void select_Direct_Debit_as_Yes() throws Throwable {
		moveIN.selectDebitasYes();
	}

	@And("^I Enter BankDetail ([^\"]*) Sort Code ([^\"]*) Account Number ([^\"]*)$")
	public void i_Enter_BankDetail_FTest_Sort_Code_Account_Number(String FName, String SortCode, String AccNumber)
			throws Throwable {
		String fcode = SortCode.substring(0, 2);
		String scode = SortCode.substring(2, 4);
		String tcode = SortCode.substring(4, 6);
		moveIN.enterCustomerPaymentDetails(FName, fcode, scode, tcode, AccNumber);
	}

	@Given("^I Select Pay in Monthly Statement$")
	public void i_Select_Pay_in_Monthly_Statement() throws Throwable {

	}

	@When("^I Click Confirm Details$")
	public void i_Click_Confirm_Details() throws Throwable {
		moveIN.confirmDetailButton();
	}

	@Then("^I Should Movin$")
	public void i_Should_Movin() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^Customer ID, Payment Referecne depict on Screen$")
	public void customer_ID_Payment_Referecne_depict_on_Screen() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@And("^Customer ID, Payment Reference depict on Screen$")
	public void customer_ID_Payment_Reference_depict_on_Screen() throws Throwable {
		
		moveIN.verifyCustomeridGenerated();

	}

	@Then("^I Should  See Activation Mail send on my EmailID Message$")
	public void i_Should_See_Activation_Mail_send_on_my_EmailID_Message() throws Throwable {

		moveIN.verifyEmailMessage();
	}

	@And("^Click on Finish$")
	public void click_on_Finish() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		moveIN.clickonFinish();
	}

	@And("^Confirmation Message$")
	public void confirmation_Message() throws Throwable {
		moveIN.confirmationMessage(); // Write code here that turns the phrase above into concrete actions

	}

	@And("^Select Direct Dabit as No$")
	public void Select_DebitAsNo() throws InterruptedException, DocumentException {
		moveIN.selectDebitasNo();
	}

	@And("^I Select Correspondence address No$")
	public void i_Select_Correspondence_address_No() throws Throwable {
		moveIN.correspondenceAddNo();
	}

	@And("^I enter Correspodant Address post code ([^\"]*)$")
	public void i_enter_Correspodant_Address_post_code_SO_JY(String CorCode) throws Throwable {
		moveIN.correspondanceCode(CorCode);
	}

	@And("^I Select my Correspodant Address ([^\"]*) from address list$")
	public void i_Select_my_Correspodant_Address_from_address_list(String address) throws Throwable {
		moveIN.selectCorresponAdd(address);
	}

	@Given("^I Select my Address from address list$")
	public void i_Select_my_Address_from_address_list() throws Throwable {
		moveIN.selectAddress();
	}
	
	@Then("^I can see Mobile and Home number for Contact Details$")
	public void i_can_see_Mobile_and_Home_number_for_Contact_Details() throws Throwable 
	{
		moveIN.mobileHomeContactPresent();  
	}
	
	@Then("^I can select one at a time$")
	public void i_can_select_one_at_a_time() throws Throwable {
		moveIN.verifyToggelingMobileHomeToggelButton();
	}
	
	@When("^Click on Title$")
	public void click_on_Title() throws Throwable 
	{
		moveIN.clickOnTitle();   
	}

	@Then("^I can See Title Dropdow with Miss,Mr,Mrs,Ms,Dr\\.,Prof$")
	public void i_can_See_Title_Dropdow_with_Miss_Mr_Mrs_Ms_Dr_Prof() throws Throwable {
		moveIN.verifyTitleOptions();
	}
	
	@When("^I Select Direct Debit as Yes$")
	public void i_Select_Direct_Debit_as_Yes() throws Throwable 
	{
	    moveIN.selectDebitasYes();
	}

	@Then("^I can See 'Pay in monthly installments'$")
	public void i_can_See_Pay_in_monthly_installments() throws Throwable {
		moveIN.verifyPayInMonthlyInstall();
	}

	@And("^'Pay in Full'$")
	public void pay_in_Full() throws Throwable {
		moveIN.verifyPayInFull();
	}

	@And("^I am able to select to 'Pay in monthly installments'$")
	public void i_am_able_to_select_to_Pay_in_monthly_installments() throws Throwable {
		moveIN.selectPayInMonthlyInstall();
	}

	@And("^I am able to select to 'Pay in Full'$")
	public void i_am_able_to_select_to_Pay_in_Full() throws Throwable {
		moveIN.selectPayInFull();
	}
	
	@And("^I select to 'Pay in monthly installments'$")
	public void i_select_to_Pay_in_monthly_installments() throws Throwable {
		moveIN.selectPayInMonthlyInstall();
	}

	@Then("^I Can Select any day of Month for Direct Dabit$")
	public void i_Can_Select_any_day_of_Month_for_Direct_Dabit() throws Throwable {
		moveIN.verifyDayofDirectDebitOption();
		moveIN.clickDayofDirectDebitOption();
		
	}
	
	@When("^I select to 'Pay in Full'$")
	public void i_select_to_Pay_in_Full() throws Throwable {
		moveIN.selectPayInFull();
	}

}
