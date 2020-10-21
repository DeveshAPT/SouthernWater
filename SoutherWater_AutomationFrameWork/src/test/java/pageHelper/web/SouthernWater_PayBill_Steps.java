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


public class SouthernWater_PayBill_Steps 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	PropertyReader prpertyreader = new PropertyReader();
		public SouthernWater_PayBill_Steps(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
			
		}
		
		public SouthernWater_PayBill_Steps(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
			
		}
		
		@Given("^I am on SouthernWater Pay Bill page$") 
		public void SouthernWaterPayBill() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
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
		
		@And("^Back link is also avialable") 
		public void Verify_BackButon() throws InterruptedException, DocumentException
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")), "Back");
		}
		
		//******** Second ******//
		
		@Given("^I am on SouthernWater PayBill detail Page$") 
		public void IAmSouthernWaterPayBillDetail() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			Thread.sleep(5000);
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I Click on Back Button$") 
		public void ClickOnBackButton() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
			webDriver.WaitforPageToBeReady();	
		}
				
		@Then("^I moved to Term page") 
		public void TermPage() throws DocumentException, Exception
		{
			System.out.println("Then Body");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));				
		}
		
		//******* Third ******* //
		
		@Given("^I am on SouthernWater Pay Bill page detail Page$") 
		public void SouthernWaterPayBillDetail() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
			webDriver.WaitforPageToBeReady();
		}
		
		@When("^I Click on Containue$") 
		public void ClickOnContainue() throws Exception
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
		
		// ***** Fourth ****** //
		
		@Given("^I am on SouthernWater Pay Bill with mandatory field error$") 
		public void SouthernWaterPayErrorMessage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
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
		
		
		// ***** Fifth ****** //
		@Given("I am on SouthernWater Pay Bill with mandatory field error message$") 
		public void SouthernWaterPayMandatroyMessage() throws Exception
		{
			
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			System.out.println(prpertyreader.readproperty("PayBill"));
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
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
			
		
		@Then("^I Should not see the error Message for mandatroy fields$") 
		public void MandatoryErrorMessageRemoved() throws InterruptedException, DocumentException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ErrorMessage"));
			flag=elements.isEmpty()?true:false;
			Assert.assertTrue(flag, "Error Removed");
					
		}
		
		//*** ****//
		@Given("^I am on SouthernWater Pay Bill detail Page$") 
		public void SouthernWaterBillPay() throws Exception
		{
			Thread.sleep(5000);
				webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			System.out.println(prpertyreader.readproperty("PayBill"));
			webDriver.OpenURL(prpertyreader.readproperty("PayBill"));
			Thread.sleep(5000);
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
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
						
		@Then("^I Can see the Suggestion Messsage") 
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
						
		@Then("^I Suggestion Messsage should hide") 
		public void SuugestionMessageDisAppear() throws InterruptedException, DocumentException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipMessage"));
			flag=elements.isEmpty()?true:false;
			Assert.assertTrue(flag, "Error Removed");			
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