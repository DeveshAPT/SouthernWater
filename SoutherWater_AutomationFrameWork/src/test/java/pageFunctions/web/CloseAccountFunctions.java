package pageFunctions.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class CloseAccountFunctions 
{
	public  webHelper pagedriver;
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	xmlreader CloseAccLoct=new xmlreader("src\\test\\resources\\locators\\CloseAccount.xml");
	PropertyReader prpertyreader = new PropertyReader();
	String dueAmount;
	
	public CloseAccountFunctions(webHelper dr)
	{
		pagedriver=dr;
	}

	public void OpenCloseAccountPage() throws Exception
	{
		Thread.sleep(5000);
		//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		pagedriver.WaitforPageToBeReady();
		pagedriver.OpenURL(prpertyreader.readproperty("CloseAccount"));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(10000);
	}
	
	public void StartClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/CloseAccountStart")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(7000);
	}
	
	public void EnterCustDetails(String customerName,String paymentRef, String lastName ) throws InterruptedException, IOException, DocumentException
	{
		pagedriver.SendKeys(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/CustomerNumber")),customerName);
		pagedriver.SendKeys(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/PaymentReference")),paymentRef);
		pagedriver.SendKeys(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/LastName")),lastName);
	}
	
	
	
	public void EnterMoveOutDate() throws InterruptedException, IOException, DocumentException
	{
		String date1=  core.baseDriverHelper.GetFutureDate();
		System.out.println("selected date::: "+date1);	
		pagedriver.SendKeys(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutDateInput")),date1+Keys.TAB);
	}
	
	public void ContinueClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
		Thread.sleep(5000);
	}
	
	public void EnterPostCode(String postCode) throws InterruptedException, IOException, DocumentException
	{
		pagedriver.SendKeys(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/PostCodeInput")),postCode);
	}
	
	public void FindAddressClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/FinalAddress")));
		Thread.sleep(5000);
	}
	
	public void SelectAddress(String address) throws InterruptedException, DocumentException
	{
		Select DropList=new Select(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/SelectAddress")));
		DropList.selectByVisibleText(address);
	}
	
	public void MoveOutContinue() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
		Thread.sleep(5000);
	}
	
	public void ConfirmClick() throws InterruptedException, DocumentException, Exception
	{
		//pagedriver.Clickon(pagedriver.getwebelement(CloseAccLoct.getlocator("//locators/ConfirmCloseAccount")));
		Thread.sleep(5000);
	}
	
	public void AccountShouldClose()
	{
		
	}
	
	public void ClosingMessage()
	{
		
	}
}