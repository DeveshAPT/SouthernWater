package pageHelper.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import pageFunctions.web.ExcelReading;
import pageFunctions.web.LoginFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class AccountDashBoardPageHelper {

	public webHelper webDriver;
	public AccountDashBoardFunctions dashBoard;
	public LoginFunctions login;
	private bddDriver DriverInstance;
	public String enteredName, enteredCustomerNumber, enteredEmailID, newEmail, firstSecurityQuest;
	PropertyReader prpertyreader = new PropertyReader();
	ExcelReading excel = new ExcelReading();

	public AccountDashBoardPageHelper(WebDriver driver) {
		webDriver = new baseDriverHelper(driver);
		System.out.println("First Constructor");
		dashBoard = new AccountDashBoardFunctions(webDriver);
		login = new LoginFunctions(webDriver);
	}

	public AccountDashBoardPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		dashBoard = new AccountDashBoardFunctions(webDriver);
		login = new LoginFunctions(webDriver);
	}

	// New Functions
	@Then("^I Should see Your Account link on the Page$")
	public void i_Should_see_Your_Account_link_on_the_Page() throws Throwable {
		dashBoard.yourAccountDisplayed();
	}

	@And("^Click on 'Your Account' Option$")
	public void click_on_Your_Account_Option() throws Throwable {
		dashBoard.yourAccountClick();
	}

	@Then("^I Should see 'Dashboard' Option$")
	public void i_Should_see_Dashboard_Option() throws Throwable {
		dashBoard.dashBoardHead();
	}

	@And("^I Should See 'Log out' Option$")
	public void i_Should_See_Logout_Option() throws Throwable {
		dashBoard.logoutOption();
	}

	@And("^I Should See 'Make a payment' Option$")
	public void i_Should_See_Make_a_payment_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Make a payment");
	}

	@And("^I Should See 'Payment history' Option$")
	public void i_Should_See_Payment_history_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Payment history");
	}

	@And("^I Should See 'Tell us you are moving' Option$")
	public void i_Should_See_Close_your_account_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Tell us you're moving");
	}

	@And("^I Should See 'Set up/Amend a Direct Debit' Option$")
	public void i_Should_See_Set_up_a_Direct_Debit_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Set up/Amend a Direct Debit");
	}

	@And("^I Should See 'Paperless settings' Option$")
	public void i_Should_See_Paperless_settings_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Paperless settings");
	}

	@And("^I Should See 'Your profile' Option$")
	public void i_Should_See_Your_profile_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Your profile");

	}

	@And("^I Should See 'View bills/Account statement' Option$")
	public void i_Should_See_Account_statement_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("View bills/Account statement");
	}

	@And("^I Should See 'Submit a meter reading' Option$")
	public void i_Should_See_Submit_a_meter_reading_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Submit a meter reading");

	}

	@Given("^I am on Account DashBoard Using Login Credentials ([^\"]*) and ([^\"]*)$")
	public void i_am_on_Account_DashBoard_Using_Login_Credentials_devesh_kumar_southernwater_co_uk_and_Logica(
			String email, String password) throws Throwable {
		login.OpenLoginPage();
		login.EnterEmailAndPassword(email, password);
		login.ClickOnLogin();
		dashBoard.yourAccountClick();

	}

	@When("^I Click on Logout from Dashboard$")
	public void i_Click_on_Logout_from_Dashboard() throws Throwable {
		dashBoard.logoutClick();
	}

	@Then("^I Should See 'Thank You' Message after Logout$")
	public void i_Should_See_Thank_You_Message_after_Logout() throws Throwable {
		dashBoard.logoutSuccessfully();
	}

	@Then("^I am not able to see 'Your Account' Option$")
	public void i_am_not_able_to_see_Your_Account_Option() throws Throwable {
		dashBoard.yourAccountShouldNotVisible();
	}

	@When("^I Click on 'Submit a meter reading' from Dashboard$")
	public void i_Click_on_Submit_a_meter_reading_from_Dashboard() throws Throwable {
		dashBoard.dashBoardOptionsClick("Submit a meter reading");
	}

	@Then("^I Should Move to Submit Meter Reading Page$")
	public void i_Should_Move_to_Submit_Meter_Reading_Page() throws Throwable {
		dashBoard.submitMeterReadingPageOpen();
	}

	@When("^I Click on 'Make a payment' from Dashboard$")
	public void i_Click_on_Make_a_payment_from_Dashboard() throws Throwable {
		dashBoard.dashBoardOptionsClick("Make a payment");
	}

	@Then("^I Should Move to Payment Page$")
	public void i_Should_Move_to_Payment_Page() throws Throwable {
		dashBoard.makePaymentPageOpen();
	}

	@When("^I Click on 'Tell us you are moving' from Dashboard$")
	public void i_Click_on_Close_your_account_from_Dashboard() throws Throwable {
		dashBoard.dashBoardOptionsClick("Tell us you're moving");
	}

	@Then("^I Should Move to Close Account Page$")
	public void i_Should_Move_to_Close_Account_Page() throws Throwable {
		dashBoard.closeAccountPageOpen();
	}

	// New Function

	@Then("^I Should See Quick Link for 'Set up a Direct Debit'$")
	public void i_Should_Quick_Link_for_Set_up_a_Direct_Debit() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("Set up a Direct Debit");
	}

	@And("^I Should See Quick Link for 'View bills/account statement'$")
	public void i_Should_Quick_Link_for_View_bills_account_statement() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("View bills/account statement");
	}

	@And("^I Should See Quick Link for 'View payment history'$")
	public void i_Should_Quick_Link_for_View_payment_history() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("View payment history");
	}

	@And("^I Should See Quick Link for 'Change paperless settings'$")
	public void i_Should_Quick_Link_for_Change_paperless_settings() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("Change paperless settings");
	}

	@Then("^I Should See Quick Link for 'Make a payment'$")
	public void i_Should_Quick_Link_for_Make_a_payment() throws Throwable {
		dashBoard.dashBoardMakePaymentButton();
	}

	@Then("^I Should not see Quick Link for 'Make a payment'$")
	public void i_Should_not_see_Quick_Link_for_Make_a_payment() throws Throwable {
		dashBoard.dashBoardMakePaymentButtonNotDisplay();
	}

	@Then("^I Should See Quick Link for 'Amend Direct Debit'$")
	public void i_Should_See_Quick_Link_for_Amend_Direct_Debit() throws Throwable {
		dashBoard.dashBoardStruggglingToPay();
	}

	@And("^I Should See Quick Link for 'Struggling to pay'$")
	public void i_Should_Quick_Link_for_Struggling_to_pay() throws Throwable {
		dashBoard.dashBoardStruggglingToPay();
	}

	@And("^I Should See Quick Link for 'Submit a meter reading'$")
	public void i_Should_Quick_Link_for_Submit_a_meter_reading() throws Throwable {
		dashBoard.dashBoardSubmitReading();
	}

	@And("^I Should See Quick Link for 'Tell us you are moving'$")
	public void i_Should_Quick_Link_for_Tell_us_you_are_moving() throws Throwable {
		dashBoard.dashBoardMovingLink();
	}

	@And("^I Should See Quick Link for 'Contact us'$")
	public void i_Should_Quick_Link_for_Contact_us() throws Throwable {
		dashBoard.dashBoardFooterButton("Contact us");
	}

	@And("^I Should See Quick Link for 'Find out more'$")
	public void i_Should_Quick_Link_for_Find_out_more() throws Throwable {
		dashBoard.dashBoardFooterButton("Find out more");
	}

	@And("^I Should See Quick Link for 'How to keep it clear'$")
	public void i_Should_Quick_Link_for_How_to_keep_it_clear() throws Throwable {
		dashBoard.dashBoardFooterButton("How to keep it clear");
	}

	@Then("^I Should See Latest Bill$")
	public void i_Should_See_Latest_Bill() throws Throwable {
		dashBoard.dashBoardLatestBillMainHeading();
	}

	@And("^Latest Bill Amount$")
	public void latest_Bill_Amount() throws Throwable {
		dashBoard.dashBoardLatestBillAmount();
	}

	@And("^Latest Bill Date$")
	public void latest_Bill_Date() throws Throwable {
		dashBoard.dashBoardLatestBillDate();
	}

	@Then("^I Should Customer Number on dashboard$")
	public void i_Should_Customer_Number_on_dashboard() throws Throwable {
		dashBoard.dashBoardCustomerReferenceNumber();

	}

	@And("^Payment Reference Number on dashboard$")
	public void payment_Reference_Number_on_dashboard() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoard.dashBoardPaymentReferenceNumber();
	}

	@Then("^I Should See Amount Due Label on Dashboard$")
	public void i_Should_See_Amount_Due_Label_on_Dashboard() throws Throwable {
		dashBoard.dashBoardBillDueLabel();
	}

	@And("^Latest Bill Amount Due on Dashboard$")
	public void latest_Bill_Amount_Due_on_Dashboard() throws Throwable {
		dashBoard.dashBoardBillAmount();
	}

	@And("^Bill Date on Date$")
	public void bill_Date_on_Date() throws Throwable {
		dashBoard.dashBoardBillAmountDate();
	}

	@Then("^i Should see latest Bill Date, Due Dates are same$")
	public void i_Should_see_latest_Bill_Date_Due_Dates_are_same() throws Throwable {
		dashBoard.matchBillDateAndDueDateisSame();
	}

	@Then("^I Should see the Meter Reading Heading$")
	public void i_Should_see_the_Meter_Reading_Heading() throws Throwable {
		dashBoard.meterReadingHeading();
	}

	@And("^Last Meter Reading label with Value$")
	public void last_Meter_Reading_label_with_Value() throws Throwable {
		dashBoard.meterReadingLabelAndValues();
	}

	@And("^Meter Number label with Value$")
	public void meter_Number_label_with_Value() throws Throwable {
		dashBoard.meterNumberLabelAndValues();
	}

	@And("^Date Last Read label with Value$")
	public void date_Last_Read_label_with_Value() throws Throwable {
		dashBoard.meterReadLabelAndValues();
	}

	@Given("^I have open login page$")
	public void i_have_open_login_page() throws Throwable {
		login.OpenLoginPage();
	}

	@And("^Login With  my ([^\"]*) and ([^\"]*)$")
	public void login_With_my_Kumar_devesh_yahoo_com_and_Apple(String email, String password) throws Throwable {
		login.EnterEmailAndPassword(email, password);
	}

	@And("^I Click Change Paperless Setting$")
	public void i_Click_Change_Paperless_Setting() throws Throwable {
		dashBoard.dashBoardQuickLinkClick("Change paperless settings");
	}

	@And("^I Should move to Paperless Setting Page$")
	public void i_Should_move_to_Paperless_Setting_Page() throws Throwable {
		Thread.sleep(7000);
		dashBoard.paperlessSettingPageOpen();
	}

	@When("^I Click on Update$")
	public void i_Click_on_Update() throws Throwable {
		Thread.sleep(4000);
		dashBoard.clickUpdateofPaperless();
	}

	@Then("^I Can See Thankyou Message$")
	public void i_Can_See_Thankyou_Message() throws Throwable {
		dashBoard.thankYouMessage();
	}

	@When("^I Click Set Up Direct Debit$")
	public void i_Click_Set_Up_Direct_Debit() throws Throwable {
		dashBoard.dashBoardQuickLinkClick("Set up a Direct Debit ");
	}

	@Then("^I Should move to Setup Direct Debit Page$")
	public void i_Should_move_to_Setup_Direct_Debit_Page() throws Throwable {
		dashBoard.setupDirectDebitPageOpen();
	}

	@When("^I Click Contact us$")
	public void i_Click_Contact_us() throws Throwable {
		dashBoard.dashBoardFooterButtonClick("Contact us");
	}

	@Then("^Contact Us page should open in new tab$")
	public void contact_Us_page_should_open_in_new_tab() throws Throwable {
		dashBoard.contactUsPageOpenInNewTab();
	}

	@When("^I Click Discover ways to save$")
	public void i_Click_Discover_ways_to_save() throws Throwable {
		dashBoard.dashBoardFooterButtonClick("Discover ways to save");
	}

	@Then("^Save Water page should open in new tab$")
	public void save_Water_page_should_open_in_new_tab() throws Throwable {
		dashBoard.saveWaterPageOpenInNewTab();
	}

	@When("^I Click Learn more$")
	public void i_Click_Learn_more() throws Throwable {
		dashBoard.dashBoardFooterButtonClick("Learn more");
	}

	@Then("^How to prevent blockage page should open in new tab$")
	public void how_to_prevent_blockagepage_should_open_in_new_tab() throws Throwable {
		dashBoard.preventBlockagePageOpenInNewTab();
	}

	@When("^I Click Set Up your Profile$")
	public void i_Click_Set_Up_your_Profile() throws Throwable {
		dashBoard.dashBoardOptionsClick("Your profile");
	}

	@Then("^I Should move to View Profile Page$")
	public void i_Should_move_to_View_Profile_Page() throws Throwable {
		dashBoard.yourProfilePageOpen();
	}

	@When("^I Click Set Up Payment history$")
	public void i_Click_Set_Up_Payment_history() throws Throwable {

		dashBoard.dashBoardOptionsClick("Payment history");
	}

	@Then("^I Should move to Payment history Page$")
	public void i_Should_move_to_Payment_history_Page() throws Throwable {

		dashBoard.paymentHistoryPageOpen();
	}

	// New Dashboard
	
	@Given("^I am at login Page$")
	public void i_am_at_login_Page() throws Throwable {
		login.OpenLoginPage();
	}

	@And("^Login with Credentials$")
	public void login_with_Credentials() throws Throwable {
		// Map<String, String> map=excel.TestDataFromExcel("Dashboard");
		String email = prpertyreader.readproperty("UserEmail");
		String password = prpertyreader.readproperty("UserPassword");
		login.EnterEmailAndPassword(email, password);
	}

	@Then("^I can see the QucikLinks ([^\"]*) on Dashboard$")
	public void i_can_see_the_QucikLinks(String links) throws Throwable 
	{
		String[] Listlinks = links.split(",");
		for (int i = 0; i < Listlinks.length; i++) 
		{
			String temp=Listlinks[i].trim();
			System.out.println(temp);
			dashBoard.dashBoardQuickLinkFound(temp.trim());
			
		}
	}
	
	@Then("^I can see Customer Number,Payment Reference on Dashboard$")
	public void customer_Number_Payment_Reference_on_Dashboard() throws Throwable {
		dashBoard.dashBoardPaymentReferenceNumber();
		dashBoard.dashBoardCustomerReferenceNumber();
	}
	
	@Then("^I Can see Customer Email ID, Correspondence Address under your profile section$")
	public void i_Can_see_Customer_Email_ID_Correspondence_Address_under_your_profile_section() throws Throwable {
		dashBoard.yourProfileHeadingDashBoard();
		dashBoard.yourProfileEmailHeadingAndEmailID();
		dashBoard.yourProfileAddressLabelAndValue();
	   
	}
	
	@Then("^I Can see Last Meter Reading, Meter Number, Date last Read$")
	public void i_Can_see_Last_Meter_Reading_Meter_Number_Date_last_Read() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dashBoard.meterReadingHeading();
		dashBoard.meterReadingLabelAndValues();
		dashBoard.meterNumberLabelAndValues();
		dashBoard.meterReadLabelAndValues();
	   
	}
	
	@Then("^I Can see Property address, Your Services$")
	public void i_Can_see_Property_address_Your_Services() throws Throwable {
		dashBoard.accountDetailsSectionVerification();
	}
	
	@Then("^I Can see Latest Bill, Bill Amount, Bill Date$")
	public void i_Can_see_Latest_Bill_Bill_Amount_Bill_Date() throws Throwable 
	{
		dashBoard.dashBoardLatestBillMainHeading();
		dashBoard.dashBoardLatestBillAmount();
		dashBoard.dashBoardLatestBillDate();
	}
	
	@Then("^I Can see Amount Due, Amount, date$")
	public void i_Can_see_Amount_Due_Amount_date() throws Throwable {
		dashBoard.dashBoardBillDueLabel();
		dashBoard.dashBoardBillAmount();
		dashBoard.dashBoardBillAmountDate();
	}
	
	@Then("^I Can See Following Menu ([^\"]*) Items$")
	public void i_Can_See_Following_Menu_Items(String MenuList) throws Throwable {
		String[] Listlinks = MenuList.split(",");
		for (int i = 0; i < Listlinks.length; i++) 
		{
			String temp=Listlinks[i].trim();
			System.out.println(temp);
			dashBoard.dashBoardOptionsVerification(temp.trim());
			
		}
	}
	
	@And("^I Click View bills/Account statement$")
	public void i_Click_View_bills_Account_statement() throws Throwable 
	{
		dashBoard.dashBoardOptionsClick("View bills/Account statement");
	}

	@Then("^I Should move to View Bill Account Statement Page$")
	public void i_Should_move_to_View_Bill_Account_Statement_Page() throws Throwable {
		dashBoard.yourViewBillsPageOpen();
	}
	
	@And("^I Click on 'Submit a meter reading' button from Dashboard$")
	public void i_Click_on_Submit_a_meter_reading_button_from_Dashboard() throws Throwable {
		dashBoard.clickSubmitMeterReadingButton();
	}
	
	@And("^I Click on 'Tell us you are moving' button from Dashboard$")
	public void i_Click_on_Tell_us_you_are_moving_button_from_Dashboard() throws Throwable {
		dashBoard.clickYouAreMovingButton();
	}
	
	@And("^I Click on 'Make a payment' button from Dashboard$")
	public void i_Click_on_Make_a_payment_button_from_Dashboard() throws Throwable {
	   
		dashBoard.clickMakeAPaymentButton();
	}
	
	@When("^I Click 'View Profile' button from Dashboard$")
	public void i_Click_View_Profile_button_from_Dashboard() throws Throwable {
		dashBoard.clickViewProfileButton();
	   
	}
}
