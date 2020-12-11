package pageHelper.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

	public Map<String, Map<String, String>> setMapData() throws IOException {

		String path = "src//test//resources//dataSource//testdata.xlsx";

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int lastRow = sheet.getLastRowNum();

		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();

		Map<String, String> dataMap = new HashMap<String, String>();

		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) {

			Row row = sheet.getRow(i);

			// 1st Cell as Value
			Cell valueCell = row.getCell(1);

			// 0th Cell as Key
			Cell keyCell = row.getCell(0);

			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();

			// Putting key & value in dataMap
			dataMap.put(key, value);

			// Putting dataMap to excelFileMap
			excelFileMap.put("DataSheet", dataMap);
		}

		// Returning excelFileMap
		return excelFileMap;

	}

	// New Functions
	@Then("^I Should see Your Account link on the Page$")
	public void i_Should_see_Your_Account_link_on_the_Page() throws Throwable {
		dashBoard.YourAccountDisplayed();
	}

	@And("^Click on 'Your Account' Option$")
	public void click_on_Your_Account_Option() throws Throwable {
		dashBoard.YourAccountClick();
	}

	@Then("^I Should see 'Dashboard' Option$")
	public void i_Should_see_Dashboard_Option() throws Throwable {
		dashBoard.DashBoardHead();
	}

	@And("^I Should See 'Log out' Option$")
	public void i_Should_See_Logout_Option() throws Throwable {
		dashBoard.LogoutOption();
	}

	@And("^I Should See 'Make a payment' Option$")
	public void i_Should_See_Make_a_payment_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Make a payment");
	}

	@And("^I Should See 'Payment history' Option$")
	public void i_Should_See_Payment_history_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Payment history");
	}

	@And("^I Should See 'Tell us you are moving' Option$")
	public void i_Should_See_Close_your_account_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Tell us you're moving");
	}

	@And("^I Should See 'Set up/Amend a Direct Debit' Option$")
	public void i_Should_See_Set_up_a_Direct_Debit_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Set up/Amend a Direct Debit");
	}

	@And("^I Should See 'Paperless settings' Option$")
	public void i_Should_See_Paperless_settings_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Paperless settings");
	}

	@And("^I Should See 'Your profile' Option$")
	public void i_Should_See_Your_profile_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Your profile");

	}

	@And("^I Should See 'View bills/Account statement' Option$")
	public void i_Should_See_Account_statement_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("View bills/Account statement");
	}

	@And("^I Should See 'Submit a meter reading' Option$")
	public void i_Should_See_Submit_a_meter_reading_Option() throws Throwable {
		dashBoard.DashBoardOptionsVerification("Submit a meter reading");

	}

	@Given("^I am on Account DashBoard Using Login Credentials ([^\"]*) and ([^\"]*)$")
	public void i_am_on_Account_DashBoard_Using_Login_Credentials_devesh_kumar_southernwater_co_uk_and_Logica(
			String email, String password) throws Throwable {
		login.OpenLoginPage();
		login.EnterEmailAndPassword(email, password);
		login.ClickOnLogin();
		dashBoard.YourAccountClick();

	}

	@When("^I Click on Logout from Dashboard$")
	public void i_Click_on_Logout_from_Dashboard() throws Throwable {
		dashBoard.LogoutClick();
	}

	@Then("^I Should See 'Thank You' Message after Logout$")
	public void i_Should_See_Thank_You_Message_after_Logout() throws Throwable {
		dashBoard.LogoutSuccessfully();
	}

	@Then("^I am not able to see 'Your Account' Option$")
	public void i_am_not_able_to_see_Your_Account_Option() throws Throwable {
		dashBoard.YourAccountShouldNotVisible();
	}

	@When("^I Click on 'Submit a meter reading' from Dashboard$")
	public void i_Click_on_Submit_a_meter_reading_from_Dashboard() throws Throwable {
		dashBoard.DashBoardOptionsClick("Submit a meter reading");
	}

	@Then("^I Should Move to Submit Meter Reading Page$")
	public void i_Should_Move_to_Submit_Meter_Reading_Page() throws Throwable {
		dashBoard.SubmitMeterReadingPageOpen();
	}

	@When("^I Click on 'Make a payment' from Dashboard$")
	public void i_Click_on_Make_a_payment_from_Dashboard() throws Throwable {
		dashBoard.DashBoardOptionsClick("Make a payment");
	}

	@Then("^I Should Move to Payment Page$")
	public void i_Should_Move_to_Payment_Page() throws Throwable {
		dashBoard.MakePaymentPageOpen();
	}

	@When("^I Click on 'Tell us you are moving' from Dashboard$")
	public void i_Click_on_Close_your_account_from_Dashboard() throws Throwable {
		dashBoard.DashBoardOptionsClick("Tell us you're moving");
	}

	@Then("^I Should Move to Close Account Page$")
	public void i_Should_Move_to_Close_Account_Page() throws Throwable {
		dashBoard.CloseAccountPageOpen();
	}

	// New Function

	@Then("^I Should See Quick Link for 'Set up a Direct Debit'$")
	public void i_Should_Quick_Link_for_Set_up_a_Direct_Debit() throws Throwable {
		dashBoard.DashBoardQuickLinkFound("Set up a Direct Debit");
	}

	@And("^I Should See Quick Link for 'View bills/account statement'$")
	public void i_Should_Quick_Link_for_View_bills_account_statement() throws Throwable {
		dashBoard.DashBoardQuickLinkFound("View bills/account statement");
	}

	@And("^I Should See Quick Link for 'View payment history'$")
	public void i_Should_Quick_Link_for_View_payment_history() throws Throwable {
		dashBoard.DashBoardQuickLinkFound("View payment history");
	}

	@And("^I Should See Quick Link for 'Change paperless settings'$")
	public void i_Should_Quick_Link_for_Change_paperless_settings() throws Throwable {
		dashBoard.DashBoardQuickLinkFound("Change paperless settings");
	}

	@Then("^I Should See Quick Link for 'Make a payment'$")
	public void i_Should_Quick_Link_for_Make_a_payment() throws Throwable {
		dashBoard.DashBoardMakePaymentButton();
	}

	@Then("^I Should not see Quick Link for 'Make a payment'$")
	public void i_Should_not_see_Quick_Link_for_Make_a_payment() throws Throwable {
		dashBoard.DashBoardMakePaymentButtonNotDisplay();
	}

	@Then("^I Should See Quick Link for 'Amend Direct Debit'$")
	public void i_Should_See_Quick_Link_for_Amend_Direct_Debit() throws Throwable {
		dashBoard.DashBoardStruggglingToPay();
	}

	@And("^I Should See Quick Link for 'Struggling to pay'$")
	public void i_Should_Quick_Link_for_Struggling_to_pay() throws Throwable {
		dashBoard.DashBoardStruggglingToPay();
	}

	@And("^I Should See Quick Link for 'Submit a meter reading'$")
	public void i_Should_Quick_Link_for_Submit_a_meter_reading() throws Throwable {
		dashBoard.DashBoardSubmitReading();
	}

	@And("^I Should See Quick Link for 'Tell us you are moving'$")
	public void i_Should_Quick_Link_for_Tell_us_you_are_moving() throws Throwable {
		dashBoard.DashBoardMovingLink();
	}

	@And("^I Should See Quick Link for 'Contact us'$")
	public void i_Should_Quick_Link_for_Contact_us() throws Throwable {
		dashBoard.DashBoardFooterButton("Contact us");
	}

	@And("^I Should See Quick Link for 'Find out more'$")
	public void i_Should_Quick_Link_for_Find_out_more() throws Throwable {
		dashBoard.DashBoardFooterButton("Find out more");
	}

	@And("^I Should See Quick Link for 'How to keep it clear'$")
	public void i_Should_Quick_Link_for_How_to_keep_it_clear() throws Throwable {
		dashBoard.DashBoardFooterButton("How to keep it clear");
	}

	@Then("^I Should See Latest Bill$")
	public void i_Should_See_Latest_Bill() throws Throwable {
		dashBoard.DashBoardLatestBillMainHeading();
	}

	@And("^Latest Bill Amount$")
	public void latest_Bill_Amount() throws Throwable {
		dashBoard.DashBoardLatestBillAmount();
	}

	@And("^Latest Bill Date$")
	public void latest_Bill_Date() throws Throwable {
		dashBoard.DashBoardLatestBillDate();
	}

	@Then("^I Should Customer Number on dashboard$")
	public void i_Should_Customer_Number_on_dashboard() throws Throwable {
		dashBoard.DashBoardCustomerReferenceNumber();

	}

	@And("^Payment Reference Number on dashboard$")
	public void payment_Reference_Number_on_dashboard() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoard.DashBoardPaymentReferenceNumber();
	}

	@Then("^I Should See Amount Due Label on Dashboard$")
	public void i_Should_See_Amount_Due_Label_on_Dashboard() throws Throwable {
		dashBoard.DashBoardBillDueLabel();
	}

	@And("^Latest Bill Amount Due on Dashboard$")
	public void latest_Bill_Amount_Due_on_Dashboard() throws Throwable {
		dashBoard.DashBoardBillAmount();
	}

	@And("^Bill Date on Date$")
	public void bill_Date_on_Date() throws Throwable {
		dashBoard.DashBoardBillAmount();
	}

	@Then("^i Should see latest Bill Date, Due Dates are same$")
	public void i_Should_see_latest_Bill_Date_Due_Dates_are_same() throws Throwable {
		dashBoard.MatchBillDateAndDueDateisSame();
	}

	@Then("^I Should see the Meter Reading Heading$")
	public void i_Should_see_the_Meter_Reading_Heading() throws Throwable {
		dashBoard.MeterReadingHeading();
	}

	@And("^Last Meter Reading label with Value$")
	public void last_Meter_Reading_label_with_Value() throws Throwable {
		dashBoard.MeterReadingLabelAndValues();
	}

	@And("^Meter Number label with Value$")
	public void meter_Number_label_with_Value() throws Throwable {
		dashBoard.MeterNumberLabelAndValues();
	}

	@And("^Date Last Read label with Value$")
	public void date_Last_Read_label_with_Value() throws Throwable {
		dashBoard.MeterReadLabelAndValues();
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
		dashBoard.DashBoardQuickLinkClick("Change paperless settings");
	}

	@And("^I Should move to Paperless Setting Page$")
	public void i_Should_move_to_Paperless_Setting_Page() throws Throwable {
		Thread.sleep(7000);
		dashBoard.PaperlessSettingPageOpen();
	}

	@When("^I Click on Update$")
	public void i_Click_on_Update() throws Throwable {
		Thread.sleep(4000);
		dashBoard.ClickUpdateofPaperless();
	}

	@Then("^I Can See Thankyou Message$")
	public void i_Can_See_Thankyou_Message() throws Throwable {
		dashBoard.ThankYouMessage();
	}

	@When("^I Click Set Up Direct Debit$")
	public void i_Click_Set_Up_Direct_Debit() throws Throwable {
		dashBoard.DashBoardQuickLinkClick("Set up a Direct Debit ");
	}

	@Then("^I Should move to Setup Direct Debit Page$")
	public void i_Should_move_to_Setup_Direct_Debit_Page() throws Throwable {
		dashBoard.SetupDirectDebitPageOpen();
	}

	@When("^I Click Contact us$")
	public void i_Click_Contact_us() throws Throwable {
		dashBoard.DashBoardFooterButtonClick("Contact us");
	}

	@Then("^Contact Us page should open in new tab$")
	public void contact_Us_page_should_open_in_new_tab() throws Throwable {
		dashBoard.ContactUsPageOpenInNewTab();
	}

	@When("^I Click Find out more$")
	public void i_Click_Find_out_more() throws Throwable {
		dashBoard.DashBoardFooterButtonClick("Find out more");
	}

	@Then("^Target_100 page should open in new tab$")
	public void target_page_should_open_in_new_tab() throws Throwable {
		dashBoard.Target100PageOpenInNewTab();
	}

	@When("^I Click How to keep it clear$")
	public void i_Click_How_to_keep_it_clear() throws Throwable {
		dashBoard.DashBoardFooterButtonClick("How to keep it clear");
	}

	@Then("^Keep it clear page should open in new tab$")
	public void keep_it_clear_page_should_open_in_new_tab() throws Throwable {
		dashBoard.KeepITClearPageOpenInNewTab();
	}

	@When("^I Click Set Up your Profile$")
	public void i_Click_Set_Up_your_Profile() throws Throwable {
		dashBoard.DashBoardOptionsClick("Your profile");
	}

	@Then("^I Should move to View Profile Page$")
	public void i_Should_move_to_View_Profile_Page() throws Throwable {
		dashBoard.YourProfilePageOpen();
	}

	@When("^I Click Set Up Payment history$")
	public void i_Click_Set_Up_Payment_history() throws Throwable {
		
		dashBoard.DashBoardOptionsClick("Payment history");
	}

	@Then("^I Should move to Payment history Page$")
	public void i_Should_move_to_Payment_history_Page() throws Throwable {
		
		dashBoard.PaymentHistoryPageOpen();
	}

}
