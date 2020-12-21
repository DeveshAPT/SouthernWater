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
import pageFunctions.web.RegistrationFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class CustomerRegistrationPageHelper {
	public webHelper webDriver;
	public RegistrationFunctions registerFunc;
	private bddDriver DriverInstance;
	public String enteredName, enteredCustomerNumber, enteredEmailID, newEmail, firstSecurityQuest;
	xmlreader custRegist = new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	PropertyReader prpertyreader = new PropertyReader();

	public CustomerRegistrationPageHelper(WebDriver driver) {
		webDriver = new baseDriverHelper(driver);
		System.out.println("First Constructor");
		registerFunc = new RegistrationFunctions(webDriver);
	}

	public CustomerRegistrationPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		registerFunc = new RegistrationFunctions(webDriver);
	}

	// SSR-502 >> Agree terms and conditions
	// Test1 >>Verify Terms and Condition on Customer Registration Page

	@Given("^I am at SouthernWater web portal$")
	public void SouthernWaterPortal() throws Exception {
		Thread.sleep(5000);
		// webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		webDriver.WaitforPageToBeReady();

	}

	@When("^I open Customer Registration Page$")
	public void OpenCustomerRegistrationPage() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@Then("^I am able to see Terms & Conditions Check Box$")
	public void VerifyTermsAndConditionCheckbox() throws InterruptedException, DocumentException {
		registerFunc.verifyTermsConditionsCheckBox();
	}

	@And("^Hyperlink for Terms & Conditions$")
	public void VerifyTermsAndConditionLink() throws InterruptedException, DocumentException {
		registerFunc.verifyTermsAndCondtionLink();
	}

	// Test2 >> Verify that the Terms & Condition page is for customer

	@Given("^I am at online Customer Registration Page$")
	public void OpenOnlieCustomerRegistrationPage() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@When("^I Click on term & condition link$")
	public void ClickTermsAndConditions() throws Exception {
		registerFunc.clickTermsConditionLink();
	}

	@Then("^I Should move to Terms & Conditions Page$")
	public void VerifyTermsAndConditionPageOpen() throws InterruptedException, DocumentException {

		registerFunc.verifyTermsAndConditionPage();

	}

	// Test3 >> Verify that the Terms & Condition Close button should navigate
	// Customer Registration Page

	@Given("^I am on SW on Terms & Condition page$")
	public void TermAndConditionPagesOpened() throws Exception {

		registerFunc.openRegistrationPage();

		registerFunc.clickTermsConditionLink();

	}

	@And("^I can See the Close Button$")
	public void CloseButtonVisible() throws Exception {
		registerFunc.closeTermAndConditionPage();
	}

	@And("^I Click on Close button$")
	public void ClickTermsAndConditionsClose() throws Exception {
		registerFunc.clickCloseTermAndCondition();
	}

	@And("^I should move to Customer Registration Page$")
	public void VerifyRegistrationPageOpen() throws InterruptedException, DocumentException {

		registerFunc.verifyRegisterationPageOpen();
	}

	// Test4 >> Verify Agree Terms & Condition is mandatory

	@Given("^Customer Registration Page is open$")
	public void CustomerRegistrationPageIsOpen() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@When("^I click on Start button without agree Terms & Conditions$")
	public void ClickStartWithoutAgreeTerms() throws Exception {
		registerFunc.clickStart();
	}

	@Then("^I should see the error message for agree Terms & Conditions$")
	public void AcceptTermFirstMessageVerification() throws InterruptedException, DocumentException {

		registerFunc.acceptTermsAndConditionMandatoryMessageSecond();
	}

	@And("^Second at below the Terms & Condition line$")
	public void AcceptTermSecondMessageVerification() throws InterruptedException, DocumentException {

		registerFunc.acceptTermsAndConditionMandatoryMessageSecond();
	}

	// Test5 >> Verify Agree Terms & Condition is mandatory should remove after
	// checking agree Terms & Condition

	@Given("^Customer Registration Page is open and having Terms & Condition error on page$")
	public void CustomerRegistrationPageIsOpenWithTermErrorMessage() throws Exception {

		registerFunc.openRegistrationPage();

		registerFunc.clickStart();

		registerFunc.acceptTermsAndConditionMandatoryMessageSecond();

		registerFunc.acceptTermsAndConditionMandatoryMessageSecond();

	}

	@When("^I Click checkbox against Terms & Conditions$")
	public void ClickTermsConditionCheckBox() throws Exception {

		registerFunc.clickTermsAndConditionCheckBox();
	}

	@Then("^Agree Terms & Conditions Error message should remove from both locations$")
	public void AcceptTermMessageVerificationRemoved() throws InterruptedException, DocumentException {

		registerFunc.termsConditionMessegeDisAppear();
	}

	// Test6 >> Verify Your Privacy Link Functionality

	@Given("^I am on Customer Registration Page$")
	public void OpeningCustomerRegPage() throws InterruptedException, DocumentException, Exception {
		registerFunc.openRegistrationPage();
	}

	@When("^I Click Your Privacy Link$")
	public void ClickOnPrivacyLink() throws InterruptedException, DocumentException, Exception {
		registerFunc.privacyLinkClick();
	}

	@Then("^I Should move to Privacy Page$")
	public void VerifyPrivacyPage() {
		webDriver.VerifyTitle("Privacy - protecting and respecting your privacy");
	}

	// SSR-444 >> Tell the user what information they will need at the start of the
	// register account journey

	// Test1 >> Verify field details message on customer registration page

	@Given("^I am on online SouthernWater Portal page$")
	public void AccessingSouthernWaterWebPortal() throws InterruptedException, DocumentException, Exception {
		Thread.sleep(5000);
		// webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		webDriver.WaitforPageToBeReady();

	}

	@When("^I Access Customer Registration Page$")
	public void AccessingCustomerRegistrationPage() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@Then("^I am able to see It should only take a few minutes$")
	public void LabelItShouldOnlyTakeAFewMinutes() throws InterruptedException, DocumentException {
		registerFunc.verifyItShouldTakeFewMinute();
	}

	@And("^Your customer number This is the 8-digit number shown on the top right of your bill$")
	public void Label8DigitsNumber() throws InterruptedException, DocumentException {
		registerFunc.verify8Digitlabel();
	}

	@And("^Your last name as shown on the bill$")
	public void LabelLastName() throws InterruptedException, DocumentException {
		registerFunc.verifyLastNameLabel();
	}

	@And("^Your email address$")
	public void LabelEmail() throws InterruptedException, DocumentException {
		registerFunc.verifyEmailLabel();
	}

	// SSR-926 >> Tell the customer a verification email has been sent to them

	// Test1 >> Verify verification Email Send Message to Customer registration page

	@Given("^I am on online SouthernWater Customer Registration Page$")
	public void AccessingCustomerRegPage() throws InterruptedException, DocumentException, Exception {
		registerFunc.openRegistrationPage();
	}

	@When("^An email for verification send to me$")
	public void EmailSendToMe() {

	}

	@Then("^I am able to see the message to check the email on Customer Registration page.$")
	public void EmailSendMessage() {

	}

	// SSR-926 >> SSR-960 >> Confirm account has been successfully
	// registered/activated

	// Test1 >> Verify activation message after clicking on verification email

	@Given("^I have the Email Verification Link$")
	public void OpenEmailForVerficationLinks() {

	}

	@When("^I Click on verification email before 48 hours$")
	public void ClickOnVerificationLinkBefore48() {

	}

	@Then("^I should move to new page$")
	public void OpenNewPage() {

	}

	@And("^I am able to see that my account successful registered/activated$")
	public void AccountActivatedMessage() {

	}

	@And("^I am able to login$")
	public void AbleToLogin() {

	}

	// Test2 >> Verification Link Expire After 48 hours

	@Given("^I have the Account Verification Link in mail$")
	public void HavingAccountVerifcationLink() {

	}

	@When("^I Click on verification email after 48 hours$")
	public void ClickOnVerificationLinkAftere48() {

	}

	@Then("^I am at online Register page$")
	public void OpenRegistrationPage() {

	}

	// Test cases
	@Given("^I am at online Register Web page$")
	public void SouthernWaterWebPortal() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@When("^I Check Terms & Condition$")
	public void OpenCustomerWebRegistrationPage() throws Exception {
		registerFunc.clickTermsAndConditionCheckBox();
		// webDriver.

	}

	@And("^Click on Start$")
	public void Click_on_Start() throws Exception {
		registerFunc.clickStart();
	}

	@And("^Enter on Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
	public void EnterCustomerDatialsInfields(String CustomerNumber, String LastName, String Email)
			throws InterruptedException, IOException, DocumentException {
		registerFunc.enterCustomerDetials(CustomerNumber, LastName, Email);
	}

	@And("^Click on Continue link$")
	public void ClickOnContinue() throws Exception {
		registerFunc.continueClick();
	}

	@Then("^I Can see Name$")
	public void ICanSeeName() throws InterruptedException, DocumentException {
		registerFunc.verifyCustomerDetail();

	}

	@And("^Email$")
	public void Email() throws InterruptedException, DocumentException {
		registerFunc.verifyEmail();

	}

	@And("^Customer Number$")
	public void Customer_Number() throws InterruptedException, DocumentException {
		registerFunc.verifyCustomerNumber();

	}

	@And("^Address$")
	public void Address() throws InterruptedException, DocumentException {
		registerFunc.verifyAddress();

	}

	// Test Cases

	@Given("^I am at Your Details step in Online Registration$")
	public void YourDetailsRegsitrationPage() throws Exception {

		registerFunc.openRegistrationPage();

		registerFunc.clickTermsAndConditionCheckBox();

		registerFunc.clickStart();

		registerFunc.yourDetailStepIsOpen();

	}

	@When("^Enter Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
	public void EnterCustomerDetailsOnRegistration(String CustomerNumber, String LastName, String Email)
			throws InterruptedException, IOException, DocumentException {
		registerFunc.enterCustomerDetials(CustomerNumber, LastName, Email);
	}

	@And("^Click Continue$")
	public void ClickContinueButton() throws Exception {
		registerFunc.continueClick();
	}

	@And("^Click on back Button of Check Details$")
	public void ClickBackButton() throws Exception {
		registerFunc.backButtonClick();
	}

	@Then("^I should move to Your Details$")
	public void MovedBackToYourDetials() throws InterruptedException, DocumentException {
		registerFunc.yourDetailStepIsOpen();

	}

	// Test Cases

	@Given("^I am Accessing Online Regisration Page$")
	public void AccessingOnlineRegistrationPage() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@And("^Check Terms and Condition$")
	public void CheckTermsAndConditionCheckBox() throws Exception {
		registerFunc.clickTermsAndConditionCheckBox();
	}

	@And("^Click Start$")
	public void ClickStartButtonLinkOnWeb() throws Exception {
		registerFunc.clickStart();
		webDriver.WaitforPageToBeReady();
		registerFunc.yourDetailStepIsOpen();
	}

	@And("^Enter detail Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
	public void EnterCustomerDetail(String CustomerNumber, String LastName, String Email)
			throws InterruptedException, IOException, DocumentException {
		registerFunc.enterCustomerDetials(CustomerNumber, LastName, Email);
	}

	@And("^Click Continue Button link$")
	public void ClickContinueButtonLink() throws Exception {
		registerFunc.continueClick();
	}

	@When("^I Click Back Button of Check Detials Step$")
	public void ClickBackButtonCheckDetails() throws Exception {
		registerFunc.backButtonClick();
	}

	@And("^I Update the New Email ([^\"]*)$")
	public void UpdateNewEmail(String NewEmail) throws InterruptedException, DocumentException, IOException {
		registerFunc.enterEmailID(NewEmail);

	}

	@And("^Click on again on Continue link$")
	public void ClickAgainContinueButtonLink() throws Exception {
		registerFunc.continueClick();
	}

	@Then("^I Can see Updated Emails$")
	public void UpdatedEmails() throws Exception {
		registerFunc.verifyUpdatedEmail();
	}

	// Test
	@Given("^I am Login Details Page after Entering Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*) and ([^\"]*)$")
	public void OpenLoginDetailPage(String CustomerNumber, String LastName, String Email, String Password)
			throws Exception {

		registerFunc.openRegistrationPage();

		registerFunc.clickTermsAndConditionCheckBox();

		registerFunc.clickStart();

		webDriver.WaitforPageToBeReady();

		registerFunc.yourDetailStepIsOpen();

		registerFunc.enterCustomerDetials(CustomerNumber, LastName, Email);

		registerFunc.continueClick();

		registerFunc.confirmContinueClick();

		registerFunc.enterPassword(Password);

	}

	@And("^I Select First Security Question ([^\"]*) and Answer ([^\"]*)$")
	public void SelectFirstSecurityQuestioAndAnswer(String firstQuestion, String firstAnswer)
			throws InterruptedException, IOException, DocumentException {
		registerFunc.firstQuestionAnswer(firstQuestion, firstAnswer);
	}

	@When("^I want to Select Second Security Question ([^\"]*) same as in First Security Question$")
	public void SelectSameSecurityQuestion(String firstQuestion) {
		registerFunc.trySelectFirstQuestionInSecondQuestion(firstQuestion);
	}

	@Then("^I Can not See First Secuirty Question Option in Security Question Options$")
	public void FirstSelectedSecuirtyQuestionNotFoundinSecond() throws InterruptedException, DocumentException {
		registerFunc.firstQuestionNotvisibleInSecondQuestionAfterSelection();

	}

	// Test

	@Given("^I have open the Online Registration Link$")
	public void IHaveOpenRegistrationPage() throws Exception {
		registerFunc.openRegistrationPage();
	}

	@When("^I agree  Terms and Condition$")
	public void I_AgreeTesrAndConditions() throws Exception {
		registerFunc.clickTermsAndConditionCheckBox();
	}

	@And("^I Click Start$")
	public void IClickStartButtonOnWebPage() throws Exception {
		registerFunc.clickStart();

	}

	@And("^Enter My Detail Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
	public void EnterMyCustomerDetail(String CustName, String LastName, String CustEmailID) throws Exception {
		Thread.sleep(4000);
		webDriver.WaitforPageToBeReady();
		registerFunc.yourDetailStepIsOpen();
		enteredEmailID = CustEmailID;
		registerFunc.enterCustomerDetials(CustName, LastName, CustEmailID);

	}

	@And("^Click Continue Button Present on Screen$")
	public void ClickContinueButtonOnPage() throws InterruptedException, DocumentException, Exception {
		registerFunc.continueClick();
	}

	@And("^Click Confirm and Continue$")
	public void ClickOnConfirmContinue() throws InterruptedException, DocumentException, Exception {
		registerFunc.confirmContinueClick();
	}

	@And("^Set Password as ([^\"]*)$")
	public void SetPassword(String Password) throws InterruptedException, IOException, DocumentException {
		registerFunc.enterPassword(Password);
	}

	@And("^First Security Question ([^\"]*) and Answer ([^\"]*)$")
	public void SetFirstQuestionAnswer(String firstQuestion, String firstAnswer)
			throws InterruptedException, DocumentException, IOException {
		registerFunc.firstQuestionAnswer(firstQuestion, firstAnswer);
	}

	@And("^Second Security Question ([^\"]*) and Answer ([^\"]*)$")
	public void SetSecondQuestionAnswer(String secondQuestion, String secondAnswer)
			throws InterruptedException, DocumentException, IOException {
		registerFunc.secondQuestionAnswer(secondQuestion, secondAnswer);
	}

	@And("^Click on Login Detail Continue Button$")
	public void ClickContinueOnPasswordPage() throws InterruptedException, DocumentException, Exception {
		// registerFunc.ContinueClickPassword();
	}

	@Then("^I Can See Activation Mail send on my EmailID$")
	public void ActivationMailSendMessage() throws Exception {
		// registerFunc.ActivationMailMessageVerify();
	}

	// New Functions

	@And("^I should see the Mandatory Field Message on Register Now Step$")
	public void i_should_see_the_Mandatory_Field_Message_on_Register_Now_Step() throws Throwable {
		registerFunc.mandatoryFieldMessages("RegisterNow");
	}

	@And("^I agree Terms and Condition$")
	public void i_agree_Terms_and_Condition() throws Throwable {
		registerFunc.clickTermsAndConditionCheckBox();
	}

	@And("^Enter My Detail Customer Number ([^\"]*)$")
	public void enter_My_Detail_Customer_Number_test(String custNumb) throws Throwable {
		registerFunc.enterCustomerNumner(custNumb);
	}

	@And("^I should see the Mandatory Field Message on Your Details Step$")
	public void i_should_see_the_Mandatory_Field_Message_on_Your_Details_Step() throws Throwable {
		registerFunc.mandatoryFieldMessages("YourDetail");
	}

	@And("^I Enter Details as Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
	public void i_Enter_Details_as_Customer_Number_Last_Name_Email(String custID, String LName, String email)
			throws Throwable {
		registerFunc.enterCustomerDetials(custID, LName, email);
	}

	@And("^Click on Login Detail Continue Button Without input$")
	public void click_on_Login_Detail_Continue_Button_Without_input() throws Throwable {
		registerFunc.continueClickPassword();

	}
	@Given("^I should see the Mandatory Field Message on Login Details Step$")
	public void i_should_see_the_Mandatory_Field_Message_on_Login_Details_Step() throws Throwable {
		registerFunc.mandatoryFieldMessages("LoginDetail");
	}
	
	@When("^I Enter Password ([^\"]*)$")
	public void i_Enter_Password_Apple(String Password) throws Throwable {
		registerFunc.enterPassword(Password);
	}

	@Then("^I Should not see any Mandatory Error Message$")
	public void i_Should_not_see_any_Mandatory_Error_Message() throws Throwable {
		registerFunc.mandatoryFieldMessagesGone("LoginDetail");
	}
	
	@Given("^I am Login Detail page Using ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
	public void i_am_Login_Detail_page_Using_Last_Name_Email(String CustomerNumber, String  LastName, String Email) throws Throwable 
	{
		registerFunc.openRegistrationPage();

		registerFunc.clickTermsAndConditionCheckBox();

		registerFunc.clickStart();

		webDriver.WaitforPageToBeReady();

		registerFunc.yourDetailStepIsOpen();

		registerFunc.enterCustomerDetials(CustomerNumber, LastName, Email);

		registerFunc.continueClick();

		registerFunc.confirmContinueClick();  
	}

	@And("^I Click Back Button$")
	public void i_Click_Back_Button() throws Throwable {
		registerFunc.commonBackRegistration();
	}
	
	@And("^I Move to Check and Confirm Step$")
	public void i_Move_to_Check_and_Confirm_Step() throws Throwable {
		registerFunc.checkAndConfirmOpen();
	}
	
	@And("^I Should move to Your Details Step$")
	public void i_Should_move_to_Your_Details_Step() throws Throwable {
		registerFunc.yourDetailStepIsOpen();
	}
}
