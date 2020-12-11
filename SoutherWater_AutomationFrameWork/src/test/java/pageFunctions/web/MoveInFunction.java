package pageFunctions.web;

import java.io.IOException;
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

	public webHelper pagedriver;
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
		pagedriver = dr;
		custException = new AssertionExceptionManager(pagedriver);
	}

	public void OpenMoveInPage() throws Exception {
		Thread.sleep(3000);
		pagedriver.WaitforPageToBeReady();
		// pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/AcceptCokies")));
		pagedriver.OpenURL(prpertyreader.readproperty("MoveInUrl"));
		pagedriver.WaitforPageToBeReady();
		System.out.println(pagedriver.GetTitle());
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CreateAnAccountHeading")),
				"Create an account");
	}

	public void StartClick() throws InterruptedException, DocumentException, Exception {
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/StartButton")));
	}

	public void FillMoveINDetails(String postCode, String address) throws Exception {
		Thread.sleep(3000);
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")),
				"Moving details");
		EnterPostCode(postCode);

		FindAddressClick();
		Thread.sleep(3000);

		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")), address);
		Thread.sleep(2000);
	}

	public void EnterMoveINDate() throws InterruptedException, IOException, DocumentException {
		String date1 = core.baseDriverHelper.GetFutureDate();
		System.out.println("selected date::: " + date1);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/YourMovingDateLabel")),
				"Your moving date");
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MoveOutDate")),
				date1 + Keys.TAB);
		Thread.sleep(2000);
	}

	public void EnterOccupant() throws InterruptedException, IOException, DocumentException {

		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupants")),
				String.valueOf(NumberOfOccupants) + Keys.TAB);
		Thread.sleep(2000);
	}

	public void ContinueClick() throws InterruptedException, DocumentException, Exception {
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));
		Thread.sleep(2000);
		pagedriver.WaitforPageToBeReady();
	}

	public void VerifyYourDetailsSteps() throws InterruptedException, DocumentException {
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/YourDetailsHeader")),
				"Your details");
		Thread.sleep(2000);

	}

	public void EnterYourDetails(String title, String firstName, String middleName, String lastName, String dOB,
			String contact, String email) throws InterruptedException, DocumentException, Exception {

		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")));
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")), title);
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/FirstName")), firstName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MiddleName")), middleName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/LastName")), lastName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/DateOfBirth")), dOB + Keys.TAB);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/UserMobileNumber")), contact);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/UserEmailAddress")), email);
		Thread.sleep(2000);
	}

	public void EnterCustomerPaymentDetails(String accHoldName, String code1, String code2, String code3,
			String accountNumber) throws Exception {
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/PaymentDeatils")),
				"Payment details");
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/AccountHolderName")),
				accHoldName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeOne")), code1);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeTwo")), code2);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeThree")), code3);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/BankAccountNumber")),
				accountNumber);
		Thread.sleep(2000);
	}

	public void VerifyMoveINDetails(String firstName, String midName, String lastName, String email, String occupant,
			String accountNumber) throws Exception {
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CheckAndConfirmHeader")),
				"Check and confirm");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyName")),
				firstName + " " + midName + " " + lastName);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyEmail")), email);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyNumberOfOccupants")),
				occupant);
		Thread.sleep(3000);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/AccountNumberLabel")),
				"Account number");
		Thread.sleep(3000);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyAccountNumber")),
				accountNumber);
		Thread.sleep(3000);
	}

	public void ConfirmDetailButton() throws InterruptedException, DocumentException, Exception {
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ConfirmDetailsButton")));
	}

	public void VerifyMoveInDetailPageLoaded() throws Exception {
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")),
				"Moving details");
		Thread.sleep(2000);

	}

	public void VerifyMandatoryFieldsMessage() throws Exception {
		Thread.sleep(2000);
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")),
				"There’s a problem");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")),
				"You’ll need to correct the errors to continue.");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderUKPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderYourMovingDateErrorMessage")),
				"Please enter your moving date");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderNumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ValidUkPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDateErroeMessage")),
				"Please enter your moving date");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants");

	}

	public void EnterPostCode(String postcode) throws InterruptedException, IOException, DocumentException {
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CustomerPostCode")),
				postcode + Keys.TAB);
	}

	public void FindAddressClick() throws InterruptedException, DocumentException, Exception {
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/FindAddressButton")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}

	public void InValidAddressMessage() throws Exception {
		Thread.sleep(2000);
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")),
				"There’s a problem");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")),
				"You’ll need to correct the errors to continue.");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderUKPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ValidUkPostCodeErrorMessage")),
				"Please enter a valid UK postcode");
	}

	public void VerifyEnterAddressManually() throws InterruptedException, DocumentException {
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/EnterYourAddressManually")),
				"Enter your address manually");
	}

	public void PleaseSelectAddressAndOtherErrorMessage() throws InterruptedException, DocumentException {
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")),
				"There’s a problem");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")),
				"You’ll need to correct the errors to continue.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/PleaseSelectAnAddress")),
				"Please select an address");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderYourMovingDateErrorMessage")),
				"Please enter your moving date");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderNumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDateErroeMessage")),
				"Please enter your moving date");
		pagedriver.VerifyText(
				pagedriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupantsErrorMessage")),
				"Please enter the number of occupants");
	}

	public void SelectAddress(String address) throws InterruptedException, DocumentException, Exception {
		int j = 0;
		Select DisplayAddress = new Select(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
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

	public void SelectAddress() throws InterruptedException, DocumentException, Exception {

		Select DisplayAddress = new Select(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
		DisplayAddress.selectByIndex(2);

	}

	public void CommonContinue() throws Exception {
		try {
			List<WebElement> buttons = pagedriver.getwebelements(MoveInLoct.getlocator("//locators/ContinueButton"));
			List<WebElement> links = pagedriver.getwebelements(MoveInLoct.getlocator("//locators/ContinueLink"));
			if (buttons.size() > 0)
				pagedriver.Clickon(buttons.get(0));
			else if (links.size() > 0)
				pagedriver.Clickon(links.get(0));
		} catch (Exception ex) {
			System.out.print("Check Continue Button");
			System.out.print(ex.toString());
		}
	}

	public void verifyCustomeridGenerated() throws DocumentException, InterruptedException {
		Thread.sleep(20000);

		// custException.IsTrue(pagedriver.IsNotPresent(MoveInLoct.getlocator("//locators/MoveInCustomerLabel")),"Movin
		// Confirmation label Customer label Not found");
		custException.IsTrue(pagedriver.IsNotPresent(MoveInLoct.getlocator("//locators/GeneratedMoveInCustomerNumber")),
				"Movin Confirmation Customer ID Not Generated");
		// custException.pagedriver.IsNotPresent(MoveInLoct.getlocator("//locators/MoveInPayRefLabel"));
		custException.IsTrue(pagedriver.IsNotPresent(MoveInLoct.getlocator("//locators/GeneratedMoveInPayRefNumber")),
				"\"Movin Confirmation Payment Reference  Not Generated");
	}

	public void verifyEmailMessage() throws DocumentException, InterruptedException {

		custException.IsTrue(pagedriver.IsNotPresent(MoveInLoct.getlocator("//locators/VerifyEmailHeading")),
				"Verification Email Not found");

	}

	public void ClickonFinish() throws InterruptedException, DocumentException, Exception {
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/Finish")));

	}

	public void ConfirmationMessage() throws InterruptedException, DocumentException, Exception {
		custException.IsTrue(pagedriver.IsNotPresent(MoveInLoct.getlocator("//locators/ConfirmationMessage")),
				"Confirmation Message Not found");
	}

	public void SelectDebitasNo() throws InterruptedException, DocumentException {
		pagedriver.SafeJavaScriptClick(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/DirectDebitNo")));
	}

	public void CorrespondenceAddNo() throws InterruptedException, DocumentException {
		pagedriver.SafeJavaScriptClick(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrespondenceNo")));
	}

	public void CorrespondanceCode(String code) throws Exception {

		Thread.sleep(5000);
		List<WebElement> Input = pagedriver.getwebelements(MoveInLoct.getlocator("//locators/CustomerPostCode"));
		WebElement post = Input.get(1);
		pagedriver.SendKeys(post, code + Keys.TAB);

		List<WebElement> btns = pagedriver.getwebelements(MoveInLoct.getlocator("//locators/FindAddressButton"));
		WebElement btn = btns.get(1);
		pagedriver.Clickon(btn);
		Thread.sleep(5000);

	}

	public void SelectCorresponAdd(String Address) throws Exception {

		Thread.sleep(5000);
		List<WebElement> AddDrops = pagedriver.getwebelements(MoveInLoct.getlocator("//locators/SelectAddress"));

		Select DisplayAddress = new Select(AddDrops.get(1));
		DisplayAddress.selectByVisibleText(Address);

	}
}
