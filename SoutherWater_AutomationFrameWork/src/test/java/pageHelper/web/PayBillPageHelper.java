
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
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
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
			
		}
		
		@When("^I Click on Start$") 
		public void ClickOnStart() throws Exception
		{
			
			payFunc.PayUnAuthBillStart();
		}
		
		@Then("^I move to customer details page") 
		public void Verify_PayBillPage() throws InterruptedException, DocumentException
		{
			payFunc.YourDetailsSteps();
		}
		
		@And("^Back link is also available") 
		public void Verify_BackButon() throws InterruptedException, DocumentException
		{
			payFunc.VerifyBackButton();
		}
		
		//Test2 >> Verify Pay Bill Back Button Functionality//
		
		@Given("^I am on SouthernWater Pay Bill detail Page$") 
		public void IAmSouthernWaterPayBillDetail() throws Exception
		{
			payFunc.AccessUnauthPayBillPage();
			payFunc.PayUnAuthBillStart();
		}
				
		@When("^I Click on Back Button$") 
		public void ClickOnBackButton() throws Exception
		{
			payFunc.ClickBackButton();
		}
				
		@Then("^I moved to Pay Detail Main Page") 
		public void MovedToPayBillMainPage() throws DocumentException, Exception
		{
			payFunc.MainPageVerification();		
		}
		
		//Test3 >> Verify Question Mark ToolTip //
		
		@Given("^I am on SouthernWater PayBill detail Page$") 
		public void SouthernWaterBillPay() throws Exception
		{
			payFunc.AccessUnauthPayBillPage();
			payFunc.PayUnAuthBillStart();
			
		}
						
		@When("^I Click First Time on Question Mark Icons$") 
		public void ClickQuestionIconFirst() throws Exception
		{
			payFunc.ClickQuestionmarkFirst();
		}
						
		@Then("^I Can see the Suggestion Message") 
		public void SuugestionMessageAppear() throws InterruptedException, DocumentException
		{
			payFunc.QuestionMarkMessages();	
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
			payFunc.AccessUnauthPayBillPage();
			payFunc.PayUnAuthBillStart();
		}
		
		@When("^I Click on Continue$") 
		public void ClickOnContinueLink() throws Exception
		{
			payFunc.ClickContinue();
		}
		
		@Then("^I Should see the mandatory field Error Message") 
		public void MandatoryMessage() throws InterruptedException, DocumentException
		{
			payFunc.MandatoryFieldMessage();
		}
		
		//Test5 >> Check the error message for Incorrect Data //
		
		@Given("^I am on SouthernWater Pay Bill on Your Detail Step$") 
		public void SouthernWaterPayErrorMessage() throws Exception
		{
			payFunc.AccessUnauthPayBillPage();
			payFunc.PayUnAuthBillStart();
		}
				
		@When("^I enter all details$") 
		public void EnteringDetails() throws Exception
		{
			payFunc.EnterYourDetails("1234567890","1234567891234","BDDTest","BDD@Test.com");
		}
			
		@And("^I click on Continue$")
		public void ClickOnContinue() throws InterruptedException, Exception
		{
			payFunc.ClickContinue();
		}
		
		@Then("^I Should see the error Message for incorrect Data") 
		public void IncorrectDataMessage() throws InterruptedException, DocumentException
		{
			payFunc.IncorrectDateMessage();			
		}
		
		
		//Test6 >> Check the error message removed after entering mandatory field //
		@Given("I am on SouthernWater Pay Bill with mandatory field error message$") 
		public void SouthernWaterPayMandatroyMessage() throws Exception
		{
			payFunc.AccessUnauthPayBillPage();
			payFunc.PayUnAuthBillStart();
			payFunc.ClickContinue();
			
		}
				
		@When("^I enter all details in form$") 
		public void EnteringDetailsInForms() throws Exception
		{
			payFunc.EnterYourDetails("1234567890","1234567891234","BDDTest","BDD@Test.com");
			
		}
			
		@Then("^I Should not see the error Message for mandatory fields$") 
		public void MandatoryErrorMessageRemoved() throws InterruptedException, DocumentException
		{
			payFunc.MandatoryFieldMessageShouldnotVisible();
					
		}
		
		//Test
		
		@Given("^I am Accesing Pay Bill Detail Page$")
		public void AccessingPayBillPage() throws IOException, InterruptedException
		{
			payFunc.AccessUnauthPayBillPage();
			
		}
		
		@And("^I Click Start Button on Page$")
		public void StartButtonofPage() throws Exception
		{
			payFunc.PayUnAuthBillStart();
		}
		
		@And("^I Enter Details Customer Number ([^\"]*) Payment Reference ([^\"]*) Last Name ([^\"]*) EmailID ([^\"]*)$")
		public void IEnterCustDetailWithPaymentRef(String CustomerNumber,String PaymentRef,String LastName,String Email) throws Exception
		{
			payFunc.EnterYourDetails(CustomerNumber,PaymentRef,LastName,Email);
		}
		
		@And("^I Click On Continue Button on Detail Step$")
		public void ContinueButtonofDetailStep() throws Exception
		{
			payFunc.ClickContinue();
			
		}
		
		@And("^I Click on Continue Button of Check Detail Step")
		public void ContinueCheckDetailPage() throws Exception
		{
			payFunc.ClickCheckDetailContinue();
		}
		
		@And("I Select Pay another Amount")
		public void SelectPayAnotherAmount() throws Exception
		{
			payFunc.SelectAnotherAmount();
		}
		
		@And("^I Enter Partial Amount([^\"]*)$")
		public void EnterPartialAmount(String amount) throws Exception
		{
			payFunc.EnterAmount(amount);
		}
		
		@And("^I Click on Make Payment$")
		public void ClickMakePayment() throws InterruptedException, DocumentException, Exception
		{
			payFunc.ClickMakePayment();
		}
		
		@When("^I Enter Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*)  and SecurityCode ([^\"]*)$")
		public void EnterPaymentCardDetails(String CardNumber, String NameOnCard, String ExpiryMonth,String ExpiryYear, String code) throws InterruptedException, IOException, DocumentException 
		{
			
			payFunc.EnterPaymentDetails(CardNumber,NameOnCard,ExpiryMonth,ExpiryYear,code);
		}
		
		@And("^I Click on Pay Now on Make Payment Step$")
		public void ClickPayNow() throws Exception
		{
			payFunc.ClickPayNowButton();
		}
		
		@Then("^I Can see Payment Confirmation Message$")
		public void PyamentConfirmationMessage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyPaymentConfirmation();
		}
		
		@And("^Thankyou Message$")
		public void ThankyouMessage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyThankYouMessage();
		}
		
		@And("^Transaction with Transaction Number$")
		public void TransactionMessage() throws DocumentException, InterruptedException
		{
			payFunc.TranSactionMessageConfirmation();
		}
		
		@And("Payment Reference With Reference Number")
		public void PaymentReferenceNumber() throws InterruptedException, DocumentException
		{
			
			payFunc.PaymentReferenceVerification();
		}
		
		@And("Same Amount ([^\"]*) as I Pay")
		public void AmountVerification(String Amount) throws InterruptedException, DocumentException
		{
			payFunc.VerifyPaidAmount(Amount);
		}
		
		
		//Test Full Amount 
		@Given("^I have Open Pay Bill Detail Page$")
		public void IHaveOpenPayBillPage() throws IOException, InterruptedException
		{
			payFunc.AccessUnauthPayBillPage();
		}
		
		@And("^I Click Start Link on Page$")
		public void i_Click_Start_Link_on_Page() throws Exception
		{
			payFunc.PayUnAuthBillStart();
		}
		
		@And("^I enter my details Customer Number ([^\"]*) Payment Reference ([^\"]*) Last Name ([^\"]*) EmailID ([^\"]*)$")
		public void IEnterMyCustDetailWithPaymentRef(String CustomerNumber,String PaymentRef,String LastName,String Email) throws Exception
		{
			payFunc.EnterYourDetails(CustomerNumber,PaymentRef,LastName,Email);
		}
		
		@And("^I Click On Continue link on Detail Step$")
		public void ContinueLinnkButtonofDetailStep() throws Exception
		{
			payFunc.ClickContinue();
		}
		
		@And("^I Click on Continue link of Check Detail Step")
		public void ContinueLinkButtonCheckDetailPage() throws Exception
		{
			payFunc.ClickCheckDetailContinue();
		}
		
		@And("I Select Pay Full Amount")
		public void SelectPayFulllAmount() throws Exception
		{
			payFunc.SelectFullAmount();
		}
		
		
		@And("^I Click on Make Payment Link$")
		public void ClickMakePaymentLink() throws InterruptedException, DocumentException, Exception
		{
			payFunc.ClickMakePayment();
		}
		
		@When("^I Enter Payment Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*)  and SecurityCode ([^\"]*)$")
		public void IEnterPaymentCardDetails(String CardNumber, String NameOnCard, String ExpiryMonth,String ExpiryYear, String code) throws InterruptedException, IOException, DocumentException 
		{
			payFunc.EnterPaymentDetails(CardNumber,NameOnCard,ExpiryMonth,ExpiryYear,code);
		}
		
		@And("^I Click on Pay Now Button on Make Payment Step$")
		public void ClickPayNowtoMakePayment() throws Exception
		{
			payFunc.ClickPayNowButton();
		}
		
		@Then("^I Can see Payment Confirmation Message on Page$")
		public void PyamentConfirmationMessagePage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyPaymentConfirmation();
		}
		
		@And("^Thankyou Message on Page$")
		public void ThankyouMessageOnPage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyThankYouMessage();
		}
		
		@And("^Transaction with Transaction Number on Receipt$")
		public void TransactionMessageOnPage() throws DocumentException, InterruptedException
		{
			payFunc.TranSactionMessageConfirmation();
		}
		
		@And("Payment Reference With Reference Number on Receipt")
		public void Payment_Reference_With_Reference_Number_On_Receipt() throws InterruptedException, DocumentException
		{
			
			payFunc.PaymentReferenceVerification();
		}
		
		@And("Same Amount as I Pay on Receipt")
		public void AmountVerificationPage() throws InterruptedException, DocumentException
		{
			payFunc.VerifyFullAmountonReciept();	
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
			payFunc.SelectAnotherAmount();
		}
		
		@And("^I Enter Amount as ([^\"]*)$")
		public void EnterPartialAmountForPayment(String amount) throws Exception
		{
			payFunc.EnterAmount(amount);
		}
		
		@And("^I Click on Make Payment Link on Page$")
		public void MakePaymentLink() throws Exception
		{
			payFunc.ClickMakePayment();
		}
		
		@When("^I Fill Payment Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*) and SecurityCode ([^\"]*)$")
		public void EnterPaymentcardDetails(String CardNumber, String NameOnCard, String Month, String Year, String Code) throws InterruptedException, IOException, DocumentException
		{
			payFunc.EnterPaymentDetails(CardNumber,NameOnCard,Month,Year,Code);
		}
		
		@And("^I Click on Pay Now Button on Make Payment Step on Portal$")
		public void IClickPayNowOnMakePayment() throws InterruptedException, DocumentException, Exception
		{
			payFunc.ClickPayNowButton();
		}
		
		@Then("^I Can see Payment Confirmation Message on Portal$")
		public void PaymentConfirmationMessages() throws DocumentException, InterruptedException
		{
			payFunc.VerifyPaymentConfirmation();
		}
		
		@And("^I Can See Thankyou Message on Portal$")
		public void PaymentThankyouMessage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyThankYouMessage();
		}
		
		@And("^I Can See Transaction with Transaction Number on Portal$")
		public void PaymentTransactionMessageOnPortal() throws DocumentException, InterruptedException
		{
			payFunc.TranSactionMessageConfirmation();
		}
		
		@And("^I Can See Payment Reference With Reference Number on Portal$")
		public void PaymentReferenceMessageOnPortal() throws InterruptedException, DocumentException
		{
			payFunc.PaymentReferenceVerification();
		}
		
		@And("^I Can See Same Amount as ([^\"]*) I Pay on Portal$")
		public void PaymentAmountVerificationOnPortal(String partialAmount) throws InterruptedException, DocumentException
		{
			payFunc.VerifyPaidAmount(partialAmount);
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
			payFunc.SelectFullAmount();
		}
		
		@And("^I Click on Make Payment Link on Portal$")
		public void IClickMakePaymentLinkOnPage() throws InterruptedException, DocumentException, Exception
		{
			payFunc.ClickMakePayment();
		}
		
		@When("^I Fill Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear> and SecurityCode <SecureCode>$")
		public void FillPaymentCardDetails(String CardNumber, String NameOnCard, String Month, String Year, String Code) throws InterruptedException, IOException, DocumentException
		{
			payFunc.EnterPaymentDetails(CardNumber,NameOnCard,Month,Year,Code);
		}
		
		@And("^I Click on Pay Now Link on Make Payment Step on Portal$")
		public void IClickPayNowWithCardDetails() throws Exception
		{
			payFunc.ClickPayNowButton();
		}
		
		@Then("^I Should see Payment Confirmation Message$")
		public void IShouldSeePaymentConfirmationMessageOnPage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyPaymentConfirmation();
		}
		
		@And("^I Should See Thankyou Message$")
		public void ICanSeeThankyouMessage() throws DocumentException, InterruptedException
		{
			payFunc.VerifyThankYouMessage();
		}
		
		@And("^I Should See Transaction with Transaction$")
		public void IShouldSeeTransactionMessages() throws DocumentException, InterruptedException
		{
			payFunc.TranSactionMessageConfirmation();
		}
		
		@And("^I Should See Payment Reference With Reference$")
		public void IShouldSeePaymentReference() throws InterruptedException, DocumentException
		{
			payFunc.PaymentReferenceVerification();
		}
		
		@And("^I Should See Payment Amount as I Pay on Portal$")
		public void IShouldSeePaymentAmountVerification() throws InterruptedException, DocumentException
		{
			payFunc.VerifyFullAmountonReciept();
		}
}
