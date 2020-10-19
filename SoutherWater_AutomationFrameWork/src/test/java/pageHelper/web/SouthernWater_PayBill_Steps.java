package pageHelper.web;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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


public class SouthernWater_PayBill_Steps 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	PropertyReader prpertyreader = new PropertyReader();
		public SouthernWater_PayBill_Steps(WebDriver driver) 
		{
			webDriver=new baseDriverHelper(driver);
			//System.out.println(prpertyreader.readproperty("PayBill"));
			//webDriver.OpenURL("https://www.southernwater.co.uk/pay-bill");
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
			webDriver.Clickon(webDriver.getwebelement("//button[@id='onetrust-accept-btn-handler']"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
		}
		
		@When("^I Click on Start$") 
		public void ClickOnStart() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Start']"));
			webDriver.WaitforPageToBeReady();
			
		}
		
		@Then("^I move to customer details page") 
		public void Verify_PayBillPage() throws InterruptedException
		{
			webDriver.VerifyText(webDriver.getwebelement("//h1[text()='Your details']"), "Your details");
			
		}
		
		@And("^Back link is also avialable") 
		public void Verify_BackButon() throws InterruptedException
		{
			webDriver.VerifyText(webDriver.getwebelement("//a[text()='Back']"), "Back");
			
		}
		
		//*** second test **** //
		
		@Given("^I am on SouthernWater PayBill detail Page$") 
		public void IAmSouthernWaterPayBillDetail() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement("//button[@id='onetrust-accept-btn-handler']"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Start']"));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I Click on Back Button$") 
		public void ClickOnBackButton() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Back']"));
			webDriver.WaitforPageToBeReady();
					
		}
				
		@Then("^I moved to Term page") 
		public void TermPage() throws InterruptedException
		{
			System.out.println("Then Body");
			webDriver.VerifyText(webDriver.getwebelement("//a[text()='Start']"), "Start");
							
		}
		
		
		//*** Third test **** //
		
		@Given("^I am on SouthernWater Pay Bill page detail Page$") 
		public void SouthernWaterPayBillDetail() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement("//button[@id='onetrust-accept-btn-handler']"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Start']"));
			webDriver.WaitforPageToBeReady();
		}
		
		@When("^I Click on Containue$") 
		public void ClickOnContainue() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//button[text()='Continue']"));
			webDriver.WaitforPageToBeReady();
			
		}
		
		@Then("^I Should see the mandatory field Error Message") 
		public void MandatoryMessage() throws InterruptedException
		{
			System.out.println("Then Body");
			webDriver.VerifyText(webDriver.getwebelement("//p[text()='You’ll need to correct the errors to continue.']"), "You’ll need to correct the errors to continue.");
			
		}
		
		//*** Fourth test **** //
		
		@Given("^I am on SouthernWater Pay Bill with mandatory field error$") 
		public void SouthernWaterPayErrorMessage() throws Exception
		{
			
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement("//button[@id='onetrust-accept-btn-handler']"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Start']"));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I enter all details$") 
		public void EnteringDetails() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//button[text()='Continue']"));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement("//p[text()='You’ll need to correct the errors to continue.']"), "You’ll need to correct the errors to continue.");
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerNumber']"), "1234567890"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerRefNumber']"), "1234567891234"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='inpName']"), "BDDTest"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='inpEmail']"), "BDD@Test.com"+Keys.TAB);
			
			System.out.println("Then Body");
			Thread.sleep(12000);
			System.out.println("Then Body");
			
		}
			
		@And("^I click on Continue$")
		public void ClickOnContinue() throws InterruptedException, Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//button[text()='Continue']"));
		}
		@Then("^I Should see the error Message for incorrect Data") 
		public void IncorrectDataMessage() throws InterruptedException
		{
			/*boolean flag=false; //div[@class='feedback-box__text'],There’s a problem
			List<WebElement> elements=webDriver.getwebelements("//div[@class='feedback-box mb-4 feedback-box--harley']");
			if(elements.isEmpty())
			{
				
		        flag= true;
		    } 
			else 
			{
				flag= false;
		    }
			Assert.assertTrue(flag, "Error Removed");*/
			webDriver.VerifyText(webDriver.getwebelement("//div[@class='feedback-box__text']"), "There’s a problem");
					
		}
		
		@Given("I am on SouthernWater Pay Bill with mandatory field error message$") 
		public void SouthernWaterPayMandatroyMessage() throws Exception
		{
			
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement("//button[@id='onetrust-accept-btn-handler']"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Start']"));
			webDriver.WaitforPageToBeReady();
		}
				
		@When("^I enter all details in form$") 
		public void EnteringDetailsInForms() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//button[text()='Continue']"));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement("//p[text()='You’ll need to correct the errors to continue.']"), "You’ll need to correct the errors to continue.");
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerNumber']"), "1234567890"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='customerRefNumber']"), "1234567891234"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='inpName']"), "BDDTest"+Keys.TAB);	
			webDriver.SendKeys(webDriver.getwebelement("//input[@id='inpEmail']"), "BDD@Test.com"+Keys.TAB);
			
			System.out.println("Then Body");
			Thread.sleep(12000);
			System.out.println("Then Body");
			
		}
			
		
		@Then("^I Should not see the error Message for mandatroy fields$") 
		public void MandatoryErrorMessageRemoved() throws InterruptedException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements("//div[@class='feedback-box__text']");
			if(elements.isEmpty())
			{
				
		        flag= true;
		    } 
			else 
			{
				flag= false;
		    }
			Assert.assertTrue(flag, "Error Removed");
			//webDriver.VerifyText(webDriver.getwebelement("//div[@class='feedback-box__text']"), "There’s a problem");
					
		}
		
		
		//*** Fourth test **** //
		
		@Given("^I am on SouthernWater Pay Bill detail Page$") 
		public void SouthernWaterBillPay() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement("//button[@id='onetrust-accept-btn-handler']"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Quick Pay - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			webDriver.Clickon(webDriver.getwebelement("//a[text()='Start']"));
			webDriver.WaitforPageToBeReady();
			
		}
						
		@When("^I Click First Time on Question Mark Icons$") 
		public void ClickQuestionIconFirst() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("(//span[@class='fas fa-question-circle tooltip-icon'])[1]"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement("(//span[@class='fas fa-question-circle tooltip-icon'])[1]"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement("//span[@class='fas fa-question-circle tooltip-icon']"));
			webDriver.WaitforPageToBeReady();
					/*List<WebElement> elements=webDriver.getwebelements("//span[@class='fas fa-question-circle tooltip-icon']");
					Iterator<WebElement> iter = elements.iterator();
					while(iter.hasNext()) 
					{
					    WebElement we = iter.next();
					    webDriver.Clickon(we);
					}*/
		}
						
		@Then("^I Can see the Suggestion Messsage") 
		public void SuugestionMessageAppear() throws InterruptedException
		{
					/*List<WebElement> elements=webDriver.getwebelements("//div[@class='tooltip-msg']");
					WebElement ele=null;	
					for(int i=0;i<=elements.size();i++)
					{
						ele=elements.get(i);
						if(i==0)
							webDriver.VerifyText(ele, "Your 8 or 10 digit customer number is in the top right corner of any letters or emails you have received from us.");
						else if(i==1)
							webDriver.VerifyText(ele, "Your 13 digit payment reference is in the top right corner of any bills you have received from us. Please enter it without any spaces between the digits.");
						else if(i==2)
							webDriver.VerifyText(ele, "Please enter this information exactly as it appears on any letters or emails you have received from us. If more than one person is responsible for the charges, please enter the last name of the first customer shown on any letters or emails you have from us.");
					}*/
					
			webDriver.VerifyText(webDriver.getwebelement("(//div[@class='tooltip-msg'])[1]"), "Your 8 or 10 digit customer number is in the top right corner of any letters or emails you have received from us.");		
			webDriver.VerifyText(webDriver.getwebelement("(//div[@class='tooltip-msg'])[2]"), "Your 13 digit payment reference is in the top right corner of any bills you have received from us. Please enter it without any spaces between the digits.");
			webDriver.VerifyText(webDriver.getwebelement("(//div[@class='tooltip-msg'])[3]"), "Please enter this information exactly as it appears on any letters or emails you have received from us. If more than one person is responsible for the charges, please enter the last name of the first customer shown on any letters or emails you have from us.");
		}
		
		@When("^I Click Second Time on Question Mark Icons$") 
		public void ClickQuestionIconSecond() throws Exception
		{
					//clickonQuestionMarks();
					
					webDriver.Clickon(webDriver.getwebelement("(//span[@class='fas fa-question-circle tooltip-icon active'])[1]"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement("(//span[@class='fas fa-question-circle tooltip-icon active'])[1]"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement("//span[@class='fas fa-question-circle tooltip-icon active']"));
			webDriver.WaitforPageToBeReady();
			/*List<WebElement> elements=webDriver.getwebelements("//span[@class='fas fa-question-circle tooltip-icon active']");
					Iterator<WebElement> iter = elements.iterator();
					while(iter.hasNext()) 
					{
					    WebElement we = iter.next();
					    webDriver.Clickon(we);
					}*/
		}
						
		@Then("^I Suggestion Messsage should hide") 
		public void SuugestionMessageDisAppear() throws InterruptedException
		{
			boolean flag=false;
			List<WebElement> elements=webDriver.getwebelements("//div[@class='tooltip-msg']");
			if(elements.isEmpty())
			{
				  flag= true;
			} 
			else 
			{
				flag= false;
			}
			Assert.assertTrue(flag, "Error Removed");
							
			}
		
		public void clickonQuestionMarks() throws Exception
		{
			List<WebElement> elements=webDriver.getwebelements("(//span[@class='fas fa-question-circle tooltip-icon active'])[1]");
			/*Iterator<WebElement> iter = elements.iterator();
			while(iter.hasNext()) 
			{
			    WebElement we = iter.next();
			    webDriver.Clickon(we);
			    //we.click();
			}*/
			do
			{
				 WebElement we = elements.get(1);
				 webDriver.Clickon(we);
				 elements=webDriver.getwebelements("(//span[@class='fas fa-question-circle tooltip-icon active'])[1]");
			}while(elements.size()>0);
			
		}
		
		
}
