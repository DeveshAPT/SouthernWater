package pageFunctions.web;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class MoveInFunction 
{

	public  webHelper pagedriver;
	public AssertionExceptionManager custException;
	PropertyReader prpertyreader = new PropertyReader();

	xmlreader MoveInLoct=new xmlreader("src\\test\\resources\\locators\\MoveIn.xml");
	String TestFirstName = "TestFirstName";
	String TestMiddleName = "TestMiddleName";
	String TestLastName ="TestLastName";
	String CustomerEmailAddress = "neeraj.m@360logica.com";
	Integer NumberOfOccupants = 3;
	Integer AccountNumber = 55779911;
	public MoveInFunction(webHelper dr)
	{
		pagedriver=dr;
		custException=new AssertionExceptionManager(pagedriver);
	}
	
	public void OpenMoveInPage() throws Exception
	{
		Thread.sleep(3000);
		pagedriver.WaitforPageToBeReady();
		//pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/AcceptCokies")));
		pagedriver.OpenURL(prpertyreader.readproperty("MoveInUrl"));
		pagedriver.WaitforPageToBeReady();
		System.out.println(pagedriver.GetTitle());
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CreateAnAccountHeading")), "Create an account");
	}
	
	public void StartClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/StartButton")));	
	}
	
	public void FillMoveINDetails(String postCode, String address) throws Exception
	{
		Thread.sleep(3000);
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")), "Moving details");
		EnterPostCode(postCode);
		
		FindAddressClick();
		Thread.sleep(3000);
		
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")));
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectAddress")), address);
		Thread.sleep(2000); 	
	}
	
	public void EnterMoveINDate() throws InterruptedException, IOException, DocumentException
	{
		String date1=  core.baseDriverHelper.GetFutureDate();
		System.out.println("selected date::: "+date1);	
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/YourMovingDateLabel")), "Your moving date");
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MoveOutDate")),date1+Keys.TAB);
		Thread.sleep(2000);
	}
	
	public void EnterOccupant() throws InterruptedException, IOException, DocumentException
	{

		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupants")),String.valueOf(NumberOfOccupants)+Keys.TAB);
		Thread.sleep(2000);
	}
	
	public void ContinueClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ContinueButton")));
		Thread.sleep(2000);
		pagedriver.WaitforPageToBeReady();
	}
	
	public void VerifyYourDetailsSteps() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/YourDetailsHeader")), "Your details");
		Thread.sleep(2000);
		
	
	}
	
	public void EnterYourDetails(String title,String firstName,String middleName ,String lastName,String dOB,String contact,String email) throws InterruptedException, DocumentException, Exception
	{
		
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")));
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SelectTitle")), title);
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/FirstName")), firstName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MiddleName")), middleName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/LastName")), lastName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/DateOfBirth")),dOB+Keys.TAB);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/UserMobileNumber")), contact);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/UserEmailAddress")), email);
		Thread.sleep(2000);
	}
	
	public void EnterCustomerPaymentDetails(String accHoldName,String code1,String code2,String code3, String accountNumber  ) throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/PaymentDeatils")), "Payment details");
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/AccountHolderName")), accHoldName);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeOne")), code1);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeTwo")),code2);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/SortCodeThree")),code3);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/BankAccountNumber")), accountNumber);
		Thread.sleep(2000);	
	}
	
	public void VerifyMoveINDetails(String firstName, String midName,String lastName,String email,String occupant,String accountNumber) throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CheckAndConfirmHeader")), "Check and confirm");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyName")), firstName +" "+ midName + " "+lastName);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyEmail")), email);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyNumberOfOccupants")), occupant);
		Thread.sleep(3000);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/AccountNumberLabel")), "Account number");
		Thread.sleep(3000);
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/VerifyAccountNumber")), accountNumber);
		Thread.sleep(3000);
	}
	
	public void ConfirmDetailButton() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ConfirmDetailsButton")));
	}
	
	public void VerifyMoveInDetailPageLoaded() throws Exception
	{
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDetails")), "Moving details");
		Thread.sleep(2000);
		
	}
	
	public void VerifyMandatoryFieldsMessage()throws Exception
	{
		Thread.sleep(2000);
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")), "There’s a problem");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")), "You’ll need to correct the errors to continue.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderUKPostCodeErrorMessage")), "Please enter a valid UK postcode");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderYourMovingDateErrorMessage")), "Please enter your moving date");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderNumberOfOccupantsErrorMessage")), "Please enter the number of occupants.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ValidUkPostCodeErrorMessage")), "Please enter a valid UK postcode");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDateErroeMessage")), "Please enter your moving date");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupantsErrorMessage")), "Please enter the number of occupants");
		
		
		
	}
	
	public void EnterPostCode(String postcode) throws InterruptedException, IOException, DocumentException
	{
		Thread.sleep(2000);
		pagedriver.SendKeys(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CustomerPostCode")), postcode+Keys.TAB);
	}
	
	public void FindAddressClick() throws InterruptedException, DocumentException, Exception
	{
		pagedriver.Clickon(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/FindAddressButton")));
		pagedriver.WaitforPageToBeReady();
		Thread.sleep(2000);
	}
	
	public void InValidAddressMessage() throws Exception
	{
		Thread.sleep(2000);
		pagedriver.WaitforPageToBeReady();
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")), "There’s a problem");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")), "You’ll need to correct the errors to continue.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderUKPostCodeErrorMessage")), "Please enter a valid UK postcode");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ValidUkPostCodeErrorMessage")), "Please enter a valid UK postcode");
	}
	
	public void VerifyEnterAddressManually() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/EnterYourAddressManually")), "Enter your address manually");
	}
	
	public void PleaseSelectAddressAndOtherErrorMessage() throws InterruptedException, DocumentException
	{
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/ThereIsAProblemErrorMessage")), "There’s a problem");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/CorrectErrorsToContinueErrorMessage")), "You’ll need to correct the errors to continue.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/PleaseSelectAnAddress")), "Please select an address");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderYourMovingDateErrorMessage")), "Please enter your moving date");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/HeaderNumberOfOccupantsErrorMessage")), "Please enter the number of occupants.");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/MovingDateErroeMessage")), "Please enter your moving date");
		pagedriver.VerifyText(pagedriver.getwebelement(MoveInLoct.getlocator("//locators/NumberOfOccupantsErrorMessage")), "Please enter the number of occupants");
	}
	
}
