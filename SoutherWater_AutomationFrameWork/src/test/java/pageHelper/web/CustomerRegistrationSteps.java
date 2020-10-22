package pageHelper.web;
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

public class CustomerRegistrationSteps 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	PropertyReader prpertyreader = new PropertyReader();
		public CustomerRegistrationSteps(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
		}
		
		public CustomerRegistrationSteps(bddDriver contextSteps) throws Exception {
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			

		}
		
		@When("^I open Customer Registration Page$")
		public void OpenCustomerRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");

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
			List<WebElement> elements=webDriver.getwebelements(custRegist.getlocator("//locators/TermsAndConditionLink"));
			flag=elements.size()>0?true:false;
			Assert.assertTrue(flag, "Terms and Conditions Link not Present");
		}
		
		//Test2 >> Verify that the Terms & Condition page is for customer
		
		@Given("^I am at online Customer Registration Page$")
		public void OpenOnlieCustomerRegistrationPage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");
		}
		
		@When("^I Click on term & condition link$")
		public void ClickTermsAndConditions() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/TermsAndConditionsLink")));
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/TermsAndConditionsLink")));
			webDriver.WaitforPageToBeReady();
			
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");
					
		}
		
		@When("^I Click on Close button$")
		public void ClickTermsAndConditionsClose() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(custRegist.getlocator("//locators/TermsAndConditionClose")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I should move to Customer Registration Page$")
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
					
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");					
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
							
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");
					
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
		}
						
		@Then("^Agree Terms & Conditions Error message should remove from both locations$")
		public void AcceptTermMessageVerificationRemoved() throws InterruptedException, DocumentException
		{
									
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			
		}
		
		
		@When("^I Access Customer Registration Page$")
		public void AccessingCustomerRegistrationPage() throws Exception
		{
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
							
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");
		}
		
		@Then("^I am able to see 'It should only take a few minutes'$")
		public void LabelItShouldOnlyTakeAFewMinutes() throws InterruptedException, DocumentException
		{
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/ItShouldTakeLabel"));
			boolean exist=elements2.size()>0?true:false;
			Assert.assertTrue(exist, "It should only take a few minutes");		
		}
		
		@And("^Your customer number. This is the 8-digit number shown on the top right of your bill$")
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			
			webDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
			Thread.sleep(5000);
							
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Register");
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
				
		@Then("^I should Error message for linked is expired$")
		public void LinkExpiredMessage()
		{
					
		}
				
				
}
