
package pageHelper.web;
import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import core.apiHelper;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import pageFunctions.web.PayBillFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;


public class PayBillPageHelper 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public PayBillFunctions payFunc;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	String dueAmount;
	
		public PayBillPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			payFunc=new PayBillFunctions(webDriver);
			System.out.println("First Constructor");
			
		}
		
		public PayBillPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			payFunc=new PayBillFunctions(webDriver);
		}
		
		//Test 1 >> Check the SouthernWater App Access//
		
		@Given("^I am on SouthernWater Pay Bill page$") 
		public void SouthernWaterPayBill() throws Exception
		{
			payFunc.acessUnauthPayBillPage();
		}
		
		@When("^I Click on Start$") 
		public void ClickOnStart() throws Exception
		{
			
			payFunc.payUnAuthBillStart();
		}
		
		@Then("^I move to customer details page") 
		public void Verify_PayBillPage() throws InterruptedException, DocumentException
		{
			payFunc.yourDetailsSteps();
		}
		
		@And("^Back link is also available") 
		public void Verify_BackButon() throws InterruptedException, DocumentException
		{
			payFunc.verifyBackButton();
		}
		
		//Test2 >> Verify Pay Bill Back Button Functionality//
		
		@Given("^I am on SouthernWater Pay Bill detail Page$") 
		public void IAmSouthernWaterPayBillDetail() throws Exception
		{
			payFunc.acessUnauthPayBillPage();
			payFunc.payUnAuthBillStart();
		}
				
		@When("^I Click on Back Button$") 
		public void ClickOnBackButton() throws Exception
		{
			payFunc.clickBackButton();
		}
				
		@Then("^I moved to Pay Detail Main Page") 
		public void MovedToPayBillMainPage() throws DocumentException, Exception
		{
			payFunc.mainPageVerification();		
		}
		
		//Test3 >> Verify Question Mark ToolTip //
		
		@Given("^I am on SouthernWater PayBill detail Page$") 
		public void SouthernWaterBillPay() throws Exception
		{
			payFunc.acessUnauthPayBillPage();
			payFunc.payUnAuthBillStart();
			
		}
						
		@When("^I Click First Time on Question Mark Icons$") 
		public void ClickQuestionIconFirst() throws Exception
		{
			payFunc.clickQuestionmarkFirst();
		}
						
		@Then("^I Can see the Suggestion Message") 
		public void SuugestionMessageAppear() throws InterruptedException, DocumentException
		{
			payFunc.questionMarkMessages();	
		}
		
		@When("^I Click Second Time on Question Mark Icons$") 
		public void ClickQuestionIconSecond() throws Exception
		{
			payFunc.ClickQuestionmarkSecond();
		}
						
		@Then("^I Suggestion Message should hide") 
		public void SuugestionMessageDisAppear() throws InterruptedException, DocumentException
		{
			payFunc.verifyMessageShouldnotvisible();
		}
		
		//Test4 >> Verify Question Mark ToolTip //
		
		@Given("^I am on SouthernWater Pay Bill page detail Page$") 
		public void SouthernWaterPayBillDetail() throws Exception
		{
			payFunc.acessUnauthPayBillPage();
			payFunc.payUnAuthBillStart();
		}
		
		@When("^I Click on Continue of Pay Bill Detail Page$") 
		public void When_I_Click_on_Continue_of_Pay_Bill_Detail_Page() throws Exception
		{
			payFunc.payBillDetailClickContinue();
		}
		
		
		@Then("^I Should see the mandatory field Error Message") 
		public void MandatoryMessage() throws InterruptedException, DocumentException
		{
			payFunc.mandatoryFieldMessage();
		}
		
		//Test5 >> Check the error message for Incorrect Data //
		
		@Given("^I am on SouthernWater Pay Bill on Your Detail Step$") 
		public void SouthernWaterPayErrorMessage() throws Exception
		{
			payFunc.acessUnauthPayBillPage();
			payFunc.payUnAuthBillStart();
		}
				
		@When("^I enter all details$") 
		public void EnteringDetails() throws Exception
		{
			payFunc.enterYourDetails("1234567890","1234567891234","BDDTest","BDD@Test.com");
		}
			
		@And("^I click on Continue on Detail page$")
		public void I_click_on_Continue_on_Detail_page() throws InterruptedException, Exception
		{
			payFunc.payBillDetailClickContinue();
		}
		
		@Then("^I Should see the error Message for incorrect Data") 
		public void IncorrectDataMessage() throws InterruptedException, DocumentException
		{
			payFunc.incorrectDateMessage();			
		}
		
		
		//Test6 >> Check the error message removed after entering mandatory field //
		@Given("I am on SouthernWater Pay Bill with mandatory field error message$") 
		public void SouthernWaterPayMandatroyMessage() throws Exception
		{
			payFunc.acessUnauthPayBillPage();
			payFunc.payUnAuthBillStart();
			payFunc.payBillDetailClickContinue();
			
		}
				
		@When("^I enter all details in form$") 
		public void EnteringDetailsInForms() throws Exception
		{
			payFunc.enterYourDetails("1234567890","1234567891234","BDDTest","BDD@Test.com");
			
		}
			
		@Then("^I Should not see the error Message for mandatory fields$") 
		public void MandatoryErrorMessageRemoved() throws InterruptedException, DocumentException
		{
			payFunc.mandatoryFieldMessageShouldnotVisible();
					
		}
		
		//Test
		
		@Given("^I am Accesing Pay Bill Detail Page$")
		public void AccessingPayBillPage() throws IOException, InterruptedException
		{
			payFunc.acessUnauthPayBillPage();
			
		}
		
		@And("^I Click Start Button on Page$")
		public void StartButtonofPage() throws Exception
		{
			payFunc.payUnAuthBillStart();
		}
		
		@And("^I Enter Details Customer Number ([^\"]*) Payment Reference ([^\"]*) Last Name ([^\"]*) EmailID ([^\"]*)$")
		public void IEnterCustDetailWithPaymentRef(String CustomerNumber,String PaymentRef,String LastName,String Email) throws Exception
		{
			payFunc.enterYourDetails(CustomerNumber,PaymentRef,LastName,Email);
		}
		
		@And("^I Click On Continue Button on Detail Step$")
		public void ContinueButtonofDetailStep() throws Exception
		{
			payFunc.payBillDetailClickContinue();
			
		}
		
		@And("^I Click on Continue Button of Check Detail Step")
		public void And_I_Click_on_Continue_Button_of_Check_Detail_Step() throws Exception
		{
			payFunc.clickCheckDetailContinue();
		}
		
		@And("I Select Pay another Amount")
		public void SelectPayAnotherAmount() throws Exception
		{
			payFunc.selectAnotherAmount();
		}
		
		@And("^I Enter Partial Amount([^\"]*)$")
		public void EnterPartialAmount(String amount) throws Exception
		{
			payFunc.enterAmount(amount);
		}
		
		@And("^I Click on Make Payment$")
		public void ClickMakePayment() throws InterruptedException, DocumentException, Exception
		{
			payFunc.clickMakePayment();
		}
		
		@When("^I Enter Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*)  and SecurityCode ([^\"]*)$")
		public void EnterPaymentCardDetails(String CardNumber, String NameOnCard, String ExpiryMonth,String ExpiryYear, String code) throws InterruptedException, IOException, DocumentException 
		{
			
			payFunc.enterPaymentDetails(CardNumber,NameOnCard,ExpiryMonth,ExpiryYear,code);
		}
		
		@And("^I Click on Pay Now on Make Payment Step$")
		public void ClickPayNow() throws Exception
		{
			payFunc.clickPayNowButton();
		}
		
		@Then("^I Can see Payment Confirmation Message$")
		public void PyamentConfirmationMessage() throws DocumentException, InterruptedException
		{
			payFunc.verifyPaymentConfirmation();
		}
		
		@And("^Thankyou Message$")
		public void ThankyouMessage() throws DocumentException, InterruptedException
		{
			payFunc.verifyThankYouMessage();
		}
		
		@And("^Transaction with Transaction Number$")
		public void TransactionMessage() throws DocumentException, InterruptedException
		{
			payFunc.tranSactionMessageConfirmation();
		}
		
		@And("Payment Reference With Reference Number")
		public void PaymentReferenceNumber() throws InterruptedException, DocumentException
		{
			
			payFunc.paymentReferenceVerification();
		}
		
		@And("Same Amount ([^\"]*) as I Pay")
		public void AmountVerification(String Amount) throws InterruptedException, DocumentException
		{
			payFunc.verifyPaidAmount(Amount);
		}
		
		
		//Test Full Amount 
		@Given("^I have Open Pay Bill Detail Page$")
		public void IHaveOpenPayBillPage() throws IOException, InterruptedException
		{
			payFunc.acessUnauthPayBillPage();
		}
		
		@And("^I Click Start Link on Page$")
		public void i_Click_Start_Link_on_Page() throws Exception
		{
			payFunc.payUnAuthBillStart();
		}
		
		@And("^I enter my details Customer Number ([^\"]*) Payment Reference ([^\"]*) Last Name ([^\"]*) EmailID ([^\"]*)$")
		public void IEnterMyCustDetailWithPaymentRef(String CustomerNumber,String PaymentRef,String LastName,String Email) throws Exception
		{
			payFunc.enterYourDetails(CustomerNumber,PaymentRef,LastName,Email);
		}
		
		@And("^I Click On Continue link on Detail Step$")
		public void And_I_Click_On_Continue_link_on_Detail_Step() throws Exception
		{
			payFunc.payBillDetailClickContinue();
		}
		
		@And("^I Click on Continue link of Check Detail Step")
		public void And_I_Click_on_Continue_link_of_Check_Detail_Step() throws Exception
		{
			payFunc.clickCheckDetailContinue();
		}
		
		@And("I Select Pay Full Amount")
		public void SelectPayFulllAmount() throws Exception
		{
			payFunc.selectFullAmount();
		}
		
		
		@And("^I Click on Make Payment Link$")
		public void ClickMakePaymentLink() throws InterruptedException, DocumentException, Exception
		{
			payFunc.clickMakePayment();
		}
		
		@When("^I Enter Payment Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*)  and SecurityCode ([^\"]*)$")
		public void IEnterPaymentCardDetails(String CardNumber, String NameOnCard, String ExpiryMonth,String ExpiryYear, String code) throws InterruptedException, IOException, DocumentException 
		{
			payFunc.enterPaymentDetails(CardNumber,NameOnCard,ExpiryMonth,ExpiryYear,code);
		}
		
		@And("^I Click on Pay Now Button on Make Payment Step$")
		public void ClickPayNowtoMakePayment() throws Exception
		{
			payFunc.clickPayNowButton();
		}
		
		@Then("^I Can see Payment Confirmation Message on Page$")
		public void PyamentConfirmationMessagePage() throws DocumentException, InterruptedException
		{
			payFunc.verifyPaymentConfirmation();
		}
		
		@And("^Thankyou Message on Page$")
		public void ThankyouMessageOnPage() throws DocumentException, InterruptedException
		{
			payFunc.verifyThankYouMessage();
		}
		
		@And("^Transaction with Transaction Number on Receipt$")
		public void TransactionMessageOnPage() throws DocumentException, InterruptedException
		{
			payFunc.tranSactionMessageConfirmation();
		}
		
		@And("Payment Reference With Reference Number on Receipt")
		public void Payment_Reference_With_Reference_Number_On_Receipt() throws InterruptedException, DocumentException
		{
			
			payFunc.paymentReferenceVerification();
		}
		
		@And("Same Amount as I Pay on Receipt")
		public void AmountVerificationPage() throws InterruptedException, DocumentException
		{
			payFunc.verifyFullAmountonReciept();	
		}
		
		
		//Scenario Outline: As a Registered user I Can Pay Partial Amount of My Bill
		
		
		@Given("^I Login with my Login Credentials as Email ([^\"]*) and Password ([^\"]*)$")
		public void LoginWithYouAccountCredentials(String Email, String Password) throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),Email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),Password);
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();	
			Thread.sleep(5000);
		}
		
		@And("I Click On Make Payment from Dashboard")
		public void MakePaymentFromDashBoard() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginMakeaPayment")));
			Thread.sleep(5000);
		}
		
		@And("I Click Select Pay Another Amount Option")
		public void SelectPayAnotherAmountOption() throws Exception
		{
			payFunc.selectAnotherAmount();
		}
		
		@And("^I Enter Amount as ([^\"]*)$")
		public void EnterPartialAmountForPayment(String amount) throws Exception
		{
			payFunc.enterAmount(amount);
		}
		
		@And("^I Click on Make Payment Link on Page$")
		public void MakePaymentLink() throws Exception
		{
			payFunc.clickMakePayment();
		}
		
		@When("^I Fill Payment Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*) and SecurityCode ([^\"]*)$")
		public void EnterPaymentcardDetails(String CardNumber, String NameOnCard, String Month, String Year, String Code) throws InterruptedException, IOException, DocumentException
		{
			payFunc.enterPaymentDetails(CardNumber,NameOnCard,Month,Year,Code);
		}
		
		
		@And("^I Click on Pay Now Button on Make Payment$")
		public void i_Click_on_Pay_Now_Button_on_Make_Payment() throws Throwable 
		{
			payFunc.clickPayNowButton();
		}    
		
		@Then("^I Can see Payment Confirmation Message on Portal$")
		public void PaymentConfirmationMessages() throws DocumentException, InterruptedException
		{
			payFunc.verifyPaymentConfirmation();
		}
		
		@And("^I Can See Thankyou Message on Portal$")
		public void PaymentThankyouMessage() throws DocumentException, InterruptedException
		{
			payFunc.verifyThankYouMessage();
		}
		
		@And("^I Can See Transaction with Transaction Number on Portal$")
		public void PaymentTransactionMessageOnPortal() throws DocumentException, InterruptedException
		{
			payFunc.tranSactionMessageConfirmation();
		}
		
		@And("^I Can See Payment Reference With Reference Number on Portal$")
		public void PaymentReferenceMessageOnPortal() throws InterruptedException, DocumentException
		{
			payFunc.paymentReferenceVerification();
		}
		
		@And("^I Can See Same Amount as ([^\"]*) I Pay on Portal$")
		public void PaymentAmountVerificationOnPortal(String partialAmount) throws InterruptedException, DocumentException
		{
			payFunc.verifyPaidAmount(partialAmount);
		}
		
		
		//Scenario Outline: As a Registered user I Can Pay Full Amount of My Bill
		
		@Given("^I have Login with my Login Credentials as Email ([^\"]*) and Password ([^\"]*)$")
		public void IhaveLoginWithValidCredentials(String Email, String Password) throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),Email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),Password);
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();	
			Thread.sleep(5000);
		}
		
		@And("^I Click On Make Payment on Dashboard$")
		public void DashBoardMakePayment() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginMakeaPayment")));
			Thread.sleep(5000);
		}
		
		@And("^I Click Select Pay Full Amount Option$")
		public void SelectPayFullAmountRadio() throws Exception
		{
			payFunc.selectFullAmount();
		}
		
		@And("^I Click on Make Payment Link on Portal$")
		public void IClickMakePaymentLinkOnPage() throws InterruptedException, DocumentException, Exception
		{
			payFunc.clickMakePayment();
		}
		
		@When("^I Fill Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear> and SecurityCode <SecureCode>$")
		public void FillPaymentCardDetails(String CardNumber, String NameOnCard, String Month, String Year, String Code) throws InterruptedException, IOException, DocumentException
		{
			payFunc.enterPaymentDetails(CardNumber,NameOnCard,Month,Year,Code);
		}
		
		@And("^I Click on Pay Now Link on Make Payment Step on Portal$")
		public void IClickPayNowWithCardDetails() throws Exception
		{
			payFunc.clickPayNowButton();
		}
		
		@Then("^I Should see Payment Confirmation Message$")
		public void IShouldSeePaymentConfirmationMessageOnPage() throws DocumentException, InterruptedException
		{
			payFunc.verifyPaymentConfirmation();
		}
		
		@And("^I Should See Thankyou Message$")
		public void ICanSeeThankyouMessage() throws DocumentException, InterruptedException
		{
			payFunc.verifyThankYouMessage();
		}
		
		@And("^I Should See Transaction with Transaction$")
		public void IShouldSeeTransactionMessages() throws DocumentException, InterruptedException
		{
			payFunc.tranSactionMessageConfirmation();
		}
		
		@And("^I Should See Payment Reference With Reference$")
		public void IShouldSeePaymentReference() throws InterruptedException, DocumentException
		{
			payFunc.paymentReferenceVerification();
		}
		
		@And("^I Should See Payment Amount as I Pay on Portal$")
		public void IShouldSeePaymentAmountVerification() throws InterruptedException, DocumentException
		{
			payFunc.verifyFullAmountonReciept();
		}
		
		//New
		
		@Given("^I have Open The SouthernWater UnAuth Pay Bill Page$")
		public void i_have_Open_The_SouthernWater_UnAuth_Pay_Bill_Page() throws Throwable {
		   
			payFunc.acessUnauthPayBillPage();
		}

		@Given("^I already Click on Start Button$")
		public void i_already_Click_on_Start_Button() throws Throwable 
		{
			payFunc.payUnAuthBillStart();
		}

		@When("^I Perform Click Action on Continue Button of Pay Bill Detail Page$")
		public void i_Perform_Click_Action_on_Continue_Button_of_Pay_Bill_Detail_Page() throws Throwable 
		{
			payFunc.payBillDetailClickContinue();
		}

		@Then("^I am not able to Proceed & System throw the mandatory field Error Message$")
		public void i_am_not_able_to_Proceed_System_throw_the_mandatory_field_Error_Message() throws Throwable 
		{
			payFunc.mandatoryFieldMessage();
		}
		
		@And("^I Do Click Action on Continue Button of Pay Bill Detail Page$")
		public void i_Do_Click_Action_on_Continue_Button_of_Pay_Bill_Detail_Page() throws Throwable {
			payFunc.payBillDetailClickContinue();
		}
		@And("^I Do Click Action on Continue Button of Check Detail Step$")
		public void i_Do_Click_Action_on_Continue_Button_of_Check_Detail_Step() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			payFunc.clickCheckDetailContinue();
		}
}
