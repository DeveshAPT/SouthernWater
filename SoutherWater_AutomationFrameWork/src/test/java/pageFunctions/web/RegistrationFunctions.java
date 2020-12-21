package pageFunctions.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class RegistrationFunctions {

	public webHelper pageDriver;
	private PropertyReader prpertyreader = new PropertyReader();
	public AssertionExceptionManager custException;
	public String enteredName, enteredCustomerNumber, enteredEmailID, newEmail, firstSecurityQuest;
	xmlreader payBillLoct = new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist = new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");

	public RegistrationFunctions(webHelper dr) {
		pageDriver = dr;
		custException = new AssertionExceptionManager(pageDriver);
	}

	public void openRegistrationPage() throws InterruptedException, IOException {
		Thread.sleep(5000);
		pageDriver.OpenURL(prpertyreader.readproperty("CustomerRegistration"));
		Thread.sleep(5000);
		System.out.println(pageDriver.GetTitle());
	}

	public void verifyTermsConditionsCheckBox() throws InterruptedException, DocumentException {
		boolean flag = false;
		List<WebElement> elements = pageDriver.getwebelements(custRegist.getlocator("//locators/AgreeTermsCheckBox"));
		flag = elements.size() > 0 ? true : false;
		Assert.assertTrue(flag, "Agree CheckBox not Found");
	}

	public void verifyTermsAndCondtionLink() throws InterruptedException, DocumentException {
		boolean flag = false;
		List<WebElement> elements = pageDriver
				.getwebelements(custRegist.getlocator("//locators/TermsAndConditionsLink"));
		flag = elements.size() > 0 ? true : false;
		Assert.assertTrue(flag, "Terms and Conditions Link not Present");
	}

	public void clickTermsConditionLink() throws Exception {
		String locator = custRegist.getlocator("//locators/TermsAndConditionsLink");
		System.out.println(locator);
		Thread.sleep(5000);
		pageDriver.Moveon(pageDriver.getwebelement(locator));
		// List<WebElement> list=pageDriver.getwebelements(locator);
		// System.out.println(list.size());
		// pageDriver.SafeJavaScriptClick(pageDriver.getwebelement(locator));
		pageDriver.WaitforPageToBeReady();

	}

	public void verifyTermsAndConditionPage() throws InterruptedException, DocumentException {
		List<WebElement> elements1 = pageDriver
				.getwebelements(custRegist.getlocator("//locators/TermsAndCondtionHeading"));
		boolean flag1 = elements1.size() > 0 ? true : false;

		List<WebElement> elements2 = pageDriver.getwebelements(custRegist.getlocator("//locators/ImportantNotice"));
		boolean flag2 = elements2.size() > 0 ? true : false;

		List<WebElement> elements3 = pageDriver.getwebelements(custRegist.getlocator("//locators/Definations"));
		boolean flag3 = elements3.size() > 0 ? true : false;

		List<WebElement> elements4 = pageDriver.getwebelements(custRegist.getlocator("//locators/PaperLessBilling"));
		boolean flag4 = elements4.size() > 0 ? true : false;

		List<WebElement> elements5 = pageDriver
				.getwebelements(custRegist.getlocator("//locators/TermsAndConditionClose"));
		boolean flag5 = elements5.size() > 0 ? true : false;
		Assert.assertTrue(flag1 && flag2 && flag3 && flag4 && flag5, "Terms And Condition page Not Open");
	}

	public void closeTermAndConditionPage() throws Exception {

		pageDriver.WaitforPageToBeReady();
		// pageDriver.IsPresent((custRegist.getlocator("//locators/TermsAndConditionClose")));
		Assert.assertTrue(pageDriver.IsPresent((custRegist.getlocator("//locators/TermsAndConditionClose"))),
				"Close button not found");
	}

	public void clickCloseTermAndCondition() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/TermsAndConditionClose")));
		pageDriver.WaitforPageToBeReady();
	}

	public void clickTermsAndConditionCheckBox() throws Exception {
		pageDriver
				.SafeJavaScriptClick(pageDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
		// pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/AgreeTermsCheckBox")));
		pageDriver.WaitforPageToBeReady();
	}

	public void verifyRegisterationPageOpen() throws InterruptedException, DocumentException {

		List<WebElement> elements1 = pageDriver.getwebelements(custRegist.getlocator("//locators/RegisterNow"));
		boolean flag1 = elements1.size() > 0 ? true : false;
		Assert.assertTrue(flag1, "Customer Registration Page Not Opened");
	}

	public void clickStart() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/Start")));
		pageDriver.WaitforPageToBeReady();
	}

	public void acceptTermsAndConditionMandatoryMessageFirst() throws InterruptedException, DocumentException {
		List<WebElement> elements1 = pageDriver
				.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageFirst"));
		boolean flag1 = elements1.size() > 0 ? true : false;
		Assert.assertTrue(flag1, "First Accpet Terms and Conditions Message Not found");
	}

	public void acceptTermsAndConditionMandatoryMessageSecond() throws InterruptedException, DocumentException {
		List<WebElement> elements1 = pageDriver
				.getwebelements(custRegist.getlocator("//locators/AcceptTermMessageSecond"));
		boolean flag1 = elements1.size() > 0 ? true : false;
		Assert.assertTrue(flag1, "Second Accpet Terms and Conditions Message Not found");
	}

	public void termsConditionMessegeDisAppear() throws InterruptedException, DocumentException {
		boolean firstgone = pageDriver.IsNotPresent(custRegist.getlocator("//locators/AcceptTermMessageFirst"));
		Assert.assertTrue(firstgone, "First Accpet Terms and Conditions is not removed");

		boolean secondgone = pageDriver.IsNotPresent(custRegist.getlocator("//locators/AcceptTermMessageSecond"));
		Assert.assertTrue(!secondgone, "Second Accpet Terms and Conditions is not removed");

		/*
		 * Thread.sleep(5000); List<WebElement>
		 * elements1=pageDriver.getwebelements(custRegist.getlocator(
		 * "//locators/AcceptTermMessageFirst")); boolean
		 * flag1=elements1.isEmpty()?true:false; Assert.assertTrue(flag1,
		 * "First Accpet Terms and Conditions is not removed");
		 * 
		 * List<WebElement> elements2=pageDriver.getwebelements(custRegist.getlocator(
		 * "//locators/AcceptTermMessageSecond")); boolean
		 * flag2=elements2.isEmpty()?true:false; Assert.assertTrue(flag2,
		 * "Second Accpet Terms and Conditions is not removed");
		 */
	}

	public void privacyLinkClick() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/PrivacyLink")));
		pageDriver.WaitforPageToBeReady();
	}

	public void verifyItShouldTakeFewMinute() throws InterruptedException, DocumentException {

		List<WebElement> elements2 = pageDriver.getwebelements(custRegist.getlocator("//locators/ItShouldTakeLabel"));
		boolean exist = elements2.size() > 0 ? true : false;
		Assert.assertTrue(exist, "It should only take a few minutes");

	}

	public void verify8Digitlabel() throws InterruptedException, DocumentException {
		List<WebElement> elements2 = pageDriver.getwebelements(custRegist.getlocator("//locators/EightDigitLabel"));
		boolean exist = elements2.size() > 0 ? true : false;
		Assert.assertTrue(exist,
				"Your customer number. This is the 8 digit number shown on the top right of your bill. ");

	}

	public void verifyLastNameLabel() throws InterruptedException, DocumentException {
		List<WebElement> elements2 = pageDriver.getwebelements(custRegist.getlocator("//locators/YourLastNameLabel"));
		boolean exist = elements2.size() > 0 ? true : false;
		Assert.assertTrue(exist, "Your last name as shown on the bill. ");
	}

	public void verifyEmailLabel() throws InterruptedException, DocumentException {
		List<WebElement> elements2 = pageDriver.getwebelements(custRegist.getlocator("//locators/YourEmailLabel"));
		boolean exist = elements2.size() > 0 ? true : false;
		Assert.assertTrue(exist, "Your email address. ");
	}

	public void enterCustomerDetials(String CustomerNumber, String LastName, String Email)
			throws InterruptedException, IOException, DocumentException {
		enteredName = LastName;
		enteredCustomerNumber = CustomerNumber;
		enteredEmailID = Email;
		pageDriver.CleasrAndSendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),
				CustomerNumber + Keys.TAB);
		pageDriver.CleasrAndSendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/LastName")),
				LastName + Keys.TAB);
		pageDriver.CleasrAndSendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),
				Email + Keys.TAB);
	}

	public void enterCustomerNumner(String CustomerNumber) throws InterruptedException, IOException, DocumentException {
		pageDriver.SendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/CustomerNumber")),
				CustomerNumber + Keys.TAB);
	}

	public void continueClick() throws InterruptedException, DocumentException, Exception {
		System.out.println("I am Before Continue");
		Thread.sleep(7000);
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/Continue")));
		pageDriver.WaitforPageToBeReady();
		System.out.println("I am after Continue");
	}

	public void verifyCustomerDetail() throws InterruptedException, DocumentException {
		Thread.sleep(10000);
		List<WebElement> elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
		WebElement ele = elements.get(0);
		String Text = ele.getText();
		Assert.assertTrue(Text.contains("Name"), "Name Lable Not Found on Check Detials");

		elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
		ele = elements.get(0);
		Text = ele.getText();
		Assert.assertTrue(Text.contains(enteredName), "Entered Name Not matched on Check Detail page");
	}

	public void verifyEmail() throws InterruptedException, DocumentException {
		List<WebElement> elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
		WebElement ele = elements.get(1);
		String Text = ele.getText();
		Assert.assertTrue(Text.contains("Email address"), "Email Address Lable Not Found on Check Detials");

		elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
		ele = elements.get(1);
		Text = ele.getText();
		Assert.assertTrue(Text.contains(enteredEmailID), "Entered Email ID not matched on Check Detail page");
	}

	public void verifyCustomerNumber() throws InterruptedException, DocumentException {
		List<WebElement> elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
		WebElement ele = elements.get(2);
		String Text = ele.getText();
		Assert.assertTrue(Text.contains("Customer number"), "Customer number Lable Not Found on Check Detials");

		elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
		ele = elements.get(2);
		Text = ele.getText();
		Assert.assertTrue(Text.contains(enteredCustomerNumber),
				"Entered Customer number not matched on Check Detail page");
	}

	public void verifyAddress() throws InterruptedException, DocumentException {
		List<WebElement> elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
		WebElement ele = elements.get(3);
		String Text = ele.getText();
		Assert.assertTrue(Text.contains("Address"), "Address Lable Not Found on Check Detials");
	}

	public void yourDetailStepIsOpen() throws DocumentException, InterruptedException {
		Assert.assertTrue(pageDriver.IsPresent(custRegist.getlocator("//locators/YourDetails")),
				"Your Details Page is not open");
	}

	public void backButtonClick() throws InterruptedException, DocumentException, Exception {
		Thread.sleep(5000);
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/Back")));
		pageDriver.WaitforPageToBeReady();
	}

	public void enterEmailID(String UpdateEmail) throws InterruptedException, IOException, DocumentException {
		newEmail = UpdateEmail;
		Thread.sleep(5000);
		pageDriver.CleasrAndSendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/EmailId")),
				UpdateEmail + Keys.TAB);
	}

	public void verifyUpdatedEmail() throws InterruptedException, DocumentException {
		Thread.sleep(4000);
		List<WebElement> elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailHeadings"));
		WebElement ele = elements.get(1);
		String Text = ele.getText();
		Assert.assertTrue(Text.contains("Email address"), "Email Address Lable Not Found on Check Detials");

		elements = pageDriver.getwebelements(custRegist.getlocator("//locators/CheckDetailValues"));
		ele = elements.get(1);
		Text = ele.getText();
		Assert.assertTrue(Text.contains(newEmail), "Entered Email ID not matched on Check Detail page");
	}

	public void confirmContinueClick() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/ConfirmContinue")));
		pageDriver.WaitforPageToBeReady();
	}

	public void enterPassword(String Password) throws InterruptedException, IOException, DocumentException {
		Thread.sleep(4000);
		pageDriver.SendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/Password")), Password);
	}

	public void firstQuestionAnswer(String firstQuestion, String firstAnswer)
			throws InterruptedException, IOException, DocumentException {
		Select Question = new Select(pageDriver.getwebelement(custRegist.getlocator("//locators/FirstQuestion")));
		Question.selectByVisibleText(firstQuestion);

		pageDriver.SendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/FirstAnswer")), firstAnswer);
	}

	public void secondQuestionAnswer(String secondQuestion, String secondAnswer)
			throws InterruptedException, IOException, DocumentException {
		Select Question = new Select(pageDriver.getwebelement(custRegist.getlocator("//locators/SecondQuestion")));
		Question.selectByVisibleText(secondQuestion);

		pageDriver.SendKeys(pageDriver.getwebelement(custRegist.getlocator("//locators/SecondAnswer")),
				secondAnswer + Keys.TAB);
		Thread.sleep(5000);
	}

	public void trySelectFirstQuestionInSecondQuestion(String firstQuestion) {
		firstSecurityQuest = firstQuestion;
		try {
			Select Question = new Select(pageDriver.getwebelement(custRegist.getlocator("//locators/SecondQuestion")));
			Question.selectByVisibleText(firstQuestion);
		} catch (Exception ex) {
			System.out.println("Security Question : " + firstQuestion + " not found");
		}
	}

	public void firstQuestionNotvisibleInSecondQuestionAfterSelection() throws InterruptedException, DocumentException {
		Select Question = new Select(pageDriver.getwebelement(custRegist.getlocator("//locators/SecondQuestion")));
		List<WebElement> dd = Question.getOptions();
		for (int j = 0; j < dd.size(); j++) {
			String opt = dd.get(j).getText();
			System.out.println(opt);
			Assert.assertTrue(opt != firstSecurityQuest,
					"FirstSelected Security Question found in Second Security Question Options");
		}
	}

	public void continueClickPassword() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/PasswordContinue")));
		pageDriver.WaitforPageToBeReady();
	}

	public void activationMailMessageVerify() throws Exception {
		Thread.sleep(15000);
		pageDriver.WaitforPageToBeReady();

		Assert.assertTrue(pageDriver.IsPresent((custRegist.getlocator("//locators/VerifyEmailMessage"))),
				"'Verify your email address' not depict on screen");

		List<WebElement> Messages = pageDriver
				.getwebelements(custRegist.getlocator("//locators/VerifyEmailMessageList"));

		WebElement ele = Messages.get(0);
		String Text = ele.getText();
		Assert.assertTrue(Text.contains("We’ve sent you an email to"),
				"'We’ve sent you an email to ' message not found");
		Assert.assertTrue(Text.contains(enteredEmailID),
				"Entered Email '" + enteredEmailID + "' ID Not Matched in message not found");

		ele = Messages.get(1);
		Text = ele.getText();

		Assert.assertTrue(Text.contains("Click on the"),
				"'Click on the verification link in the email to complete your registration.' message not correct");
		Assert.assertTrue(Text.contains("verification link"),
				"'Click on the verification link in the email to complete your registration.' message not correct");
		Assert.assertTrue(Text.contains(" in the email to complete your registration."),
				"'Click on the verification link in the email to complete your registration.' message not correct");

		ele = Messages.get(2);
		Text = ele.getText();

		Assert.assertTrue(Text.contains("To protect your account, this link will expire after 48 hours."),
				"'To protect your account, this link will expire after 48 hours.' message not correct");
	}

	public void mandatoryFieldMessages(String step) throws InterruptedException, DocumentException {
		List<String> errors = new ArrayList<String>();
		if (step.equalsIgnoreCase("RegisterNow")) {
			errors.add("Please accept the Terms and Conditions");
		} else if (step.equalsIgnoreCase("YourDetail")) {
			errors.add("Please enter your customer number");
			errors.add("Please enter the last name of the first customer shown on your bill");
			errors.add("Please enter your email address");
		} else if (step.equalsIgnoreCase("LoginDetail")) {
			errors.add("Please choose a password that meets our security requirements");
			errors.add("Please choose your first security question");
			errors.add("Please set an answer to your first security question");
			errors.add("Please choose your second security question");
			errors.add("Please set an answer to your second security question");
		}

		List<WebElement> eles = pageDriver.getwebelements(custRegist.getlocator("//locators/MandatoryFieldMessage"));

		for (int i = 0; i < eles.size(); i++) {
			WebElement error = eles.get(i);
			String temp = error.getText();
			System.out.println("");
			System.out.println(temp);
			custException.IsTrue(errors.indexOf(temp) > -1, "Mandatory Field Error message : " + temp + " not found");
		}
	}

	public void mandatoryFieldMessagesGone(String step) throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsNotPresent(custRegist.getlocator("//locators/MandatoryFieldMessage")),
				"Mandatory Field Error message not gone ");

	}

	public void commonBackRegistration() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(custRegist.getlocator("//locators/CommonBack")));
		pageDriver.WaitforPageToBeReady();
	}

	public void checkAndConfirmOpen() throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsPresent(custRegist.getlocator("//locators/CheckAndConfirm")),
				"Check And Confirm Page not open ");

	}

	public void loginDetailPageOpen() throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsPresent(custRegist.getlocator("//locators/LoginDetailStepHeading")),
				"Login Detail Page is not Open");

	}
}
