package pageFunctions.web;
import java.util.List;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.baseDriverHelper;
import core.webDriver;
import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;
public class LoginFunctions 
{

	public  webHelper localdriver;
	private xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	private xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	private xmlreader regiLoct=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	private PropertyReader prpertyreader = new PropertyReader();
	public LoginFunctions(webHelper dr)
	{
		System.out.println("I am in POM");
		localdriver=  dr;
	}
	public void OpenLoginPage() throws Exception
	{
		Thread.sleep(5000);
		//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		localdriver.WaitforPageToBeReady();
		localdriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
		localdriver.WaitforPageToBeReady();
		Thread.sleep(5000);
	}
	
	public void EnterEmailAndPassword(String email, String password) throws Exception
	{
		Thread.sleep(5000);
		System.out.println("Email ID : " + email);
		System.out.println("PassWord : " + password);
		System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
		System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
		
		localdriver.SendKeys(localdriver.getwebelement(loginLoct.getlocator("//locators/EmailId")),email);
		localdriver.SendKeys(localdriver.getwebelement(loginLoct.getlocator("//locators/Password")),password);

	}
	
	public void ClickOnLogin() throws Exception
	{
				
		localdriver.Clickon(localdriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
		localdriver.WaitforPageToBeReady();	
	}
	
	public void LoginError() throws Exception
	{
		localdriver.VerifyText(localdriver.getwebelement(loginLoct.getlocator("//locators/LoginError")), "The email or password you’ve entered is incorrect.");		
		//verify Dashboard
	}
	
	public void LoginCompleted() throws InterruptedException, DocumentException
	{
		List<WebElement> elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/LoginMakeaPayment"));
		boolean flag1=elements1.size()>0?true:false;
		
		elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/SubmitMeterReading"));
		boolean flag2=elements1.size()>0?true:false;
		
		elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/CloseAccount"));
		boolean flag3=elements1.size()>0?true:false;
		
		elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/LogOut"));
		boolean flag4=elements1.size()>0?true:false;
		
		Assert.assertTrue(flag1&&flag2&&flag3&&flag4,"Dashboard not Loaded");
	}
	
	public void ClickForgotPassword() throws Exception
	{
		localdriver.Clickon(localdriver.getwebelement(loginLoct.getlocator("//locators/Forgot")));
		localdriver.WaitforPageToBeReady();	
	}
	
	public void NavigateToForgetPassword() throws InterruptedException, DocumentException
	{
		localdriver.VerifyTitle("My account");	
		
		Assert.assertTrue(localdriver.IsNotPresent(loginLoct.getlocator("//locators/LoginButton")),"Forgot Password Page is not Open");
	}
	
	public void ForgotPasswordEmailId() throws Exception
	{
		List<WebElement> elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/ForgotEmail"));
		Assert.assertTrue(elements1.size()>0?true:false,"Not able to See the Forgot Password Email ID Field");	
		
	}
	
	public void BackToLoginAndContinue() throws Exception
	{
				
		List<WebElement> elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/BackTologin"));
		boolean flag1=elements1.size()>0?true:false;	
		
		elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/ForgotContinue"));
		boolean flag2=elements1.size()>0?true:false;	
		Assert.assertTrue(flag1&&flag2, "Back to Login and Continue button is not loaded");
	}
	
	public void EnterEmailForgotPassword(String email) throws Exception
	{
		
		localdriver.SendKeys(localdriver.getwebelement(loginLoct.getlocator("//locators/ForgotEmail")),email);
	}
	
	public void ClickForgotContinue() throws Exception
	{

		localdriver.Clickon(localdriver.getwebelement(loginLoct.getlocator("//locators/ForgotContinue")));
		localdriver.WaitforPageToBeReady();	
		
	}
	
	public void ResetPasswordLinkVerification(String EmailID ) throws InterruptedException, DocumentException
	{
		
		Thread.sleep(10000);
		List<WebElement> elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/ForgotMessageEmail"));
		WebElement ele=elements1.get(0);
		String Text=ele.getText();
		System.out.println("Email ID = " + Text);
		Assert.assertTrue(Text.contains(EmailID),"Email id in message not matched with entered Email ID ");
		
		elements1=localdriver.getwebelements(loginLoct.getlocator("//locators/ForgotMessage"));
		ele=elements1.get(0);
		Text=ele.getText();
		System.out.println("Message = " + Text);
		Assert.assertTrue(Text.contains(EmailID),"Message(We have sent you an email) not found");
	}
	
	public void ClickOnRegisration () throws Exception
	{
		localdriver.Clickon(localdriver.getwebelement(loginLoct.getlocator("//locators/Register")));
		localdriver.WaitforPageToBeReady();
	}
	
	public void VerifyRegisrationPageOpen() throws InterruptedException, DocumentException
	{
		
		List<WebElement> elements1=localdriver.getwebelements(regiLoct.getlocator("//locators/RegisterNow"));
		boolean flag1=elements1.size()>0?true:false;	
		Assert.assertTrue(flag1,"Test Failed Due to >> Not Navigated to Registered page");
	
	}
}
