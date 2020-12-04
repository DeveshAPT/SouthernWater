package pageFunctions.web;
import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class PayBillFunctions 
{
	public  webHelper pagedriver;
	public AssertionExceptionManager custException;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
	String dueAmount;
	
	public PayBillFunctions(webHelper dr)
	{
		pagedriver=dr;
		custException=new AssertionExceptionManager(dr);
	}
	
	private void ClickOnAcceptCokies()
	{
		try
		{
		//webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			pagedriver.WaitforPageToBeReady();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void AccessUnauthPayBillPage() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		ClickOnAcceptCokies();
		pagedriver.OpenURL(prpertyreader.readproperty("PayBill"));
		Thread.sleep(5000);
		System.out.println(pagedriver.GetTitle());
		
	}
	
	public void PayUnAuthBillStart() throws InterruptedException, DocumentException, Exception
	{
		Thread.sleep(4000);
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/Start")));
		pagedriver.WaitforPageToBeReady();
	}
	
	public void YourDetailsSteps() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/YourDetailHeading")), "Your details");
	}
	
	public void VerifyBackButton() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")), "Back");
	}
	
	public void ClickBackButton() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/BackButton")));
		pagedriver.WaitforPageToBeReady();	
		
	}
	
	public void MainPageVerification() throws InterruptedException, DocumentException, Exception
	{
		System.out.println("Then Body");
		
		custException.IsTrue(pagedriver.IsPresent(payBillLoct.getlocator("//locators/Start")),"Pay Bill Start Page not Loaded");
		
	}
	
	public void ClickQuestionmarkFirst() throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipIcon"));
		do
		{
			pagedriver.Clickon(elements.get(0));
			elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipIcon"));
		}while(elements.size()>0);
	}
	
	public void ClickQuestionmarkSecond() throws Exception
	{
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ActiveToolTip"));
		do
		{
			pagedriver.Clickon(elements.get(0));
			elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ActiveToolTip"));
		}while(elements.size()>0);
	}
	
	public void QuestionMarkMessages() throws InterruptedException, DocumentException
	{
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipMessage"));
		WebElement ele=null;	
		for(int i=0;i<elements.size();i++)
		{
			ele=elements.get(i);
			if(i==0)
				pagedriver.VerifyText(ele, "Your 8 or 10 digit customer number is in the top right corner of any letters or emails you have received from us.");
			else if(i==1)
				pagedriver.VerifyText(ele, "Your 13 digit payment reference is in the top right corner of any bills you have received from us. Please enter it without any spaces between the digits.");
			else if(i==2)
				pagedriver.VerifyText(ele, "Please enter this information exactly as it appears on any letters or emails you have received from us. If more than one person is responsible for the charges, please enter the last name of the first customer shown on any letters or emails you have from us.");
		}
	}
	
	public void verifyMessageShouldnotvisible() throws InterruptedException, DocumentException
	{
		boolean flag=false;
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ToolTipMessage"));
		flag=elements.isEmpty()?true:false;
		custException.IsTrue(flag, "Question Mark messages are Still visible");	
		
	}
	
	public void PayBillDetailClickContinue() throws InterruptedException, DocumentException, Exception
	{
		Thread.sleep(5000);
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ContinueButton")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(5000);
	}
	
	public void MandatoryFieldMessage() throws InterruptedException, DocumentException
	{
		System.out.println("Then Body");
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/IncorrectInputMsg")), "You’ll need to correct the errors to continue.");
	}
	
	public void EnterYourDetails(String custNumber,String custRefNumber,String custLName,String custEmail) throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerNumber")), custNumber+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerRefNum")), custRefNumber+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerLName")),custLName+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CustomerEmail")), custEmail+Keys.TAB);
		
	}
	
	public void IncorrectDateMessage() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ErrorMessage")), "There’s a problem");
	}
	
	public void MandatoryFieldMessageShouldnotVisible() throws InterruptedException, DocumentException
	{
		boolean flag=false;
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/ErrorMessage"));
		flag=elements.isEmpty()?true:false;
		custException.IsTrue(flag, "Mandatory Field Message Not Removed");	
	}
	
	public void ClickCheckDetailContinue() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/DetailsContinue")));
		Thread.sleep(5000);
	}
	
	public void SelectAnotherAmount() throws Exception
	{
		pagedriver.SafeJavaScriptClick(pagedriver.getwebelement(payBillLoct.getlocator("//locators/AnotherAmount")));
		pagedriver.WaitforPageToBeReady();
	}
	
	public void EnterAmount(String amount) throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/EnterAmount")), amount+Keys.TAB);
	}
	
	public void ClickMakePayment() throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/MakePayment")));
		Thread.sleep(5000);
	}
	
	public void EnterPaymentDetails(String CardNumber, String NameOnCard, String ExpiryMonth, String ExpiryYear, String code) throws InterruptedException, IOException, DocumentException
	{
		pagedriver.switchtofram(pagedriver.getwebelement(payBillLoct.getlocator("//locators/PaymentFrame")));
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CardNumber")), CardNumber+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/CardHolderName")), NameOnCard+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ExpiryMonth")), ExpiryMonth+Keys.TAB);	
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/ExpiryYear")), ExpiryYear+Keys.TAB);
		pagedriver.SendKeys(pagedriver.getwebelement(payBillLoct.getlocator("//locators/SecurityCode")), code+Keys.TAB);
	}
	
	public void ClickPayNowButton() throws Exception
	{
		//webDriver.switchtofram(webDriver.getwebelement("//iframe[@id='wp-cl-custom-html-iframe']"));
		pagedriver.WaitforPageToBeReady();
		pagedriver.Clickon(pagedriver.getwebelement(payBillLoct.getlocator("//locators/Pay")));
		
		Thread.sleep(5000);
		pagedriver.switchtodefault();
	}
	
	public void VerifyPaymentConfirmation() throws DocumentException, InterruptedException
	{
		custException.IsTrue(pagedriver.IsPresent(payBillLoct.getlocator("//locators/ConfirmationMessage")),"Payment Confirmation Message not found");
	}
	
	public void VerifyThankYouMessage() throws DocumentException, InterruptedException
	{
		custException.IsTrue(pagedriver.IsPresent(payBillLoct.getlocator("//locators/ThankYou")),"Payment Confirmation Message not found");
	}
	
	public void TranSactionMessageConfirmation() throws InterruptedException, DocumentException
	{
		custException.IsTrue(pagedriver.IsPresent(payBillLoct.getlocator("//locators/PaymentReceipt")),"Payment Receipt Message not found");
		
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
		WebElement ele=elements.get(0);
		
		String text=ele.getText();
		System.out.println(text);
		custException.IsTrue(text.equals("Transaction number"), "Transaction number Label Not found");
		
		elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
		ele=elements.get(0);
		
		text=ele.getText();
		System.out.println(text);
		custException.IsTrue(text!=null, "Transaction number value not found");
	}
	
	public void PaymentReferenceVerification() throws InterruptedException, DocumentException
	{
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
		WebElement ele=elements.get(1);
		
		String text=ele.getText();
		System.out.println(text);
		custException.IsTrue(text.equals("Payment reference"), "Payment reference Label Not found");
		
		elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
		custException.IsTrue(elements.size()==3, "Error in Payment detail Values");
		
		ele=elements.get(1);
		text=ele.getText();
		System.out.println(text);
		custException.IsTrue(text!=null, "Payment reference value not found");
	}
	
	public void VerifyPaidAmount(String amount) throws InterruptedException, DocumentException
	{
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
		WebElement ele=elements.get(2);
		
		String text=ele.getText();
		System.out.println(text);
		//softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
		custException.IsTrue(text.equals("Amount paid"), "Payment reference Label Not found");
		
		elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
		ele=elements.get(2);
		
		text=ele.getText();
		System.out.println(text);
		custException.IsTrue(text.contains(amount), "Entered Amount not matched with reciept amount");
	}
	
	public void SelectFullAmount() throws Exception
	{
		dueAmount=pagedriver.getwebelement(payBillLoct.getlocator("//locators/DueAmount")).getText();
		System.out.println("");
		System.out.println(dueAmount);
		
		pagedriver.SafeJavaScriptClick(pagedriver.getwebelement(payBillLoct.getlocator("//locators/FullAmount")));
		pagedriver.WaitforPageToBeReady();	
	}
	
	public void VerifyFullAmountonReciept() throws InterruptedException, DocumentException
	{
		List<WebElement> elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailHeading"));
		WebElement ele=elements.get(2);
		
		String text=ele.getText();
		System.out.println(text);
		//softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
		Assert.assertTrue(text.equals("Amount paid"), "Payment reference Label Not found");
		
		elements=pagedriver.getwebelements(payBillLoct.getlocator("//locators/PaymentDetailLabel"));
		ele=elements.get(2);
		
		text=ele.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains(dueAmount), "Entered Amount not matched with reciept amount");
	}
}
