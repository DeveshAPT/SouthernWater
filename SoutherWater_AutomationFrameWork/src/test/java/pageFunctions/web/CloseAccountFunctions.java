package pageFunctions.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.webHelper;
import java.util.List;
import utils.PropertyReader;
import utils.xmlreader;

public class CloseAccountFunctions 
{
	public  webHelper pageDriver;
	public AssertionExceptionManager custException;
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	xmlreader CloseAccLoct=new xmlreader("src\\test\\resources\\locators\\CloseAccount.xml");
	PropertyReader prpertyreader = new PropertyReader();
	String dueAmount;
	
	public CloseAccountFunctions(webHelper dr)
	{
		pageDriver=dr;
		custException=new AssertionExceptionManager(dr);
	}

	public void OpenCloseAccountPage() throws Exception
	{
		Thread.sleep(5000);
		//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
		pageDriver.WaitforPageToBeReady();
		pageDriver.OpenURL(prpertyreader.readproperty("CloseAccount"));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(10000);
	}
	
	public void StartClick() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/CloseAccountStart")));
		pageDriver.WaitforPageToBeReady();
		Thread.sleep(7000);
	}
	
	public void EnterCustDetails(String customerName,String paymentRef, String lastName ) throws InterruptedException, IOException, DocumentException
	{
		pageDriver.SendKeys(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/CustomerNumber")),customerName);
		pageDriver.SendKeys(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/PaymentReference")),paymentRef);
		pageDriver.SendKeys(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/LastName")),lastName);
	}
	
	
	
	public void EnterMoveOutDate() throws InterruptedException, IOException, DocumentException
	{
		String date1=  core.baseDriverHelper.GetFutureDate();
		System.out.println("selected date::: "+date1);	
		pageDriver.SendKeys(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutDateInput")),date1+Keys.TAB);
	}
	
	public void ContinueClick() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
		Thread.sleep(5000);
	}
	
	public void EnterPostCode(String postCode) throws InterruptedException, IOException, DocumentException
	{
		pageDriver.SendKeys(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/PostCodeInput")),postCode);
	}
	
	public void FindAddressClick() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/FinalAddress")));
		Thread.sleep(5000);
	}
	
	public void SelectAddress(String address) throws InterruptedException, DocumentException
	{
		Select DropList=new Select(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/SelectAddress")));
		DropList.selectByVisibleText(address);
	}
	
	public void MoveOutContinue() throws InterruptedException, DocumentException, Exception
	{
		pageDriver.Clickon(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/MoveOutContinue")));
		Thread.sleep(5000);
	}
	
	public void ConfirmClick() throws InterruptedException, DocumentException, Exception
	{
		
		Thread.sleep(5000);
		
		List <WebElement> elements1=pageDriver.getwebelements(CloseAccLoct.getlocator("//locators/ConfirmCloseAccount"));
		System.out.println(String.valueOf(elements1.size()));
		
		custException.IsTrue(elements1.size()>0, "Click Confirm Button Not Visible","Click Confirm Button Verified");
		//pageDriver.Clickon(pageDriver.getwebelement(CloseAccLoct.getlocator("//locators/ConfirmCloseAccount")));
	}
	
	public void ClickCloseYourAccount() throws DocumentException, Exception
	{
		
		pageDriver.Clickon(pageDriver.getwebelement(loginLoct.getlocator("//locators/CloseAccountButton")));
		Thread.sleep(5000);
		
	}
	
	public void AccountShouldClose()
	{
		
	}
	
	public void ClosingMessage()
	{
		
	}
}
