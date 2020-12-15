package pageFunctions.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ConfirmDetailsButton")));
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
		pageDriver.SendKeys(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/CustomerPostCode")),
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

	public void commonContinue() throws Exception 
	{
		System.out.println();
		boolean first=pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ContinueButton"));
		System.out.println(first);
		if(first)
		{
			pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));
		}
		else 
		{
			boolean Second=pageDriver.IsPresent(MoveInLoct.getlocator("//locators/ContinueLink"));
			System.out.println(Second);
			if(Second)
			{
				pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueLink")));
			}
			
		}
		
		
		/*try {
			List<WebElement> buttons = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/ContinueButton"));
			List<WebElement> links = pageDriver.getwebelements(MoveInLoct.getlocator("//locators/ContinueLink"));
			if (buttons.size() > 0)
				pageDriver.Clickon(buttons.get(0));
			else if (links.size() > 0)
				pageDriver.Clickon(links.get(0));
		} catch (Exception ex) {
			System.out.print("Check Continue Button");
			System.out.print(ex.toString());
		}*/
	}

	public void mobileHomeContactPresent() throws DocumentException, InterruptedException {
		custException.IsTrue(
				pageDriver.IsPresent(MoveInLoct.getlocator("//locators/Mobile"))
						&& pageDriver.IsPresent(MoveInLoct.getlocator("//locators/Home")),
				"Mobile and Home Contact details entering Button not Present");
	}

	public void verifyToggelingMobileHomeToggelButton() throws Exception {
		Thread.sleep(5000);
		WebElement eleMobile=pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Mobile"));
		WebElement eleHome=pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Home"));
		pageDriver.Clickon(eleMobile);
		
		String mobileClass=eleMobile.getAttribute("class");
		System.out.println(mobileClass);
		String homeClass=eleHome.getAttribute("class");
		System.out.println(homeClass);
		
		custException.IsTrue(mobileClass.equals("secondary-button selected") && homeClass.equals("secondary-button"), "Mobile Home contact buttons are not toggel in nature");
		
		pageDriver.Clickon(eleHome);
		
		eleMobile=pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Mobile"));
		eleHome=pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Home"));
		
		
		mobileClass=eleMobile.getAttribute("class");
		System.out.println(mobileClass);
		homeClass=eleHome.getAttribute("class");
		System.out.println(homeClass);
		
		custException.IsTrue(mobileClass.equals("secondary-button") && homeClass.equals("secondary-button selected"), "Mobile Home contact buttons are not toggel in nature");
	}

	public void verifyCustomeridGenerated() throws DocumentException, InterruptedException {
		Thread.sleep(20000);

		// custException.IsTrue(pageDriver.IsNotPresent(MoveInLoct.getlocator("//locators/MoveInCustomerLabel")),"Movin
		// Confirmation label Customer label Not found");
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/GeneratedMoveInCustomerNumber")),
				"Movin Confirmation Customer ID Not Generated");
		// custException.pageDriver.IsNotPresent(MoveInLoct.getlocator("//locators/MoveInPayRefLabel"));
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/GeneratedMoveInPayRefNumber")),
				"\"Movin Confirmation Payment Reference  Not Generated");
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
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PayMonthly")),"'Pay in Monthly installments' option is not available for Payment Frequency");
	}
	
	public void verifyPayInFull() throws InterruptedException, DocumentException {
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/PayFull")),"'Pay in full' option is not available for Payment Frequency");
	}
	
	public void selectPayInMonthlyInstall() throws Exception 
	{	
		Thread.sleep(5000);
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/PayMonthly")));
	}
	
	public void verifyDayofDirectDebitOption() throws Exception 
	{	
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayOne")),"'1st' Day of Direct is not not available for Payment Frequency");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayFive")),"'5th' Day of Direct is not not available for Payment Frequency");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayTen")),"'10th' Day of Direct is not not available for Payment Frequency");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayFifteen")),"'15th' Day of Direct is not not available for Payment Frequency");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayTwenty")),"'20th' Day of Direct is not not available for Payment Frequency");
		
		custException.IsTrue(pageDriver.IsPresent(MoveInLoct.getlocator("//locators/DayTwentyFive")),"'25th' Day of Direct is not not available for Payment Frequency");
	}
	
	public void clickDayofDirectDebitOption() throws Exception 
	{	
		
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
	
	public void selectPayInFull() throws Exception 
	{
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
	
	public void clickOnTitle() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Titledropdow")));
	}
	
	public void verifyTitleOptions() throws InterruptedException, DocumentException
	{
		Thread.sleep(5000);
		Select titleDrop = new Select(pageDriver.getwebelement(MoveInLoct.getlocator("//locators/Titledropdow")));
		List<WebElement> eles = titleDrop.getOptions();
		List<String> titles=new ArrayList<String>();
		
		for (int i = 0; i < eles.size(); i++) {
			WebElement opt = eles.get(i);
			String temp = opt.getText();
			temp=	temp.replaceAll("\\s", "");
			System.out.println(temp);
			titles.add(temp);
			
		}
		
		custException.IsTrue(titles.indexOf("Miss")>-1,"'Miss' not Present in Title");
		
		custException.IsTrue(titles.indexOf("Mr")>-1,"'Mr' not Present in Title");
		
		custException.IsTrue(titles.indexOf("Mrs")>-1,"'Mrs' not Present in Title");
		
		custException.IsTrue(titles.indexOf("Ms")>-1,"'Ms' not Present in Title");
		
		custException.IsTrue(titles.indexOf("Dr.")>-1,"'Dr.' not Present in Title");
		
		custException.IsTrue(titles.indexOf("Prof")>-1,"'Prof' not Present in Title");
		
				
	}
}
