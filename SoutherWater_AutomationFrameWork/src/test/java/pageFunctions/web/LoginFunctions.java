package pageFunctions.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.baseDriverHelper;
import core.webDriver;
import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class LoginFunctions {

	public webHelper pageDriver;
	public AssertionExceptionManager custException;
	private xmlreader payBillLoct = new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	private xmlreader loginLoct = new xmlreader("src\\test\\resources\\locators\\Login.xml");
	private xmlreader regiLoct = new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	private PropertyReader prpertyreader = new PropertyReader();
	ExcelWork excel = new ExcelWork();

	public LoginFunctions(webHelper dr) {
		System.out.println("I am in POM");
		pageDriver = dr;
		custException = new AssertionExceptionManager(dr);
	}

	public void OpenLoginPage() throws Exception {
		Thread.sleep(5000);
		// webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		pageDriver.WaitforPageToBeReady();
		pageDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(5000);
	}

	public void enterEmailAndPassword(String email, String password) throws Exception {
		Thread.sleep(5000);
		System.out.println("Email ID : " + email);
		System.out.println("PassWord : " + password);
		System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
		System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));

		pageDriver.SendKeys(pageDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")), email);
		pageDriver.SendKeys(pageDriver.getwebelement(loginLoct.getlocator("//locators/Password")), password);

	}
	
	public void loginCustomerType(String Custtype) throws Exception 
	{
		
		Map<String, HashMap<String, String>> DataSet=excel.ReadTestData("Users");
		System.out.println("");
		System.out.println(DataSet.size());
		HashMap<String, String>map=DataSet.get(Custtype);
		String email=map.get("Email");
		String password=map.get("Password");
		Thread.sleep(5000);
		System.out.println("Email ID : " + email);
		System.out.println("PassWord : " + password);
		System.out.println("Email Locator  : " + loginLoct.getlocator("//locators/EmailId"));
		System.out.println("PassWord Locator : " + loginLoct.getlocator("//locators/Password"));
		pageDriver.SendKeys(pageDriver.getwebelement(loginLoct.getlocator("//locators/EmailId")), email);
		pageDriver.SendKeys(pageDriver.getwebelement(loginLoct.getlocator("//locators/Password")), password);

	}


	public void clickOnLogin() throws Exception {

		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/LoginButton")));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(7000);
	}

	public void loginError() throws Exception {
		pageDriver.VerifyText(pageDriver.getwebelement(loginLoct.getlocator("//locators/LoginError")),
				"The email or password you’ve entered is incorrect.");
		// verify Dashboard
	}

	public void loginCompleted() throws InterruptedException, DocumentException {
		List<WebElement> elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/LoginMakeaPayment"));
		boolean flag1 = elements1.size() > 0 ? true : false;

		elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/SubmitMeterReading"));
		boolean flag2 = elements1.size() > 0 ? true : false;

		elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/CloseAccount"));
		boolean flag3 = elements1.size() > 0 ? true : false;

		elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/LogOut"));
		boolean flag4 = elements1.size() > 0 ? true : false;

		Assert.assertTrue(flag1 && flag2 && flag3 && flag4, "Dashboard not Loaded");
	}

	public void clickForgotPassword() throws Exception {
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/Forgot")));
		pageDriver.WaitforPageToBeReady();
	}

	public void navigateToForgetPassword() throws InterruptedException, DocumentException {
		pageDriver.VerifyTitle("My account");

		Assert.assertTrue(pageDriver.IsNotPresent(loginLoct.getlocator("//locators/LoginButton")),
				"Forgot Password Page is not Open");
	}

	public void forgotPasswordEmailId() throws Exception {
		List<WebElement> elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/ForgotEmail"));
		Assert.assertTrue(elements1.size() > 0 ? true : false, "Not able to See the Forgot Password Email ID Field");

	}

	public void backToLoginAndContinue() throws Exception {

		List<WebElement> elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/BackTologin"));
		boolean flag1 = elements1.size() > 0 ? true : false;

		elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/ForgotContinue"));
		boolean flag2 = elements1.size() > 0 ? true : false;
		Assert.assertTrue(flag1 && flag2, "Back to Login and Continue button is not loaded");
	}

	public void enterEmailForgotPassword(String email) throws Exception {

		pageDriver.SendKeys(pageDriver.getwebelement(loginLoct.getlocator("//locators/ForgotEmail")), email);
	}

	public void clickForgotContinue() throws Exception {

		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/ForgotContinue")));
		pageDriver.WaitforPageToBeReady();

	}

	public void resetPasswordLinkVerification(String EmailID) throws InterruptedException, DocumentException {

		Thread.sleep(10000);
		List<WebElement> elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/ForgotMessageEmail"));
		WebElement ele = elements1.get(0);
		String Text = ele.getText();
		System.out.println("Email ID = " + Text);
		//Assert.assertTrue(Text.contains(EmailID), "Email id in message not matched with entered Email ID ");
		Assert.assertTrue(Text.contains("verification link"), "Email id in message not matched with entered Email ID ");
		elements1 = pageDriver.getwebelements(loginLoct.getlocator("//locators/ForgotMessageEmail"));
		ele = elements1.get(1);
		Text = ele.getText();
		System.out.println("Message = " + Text);
		//This link will expire in 4 hours.
		//Assert.assertTrue(Text.contains(EmailID), "Message(We have sent you an email) not found");
		Assert.assertTrue(Text.contains("This link will expire in 4 hours."), "Message(We have sent you an email) not found");
	}

	public void clickOnRegisration() throws Exception {
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/Register")));
		pageDriver.WaitforPageToBeReady();
	}

	public void verifyRegisrationPageOpen() throws InterruptedException, DocumentException {

		List<WebElement> elements1 = pageDriver.getwebelements(regiLoct.getlocator("//locators/RegisterNow"));
		boolean flag1 = elements1.size() > 0 ? true : false;
		Assert.assertTrue(flag1, "Test Failed Due to >> Not Navigated to Registered page");

	}
}
