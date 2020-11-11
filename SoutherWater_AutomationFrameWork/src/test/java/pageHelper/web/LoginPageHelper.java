package pageHelper.web;
import java.util.List;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.xmlreader;

public class LoginPageHelper {
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	String EmailID=null;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	xmlreader regiLoct=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	PropertyReader prpertyreader = new PropertyReader();
		public LoginPageHelper(WebDriver driver)  
		{
			webDriver=new baseDriverHelper(driver);
			System.out.println("First Constructor");
		}
		
		public LoginPageHelper(bddDriver contextSteps) throws Exception {
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		}
		
		@Given("^I am at login page$")
		public void I_am_at_login_page() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			webDriver.VerifyTitle("My account");
			
		}
		
		@When("^I Enter my ([^\"]*) and([^\"]*) into respective fields$")
		public void EnterEmailAndPassword(String email, String password) throws Exception
		{
			Thread.sleep(5000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);

		}
		
		@And("^Click on Login$")
		public void ClickOnLogin() throws Exception
		{
					
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();	
		}
		
		@Then("^I Should not login$")
		public void LoginFailed() throws InterruptedException, DocumentException
		{
			webDriver.VerifyTitle("My account");		
			//Login done	
		}
		
		@And("^I Should see the Login error message$")
		public void LoginError() throws Exception
		{
			webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginError")), "The email or password you’ve entered is incorrect.");		
			//verify Dashboard
		}	
		
		// Second 
		@Given("^I am on login page$")
		public void I_am_on_login_page() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			webDriver.VerifyTitle("My account");
			
		}
		
		@When("^I Enter credentials ([^\"]*) and([^\"]*) into respective fields$")
		public void EnterCredentials(String email, String password) throws Exception
		{
			Thread.sleep(5000);
			System.out.println("Email ID : " + email);
			System.out.println("PassWord : " + password);
			System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
			System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);

		}
		
		@And("^Click on Login button$")
		public void ClickOnLoginButton() throws Exception
		{
					
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
			webDriver.WaitforPageToBeReady();	
			Thread.sleep(5000);
		}
		
		@Then("^I should see the Dashboard$")
		public void LoginCompleteed() throws InterruptedException, DocumentException
		{
			List<WebElement> elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/LoginMakeaPayment"));
			boolean flag1=elements1.size()>0?true:false;
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/SubmitMeterReading"));
			boolean flag2=elements1.size()>0?true:false;
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/CloseAccount"));
			boolean flag3=elements1.size()>0?true:false;
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/LogOut"));
			boolean flag4=elements1.size()>0?true:false;
			
			Assert.assertTrue(flag1&&flag2&&flag3&&flag4,"Dashboard not Loaded");
		}
		//Third
		
		@Given("^User is at login page$")
		public void UserAtLogin() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			webDriver.VerifyTitle("My account");
			
		}
		
		@When("^I Click on Forgot Password$")
		public void ClickForgotPassword() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/Forgot")));
			webDriver.WaitforPageToBeReady();	
		}
		
		@Then("^I Should navigate to Forgot Password Page$")
		public void NavigateToForgetPassword() throws InterruptedException, DocumentException
		{
			webDriver.VerifyTitle("My account");		
			List<WebElement> elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/EmailId"));
			boolean flag1=elements1.size()>0?false:true;	
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/Password"));
			boolean flag2=elements1.size()>0?false:true;	
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/LoginButton"));
			boolean flag3=elements1.size()>0?false:true;
			
			Assert.assertTrue(flag1&&flag2&&flag3, "Forget Password Page is not Open");
		}
		
		@And("^I Should Email address field for reset password$")
		public void ForgotPasswordEmailId() throws Exception
		{
			List<WebElement> elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/ForgotEmail"));
			Assert.assertTrue(elements1.size()>0?true:false,"Not able to See the Forgot Password Email ID Field");	
			
		}	
		@And("^Back to login, Continue links$")
		public void BackToLoginAndContinue() throws Exception
		{
					
			List<WebElement> elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/BackTologin"));
			boolean flag1=elements1.size()>0?true:false;	
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/ForgotContinue"));
			boolean flag2=elements1.size()>0?true:false;	
			Assert.assertTrue(flag1&&flag2, "Back to Login and Continue button is not loaded");
		}
		
		// Fourth
		
		@Given("^I am at Reset Password Page$")
		public void ResetPasswordPage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/Forgot")));
			webDriver.WaitforPageToBeReady();	
			
		}


		@When("^I Enter ([^\"]*) in Reset Password$")
		public void EnterEmailForgotPassword(String email) throws Exception
		{
			EmailID=email;
			webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator("//locators/ForgotEmail")),email);
		}
		
		@And("^Click on Continue$")
		public void ClickContinue() throws Exception
		{

			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/ForgotContinue")));
			webDriver.WaitforPageToBeReady();	
			
		}	
		
		@Then("^I Can See the Verification Link Sent Message$")
		public void ResetPasswordLinkVerification() throws InterruptedException, DocumentException
		{
			
			
			List<WebElement> elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/ForgotMessageEmail"));
			WebElement ele=elements1.get(0);
			String Text=ele.getText();
			System.out.println("Email ID = " + Text);
			Assert.assertTrue(Text.contains(EmailID),"Email id in message not matched with entered Email ID ");
			
			elements1=webDriver.getwebelements(loginLoct.getlocator("//locators/ForgotMessage"));
			ele=elements1.get(0);
			Text=ele.getText();
			System.out.println("Message = " + Text);
			Assert.assertTrue(Text.contains(EmailID),"Message(We have sent you an email) not found");
		}
		
		//Fifth 
		
		@Given("^I am accessing the Login Page$")
		public void OpenLoginPage() throws Exception
		{
			Thread.sleep(5000);
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.WaitforPageToBeReady();
			webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
			webDriver.WaitforPageToBeReady();
			Thread.sleep(10000);
		
			
		}

		@When("^I Click on Registration$")
		public void ClickOnRegisration () throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator("//locators/Register")));
			webDriver.WaitforPageToBeReady();
		}
		
		
		@Then("^I Should Navigate to Registration Page$")
		public void VerifyRegisrationPageOpen() throws InterruptedException, DocumentException
		{
			
			List<WebElement> elements1=webDriver.getwebelements(regiLoct.getlocator("//locators/RegisterNow"));
			boolean flag1=elements1.size()>0?true:false;	
			Assert.assertTrue(flag1,"Test Failed Due to >> Not Navigated to Registered page");
		
		}
}
