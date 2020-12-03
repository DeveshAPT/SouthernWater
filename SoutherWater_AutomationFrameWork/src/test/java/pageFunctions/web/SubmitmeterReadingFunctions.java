package pageFunctions.web;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class SubmitmeterReadingFunctions 

{
	public  webHelper pageDriver;
	public AssertionExceptionManager custException;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	Integer meterReadingValue = null;
	String EnteredReading;
	int meterReading3=0;
	
	public  SubmitmeterReadingFunctions(webHelper dr)
	{
		pageDriver=dr;
		custException=new AssertionExceptionManager(dr);
	}
	
	public void AccessUnauthSubmitMeterReading() throws Exception
	{
		Thread.sleep(5000);
		//pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		pageDriver.OpenURL(prpertyreader.readproperty("MeterReading"));
		pageDriver.WaitforPageToBeReady();
		System.out.println(pageDriver.GetTitle());
		//pageDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
	}
	
	public void ClickTroubleLink() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/TroubleLink")));
		pageDriver.WaitforPageToBeReady();
	}
	
	public void VerifyFindMeterOnpage() throws InterruptedException, DocumentException
	{
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/FindMeter")), "How to find your water meter");
	}
	
	public void SubmitOnlineClick() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/SubmitOnline")));
		pageDriver.WaitforPageToBeReady();
	}
	
	public void VerifyMoveBackToSubmitMeterReadingPage() throws Exception
	{
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(5000);
		pageDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
	}
	
	public void StartClick() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
		pageDriver.WaitforPageToBeReady();
	}
	
	public void EnterCustomerDetails(String custNum, String custRefNum, String custLname, String email) throws Exception
	{
		pageDriver.SendKeys(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), custNum+Keys.TAB);	
		pageDriver.SendKeys(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), custRefNum+Keys.TAB);	
		pageDriver.SendKeys(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")), custLname+Keys.TAB);
		pageDriver.SendKeys(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), email+Keys.TAB);
		
	}
	public void EnterCustomerDetails(String CustNumb, String PayRef, String LastName) throws Exception
	{
		 pageDriver.SendKeys(pageDriver.getwebelement("//input[@id='customerNumber']"),CustNumb);
		 pageDriver.SendKeys(pageDriver.getwebelement("//input[@id='customerRefNumber']"),PayRef);
		 pageDriver.SendKeys(pageDriver.getwebelement("//input[@id='inpName']"),LastName);
		 
		
	}
	
	public void ContinueClick() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
		pageDriver.WaitforPageToBeReady();
	}
	
	public void VerifyCustomerDetails(String custNum, String custRefNum, String custLname) throws Exception
	{
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CheckYourDetailsHeader")), "Check your details");
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel")), "Your meter reading");
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyCustomerNumber")),custNum);
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyPaymentReferenceNumber")), custRefNum);
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyLastName")), custLname);
	}
	
	public void ContinueHyperlink() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueHyperLink")));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	
	public void EnterMeterReading() throws InterruptedException, DocumentException, IOException
	{
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReading")), "Last meter reading");
		System.out.println("meterReading started::: ");
		String meterReading =pageDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValue")).getText();
		System.out.println("meterReading::: "+meterReading);
		meterReading3 = Integer.valueOf(meterReading) +100;
		System.out.println("meterReading3::: "+meterReading3);
		pageDriver.SendKeys(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),String.valueOf(meterReading3)+Keys.TAB);
	}
	
	public void ContinueClickOnMeterReading() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	
	public void ConfirmMeterReading() throws InterruptedException, DocumentException
	{

		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingValue")), String.valueOf(meterReading3));
	}
	
	public void BackButtonClick() throws Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	
	public void ConfirmeterReadingClick() throws InterruptedException, DocumentException, Exception
	{
		//pageDriver.Clickon(pageDriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmReadingButton")));
	}
	
	public void VerifyMeterReading() throws Exception
	{
		pageDriver.WaitforPageToBeReady();
		pageDriver.VerifyText(pageDriver.getwebelement(loginLoct.getlocator("//locators/YourMeterReadingPageHeading")), "Your meter reading");
	}
	
	public void SubmitYourMeterReadingClick() throws Exception
	{
		pageDriver.WaitforPageToBeReady();
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")));
	}
	
	public void YourMeterReadingPage() throws InterruptedException, DocumentException
	{
		pageDriver.VerifyText(pageDriver.getwebelement(loginLoct.getlocator("//locators/YourMeterReadingPageHeading")), "Your meter reading");
	}
	
	public void VerifyMeterReadingPageOpen() throws InterruptedException, DocumentException
	{
		pageDriver.VerifyText(pageDriver.getwebelement(loginLoct.getlocator("//locators/SubmitMeterReading")), "Submit a meter reading");
	}
	
	public void VerifyUpdatedMeterReading() throws InterruptedException, DocumentException
	{
		Thread.sleep(2000);
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/MeterReading")), String.valueOf(meterReadingValue));
	}
	
	public void TodayDateonSubmitMeterReading() throws InterruptedException, DocumentException
	{
		String CurrentDate = core.baseDriverHelper.GetCurrentDate();
		pageDriver.VerifyText(pageDriver.getwebelement(payBillLoct.getlocator("//locators/UpdatedDateForMeterReading")), CurrentDate);
		Thread.sleep(2000);
	}
	
	public void UpdateMeterReading() throws Exception
	{
		pageDriver.WaitforPageToBeReady();
		String MeaterReadingNew = pageDriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValueOfYourReadingPage")).getText();
		System.out.println(MeaterReadingNew.toString());
		meterReadingValue =Integer.parseInt(MeaterReadingNew) +150;
		//meterReadingValue = meterReadingValue +50;
		System.out.println(meterReadingValue);
		pageDriver.CleasrAndSendKeys(pageDriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),meterReadingValue.toString());
		Thread.sleep(2000);
	}
	
	public void VerifyUpdateMeterReading() throws InterruptedException, DocumentException
	{
		Thread.sleep(5000);
		System.out.println(meterReadingValue);
		WebElement el=pageDriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel3"));
		String NewReading=el.getText();
		System.out.println(NewReading);
		//Assert.assertTrue(NewReading.equals(meterReadingValue.toString()), "New Meter Reading Not matched with Submit Meter Reading");
	}
	
	public void MeterReadingOnConfirmPage() throws InterruptedException
	{
		 WebElement el=pageDriver.getwebelement("//h3[text()='Meter reading']/following-sibling::p");
		 String NewReading=el.getText();
	}
}
