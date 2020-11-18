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
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class CustomerRegistrationPageHelper
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public String enteredName,  enteredCustomerNumber, enteredEmailID,newEmail, firstSecurityQuest;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	PropertyReader prpertyreader = new PropertyReader();
	
		public CustomerRegistrationPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
		}
		
		public CustomerRegistrationPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		}	
		
		
		//SSR-502 >> Agree terms and conditions
		//Test1 >>Verify Terms and Condition on Customer Registration Page 
		
		@Given("^I am at SouthernWater web portal$")
		public void SouthernWaterPortal() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			

		}
		
		@When("^I open Customer Registration Page$")
		public void OpenCustomerRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");

		}
		
		@Then("^I am able to see Terms & Conditions Check Box$")
		public void VerifyTermsAndConditionCheckbox() throws InterruptedException, DocumentException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/AgreeTermsCheckBox"));
			flag=elements.size()>0?true:false;
			Assert.assertTrue(flag, "Agree CheckBox not Found");
		}
		
		@And("^Hyperlink for Terms & Conditions$")
		public void VerifyTermsAndConditionLink() throws InterruptedException, DocumentException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/TermsAndConditionsLink"));
			flag=elements.size()>0?true:false;
			Assert.assertTrue(flag, "Terms and Conditions Link not Present");
		}
		
		//Test2 >> Verify that the Terms & Condition page is for customer
		
		@Given("^I am at online Customer Registration Page$")
		public void OpenOnlieCustomerRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");
		}
		
		@When("^I Click on term & condition link$")
		public void ClickTermsAndConditions() throws Exception
		{
			String locator=custRegist.getlocator("//locators/TermsAndConditionsLink");
			System.out.println(locator);
			Thread.sleep(5000);
			webDriver.Moveon(webDriver.getwebelement(locator));
			//List<WebElement> list=webDriver.getwebelements(locator);
			//System.out.println(list.size());
			//webDriver.SafeJavaScriptClick(webDriver.getwebelement(locator));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Should move to Terms & Conditions Page$")
		public void VerifyTermsAndConditionPageOpen() throws InterruptedException, DocumentException
		{
			
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/TermsAndCondtionHeading"));
			boolean flag1=elements1.size()>0?true:false;
			
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/ImportantNotice"));
			boolean flag2=elements2.size()>0?true:false;
			
			List<WebElement> elements3=webDriver.getwebelements(custRegist.getlocator("//locators/Definations"));
			boolean flag3=elements3.size()>0?true:false;
			
			List<WebElement> elements4=webDriver.getwebelements(custRegist.getlocator("//locators/PaperLessBilling"));
			boolean flag4=elements4.size()>0?true:false;
			
			List<WebElement> elements5=webDriver.getwebelements(custRegist.getlocator("//locators/TermsAndConditionClose"));
			boolean flag5=elements5.size()>0?true:false;
			Assert.assertTrue(flag1&&flag2&&flag3&&flag4&&flag5, "Terms And Condition page Not Open");
			
		}
		
		//Test3 >> Verify that the Terms & Condition Close button should navigate Customer Registration Page
		
		@Given("^I am on SW on Terms & Condition page$")
		public void TermAndConditionPagesOpened() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/TermsAndConditionsLink")));
			webDriver.WaitforPageToBeReady();
			
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");
					
		}
		@And("^I can See the Close Button$")
		public void CloseButtonVisible() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			//webDriver.IsPresent((custRegist.getlocator("//locators/TermsAndConditionClose")));
			Assert.assertTrue(webDriver.IsPresent((custRegist.getlocator("//locators/TermsAndConditionClose"))), "Close button not found");
		}
		
		@And("^I Click on Close button$")
		public void ClickTermsAndConditionsClose() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/TermsAndConditionClose")));
			webDriver.WaitforPageToBeReady();
		}
		
		@And("^I should move to Customer Registration Page$")
		public void VerifyRegistrationPageOpen() throws InterruptedException, DocumentException
		{
					
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/RegisterNow"));
			boolean flag1=elements1.size()>0?true:false;
			Assert.assertTrue(flag1, "Customer Registration Page Not Opened");			
		}		

		//Test4 >> Verify Agree Terms & Condition is mandatory 
		
		@Given("^Customer Registration Page is open$")
		public void CustomerRegistrationPageIsOpen() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
					
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");					
		}
		
		@When("^I click on Start button without agree Terms & Conditions$")
		public void ClickStartWithoutAgreeTerms() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
				
		@Then("^I should see the error message for agree Terms & Conditions$")
		public void AcceptTermFirstMessageVerification() throws InterruptedException, DocumentException
		{
							
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageFirst"));
			boolean flag1=elements1.size()>0?true:false;
			Assert.assertTrue(flag1, "First Accpet Terms and Conditions Message Not found");			
		}
		
		@And("^Second at below the Terms & Condition line$")
		public void AcceptTermSecondMessageVerification() throws InterruptedException, DocumentException
		{
							
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageSecond"));
			boolean flag1=elements1.size()>0?true:false;
			Assert.assertTrue(flag1, "Second Accpet Terms and Conditions Message Not found");			
		}
		
		//Test5 >> Verify Agree Terms & Condition is mandatory should remove after checking agree Terms & Condition 
		
		@Given("^Customer Registration Page is open and having Terms & Condition error on page$")
		public void CustomerRegistrationPageIsOpenWithTermErrorMessage() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
							
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");
					
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
					
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageFirst"));
			boolean flag1=elements1.size()>0?true:false;
			Assert.assertTrue(flag1, "First Accpet Terms and Conditions Message Not found");	
					
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageSecond"));
			boolean flag2=elements2.size()>0?true:false;
			Assert.assertTrue(flag2, "Second Accpet Terms and Conditions Message Not found");		
									
		}
		
		@When("^I Click checkbox against Terms & Conditions$")
		public void ClickTermsConditionCheckBox() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
		}
						
		@Then("^Agree Terms & Conditions Error message should remove from both locations$")
		public void AcceptTermMessageVerificationRemoved() throws InterruptedException, DocumentException
		{
			Thread.sleep(5000);						
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageFirst"));
			boolean flag1=elements1.isEmpty()?true:false;
			Assert.assertTrue(flag1, "First Accpet Terms and Conditions is not removed");	
					
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageSecond"));
			boolean flag2=elements2.isEmpty()?true:false;
			Assert.assertTrue(flag2, "Second Accpet Terms and Conditions is not removed");				
		}	
		

		//Test6 >> Verify Your Privacy Link Functionality
		
		@Given("^I am on Customer Registration Page$")
		public void OpeningCustomerRegPage() throws InterruptedException, DocumentException, Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");
		}
		
		@When("^I Click Your Privacy Link$")
		public void ClickOnPrivacyLink() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/PrivacyLink")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Should move to Privacy Page$")
		public void VerifyPrivacyPage()
		{
			webDriver.VerifyTitle("Privacy - protecting and respecting your privacy");
		}

		
		//SSR-444 >> Tell the user what information they will need at the start of the register account journey
		
		//Test1 >> Verify field details message on customer registration page
		
		@Given("^I am on online SouthernWater Portal page$")
		public void AccessingSouthernWaterWebPortal() throws InterruptedException, DocumentException, Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			
		}
		
		
		@When("^I Access Customer Registration Page$")
		public void AccessingCustomerRegistrationPage() throws Exception
		{
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
							
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");
		}
		
		@Then("^I am able to see It should only take a few minutes$")
		public void LabelItShouldOnlyTakeAFewMinutes() throws InterruptedException, DocumentException
		{
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/ItShouldTakeLabel"));
			boolean exist=elements2.size()>0?true:false;
			Assert.assertTrue(exist, "It should only take a few minutes");		
		}
		
		@And("^Your customer number This is the 8-digit number shown on the top right of your bill$")
		public void Label8DigitsNumber() throws InterruptedException, DocumentException
		{
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/EightDigitLabel"));
			boolean exist=elements2.size()>0?true:false;
			Assert.assertTrue(exist, "Your customer number. This is the 8 digit number shown on the top right of your bill. ");		
		}
		
		@And("^Your last name as shown on the bill$")
		public void LabelLastName() throws InterruptedException, DocumentException
		{
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/YourLastNameLabel"));
			boolean exist=elements2.size()>0?true:false;
			Assert.assertTrue(exist, "Your last name as shown on the bill. ");
		}
		
		@And("^Your email address$")
		public void LabelEmail() throws InterruptedException, DocumentException
		{
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/YourEmailLabel"));
			boolean exist=elements2.size()>0?true:false;
			Assert.assertTrue(exist, "Your email address. ");
		}

		//SSR-926 >> Tell the customer a verification email has been sent to them
		
		//Test1 >> Verify verification Email Send Message to Customer registration page
		
		@Given("^I am on online SouthernWater Customer Registration Page$")
		public void AccessingCustomerRegPage() throws InterruptedException, DocumentException, Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
							
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("My account");
		}
		
		@When("^An email for verification send to me$")
		public void EmailSendToMe()
		{
			
		}
		
		@Then("^I am able to see the message to check the email on Customer Registration page.$")
		public void EmailSendMessage()
		{
			
		}
		
		
		//SSR-926 >> SSR-960 >> Confirm account has been successfully registered/activated
		
		//Test1 >> Verify activation message after clicking on verification email
		
		@Given("^I have the Email Verification Link$")
		public void OpenEmailForVerficationLinks()
		{
			
		}
		
		@When("^I Click on verification email before 48 hours$")
		public void ClickOnVerificationLinkBefore48()
		{
			
		}
		
		@Then("^I should move to new page$")
		public void OpenNewPage()
		{
			
		}
		
		@And("^I am able to see that my account successful registered/activated$")
		public void AccountActivatedMessage()
		{
			
		}
		
		@And("^I am able to login$")
		public void AbleToLogin()
		{
			
		}
		
		
		//Test2 >> Verification Link Expire After 48 hours
		
		@Given("^I have the Account Verification Link in mail$")
		public void HavingAccountVerifcationLink()
		{
					
		}
				
		@When("^I Click on verification email after 48 hours$")
		public void ClickOnVerificationLinkAftere48()
		{
					
		}
				
		@Then("^I am at online Register page$")
		public void OpenRegistrationPage()
		{
					
		}
				
		// Test cases	
		@Given("^I am at online Register Web page$")
		public void SouthernWaterWebPortal() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);

		}
		
		@When("^I Check Terms & Condition$")
		public void OpenCustomerWebRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			//System.out.println(webDriver.GetTitle());
			//webDriver.VerifyTitle("Account");
			
			webDriver.SafeJavaScriptClick(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			//webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			webDriver.WaitforPageToBeReady();
			//webDriver.

		}
		
		@And("^Click on Start$")
		public void Click_on_Start() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
		
		@And("^Enter on Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
		public void EnterCustomerDatialsInfields(String CustomerNumber, String LastName, String Email ) throws InterruptedException, IOException, DocumentException
		{
			enteredName=LastName;
			enteredCustomerNumber=CustomerNumber;
			enteredEmailID=Email;
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),CustomerNumber);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/LastName")),LastName);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),Email);
		}
		
		@And("^Click on Continue link$")
		public void ClickOnContinue() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Can see Name$")
		public void ICanSeeName() throws InterruptedException, DocumentException
		{
			Thread.sleep(10000);
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
			WebElement ele=elements.get(0);
			String Text=ele.getText();
			Assert.assertTrue(Text.contains("Name"), "Name Lable Not Found on Check Detials");
			
			elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
			ele=elements.get(0);
			Text=ele.getText();
			Assert.assertTrue(Text.contains(enteredName), "Entered Name Not matched on Check Detail page");
					
		}
		
		@And("^Email$")
		public void Email() throws InterruptedException, DocumentException
		{
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
			WebElement ele=elements.get(1);
			String Text=ele.getText();
			Assert.assertTrue(Text.contains("Email address"), "Email Address Lable Not Found on Check Detials");
			
			elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
			ele=elements.get(1);
			Text=ele.getText();
			Assert.assertTrue(Text.contains(enteredEmailID), "Entered Email ID not matched on Check Detail page");
					
		}
		
		@And("^Customer Number$")
		public void Customer_Number() throws InterruptedException, DocumentException
		{
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
			WebElement ele=elements.get(2);
			String Text=ele.getText();
			Assert.assertTrue(Text.contains("Customer number"), "Customer number Lable Not Found on Check Detials");
			
			elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
			ele=elements.get(2);
			Text=ele.getText();
			Assert.assertTrue(Text.contains(enteredCustomerNumber), "Entered Customer number not matched on Check Detail page");
					
		}
		
		@And("^Address$")
		public void Address() throws InterruptedException, DocumentException
		{
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
			WebElement ele=elements.get(3);
			String Text=ele.getText();
			Assert.assertTrue(Text.contains("Address"), "Address Lable Not Found on Check Detials");
					
		}
		
		
		//Test Cases
		
		@Given("^I am at Your Details step in Online Registration$")
		public void YourDetailsRegsitrationPage() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			
			webDriver.SafeJavaScriptClick(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			//webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			webDriver.WaitforPageToBeReady();
			
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
			
			Assert.assertTrue(webDriver.IsPresent(custRegist.getlocator("//locators/YourDetails")),"Your Details Page is not open");

		}
		
		@When("^Enter Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
		public void EnterCustomerDetailsOnRegistration(String CustomerNumber, String LastName, String Email ) throws InterruptedException, IOException, DocumentException
		{
			enteredName=LastName;
			enteredCustomerNumber=CustomerNumber;
			enteredEmailID=Email;
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),CustomerNumber);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/LastName")),LastName);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),Email);
		}
		
		@And("^Click Continue$")
		public void ClickContinueButton() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
			webDriver.WaitforPageToBeReady();
		}
	
		@And("^Click on back Button of Check Details$")
		public void ClickBackButton() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Back")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I should move to Your Details$")
		public void MovedBackToYourDetials() throws InterruptedException, DocumentException
		{
			Thread.sleep(5000);
			Assert.assertTrue(webDriver.IsPresent(custRegist.getlocator("//locators/YourDetails")),"Your Details Page is not open");

		}
		
		//Test Cases
		
		@Given("^I am Accessing Online Regisration Page$")
		public void AccessingOnlineRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
		}
		
		@And("^Check Terms and Condition$")
		public void CheckTermsAndConditionCheckBox() throws Exception
		{
			webDriver.SafeJavaScriptClick(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			//webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			webDriver.WaitforPageToBeReady();
		}
				
		@And("^Click Start$")
		public void ClickStartButtonLinkOnWeb() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
			Assert.assertTrue(webDriver.IsPresent(custRegist.getlocator("//locators/YourDetails")),"Your Details Page is not open");
		}
				
		@And("^Enter detail Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$")
		public void EnterCustomerDetail(String CustomerNumber, String LastName, String Email ) throws InterruptedException, IOException, DocumentException
		{
			Thread.sleep(4000);
			enteredName=LastName;
			enteredCustomerNumber=CustomerNumber;
			enteredEmailID=Email;
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),CustomerNumber);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/LastName")),LastName);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),Email);
		}
				
		@And("^Click Continue Button link$")
		public void ClickContinueButtonLink() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I Click Back Button of Check Detials Step$")
		public void ClickBackButtonCheckDetails() throws Exception
		{
			Thread.sleep(4000);
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Back")));
			webDriver.WaitforPageToBeReady();
		}
				
		@And("^I Update the New Email ([^\"]*)$")
		public void UpdateNewEmail(String NewEmail) throws InterruptedException, DocumentException, IOException
		{
			newEmail=NewEmail;
			Thread.sleep(5000);
			webDriver.CleasrAndSendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),NewEmail+Keys.TAB);

		}
		
		@And("^Click on again on Continue link$")
		public void ClickAgainContinueButtonLink() throws Exception
		{
			Thread.sleep(4000);
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
			webDriver.WaitforPageToBeReady();
		}
				
		@Then("^I Can see Updated Emails$")
		public void UpdatedEmails() throws Exception
		{
			Thread.sleep(4000);
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
			WebElement ele=elements.get(1);
			String Text=ele.getText();
			Assert.assertTrue(Text.contains("Email address"), "Email Address Lable Not Found on Check Detials");
					
			elements=webDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
			ele=elements.get(1);
			Text=ele.getText();
			Assert.assertTrue(Text.contains(newEmail), "Entered Email ID not matched on Check Detail page");
		}
		
		//Test
		 @Given("^I am Login Details Page after Entering Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*) and ([^\"]*)$")
		 public void OpenLoginDetailPage(String CustomerNumber, String LastName, String Email, String Password) throws Exception
		 {
			 Thread.sleep(5000);
			 //webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			 webDriver.WaitforPageToBeReady();
			 webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			 Thread.sleep(5000);
			 
			 webDriver.SafeJavaScriptClick(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			 webDriver.WaitforPageToBeReady();
			 
			 webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			 webDriver.WaitforPageToBeReady();
			 Assert.assertTrue(webDriver.IsPresent(custRegist.getlocator("//locators/YourDetails")),"Your Details Page is not open");
			 
			 Thread.sleep(4000);
			 webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),CustomerNumber);
			 webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/LastName")),LastName);
			 webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),Email);
			 
			 webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
			 webDriver.WaitforPageToBeReady();
			 
			 webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/ConfirmContinue")));
			 webDriver.WaitforPageToBeReady();
			 
			 Thread.sleep(4000);
			 webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/Password")),Password);
			 
		 }
		 
		 @And("^I Select First Security Question ([^\"]*) and Answer ([^\"]*)$")
		 public void SelectFirstSecurityQuestioAndAnswer(String firstQuestion, String firstAnswer ) throws InterruptedException, IOException, DocumentException
		 {
			 Select Question=new Select(webDriver.getwebelement(custRegist.getlocator("//locators/FirstQuestion")));
			 Question.selectByVisibleText(firstQuestion);
				
			 webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/FirstAnswer")),firstAnswer); 
		 }
		 
		 @When("^I want to Select Second Security Question ([^\"]*) same as in First Security Question$")
		 public void SelectSameSecurityQuestion(String firstQuestion)
		 {
			 firstSecurityQuest=firstQuestion;
			 try
			 {
				 Select Question=new Select(webDriver.getwebelement(custRegist.getlocator("//locators/SecondQuestion")));
				 Question.selectByVisibleText(firstQuestion);
			 }
			 catch(Exception ex)
			 { 
				System.out.println("Security Question : "+ firstQuestion + " not found"); 
			 }
		 }
		 @Then("^I Can not See First Secuirty Question Option in Security Question Options$")
		 public void FirstSelectedSecuirtyQuestionNotFoundinSecond() throws InterruptedException, DocumentException
		 {
			 Select Question=new Select(webDriver.getwebelement(custRegist.getlocator("//locators/SecondQuestion")));
			 List<WebElement> dd = Question.getOptions();
			 for (int j = 0; j < dd.size(); j++) 
			 {
			    String opt  =dd.get(j).getText();
			    System.out.println(opt);
			    Assert.assertTrue(opt!=firstSecurityQuest, "FirstSelected Security Question found in Second Security Question Options");
			 }

		 }
		
		//Test 
		
		@Given("^I have open the Online Registration Link$")
		public void IHaveOpenRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
		}
		 
		@When("^I agree  Terms and Condition$")
		public void I_AgreeTesrAndConditions() throws Exception
		{
			webDriver.SafeJavaScriptClick(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			//webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
			webDriver.WaitforPageToBeReady();
		}
		
		@And("^I Click Start$")
		public void IClickStartButtonOnWebPage() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
			Assert.assertTrue(webDriver.IsPresent(custRegist.getlocator("//locators/YourDetails")),"Your Details Page is not open");
		}
		
		@And("^Enter My Detail Customer Number ([^\"]*) Last Name ([^\"]*) Email ([^\"]*)$") 
		public void EnterMyCustomerDetail(String CustName, String LastName, String CustEmailID) throws InterruptedException, IOException, DocumentException
		{
			Thread.sleep(4000);
			enteredEmailID=CustEmailID;
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),CustName);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/LastName")),LastName);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),CustEmailID);
			
		}
		  
		@And("^Click Continue Button Present on Screen$")
		public void ClickContinueButtonOnPage() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
			webDriver.WaitforPageToBeReady();
		}
		  
		@And("^Click Confirm and Continue$")
		public void ClickOnConfirmContinue() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/ConfirmContinue")));
			webDriver.WaitforPageToBeReady();
		}
		
		@And("^Set Password as ([^\"]*)$")
		public void SetPassword(String Password ) throws InterruptedException, IOException, DocumentException
		{
			Thread.sleep(4000);
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/Password")),Password);
		}
		
		@And("^First Security Question ([^\"]*) and Answer ([^\"]*)$")
		public void SetFirstQuestionAnswer(String firstQuestion, String firstAnswer) throws InterruptedException, DocumentException, IOException
		{
			Select Question=new Select(webDriver.getwebelement(custRegist.getlocator("//locators/FirstQuestion")));
			Question.selectByVisibleText(firstQuestion);
			
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/FirstAnswer")),firstAnswer);
		}
		
		@And("^Second Security Question ([^\"]*) and Answer ([^\"]*)$")
		public void SetSecondQuestionAnswer(String secondQuestion, String secondAnswer) throws InterruptedException, DocumentException, IOException
		{
			Select Question=new Select(webDriver.getwebelement(custRegist.getlocator("//locators/SecondQuestion")));
			Question.selectByVisibleText(secondQuestion);
			
			webDriver.SendKeys(webDriver.getwebelement(custRegist.getlocator("//locators/SecondAnswer")),secondAnswer);
		}
		
		@And("^Click on Login Detail Continue Button$")
		public void ClickContinueOnPasswordPage() throws InterruptedException, DocumentException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/PasswordContinue")));
			webDriver.WaitforPageToBeReady();
		}
		    
		@Then("^I Can See Activation Mail send on my EmailID$")
		public void ActivationMailSendMessage() throws Exception 
		{
			Thread.sleep(15000);
			webDriver.WaitforPageToBeReady();
			
			Assert.assertTrue(webDriver.IsPresent((custRegist.getlocator("//locators/VerifyEmailMessage"))),"'Verify your email address' not depict on screen");
			
			List<WebElement> Messages=webDriver.getwebelements(custRegist.getlocator("//locators/VerifyEmailMessageList"));
			
			WebElement ele=Messages.get(0);
			String Text=ele.getText();
			Assert.assertTrue(Text.contains("We’ve sent you an email to"), "'We’ve sent you an email to ' message not found");
			Assert.assertTrue(Text.contains(enteredEmailID), "Entered Email '"+enteredEmailID+"' ID Not Matched in message not found");
			
			ele=Messages.get(1);
			Text=ele.getText();
			
			Assert.assertTrue(Text.contains("Click on the"), "'Click on the verification link in the email to complete your registration.' message not correct");
			Assert.assertTrue(Text.contains("verification link"), "'Click on the verification link in the email to complete your registration.' message not correct");
			Assert.assertTrue(Text.contains(" in the email to complete your registration."), "'Click on the verification link in the email to complete your registration.' message not correct");
			
			ele=Messages.get(2);
			Text=ele.getText();
			
			Assert.assertTrue(Text.contains("To protect your account, this link will expire after 48 hours."), "'To protect your account, this link will expire after 48 hours.' message not correct");
		}
}