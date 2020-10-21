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
		
		
		//Test1
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
		
		//Test2
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
		
		//Test3
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

		//Test4
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
		
		//Test5
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
						
		@Then("^Agree Terms & Conditions Error message should remove from both location$")
		public void AcceptTermMessageVerificationRemoved() throws InterruptedException, DocumentException
		{
									
			List<WebElement> elements1=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageFirst"));
			boolean flag1=elements1.isEmpty()?true:false;
			Assert.assertTrue(flag1, "First Accpet Terms and Conditions is not removed");	
					
			List<WebElement> elements2=webDriver.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageSecond"));
			boolean flag2=elements2.isEmpty()?true:false;
			Assert.assertTrue(flag2, "Second Accpet Terms and Conditions is not removed");				
		}	
		
}
