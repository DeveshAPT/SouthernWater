package pageFunctions.web;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class AccountDashBoardFunctions {
	public webHelper pageDriver;
	public AssertionExceptionManager custException;
	public String enteredName, enteredCustomerNumber, enteredEmailID, newEmail, firstSecurityQuest;
	xmlreader payBillLoct = new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist = new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	xmlreader loginLoct = new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
	int lastTabCount = -1;
	int newTabCount = -1;

	public AccountDashBoardFunctions(webHelper dr) {
		System.out.println("I am in POM");
		pageDriver = dr;
		custException = new AssertionExceptionManager(dr);
	}

	public void yourAccountDisplayed() throws Exception {
		Thread.sleep(7000);
		String locator = loginLoct.getlocator("//locators/AccountButtons");
		locator = locator.replace("DisplayText", "Your Account");
		custException.IsTrue(pageDriver.IsPresent(locator), "Your Account Button is not display",
				"Your Account Button Loaded and Verified");
	}

	public void yourAccountClick() throws Exception {
		String locator = loginLoct.getlocator("//locators/AccountButtons");
		locator = locator.replace("DisplayText", "Your Account");
		pageDriver.Clickon(pageDriver.getwebelement(locator));
		Thread.sleep(7000);
	}

	public void yourAccountShouldNotVisible() throws Exception {
		String locator = loginLoct.getlocator("//locators/AccountButtons");
		locator = locator.replace("DisplayText", "Your Account");
		custException.IsTrue(pageDriver.IsNotPresent(locator), "'Your Account' Still visible after logout");
	}

	public void dashBoardHead() throws Exception {
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/AccountDashBoardLink")),
				"Account DashBoard Main Button not Loaded");
	}

	public void logoutOption() throws Exception {
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/LogOut")),
				"Logout Button not Loaded");
	}

	public void logoutClick() throws Exception {

		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/LogOut")),
				"Logout Button not Loaded");
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/LogOut")));
	}

	public void logoutSuccessfully() throws Exception {
		Thread.sleep(7000);
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/LogoutComplete")),
				"Logout Message 'You have been logged out successfully' not found");

	}

	public void dashBoardOptionsVerification(String OptionText) throws Exception {
		List<WebElement> elements = pageDriver
				.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		boolean found = false;

		for (int i = 0; i <= elements.size(); i++) {
			WebElement ele = elements.get(i);
			String text = ele.getText().toString();
			System.out.println(text);
			if (text.equals(OptionText)) {
				found = true;
				break;
			}

		}
		custException.IsTrue(found, "DashBoard Option = '" + OptionText + " is not Loaded");
	}

	public void dashBoardOptionsClick(String OptionText) throws Exception {
		// YourAccountClick();
		List<WebElement> elements = pageDriver
				.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		WebElement ele = elements.get(0);
		String text = ele.getText().toString();
		text = text.trim();
		if (text == "" || text == null)
			yourAccountClick();
		elements = pageDriver.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		boolean found = false;
		/*
		 * if(elements.size()==0) { YourAccountClick(); }
		 */
		for (int i = 0; i <= elements.size(); i++) {
			ele = elements.get(i);
			text = ele.getText().toString();
			System.out.println(text);
			if (text.equals(OptionText)) {
				found = true;
				pageDriver.Clickon(ele);
				Thread.sleep(5000);
				break;
			}

		}
		custException.IsTrue(found, "DashBoard Option = '" + OptionText + " is not Loaded unable to click");
	}

	public void submitMeterReadingPageOpen() throws DocumentException, InterruptedException {

		Thread.sleep(5000);
		String LocateMe = loginLoct.getlocator("//locators/SubmitMeterPageHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Submit Reading Page Not Open ");
	}

	public void closeAccountPageOpen() throws DocumentException, InterruptedException {

		Thread.sleep(5000);
		String LocateMe = loginLoct.getlocator("//locators/CloseAccountButton");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Close Account Page Not Open ");
	}

	public void makePaymentPageOpen() throws DocumentException, InterruptedException {

		Thread.sleep(5000);
		String LocateMe = loginLoct.getlocator("//locators/PaymentPageHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Payment Page Not Open ");
	}

	public void dashBoardQuickLinkFound(String DisplayText) throws Exception {
		Thread.sleep(5000);
	
		
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkDashBoard");
		LocateMe = LocateMe.replace("DisplayText", DisplayText);
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "DashBoard Quick Link = " + DisplayText + " not found ");
	}
	public void MakeMenuDisplay() throws Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/YourAccount")));
		Thread.sleep(5000);
		String MenuDiv = loginLoct.getlocator("//locators/MenuDiv");
		WebElement Menus=pageDriver.getwebelement(MenuDiv);
		String MenuClass=Menus.getAttribute("class");
		System.out.println();
		System.out.println(MenuClass);
		if(!MenuClass.contains("show"))
		{
			pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/YourAccount")));
			Thread.sleep(5000);
		}
		
	}

	public void dashBoardQuickLinkClick(String DisplayText) throws Exception {
		Thread.sleep(5000);
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkDashBoard");
		LocateMe = LocateMe.replace("DisplayText", DisplayText);

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "DashBoard Quick Link = " + DisplayText + " not found ");

		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	// Payment Panding Scenerio

	public void dashBoardMakePaymentButton() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkMakePayment");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "DashBoard Make Payment Link Not found ");
	}

	public void dashBoardMakePaymentButtonNotDisplay() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkMakePayment");

		custException.IsTrue(pageDriver.IsNotPresent(LocateMe), "DashBoard Make Payment Link Not found ");
	}

	public void dashBoardStruggglingToPay() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkStrugglingPay");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Struggling to Pay? not found on DashBoard");
	}

	public void struggglingToPayClick() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkStrugglingPay");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Struggling to Pay? not found on DashBoard");
		lastTabCount = pageDriver.TabSize();
		System.out.println();
		System.out.println(Integer.toString(lastTabCount));
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
		
	}

	public void dashBoardAmendDirectDebit() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickAmendDebit");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Amend Direct Debit not found on DashBoard");
	}

	public void dashBoardSubmitReading() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkMeterReading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"Quick Link 'Submit a Meter Reading' not found on DashBoard");
	}

	public void dashBoardMovingLink() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkMoving");

		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"Quick Link 'Tell us You are Moving' not found on DashBoard");
	}

	public void dashBoardFooterButton(String DisplayText) throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkFooterButton");
		LocateMe = LocateMe.replace("DisplayText", DisplayText);

		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"Footer Button '" + DisplayText + "' not found on DashBoard");
	}

	public void dashBoardLatestBillMainHeading() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/LatestBillMainHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill heading not found on DashBoard");
	}

	public void dashBoardLatestBillAmount() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/LatestBillAmount");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill Amount not found on DashBoard");
	}

	public void dashBoardLatestBillDate() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/LatestBillDateLabel");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill Date label not found on DashBoard");

		LocateMe = loginLoct.getlocator("//locators/LatestBillDate");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill Date Date not found on DashBoard");
	}

	public void dashBoardPaymentReferenceNumber() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/PaymentRefNumberLabel");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Payment Reference Label not found on DashBoard");

		LocateMe = loginLoct.getlocator("//locators/PaymentRefNumber");

		WebElement ele = pageDriver.getwebelement(LocateMe);
		String Temp = ele.getText();
		String[] OutPut = Temp.split(":");
		System.out.println(Temp);
		custException.IsTrue(OutPut.length > 1, "Payment Reference Number Not Loaded");
		custException.IsTrue(OutPut[1].trim() != "", "Payment Reference Number is blank");

	}

	public void dashBoardCustomerReferenceNumber() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/CustomerNumberLabel");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Customer Reference Label not found on DashBoard");

		LocateMe = loginLoct.getlocator("//locators/CustomerNumber");

		WebElement ele = pageDriver.getwebelement(LocateMe);
		String Temp = ele.getText();
		String[] OutPut = Temp.split(":");
		System.out.println(Temp);
		custException.IsTrue(OutPut.length > 1, "Customer Number is Not Loaded");
		custException.IsTrue(OutPut[1].trim() != "", "Customer Number is blank");

	}

	public void dashBoardBillDueLabel() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/BillAmountDueHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Bill Amount Label not found on DashBoard");

	}

	public void dashBoardBillAmount() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/BillAmount");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Bill Amount not found on DashBoard");

	}

	public void dashBoardBillAmountDate() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/BillAmountDueDate");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Bill Amount Due Date not found on DashBoard");

	}

	public void matchBillDateAndDueDateisSame() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/LatestBillDate");

		WebElement ele = pageDriver.getwebelement(LocateMe);
		String Date1 = ele.getText();
		Date1 = Date1.replaceAll("\\s", "");
		System.out.println("");
		System.out.println(Date1);

		LocateMe = loginLoct.getlocator("//locators/BillAmountDueDate");
		ele = pageDriver.getwebelement(LocateMe);
		String Date2 = ele.getText();
		Date2 = Date2.replaceAll("\\s", "");
		System.out.println("");
		System.out.println(Date2);

		custException.IsTrue(Date1.equalsIgnoreCase(Date1), "Latest Bill Date and Amount Due Date not Matched");

	}

	public void meterReadingHeading() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/MeterReadingHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "MeterReading Heading Section 'Meter reading' not found");

	}

	public void unMeterReadingHeading() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/UnmeterHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"MeterReading Heading Section 'This account is not metered.' not found");

	}

	public void meterReadingLabelAndValues() throws DocumentException, InterruptedException {

		String LocateMe = loginLoct.getlocator("//locators/MeterReadSectionLabel");
		List<WebElement> labels = pageDriver.getwebelements(LocateMe);
		custException.IsTrue(labels.size() == 3, "MeterReading Labels not loaded correctly");

		LocateMe = loginLoct.getlocator("//locators/MeterReadSectionText");
		List<WebElement> texts = pageDriver.getwebelements(LocateMe);
		custException.IsTrue(texts.size() == 3, "MeterReading Labels values not loaded correctly");

		WebElement ele1 = labels.get(0);
		String label = ele1.getText();
		// label=label.replaceAll("\\s", "");
		custException.IsTrue(label.equalsIgnoreCase("Last meter reading"), "Last meter reading label not found");

		ele1 = texts.get(0);
		label = ele1.getText();
		label = label.replaceAll("\\s", "");
		custException.IsTrue(label != "" || label != null, "Last meter reading value not found");
	}

	public void meterNumberLabelAndValues() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/MeterReadSectionLabel");
		List<WebElement> labels = pageDriver.getwebelements(LocateMe);
		custException.IsTrue(labels.size() == 3, "MeterReading Labels not loaded correctly");

		LocateMe = loginLoct.getlocator("//locators/MeterReadSectionText");
		List<WebElement> texts = pageDriver.getwebelements(LocateMe);
		custException.IsTrue(texts.size() == 3, "MeterReading Labels values not loaded correctly");

		WebElement ele1 = labels.get(1);
		String label = ele1.getText();
		// label=label.replaceAll("\\s", "");
		custException.IsTrue(label.equalsIgnoreCase("Meter number"), "Meter number label not found");

		ele1 = texts.get(1);
		label = ele1.getText();
		label = label.replaceAll("\\s", "");
		custException.IsTrue(label != "" || label != null, "Meter number value not found");
	}

	public void meterReadLabelAndValues() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/MeterReadSectionLabel");
		List<WebElement> labels = pageDriver.getwebelements(LocateMe);

		LocateMe = loginLoct.getlocator("//locators/MeterReadSectionText");
		List<WebElement> texts = pageDriver.getwebelements(LocateMe);

		WebElement ele1 = labels.get(2);
		String label = ele1.getText();
		// label=label.replaceAll("\\s", "");
		custException.IsTrue(label.equalsIgnoreCase("Date last read"), "Date last read label not found");

		ele1 = texts.get(2);
		label = ele1.getText();
		label = label.replaceAll("\\s", "");
		custException.IsTrue(label != "" || label != null, "Date last read value not found");
	}

	public void extraFunction() throws DocumentException, InterruptedException {
		String LocateMe = loginLoct.getlocator("//locators/LatestBillMainHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill heading not found on DashBoard");
	}

	public void paperlessSettingPageOpen() throws Exception {
		Thread.sleep(3500);
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/PaperLessSettingHeading")),
				"Paperless Seeting Heading not found not found");

	}

	public void selectOnline() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/PaperlessOnline");
	}

	public void clickUpdateofPaperless() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/PaperlessUpdate");
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	public void clickSubmitMeterReadingButton() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/SubmitMeterReading");
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	public void clickYouAreMovingButton() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkMoving");
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	public void clickMakeAPaymentButton() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/LoginMakeaPayment");
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	public void clickViewProfileButton() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/ViewProfileButton");
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	public void thankYouMessage() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/PaperlessUpdate");

		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"'Thank You' Message not depict on screen after paperless Update");
	}

	public void setupDirectDebitPageOpen() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/SetupDirectDebitHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Set Up Direct Debit page not open ");
	}

	public void updateProfilePageOpen() throws Exception {

		String LocateMe = loginLoct.getlocator("//locators/UpdateProfileHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Update Profile Page is not open");
	}

	public void yourViewBillsPageOpen() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/BillStatement");

		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"Your Account Statement(View bills/Account statement) Page is not open");
	}

	public void paymentHistoryPageOpen() throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/PaymentHistoryPageHeading");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Payment History Page is not open");
	}

	public void dashBoardFooterButtonClick(String DisplayText) throws Exception {
		String LocateMe = loginLoct.getlocator("//locators/QuickLinkFooterButton");
		LocateMe = LocateMe.replace("DisplayText", DisplayText);

		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"Footer Button '" + DisplayText + "' not found on DashBoard");
		lastTabCount = pageDriver.TabSize();

		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}

	public void contactUsPageOpenInNewTab() throws Exception {

		Thread.sleep(7000);
		newTabCount = pageDriver.TabSize();
		custException.IsTrue(newTabCount - lastTabCount == 1, "New Tab is not open");
		pageDriver.SwitchToLastTab();
		String LocateMe = loginLoct.getlocator("//locators/ContactUsPageHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Contact Us page is not open");
	}

	public void strugglingPageOpenInNewTab() throws Exception {

		Thread.sleep(15000);
		newTabCount = pageDriver.TabSize();
		System.out.print(Integer.toString(lastTabCount));
		System.out.print(Integer.toString(newTabCount));
		custException.IsTrue(newTabCount - lastTabCount == 1, "New Tab is not open");
		pageDriver.SwitchToLastTab();
		String LocateMe = loginLoct.getlocator("//locators/PayHelpPageHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Help Paying page not open");
	}

	public void saveWaterPageOpenInNewTab() throws Exception {
		newTabCount = pageDriver.TabSize();
		custException.IsTrue(newTabCount - lastTabCount == 1, "New Tab is not open");
		pageDriver.SwitchToLastTab();
		String LocateMe = loginLoct.getlocator("//locators/SaveWaterBanner");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Save Water page is not open");
	}

	public void preventBlockagePageOpenInNewTab() throws Exception {
		newTabCount = pageDriver.TabSize();
		custException.IsTrue(newTabCount - lastTabCount == 1, "New Tab is not open");
		pageDriver.SwitchToLastTab();
		String LocateMe = loginLoct.getlocator("//locators/PreventBlockage");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Prevent Blockage page is not open");
	}

	public void yourProfileHeadingDashBoard() throws DocumentException, InterruptedException {
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/YourProfileDashboard")),
				"Your Profile Section Heading 'Your Profile' not loaded");
	}

	public void yourProfileEmailHeadingAndEmailID() throws DocumentException, InterruptedException {
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/YourProfileEmailIDHeading")),
				"Your Profile Section Email Address label not loaded ");

		String LocateMe = loginLoct.getlocator("//locators/YourProfileEmailID");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Your Profile Section Email ID label not loaded ");

		WebElement ele = pageDriver.getwebelement(LocateMe);
		String temp = ele.getText();

		custException.IsTrue(temp.trim() != "" && temp.trim() != null,
				"Your Profile Section Customer Email ID not loaded");
	}

	public void yourProfileAddressLabelAndValue() throws DocumentException, InterruptedException {
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/YourAddressLabel")),
				"Your Profile Section Correspondence Address label not loaded ");

		String LocateMe = loginLoct.getlocator("//locators/YourAddressValues");
		custException.IsTrue(pageDriver.IsPresent(LocateMe),
				"Your Profile Section Customer Correspondence not loaded ");

		WebElement ele = pageDriver.getwebelement(LocateMe);
		String temp = ele.getText();

		custException.IsTrue(temp.trim() != "" && temp.trim() != null,
				"Your Profile Section Customer Correspondence is Blank");
	}

	public void accountDetailsSectionVerification() throws DocumentException, InterruptedException {
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/AccountDetailHeading")),
				"Your Account Section 'Account details' heading not loaded");

		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/PropertyAddresslabel")),
				"Your Account Section 'Property address' label not loaded ");

		String LocateMe = loginLoct.getlocator("//locators/PropertyAddress");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Your Profile Section Address value not loaded ");

		WebElement ele = pageDriver.getwebelement(LocateMe);
		String temp = ele.getText();

		custException.IsTrue(temp.trim() != "" && temp.trim() != null, "Your Profile Section Address value  is Blank");

		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/YourServiceLabel")),
				"Your Profile Section 'Your services' label not loaded ");

		LocateMe = loginLoct.getlocator("//locators/YourServiceType");

		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Your Profile Section Address value not loaded ");

		ele = pageDriver.getwebelement(LocateMe);
		temp = ele.getText();

		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/YourServiceType")),
				"Your Profile Section Address value is Blank");
	}
}
