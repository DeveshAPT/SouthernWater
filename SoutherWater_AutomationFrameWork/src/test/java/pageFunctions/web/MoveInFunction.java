package pageFunctions.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class MoveInFunction {

	public webHelper pageDriver;
	public AssertionExceptionManager custException;
	ExcelWork exl = new ExcelWork();;
	PropertyReader prpertyreader = new PropertyReader();

	xmlreader MoveInLoct = new xmlreader("src\\test\\resources\\locators\\MoveIn.xml");
	String TestFirstName = "TestFirstName";
	String TestMiddleName = "TestMiddleName";
	String TestLastName = "TestLastName";
	String CustomerEmailAddress = "neeraj.m@360logica.com";
	Integer NumberOfOccupants = 3;
	Integer AccountNumber = 55779911;

	public MoveInFunction(webHelper dr) {
		pageDriver = dr;
		custException = new AssertionExceptionManager(pageDriver);
	}

	public void OpenMoveInPage() throws Exception {
		Thread.sleep(3000);
		pageDriver.WaitforPageToBeReady();
		// pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/AcceptCokies")));
		pageDriver.OpenURL(prpertyreader.readproperty("MoveInUrl"));
		pageDriver.WaitforPageToBeReady();
		System.out.println(pageDriver.GetTitle());
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CreateAnAccountHeading")),
				"Create an account");
	}

	public void startClick() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/StartButton")));
	}

	public void fillMoveINDetails(String postCode, String address) throws Exception {
		Thread.sleep(3000);
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")),
				"Moving details");
		enterPostCode(postCode);

		findAddressClick();
		Thread.sleep(3000);

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
		Thread.sleep(2000);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")), address);
		Thread.sleep(2000);
	}

	public void enterMoveINDate() throws InterruptedException, IOException, DocumentException {
		String date1 = core.baseDriverHelper.GetFutureDate();
		System.out.println("selected date::: " + date1);
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/YourMovingDateLabel")),
				"Your moving date");
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/MoveOutDate")),
				date1 + Keys.TAB);
		Thread.sleep(2000);
	}

	public void enterOccupant() throws InterruptedException, IOException, DocumentException {

		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupants")),
				String.valueOf(NumberOfOccupants) + Keys.TAB);
		Thread.sleep(2000);
	}

	public void continueClick() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));
		Thread.sleep(2000);
		pageDriver.WaitforPageToBeReady();
	}

	public void verifyYourDetailsSteps() throws InterruptedException, DocumentException {
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/YourDetailsHeader")),
				"Your details");
		Thread.sleep(2000);

	}

	public void enterYourDetails(String title, String firstName, String middleName, String lastName, String dOB,
			String contact, String email) throws InterruptedException, DocumentException, Exception {

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")));
		Thread.sleep(2000);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")), title);
		Thread.sleep(2000);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/FirstName")), firstName);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/MiddleName")), middleName);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/LastName")), lastName);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DateOfBirth")), dOB + Keys.TAB);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/UserMobileNumber")), contact);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/UserEmailAddress")), email);
		Thread.sleep(2000);
	}

	public void enterCustomerPaymentDetails(String accHoldName, String code1, String code2, String code3,
			String accountNumber) throws Exception {
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PaymentDeatils")),
				"Payment details");
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/AccountHolderName")),
				accHoldName);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeOne")), code1);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeTwo")), code2);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeThree")), code3);
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/BankAccountNumber")),
				accountNumber);
		Thread.sleep(2000);
	}

	public void verifyMoveINDetails(String firstName, String midName, String lastName, String email, String occupant,
			String accountNumber) throws Exception {
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CheckAndConfirmHeader")),
				"Check and confirm");
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyName")),
				firstName + " " + midName + " " + lastName);
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyEmail")), email);
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyNumberOfOccupants")),
				occupant);
		Thread.sleep(3000);
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/AccountNumberLabel")),
				"Account number");
		Thread.sleep(3000);
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyAccountNumber")),
				accountNumber);
		Thread.sleep(3000);
	}

	public void confirmDetailButton() throws InterruptedException, DocumentException, Exception {
		// pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ConfirmDetailsButton")));
	}

	public void verifyMoveInDetailPageLoaded() throws Exception {
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")),
				"Moving details");
		Thread.sleep(2000);

	}

	public void verifyMandatoryFieldsMessage() throws Exception {
		Thread.sleep(2000);
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")),
				"There’s a problem");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")),
				"You’ll need to correct the errors to continue.");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderUKPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderYourMovingDateErrorMessage")),
				"Please enter your moving date");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderNumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants.");
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ValidUkPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDateErroeMessage")),
				"Please enter your moving date");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants");

	}

	public void enterPostCode(String postcode) throws InterruptedException, IOException, DocumentException {
		Thread.sleep(2000);
		pageDriver.CleasrAndSendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CustomerPostCode")),
				postcode + Keys.TAB);
	}

	public void findAddressClick() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/FindAddressButton")));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}

	public void inValidAddressMessage() throws Exception {
		Thread.sleep(2000);
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")),
				"There’s a problem");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")),
				"You’ll need to correct the errors to continue.");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderUKPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ValidUkPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
	}

	public void verifyEnterAddressManually() throws InterruptedException, DocumentException {
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/EnterYourAddressManually")),
				"Enter your address manually");
	}

	public void pleaseSelectAddressAndOtherErrorMessage() throws InterruptedException, DocumentException {
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")),
				"There’s a problem");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")),
				"You’ll need to correct the errors to continue.");
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PleaseSelectAnAddress")),
				"Please select an address");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderYourMovingDateErrorMessage")),
				"Please enter your moving date");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderNumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants.");
		pageDriver.VerifyText(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDateErroeMessage")),
				"Please enter your moving date");
		pageDriver.VerifyText(
				pageDriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants");
	}

	public void selectAddressRandom() throws InterruptedException, DocumentException, Exception {
		int j = 0;
		Select DisplayAddress = new Select(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));

		Random rand = new Random();
		List<WebElement> eles = DisplayAddress.getOptions();
		int rand_int1 = rand.nextInt(eles.size() - 1);
		DisplayAddress.selectByIndex(rand_int1);

	}

	public void selectAddress(String address) throws InterruptedException, DocumentException, Exception {
		int j = 0;
		Select DisplayAddress = new Select(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
		try {
			DisplayAddress.selectByVisibleText(address);
		} catch (Exception Ex) {
			List<WebElement> eles = DisplayAddress.getOptions();

			for (int i = 0; i < eles.size(); i++) {
				WebElement opt = eles.get(i);
				String temp = opt.getText();
				System.out.println(temp);

				System.out.println(Integer.toString(j));
				System.out.println("");
				temp = temp.replaceAll("\\s", "");
				System.out.println(temp);
				String add = address.replaceAll("\\s", "");
				System.out.println(add);
				if (temp.equalsIgnoreCase(add))
					break;
				j++;
			}
			WebElement opt = eles.get(j);
			String temp = opt.getText();
			System.out.println(temp);
			DisplayAddress.selectByIndex(j);

		}

	}

	public void selectAddress() throws InterruptedException, DocumentException, Exception {

		Select DisplayAddress = new Select(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
		DisplayAddress.selectByIndex(2);

	}

	public void commonContinue() throws Exception {
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(5000);
		System.out.println();
		boolean first = pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ContinueButton"));
		System.out.println(first);
		if (first) {
			pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));
		} else {
			boolean Second = pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ContinueLink"));
			System.out.println(Second);
			if (Second) {
				pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueLink")));
			}

		}

	}

	public void commonBack() throws Exception {
		System.out.println();
		boolean first = pageDriver.IsPresent(MoveInLoct.getlocator("//locators/BackButton"));
		System.out.println(first);
		if (first) {
			pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/BackButton")));
		} else {
			boolean Second = pageDriver.IsPresent(MoveInLoct.getlocator("//locators/BackLink"));
			System.out.println(Second);
			if (Second) {
				pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/BackLink")));
			}

		}

	}

	public void mobileHomeContactPresent() throws DocumentException, InterruptedException {
		custException.IsTrue(
				pageDriver.IsPresent(MoveInLoct.getlocator("//locators/Mobile"))
						&& pageDriver.IsPresent(MoveInLoct.getlocator("//locators/Home")),
				"Mobile and Home Contact details entering Button not Present");
	}

	public void verifyToggelingMobileHomeToggelButton() throws Exception {
		Thread.sleep(5000);
		WebElement eleMobile = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Mobile"));
		WebElement eleHome = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Home"));
		pageDriver.Clickon(eleMobile);

		String mobileClass = eleMobile.getAttribute("class");
		System.out.println(mobileClass);
		String homeClass = eleHome.getAttribute("class");
		System.out.println(homeClass);

		custException.IsTrue(mobileClass.equals("secondary-button selected") && homeClass.equals("secondary-button"),
				"Mobile Home contact buttons are not toggel in nature");

		pageDriver.Clickon(eleHome);

		eleMobile = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Mobile"));
		eleHome = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Home"));

		mobileClass = eleMobile.getAttribute("class");
		System.out.println(mobileClass);
		homeClass = eleHome.getAttribute("class");
		System.out.println(homeClass);

		custException.IsTrue(mobileClass.equals("secondary-button") && homeClass.equals("secondary-button selected"),
				"Mobile Home contact buttons are not toggel in nature");
	}

	public void clickHomeAsContact() throws Exception {
		WebElement eleHome = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Home"));
		pageDriver.Clickon(eleHome);
	}

	public void verifyCustomeridGenerated() throws DocumentException, InterruptedException, IOException {

		Thread.sleep(20000);
		// exl.WriteCustomerID("2020","2021");
		custException.IsTrue(pageDriver.IsNotPresent(MoveInLoct.getlocator("//locators/CheckAndConfirm")),
				"Move-In Confirmation Customer ID and Payment Reference Not Generated");

		String CustIDLocate = MoveInLoct.getlocator("//locators/GeneratedMoveInCustomerNumber");
		String PayRefLocate = MoveInLoct.getlocator("//locators/GeneratedMoveInPayRefNumber");

		custException.IsTrue(pageDriver.IsPresent(CustIDLocate), "Move-In Confirmation Customer ID Not Generated");

		custException.IsTrue(pageDriver.IsPresent(PayRefLocate),
				"Move-In Confirmation Payment Reference  Not Generated");

		WebElement CustEle = pageDriver.getwebelement(CustIDLocate);
		WebElement PayEle = pageDriver.getwebelement(PayRefLocate);

		System.out.println();
		String CustomerID = CustEle.getText();
		System.out.println(CustomerID);
		String PaymentRef = PayEle.getText();
		System.out.println(PaymentRef);
		exl.WriteCustomerID(CustomerID, PaymentRef);
	}

	public void verifyEmailMessage() throws DocumentException, InterruptedException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/VerifyEmailHeading")),
				"Verification Email Not found");

	}

	public void clickonFinish() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Finish")));

	}

	public void confirmationMessage() throws InterruptedException, DocumentException, Exception {
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ConfirmationMessage")),
				"Confirmation Message Not found");
	}

	public void selectDebitasNo() throws InterruptedException, DocumentException {
		pageDriver.SafeJavaScriptClick(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DirectDebitNo")));
	}

	public void selectDebitasYes() throws InterruptedException, DocumentException {
		pageDriver.SafeJavaScriptClick(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DirectDebitYes")));
	}

	public void verifyPayInMonthlyInstall() throws InterruptedException, DocumentException {
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PayMonthly")),
				"'Pay in Monthly installments' option is not available for Payment Frequency");
	}

	public void verifyPayInFull() throws InterruptedException, DocumentException {
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PayFull")),
				"'Pay in full' option is not available for Payment Frequency");
	}

	public void selectPayInMonthlyInstall() throws Exception {
		Thread.sleep(5000);
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PayMonthly")));
	}

	public void verifyDayofDirectDebitOption() throws Exception {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayOne")),
				"'1st' Day of Direct is not not available for Payment Frequency");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayFive")),
				"'5th' Day of Direct is not not available for Payment Frequency");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayTen")),
				"'10th' Day of Direct is not not available for Payment Frequency");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayFifteen")),
				"'15th' Day of Direct is not not available for Payment Frequency");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayTwenty")),
				"'20th' Day of Direct is not not available for Payment Frequency");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayTwentyFive")),
				"'25th' Day of Direct is not not available for Payment Frequency");
	}

	public void clickDayofDirectDebitOption() throws Exception {

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayOne")));
		Thread.sleep(5000);

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayFive")));
		Thread.sleep(5000);

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTen")));
		Thread.sleep(5000);

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayFifteen")));
		Thread.sleep(5000);

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTwenty")));
		Thread.sleep(5000);

		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTwentyFive")));

		Thread.sleep(5000);
	}

	public void randomClickDayofDirectDebitOption() throws Exception {
		List<WebElement> days = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/DayOne"));
		days.add(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayFive")));
		days.add(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTen")));
		days.add(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayFifteen")));
		days.add(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTwenty")));
		days.add(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTwentyFive")));

		Random rand = new Random();
		int index = rand.nextInt(days.size() - 1);
		System.out.print("");
		System.out.print("Selecting index : " + Integer.toString(index));
		pageDriver.Clickon(days.get(index));

	}

	public void selectPayInFull() throws Exception {
		Thread.sleep(5000);
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PayFull")));
		Thread.sleep(5000);
	}

	public void correspondenceAddNo() throws InterruptedException, DocumentException {
		pageDriver.SafeJavaScriptClick(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CorrespondenceNo")));
	}

	public void correspondanceCode(String code) throws Exception {

		Thread.sleep(5000);
		List<WebElement> Input = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/CustomerPostCode"));
		WebElement post = Input.get(1);
		pageDriver.SendKeys(post, code + Keys.TAB);

		List<WebElement> btns = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/FindAddressButton"));
		WebElement btn = btns.get(1);
		pageDriver.Clickon(btn);
		Thread.sleep(5000);

	}

	public void selectCorresponAdd(String Address) throws Exception {

		Thread.sleep(5000);
		List<WebElement> AddDrops = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/SelectAddress"));
		Select DisplayAddress = new Select(AddDrops.get(1));
		DisplayAddress.selectByVisibleText(Address);

	}

	public void clickOnTitle() throws InterruptedException, DocumentException, Exception {
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Titledropdow")));
	}

	public void verifyTitleOptions() throws InterruptedException, DocumentException {
		Thread.sleep(5000);
		Select titleDrop = new Select(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Titledropdow")));
		List<WebElement> eles = titleDrop.getOptions();
		List<String> titles = new ArrayList<String>();

		for (int i = 0; i < eles.size(); i++) {
			WebElement opt = eles.get(i);
			String temp = opt.getText();
			temp = temp.replaceAll("\\s", "");
			System.out.println(temp);
			titles.add(temp);

		}

		custException.IsTrue(titles.indexOf("Miss") > -1, "'Miss' not Present in Title");

		custException.IsTrue(titles.indexOf("Mr") > -1, "'Mr' not Present in Title");

		custException.IsTrue(titles.indexOf("Mrs") > -1, "'Mrs' not Present in Title");

		custException.IsTrue(titles.indexOf("Ms") > -1, "'Ms' not Present in Title");

		custException.IsTrue(titles.indexOf("Dr.") > -1, "'Dr.' not Present in Title");

		custException.IsTrue(titles.indexOf("Prof") > -1, "'Prof' not Present in Title");

	}

	public void mandatoryFieldVerification(String PageStep) throws InterruptedException, DocumentException {
		List<WebElement> errorList = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/MandatoryFields"));
		String errorMsg;
		WebElement errorEle = null;
		List<String> detailserror = new ArrayList<String>();
		if (PageStep.equalsIgnoreCase("Moving details")) {
			detailserror.add("Please enter a valid UK postcode");
			detailserror.add("Please enter your moving date");
			detailserror.add("Please enter the number of occupants.");
			detailserror.add("Occupants entered can only between 1-10");
		} else if (PageStep.equalsIgnoreCase("Your details")) {
			detailserror.add("Please select your title");
			detailserror.add("Please enter your first name");
			detailserror.add("Please enter your last name");
			detailserror.add("Please enter your date of birth");
			detailserror.add("Please provide a valid telephone number");
			detailserror.add("Please enter your email address");
		} else if (PageStep.equalsIgnoreCase("Payment details")) {
			errorList = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/PaymentDetailMandatoryMessage"));
			detailserror.add("You’ll need to correct the errors to continue.");
		}
		for (int i = 0; i < errorList.size(); i++) {
			errorEle = errorList.get(i);
			errorMsg = errorEle.getText();
			System.out.println();
			System.out.println(errorMsg);
			custException.IsTrue(detailserror.indexOf(errorMsg) > -1,
					"Mandatory Field Message >> " + errorMsg + " not found ");
		}
	}

	public void enterMandatoryField(String PageStep) throws Exception {
		if (PageStep.equalsIgnoreCase("Moving details")) {
			enterPostCode("PO39 0AN");
			findAddressClick();
			selectAddressRandom();
			enterMoveINDate();
			enterOccupant();
		} else if (PageStep.equalsIgnoreCase("Your details")) {
			enterYourDetails("Miss", "Toony", "Bill", "Taylor", "02/02/1985", "9810203040",
					"TestAutomation@QAutomation.com");
		} else if (PageStep.equalsIgnoreCase("Payment details")) {
			enterCustomerPaymentDetails("testAccountHolderName", "20", "00", "00", "55779911");
		}
	}

	public void verifyCheckDetailsPageIsOpen() throws DocumentException, InterruptedException {
		Thread.sleep(5000);
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/CheckAndConfirm")),
				"Check Detail Page not Open");
	}

	public void verifyPaymentDetailPageOpen() throws DocumentException, InterruptedException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PaymentDeatils")),
				"Payment Detail page is not open");

	}

	public void verifyYourDetailPageOpen() throws DocumentException, InterruptedException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/YourDetailsHeader")),
				"Your Detail page is not open");

	}

	public void verifyMovingDetailPageOpen() throws DocumentException, InterruptedException {

		Thread.sleep(5000);
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/MovingDetails")),
				"Your Detail page is not open");

	}

	public void verifyUpdateAddress(String Address) throws Exception {
		Address = Address.replace("\\s", "");
		String addrs[] = Address.split(",");
		for (int i = 0; i < addrs.length; i++) {
			System.out.println(addrs[i]);
			addrs[i] = addrs[i].replaceAll("\\s", "");
			System.out.println(addrs[i]);
		}

		WebElement ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/updateAddress"));
		String Temp = ele.getText();
		Temp = Temp.replaceAll("\\s", "");
		System.out.println();
		System.out.println(Temp);

		for (int i = 0; i < addrs.length; i++) {
			System.out.println(addrs[i]);
			custException.IsTrue(Temp.contains(addrs[i]), "Updated Address is not matched on Check Detail Page");

		}
	}

	public void verifySWlogoLoaded() throws InterruptedException, DocumentException {
		Thread.sleep(5000);
		WebElement ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/SouthernWaterLogo"));
		String Source = ele.getAttribute("src");
		custException.IsTrue(!Source.equals("#"), "Southern Water Logo is not loaded");
	}

	public void verifyCreateAccountContent() throws DocumentException, InterruptedException {
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/CreateAnAccountHeading")),
				"Create an Account Heading Not Found");
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/AreYou")),
				"' Are you new to Southern Water? 'Not Found");
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/StartButton")),
				"Start Button Not Found");
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/CancelButton")),
				"Cancel Button Not Found");
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/NewCustomerlabel")),
				"Yes Radio Button Not Found");
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ExistingCustomer")),
				"No Radio Button Not Found");

		WebElement ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/NewCustomerlabel"));
		String text = ele.getText();
		System.out.println();
		System.out.println(text);

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ExistingCustomer"));
		text = ele.getText();
		System.out.println();
		System.out.println(text);
	}

	public void verifyMovingPageContent() throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/MovingDetails")),
				"Moving Page Heading not found");

		activeStep("1");

		pendingSteps(4);

		String Loct = MoveInLoct.getlocator("//locators/NewAddress");
		String Temp = Loct.replace("HH2", "New address");
		custException.IsTrue(pageDriver.IsPresent(Temp), "New Address Label not found");

		Temp = Loct.replace("HH2", "Correspondence address");
		custException.IsTrue(pageDriver.IsPresent(Temp), "Correspondence Address Label not found");

		Temp = Loct.replace("HH2", "Household details");
		custException.IsTrue(pageDriver.IsPresent(Temp), "Household details Label not found");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/BackButton")),
				"Back Button Not Found");

	}

	public void verifyYourDetailPageContent() throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/YourDetailsHeader")),
				"Your Detail Page Heading not found");

		activeStep("2");

		pendingSteps(3);

		visitedSteps(1);

		String Loct = MoveInLoct.getlocator("//locators/TextLabel");
		String Temp = Loct.replace("HH2", "Title");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Title' Label not found");

		Temp = Loct.replace("HH2", "First name");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'First name' Label not found");

		Temp = Loct.replace("HH2", "Middle name (optional)");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Middle name (optional)' Label not found");

		Temp = Loct.replace("HH2", "Last name");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Last name' Label not found");

		Temp = Loct.replace("HH2", " Date of birth ");
		custException.IsTrue(pageDriver.IsPresent(Temp), "' Date of birth ' Label not found");

		Temp = Loct.replace("HH2", " Preferred phone number ");
		custException.IsTrue(pageDriver.IsPresent(Temp), "' Preferred phone number ' Label not found");

		Temp = Loct.replace("HH2", " Email address ");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'  Email address  ' Label not found");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/BackButton")),
				"Back Button Not Found");

	}

	public void verifyPaymentPageContent() throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PaymentDeatils")),
				"Payment Detail Page Heading not found");

		activeStep("3");

		pendingSteps(2);

		visitedSteps(2);

		String Loct = MoveInLoct.getlocator("//locators/TextLabel");
		String Temp = Loct.replace("HH2", "Name of account holder");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Name of account holder' Label not found");

		Temp = Loct.replace("HH2", "Sort code");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Sort code' Label not found");

		Temp = Loct.replace("HH2", "Account number");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Account number' Label not found");

		WebElement ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PayMonthly"));
		controlFound(ele, "Pay in monthly instalments");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PayFull"));
		controlFound(ele, "Pay in full");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayOne"));
		controlFound(ele, "1st");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayFive"));
		controlFound(ele, "5th");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTen"));
		controlFound(ele, "10th");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayFifteen"));
		controlFound(ele, "15th");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTwenty"));
		controlFound(ele, "20th");

		ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/DayTwentyFive"));
		controlFound(ele, "25th");

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/BackButton")),
				"Back Button Not Found");

	}

	public void verifyCheckDetailPageContent() throws InterruptedException, DocumentException {

		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/CheckAndConfirm")),
				"Check Detail Page Heading not found");

		activeStep("4");

		pendingSteps(1);

		visitedSteps(3);

		String Loct = MoveInLoct.getlocator("//locators/NewAddress");
		String Temp = Loct.replace("HH2", "Your details");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Your details' Label not found");

		Temp = Loct.replace("HH2", "Payment details");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Payment details' Label not found");

		Temp = Loct.replace("HH2", "Moving details");
		custException.IsTrue(pageDriver.IsPresent(Temp), "'Moving details' Label not found");

		List<String> Heading = new ArrayList<String>();
		Heading.add("Name");
		Heading.add("Date of birth");
		Heading.add("Preferred phone number");
		Heading.add("Email address");
		Heading.add("New address");
		Heading.add("Move in date");
		Heading.add("Customer type");
		Heading.add("Number of occupants");
		Heading.add("Payment method");
		Heading.add("Name of account holder");
		Heading.add("Sort code");
		Heading.add("Account number");
		Heading.add("Payment frequency");
		Heading.add("Payment date");
		
		Loct = MoveInLoct.getlocator("//locators/CheckLabel");
		List<WebElement> eles=pageDriver.getwebelements(Loct);
		System.out.println();		
		for(int i=0;i<eles.size();i++)
		{
			WebElement ele=eles.get(i);
			Temp=ele.getText();
			System.out.println(Temp);
			custException.IsTrue(Heading.indexOf(Temp)>-1, Temp+" Label not found");
		}

		Loct = MoveInLoct.getlocator("//locators/CheckValues");
		eles=pageDriver.getwebelements(Loct);
		System.out.println();			
		for(int i=0;i<eles.size();i++)
		{
			WebElement ele=eles.get(i);
			Temp=ele.getText();
			System.out.println(Temp);
			custException.IsTrue(Temp!=""&&Temp!=null, "Label Values are correctly loaded");
		}

		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/BackButton")),
				"Back Button Not Found");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ConfirmDetailsButton")),
				"Confirm details button not found");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/YourDetailEdit")),
				"Your Detail Edit Link not found");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/MovingEdit")),
				"Moving Detail Edit Link not found");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PaymentEdit")),
				"Payment Edit Link not found");

	}

	public void controlFound(WebElement ele, String val) {
		String text = ele.getText();
		System.out.println();
		System.out.println(text);
		custException.IsTrue(text.equals(val), "'" + val + "' not found");
	}

	public void activeStep(String stepnum) throws InterruptedException, DocumentException {
		WebElement ele = pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ActiveStep"));
		String text = ele.getText();
		System.out.println();
		System.out.println(text);
		custException.IsTrue(text.equals(stepnum), "'" + stepnum + "' is not active Step");

	}

	public void pendingSteps(int steps) throws InterruptedException, DocumentException {
		List<WebElement> eles = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/PendingStep"));
		custException.IsTrue(eles.size() == steps, "Pending Steps count is not Correct");

	}

	public void visitedSteps(int steps) throws InterruptedException, DocumentException {
		List<WebElement> eles = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/VisitedStep"));
		custException.IsTrue(eles.size() == steps, "Visited Steps Count is not correct");

	}
}
