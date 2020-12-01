package pageFunctions.web;

import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class AccountDashBoardFunctions {
	public  webHelper pagedriver;
	public AssertionExceptionManager custException;
	public String enteredName,  enteredCustomerNumber, enteredEmailID,newEmail, firstSecurityQuest;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader custRegist=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
	
	public AccountDashBoardFunctions(webHelper dr)
	{
		System.out.println("I am in POM");
		pagedriver=  dr;
		custException=new AssertionExceptionManager(dr);
	}
	
	public void YourAccountDisplayed() throws Exception
	{
		String locator=loginLoct.getlocator("//locators/AccountButtons");
		locator=locator.replace("DisplayText", "Your Account");
		custException.IsTrue(pagedriver.IsPresent(locator), "Your Account is not Button is not display");
	}
	
	public void YourAccountClick() throws Exception
	{
		String locator=loginLoct.getlocator("//locators/AccountButtons");
		locator=locator.replace("DisplayText", "Your Account");
		pagedriver.Clickon(pagedriver.getwebelement(locator));
		Thread.sleep(5000);
	}
	
	public void YourAccountShouldNotVisible() throws Exception
	{
		String locator=loginLoct.getlocator("//locators/AccountButtons");
		locator=locator.replace("DisplayText", "Your Account");
		custException.IsTrue(pagedriver.IsNotPresent(locator), "'Your Account' Still visible after logout");
	}
	
	public void DashBoardHead() throws Exception
	{
		custException.IsTrue(pagedriver.IsPresent(loginLoct.getlocator("//locators/AccountDashBoardLink")), "Account DashBoard Main Button not Loaded");
	}	
	
	public void LogoutOption() throws Exception
	{
		custException.IsTrue(pagedriver.IsPresent(loginLoct.getlocator("//locators/LogOut")), "Logout Button not Loaded");
	}
	
	public void LogoutClick() throws Exception
	{
		
		custException.IsTrue(pagedriver.IsPresent(loginLoct.getlocator("//locators/LogOut")), "Logout Button not Loaded");
		pagedriver.Clickon(pagedriver.getwebelement(loginLoct.getlocator("//locators/LogOut")));
	}
	
	public void LogoutSuccessfully() throws Exception
	{
		
		custException.IsTrue(pagedriver.IsPresent(loginLoct.getlocator("//locators/LogoutComplete")), "Logout Message 'You have been logged out successfully' not found");
		
	}
	
	public void DashBoardOptionsVerification(String OptionText) throws Exception
	{
		List<WebElement> elements=pagedriver.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
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
		List<WebElement> elements=pagedriver.getwebelements(loginLoct.getlocator("//locators/AccountDashBoardOption"));
		boolean found=false;
		
		for(int i=0;i<=elements.size();i++)
		{
			WebElement ele=elements.get(i);
			String text=ele.getText().toString();
			System.out.println(text);
			if(text.equals(OptionText))
			{
				found=true;
				pagedriver.Clickon(ele);
				break;
			}
			
		}
		custException.IsTrue(found, "DashBoard Option = '"+OptionText+" is not Loaded unable to click");		
	}
}
