package pageFunctions.web;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class SubmitmeterReadingFunctions 

{
	public  webHelper pagedriver;
	public AssertionExceptionManager custException;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	Integer meterReadingValue = null;
	String EnteredReading;
	int meterReading3=0;
	
	public  SubmitmeterReadingFunctions(webHelper dr)
	{
		pagedriver=dr;
		custException=new AssertionExceptionManager(dr);
	}
	
	public void AccessUnauthSubmitMeterReading() throws Exception
	{
		Thread.sleep(5000);
		//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		pagedriver.OpenURL(prpertyreader.readproperty("MeterReading"));
		pagedriver.WaitforPageToBeReady();
		System.out.println(pagedriver.GetTitle());
		//webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
	}
	
	public void ClickTroubleLink() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/TroubleLink")));
		pagedriver.WaitforPageToBeReady();
	}
	
	public void VerifyFindMeterOnpage() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/FindMeter")), "How to find your water meter");
	}
	
	public void SubmitOnlineClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/SubmitOnline")));
		pagedriver.WaitforPageToBeReady();
	}
	
	public void VerifyMoveBackToSubmitMeterReadingPage() throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(5000);
		pagedriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
	}
	
	public void StartClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
		pagedriver.WaitforPageToBeReady();
	}
	
	public void EnterCustomerDetails(String custNum, String custRefNum, String custLname, String email) throws Exception
	{
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), custNum+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), custRefNum+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")), custLname+Keys.TAB);
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), email+Keys.TAB);
		
	}
	
	public void ContinueClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton2")));
		pagedriver.WaitforPageToBeReady();
	}
	
	public void VerifyCustomerDetails(String custNum, String custRefNum, String custLname) throws Exception
	{
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CheckYourDetailsHeader")), "Check your details");
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel")), "Your meter reading");
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/VerifyCustomerNumber")),custNum);
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/VerifyPaymentReferenceNumber")), custRefNum);
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/VerifyLastName")), custLname);
	}
	
	public void ContinueHyperlink() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ContinueHyperLink")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	
	public void EnterMeterReading() throws InterruptedException, DocumentException, IOException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReading")), "Last meter reading");
		System.out.println("meterReading started::: ");
		String meterReading =pagedriver.getwebelement(payBillLoct.getlocator("//locators/LastMeterReadingValue")).getText();
		System.out.println("meterReading::: "+meterReading);
		meterReading3 = Integer.valueOf(meterReading) +100;
		System.out.println("meterReading3::: "+meterReading3);
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerMeterReading")),String.valueOf(meterReading3)+Keys.TAB);
	}
	
	public void ContinueClickOnMeterReading() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	
	public void ConfirmMeterReading() throws InterruptedException, DocumentException
	{

		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmMeterReadingValue")), String.valueOf(meterReading3));
	}
	
	public void BackButtonClick() throws Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	public void ConfirmeterReadingClick() throws InterruptedException, DocumentException, Exception
	{
		//pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ConfirmReadingButton")));
	}
}
