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
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;


public class PayBillPageHelper 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	PropertyReader prpertyreader = new PropertyReader();
		public PayBillPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
			
		}
		
		public PayBillPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			
		}
		
		//Test 1 >> Check the SouthernWater App Access//
		
		@Given("^I am on SouthernWater Pay Bill page$") 
		public void SouthernWaterPayBill() throws Exception
		{
			Thread.sleep(5000);
			ClickOnAcceptCokies();
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			//webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
		}
		
		@When("^I Click on Start$") 
		public void ClickOnStart() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
			
		}
		
		@Then("^I move to customer details page") 
		public void Verify_PayBillPage() throws InterruptedException, DocumentException
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/YourDetailHeading")), "Your details");
		}
		
		@And("^Back link is also available") 
		public void Verify_BackButon() throws InterruptedException, DocumentException
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")), "Back");
		}
		
		//Test2 >> Verify Pay Bill Back Button Functionality//
		
		@Given("^I am on SouthernWater Pay Bill detail Page$") 
		public void IAmSouthernWaterPayBillDetail() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			//Thread.sleep(5000);
			ClickOnAcceptCokies();
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I Click on Back Button$") 
		public void ClickOnBackButton() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
			webDriver.WaitforPageToBeReady();	
		}
				
		@Then("^I moved to Pay Detail Main Page") 
		public void TermPage() throws DocumentException, Exception
		{
			System.out.println("Then Body");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));				
		}
		
		//Test3 >> Verify Question Mark ToolTip //
		
		@Given("^I am on SouthernWater PayBill detail Page$") 
		public void SouthernWaterBillPay() throws Exception
		{
			Thread.sleep(5000);
				
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			//webDriver.WaitforPageToBeReady();
			//ClickOnAcceptCokies();
			System.out.println(prpertyreader.readproperty("PayBill"));
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
			
		}
						
		@When("^I Click First Time on Question Mark Icons$") 
		public void ClickQuestionIconFirst() throws Exception
		{
			
			webDriver.WaitforPageToBeReady();
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipIcon"));
			do
			{
				webDriver.Clickon(elements.get(0));
				elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipIcon"));
			}while(elements.size()>0);
		}
						
		@Then("^I Can see the Suggestion Message") 
		public void SuugestionMessageAppear() throws InterruptedException, DocumentException
		{
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipMessage"));
			WebElement ele=null;	
			for(int i=0;i<elements.size();i++)
			{
				ele=elements.get(i);
				if(i==0)
					webDriver.VerifyText(ele, "Your 8 or 10 digit customer number is in the top right corner of any letters or emails you have received from us.");
				else if(i==1)
					webDriver.VerifyText(ele, "Your 13 digit payment reference is in the top right corner of any bills you have received from us. Please enter it without any spaces between the digits.");
				else if(i==2)
					webDriver.VerifyText(ele, "Please enter this information exactly as it appears on any letters or emails you have received from us. If more than one person is responsible for the charges, please enter the last name of the first customer shown on any letters or emails you have from us.");
			}
					
			
		}
		
		@When("^I Click Second Time on Question Mark Icons$") 
		public void ClickQuestionIconSecond() throws Exception
		{
			
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ActiveToolTip"));
			do
			{
				webDriver.Clickon(elements.get(0));
				elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ActiveToolTip"));
			}while(elements.size()>0);
		}
						
		@Then("^I Suggestion Message should hide") 
		public void SuugestionMessageDisAppear() throws InterruptedException, DocumentException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipMessage"));
			flag=elements.isEmpty()?true:false;
			Assert.assertTrue(flag, "Error Removed");			
		}
		
		//Test4 >> Verify Question Mark ToolTip //
		
		@Given("^I am on SouthernWater Pay Bill page detail Page$") 
		public void SouthernWaterPayBillDetail() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			//webDriver.WaitforPageToBeReady();
			//ClickOnAcceptCokies();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
		
		@When("^I Click on Continue$") 
		public void ClickOnContinueLink() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Should see the mandatory field Error Message") 
		public void MandatoryMessage() throws InterruptedException, DocumentException
		{
			System.out.println("Then Body");
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/IncorrectInputMsg")), "You’ll need to correct the errors to continue.");
		}
		
		//Test5 >> Check the error message for Incorrect Data //
		
		@Given("^I am on SouthernWater Pay Bill with mandatory field error$") 
		public void SouthernWaterPayErrorMessage() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			//webDriver.WaitforPageToBeReady();
			//ClickOnAcceptCokies();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I enter all details$") 
		public void EnteringDetails() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/IncorrectInputMsg")), "You’ll need to correct the errors to continue.");
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), "1234567890"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), "1234567891234"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")), "BDDTest"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), "BDD@Test.com"+Keys.TAB);
			System.out.println("Then Body");
			Thread.sleep(12000);
			System.out.println("Then Body");
		}
			
		@And("^I click on Continue$")
		public void ClickOnContinue() throws InterruptedException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
		}
		
		@Then("^I Should see the error Message for incorrect Data") 
		public void IncorrectDataMessage() throws InterruptedException, DocumentException
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/ErrorMessage")), "There’s a problem");			
		}
		
		
		//Test6 >> Check the error message removed after entering mandatory field //
		@Given("I am on SouthernWater Pay Bill with mandatory field error message$") 
		public void SouthernWaterPayMandatroyMessage() throws Exception
		{
			
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			//webDriver.WaitforPageToBeReady();
			//ClickOnAcceptCokies();
			System.out.println(prpertyreader.readproperty("PayBill"));
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I enter all details in form$") 
		public void EnteringDetailsInForms() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/IncorrectInputMsg")), "You’ll need to correct the errors to continue.");
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), "1234567890"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), "1234567891234"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")), "BDDTest"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), "BDD@Test.com"+Keys.TAB);
			System.out.println("Then Body");
			Thread.sleep(12000);
			System.out.println("Then Body");
			
		}
			
		@Then("^I Should not see the error Message for mandatory fields$") 
		public void MandatoryErrorMessageRemoved() throws InterruptedException, DocumentException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ErrorMessage"));
			flag=elements.isEmpty()?true:false;
			Assert.assertTrue(flag, "Error Removed");
					
		}
		
		
		//Test
		
		@Given("^I am Accesing Pay Bill Detail Page$")
		public void AccessingPayBillPage() throws IOException, InterruptedException
		{
			Thread.sleep(5000);
			//ClickOnAcceptCokies();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
		}
		
		@And("^I Click Start Button on Page$")
		public void StartButtonofPage() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
		
		@And("^I Enter Details Customer Number ([^\"]*) Payment Reference ([^\"]*) Last Name ([^\"]*) EmailID ([^\"]*)$")
		public void IEnterCustDetailWithPaymentRef(String CustomerNumber,String PaymentRef,String LastName,String Email) throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), CustomerNumber+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), PaymentRef+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")), LastName+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), Email+Keys.TAB);
		}
		
		@And("^I Click On Continue Button on Detail Step$")
		public void ContinueButtonofDetailStep() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
			Thread.sleep(5000);
		}
		
		@And("^I Click on Continue Button of Check Detail Step")
		public void ContinueCheckDetailPage() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/DetailsContinue")));
			Thread.sleep(5000);
		}
		
		@And("I Select Pay another Amount")
		public void SelectPayAnotherAmount() throws Exception
		{
			webDriver.SafeJavaScriptClick(webDriver.getwebelement(payBillLoct.getlocator("//locators/AnotherAmount")));
			webDriver.WaitforPageToBeReady();
		}
		
		@And("^I Enter Partial Amount([^\"]*)$")
		public void EnterPartialAmount(String amount) throws Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/EnterAmount")), amount+Keys.TAB);
		}
		
		@And("^I Click on Make Payment$")
		public void ClickMakePayment() throws InterruptedException, DocumentException, Exception
		{
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/MakePayment")));
			Thread.sleep(5000);
		}
		
		@When("^I Enter Card Detail ([^\"]*) Name ([^\"]*) Expiry Month ([^\"]*) Expiry Year ([^\"]*)  and SecurityCode ([^\"]*)$")
		public void EnterPaymentCardDetails(String CardNumber, String NameOnCard, String ExpiryMonth,String ExpiryYear, String code) throws InterruptedException, IOException, DocumentException 
		{
			webDriver.switchtofram(webDriver.getwebelement("//iframe[@id='wp-cl-custom-html-iframe']"));
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CardNumber")), CardNumber+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/CardHolderName")), NameOnCard+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/ExpiryMonth")), ExpiryMonth+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/ExpiryYear")), ExpiryYear+Keys.TAB);
			webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator("//locators/SecurityCode")), code+Keys.TAB);
			
		}
		
		@And("^I Click on Pay Now on Make Payment Step$")
		public void ClickPayNow() throws Exception
		{
			//webDriver.switchtofram(webDriver.getwebelement("//iframe[@id='wp-cl-custom-html-iframe']"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Pay")));
			
			Thread.sleep(5000);
			webDriver.switchtodefault();
		}
		
		@Then("^I Can see Payment Confirmation Message$")
		public void PyamentConfirmationMessage() throws DocumentException, InterruptedException
		{
			Assert.assertTrue(webDriver.IsPresent(payBillLoct.getlocator("//locators/ConfirmationMessage")),"Payment Confirmation Message not found");
		}
		
		@And("^Thankyou Message$")
		public void ThankyouMessage() throws DocumentException, InterruptedException
		{
			Assert.assertTrue(webDriver.IsPresent(payBillLoct.getlocator("//locators/ThankYou")),"Payment Confirmation Message not found");
		}
		
		@And("^Transaction with Transaction Number$")
		public void TransactionMessage() throws DocumentException, InterruptedException
		{
			Assert.assertTrue(webDriver.IsPresent(payBillLoct.getlocator("//locators/PaymentReceipt")),"Payment Receipt Message not found");
			
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
			WebElement ele=elements.get(0);
			
			String text=ele.getText();
			System.out.println(text);
			Assert.assertTrue(text.equals("Transaction number"), "Transaction number Label Not found");
			
			elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
			ele=elements.get(0);
			
			text=ele.getText();
			System.out.println(text);
			Assert.assertTrue(text!=null, "Transaction number value not found");
		}
		
		@And("Payment Reference With Reference Number")
		public void PaymentReferenceNumber() throws InterruptedException, DocumentException
		{
			
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
			WebElement ele=elements.get(1);
			
			String text=ele.getText();
			System.out.println(text);
			Assert.assertTrue(text.equals("Payment reference"), "Payment reference Label Not found");
			
			elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
			Assert.assertTrue(elements.size()==3, "Error in Payment detail Values");
			
			ele=elements.get(1);
			text=ele.getText();
			System.out.println(text);
			Assert.assertTrue(text!=null, "Payment reference value not found");
		}
		
		@And("Same Amount ([^\"]*) as I Pay")
		public void AmountVerification(String Amount) throws InterruptedException, DocumentException
		{
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
			WebElement ele=elements.get(2);
			
			String text=ele.getText();
			System.out.println(text);
			//softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
			Assert.assertTrue(text.equals("Amount paid"), "Payment reference Label Not found");
			
			elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
			ele=elements.get(2);
			
			text=ele.getText();
			System.out.println(text);
			Assert.assertTrue(text.contains(Amount), "Entered Amount not matched with reciept amount");
		}
		
		public void ClickOnAcceptCokies()
		{
			try
			{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		
		
		
		
		
		/*public void clickonQuestionMarks() throws Exception
		{
			List<WebElement> elements=webDriver.getwebelements("(//span[@class='fas fa-question-circle tooltip-icon active'])[1]");
			do
			{
				 WebElement we = elements.get(1);
				 webDriver.Clickon(we);
				 elements=webDriver.getwebelements("(//span[@class='fas fa-question-circle tooltip-icon active'])[1]");
			}while(elements.size()>0);
			
		}*/
		
}