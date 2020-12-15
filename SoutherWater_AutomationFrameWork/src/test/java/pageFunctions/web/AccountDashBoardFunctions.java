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
	public  webHelper pageDriver;
	public AssertionExceptionManager custException;
	public String enteredName,  enteredCustomerNumber, enteredEmailID,newEmail, firstSecurityQuest;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
	int lastTabCount=-1;
	int newTabCount=-1;
	
	public AccountDashBoardFunctions(webHelper dr)
	{
		System.out.println("I am in POM");
		pageDriver=  dr;
		custException=new AssertionExceptionManager(dr);
	}
	
	public void YourAccountDisplayed() throws Exception
	{
		Thread.sleep(5000);
		String locator=loginLoct.getlocator("//locators/AccountButtons");
		locator=locator.replace("DisplayText", "Your Account");
		custException.IsTrue(pageDriver.IsPresent(locator), "Your Account Button is not display","Your Account Button Loaded and Verified");
	}
	
	public void YourAccountClick() throws Exception
	{
		String locator=loginLoct.getlocator("//locators/AccountButtons");
		locator=locator.replace("DisplayText", "Your Account");
		pageDriver.Clickon(pageDriver.getwebelement(locator));
		Thread.sleep(5000);
	}
	
	public void YourAccountShouldNotVisible() throws Exception
	{
		String locator=loginLoct.getlocator("//locators/AccountButtons");
		locator=locator.replace("DisplayText", "Your Account");
		custException.IsTrue(pageDriver.IsNotPresent(locator), "'Your Account' Still visible after logout");
	}
	
	public void DashBoardHead() throws Exception
	{
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/AccountDashBoardLink")), "Account DashBoard Main Button not Loaded");
	}	
	
	public void LogoutOption() throws Exception
	{
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/LogOut")), "Logout Button not Loaded");
	}
	
	public void LogoutClick() throws Exception
	{
		
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/LogOut")), "Logout Button not Loaded");
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/LogOut")));
	}
	
	public void LogoutSuccessfully() throws Exception
	{
		
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/LogoutComplete")), "Logout Message 'You have been logged out successfully' not found");
		
	}
	
	public void DashBoardOptionsVerification(String OptionText) throws Exception
	{
		List<WebElement> elements=pageDriver.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		boolean found=false;
		
		for(int i=0;i<=elements.size();i++)
		{
			WebElement ele=elements.get(i);
			String text=ele.getText().toString();
			System.out.println(text);
			if(text.equals(OptionText))
			{
				found=true;
				break;
			}
			
		}
		custException.IsTrue(found, "DashBoard Option = '"+OptionText+" is not Loaded");		
	}
	
	
	public void DashBoardOptionsClick(String OptionText) throws Exception
	{
		//YourAccountClick();
		List<WebElement> elements=pageDriver.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		WebElement ele=elements.get(0);
		String text=ele.getText().toString();
		text=text.trim();
		if(text==""||text==null)
			YourAccountClick();
		elements=pageDriver.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		boolean found=false;
		/*if(elements.size()==0)
		{
			YourAccountClick();
		}*/
		for(int i=0;i<=elements.size();i++)
		{
			ele=elements.get(i);
			text=ele.getText().toString();
			System.out.println(text);
			if(text.equals(OptionText))
			{
				found=true;
				pageDriver.Clickon(ele);
				Thread.sleep(5000);
				break;
			}
			
		}
		custException.IsTrue(found, "DashBoard Option = '"+OptionText+" is not Loaded unable to click");		
	}
	
	public void SubmitMeterReadingPageOpen() throws DocumentException, InterruptedException
	{
		
		Thread.sleep(5000);
		String LocateMe=loginLoct.getlocator("//locators/SubmitMeterPageHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Submit Reading Page Not Open " );
	}
	
	
	public void CloseAccountPageOpen() throws DocumentException, InterruptedException
	{
		
		Thread.sleep(5000);
		String LocateMe=loginLoct.getlocator("//locators/CloseAccountButton");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Close Account Page Not Open " );
	}
	
	public void MakePaymentPageOpen() throws DocumentException, InterruptedException
	{
		
		Thread.sleep(5000);
		String LocateMe=loginLoct.getlocator("//locators/PaymentPageHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Payment Page Not Open " );
	}
	
	public void DashBoardQuickLinkFound(String DisplayText) throws DocumentException, InterruptedException
	{
		Thread.sleep(5000);
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkDashBoard");
		LocateMe=LocateMe.replace("DisplayText", DisplayText);
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "DashBoard Quick Link = " + DisplayText +" not found " );
	}
	
	
	public void DashBoardQuickLinkClick(String DisplayText) throws Exception
	{
		Thread.sleep(5000);
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkDashBoard");
		LocateMe=LocateMe.replace("DisplayText", DisplayText);
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "DashBoard Quick Link = " + DisplayText +" not found " );
		
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}
	
	
	//Payment Panding Scenerio
	
	public void DashBoardMakePaymentButton() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkMakePayment");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "DashBoard Make Payment Link Not found " );
	}
	
	public void DashBoardMakePaymentButtonNotDisplay() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkMakePayment");
		
		custException.IsTrue(pageDriver.IsNotPresent(LocateMe), "DashBoard Make Payment Link Not found " );
	}
	public void DashBoardStruggglingToPay() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkStrugglingPay");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Struggling to Pay? not found on DashBoard" );
	}
	
	public void DashBoardAmendDirectDebit() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickAmendDebit");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Amend Direct Debit not found on DashBoard" );
	}
	
	public void DashBoardSubmitReading() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkMeterReading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Quick Link 'Submit a Meter Reading' not found on DashBoard" );
	}
	
	public void DashBoardMovingLink() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkMoving");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Quick Link 'Tell us You are Moving' not found on DashBoard" );
	}
	
	public void DashBoardFooterButton(String DisplayText) throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkFooterButton");
		LocateMe=LocateMe.replace("DisplayText", DisplayText);
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Footer Button '"+DisplayText+"' not found on DashBoard" );
	}
	
	public void DashBoardLatestBillMainHeading() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/LatestBillMainHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill heading not found on DashBoard" );
	}
	
	public void DashBoardLatestBillAmount() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/LatestBillAmount");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill Amount not found on DashBoard" );
	}
	
	public void DashBoardLatestBillDate() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/LatestBillDateLabel");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill Date label not found on DashBoard" );
		
		LocateMe=loginLoct.getlocator("//locators/LatestBillDate");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill Date Date not found on DashBoard" );
	}
	
	public void DashBoardPaymentReferenceNumber() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/PaymentRefNumberLabel");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Payment Reference Label not found on DashBoard" );
		
		LocateMe=loginLoct.getlocator("//locators/PaymentRefNumber");
		
		WebElement ele =pageDriver.getwebelement(LocateMe);
		String Temp=ele.getText();
		String[] OutPut = Temp.split(":");
		System.out.println(Temp);
		custException.IsTrue(OutPut.length>1, "Payment Reference Number Not Loaded" );
		custException.IsTrue(OutPut[1].trim()!="", "Payment Reference Number is blank" );
		
	}
	
	public void DashBoardCustomerReferenceNumber() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/CustomerNumberLabel");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Customer Reference Label not found on DashBoard" );
		
		LocateMe=loginLoct.getlocator("//locators/CustomerNumber");
		
		WebElement ele =pageDriver.getwebelement(LocateMe);
		String Temp=ele.getText();
		String[] OutPut = Temp.split(":");
		System.out.println(Temp);
		custException.IsTrue(OutPut.length>1, "Customer Number is Not Loaded" );
		custException.IsTrue(OutPut[1].trim()!="", "Customer Number is blank" );
		
	}
	
	public void DashBoardBillDueLabel() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/BillAmountDueHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Bill Amount Label not found on DashBoard" );
		
	}
	public void DashBoardBillAmount() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/BillAmount");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Bill Amount not found on DashBoard" );
		
	}
	
	public void DashBoardBillAmountDate() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/BillAmountDueDate");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Bill Amount Due Date not found on DashBoard" );
		
	}
	
	public void MatchBillDateAndDueDateisSame() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/LatestBillDate");
		
		WebElement ele =pageDriver.getwebelement(LocateMe);
		String Date1=ele.getText();
		Date1=Date1.replaceAll("\\s", "");
		System.out.println("");
		System.out.println(Date1);
		
		LocateMe=loginLoct.getlocator("//locators/BillAmountDueDate");
		ele =pageDriver.getwebelement(LocateMe);
		String Date2=ele.getText();
		Date2=Date2.replaceAll("\\s", "");
		System.out.println("");
		System.out.println(Date2);
		
		custException.IsTrue(Date1.equalsIgnoreCase(Date1), "Latest Bill Date and Amount Due Date not Matched" );
		
	}
	
	
	public void MeterReadingHeading() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/MeterReadingHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "MeterReading Heading Section 'Meter reading' not found" );
		
	}
	
	public void MeterReadingLabelAndValues() throws DocumentException, InterruptedException
	{
		
		
		String LocateMe=loginLoct.getlocator("//locators/MeterReadSectionLabel");
		List<WebElement> labels=pageDriver.getwebelements(LocateMe);
		custException.IsTrue(labels.size()==3, "MeterReading Labels not loaded correctly" );
		
		LocateMe=loginLoct.getlocator("//locators/MeterReadSectionText");
		List<WebElement> texts=pageDriver.getwebelements(LocateMe);
		custException.IsTrue(texts.size()==3, "MeterReading Labels values not loaded correctly" );
		
		WebElement ele1=labels.get(0);
		String label=ele1.getText();
		//label=label.replaceAll("\\s", "");
		custException.IsTrue(label.equalsIgnoreCase("Last meter reading"), "Last meter reading label not found" );
		
		
		ele1=texts.get(0);
		label=ele1.getText();
		label=label.replaceAll("\\s", "");
		custException.IsTrue(label!=""||label!=null, "Last meter reading value not found" );
	}
	
	public void MeterNumberLabelAndValues() throws DocumentException, InterruptedException
	{
		
		
		String LocateMe=loginLoct.getlocator("//locators/MeterReadSectionLabel");
		List<WebElement> labels=pageDriver.getwebelements(LocateMe);
		custException.IsTrue(labels.size()==3, "MeterReading Labels not loaded correctly" );
		
		LocateMe=loginLoct.getlocator("//locators/MeterReadSectionText");
		List<WebElement> texts=pageDriver.getwebelements(LocateMe);
		custException.IsTrue(texts.size()==3, "MeterReading Labels values not loaded correctly" );
		
		WebElement ele1=labels.get(1);
		String label=ele1.getText();
		//label=label.replaceAll("\\s", "");
		custException.IsTrue(label.equalsIgnoreCase("Meter number"), "Meter number label not found" );
		
		
		ele1=texts.get(1);
		label=ele1.getText();
		label=label.replaceAll("\\s", "");
		custException.IsTrue(label!=""||label!=null, "Meter number value not found" );
	}
	
	public void MeterReadLabelAndValues() throws DocumentException, InterruptedException
	{
		
		
		String LocateMe=loginLoct.getlocator("//locators/MeterReadSectionLabel");
		List<WebElement> labels=pageDriver.getwebelements(LocateMe);
		
		
		LocateMe=loginLoct.getlocator("//locators/MeterReadSectionText");
		List<WebElement> texts=pageDriver.getwebelements(LocateMe);
		
		
		WebElement ele1=labels.get(2);
		String label=ele1.getText();
		//label=label.replaceAll("\\s", "");
		custException.IsTrue(label.equalsIgnoreCase("Date last read"), "Date last read label not found" );
		
		
		ele1=texts.get(2);
		label=ele1.getText();
		label=label.replaceAll("\\s", "");
		custException.IsTrue(label!=""||label!=null, "Date last read value not found" );
	}
	
	public void ExtraFunction() throws DocumentException, InterruptedException
	{
		String LocateMe=loginLoct.getlocator("//locators/LatestBillMainHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Latest Bill heading not found on DashBoard" );
	}
	
	public void PaperlessSettingPageOpen() throws Exception
	{
		Thread.sleep(3500);
		custException.IsTrue(pageDriver.IsPresent(loginLoct.getlocator("//locators/PaperLessSettingHeading")), "Paperless Seeting Heading not found not found");
		
	}
	
	public void SelectOnline() throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/PaperlessOnline");	
	}
	
	public void ClickUpdateofPaperless() throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/PaperlessUpdate");	
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}
	
	public void ThankYouMessage() throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/PaperlessUpdate");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "'Thank You' Message not depict on screen after paperless Update" );
	}
	
	public void SetupDirectDebitPageOpen() throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/SetupDirectDebitHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Set Up Direct Debit page not open " );
	}
	
	public void YourProfilePageOpen() throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/YourProfileHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Your Profile Page is not open" );
	}
	
	public void PaymentHistoryPageOpen() throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/PaymentHistoryPageHeading");
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Payment History Page is not open" );
	}
	
	public void DashBoardFooterButtonClick(String DisplayText) throws Exception
	{
		String LocateMe=loginLoct.getlocator("//locators/QuickLinkFooterButton");
		LocateMe=LocateMe.replace("DisplayText", DisplayText);
		
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Footer Button '"+DisplayText+"' not found on DashBoard" );
		 lastTabCount=pageDriver.TabSize();
		
		pageDriver.Clickon(pageDriver.getwebelement(LocateMe));
	}
	public void ContactUsPageOpenInNewTab() throws Exception
	{
		newTabCount=pageDriver.TabSize();
		custException.IsTrue(newTabCount-lastTabCount==1, "New Tab is not open" );
		pageDriver.SwitchToLastTab();
		String LocateMe=loginLoct.getlocator("//locators/ContactUsPageHeading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Contact Us page is not open" );
	}
	
	public void Target100PageOpenInNewTab() throws Exception
	{
		newTabCount=pageDriver.TabSize();
		custException.IsTrue(newTabCount-lastTabCount==1, "New Tab is not open" );
		pageDriver.SwitchToLastTab();
		String LocateMe=loginLoct.getlocator("//locators/Target100Heading");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Target 100 page is not open" );
	}
	
	public void KeepITClearPageOpenInNewTab() throws Exception
	{
		newTabCount=pageDriver.TabSize();
		custException.IsTrue(newTabCount-lastTabCount==1, "New Tab is not open" );
		pageDriver.SwitchToLastTab();
		String LocateMe=loginLoct.getlocator("//locators/KeepItClearBanner");
		custException.IsTrue(pageDriver.IsPresent(LocateMe), "Keep It Clear page is not open" );
	}
}
