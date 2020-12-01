package pageHelper.web;
import java.util.List;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageFunctions.web.AccountDashBoardFunctions;
import pageFunctions.web.LoginFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.xmlreader;

public class LogOutPageHelper 
{
	public  webHelper webDriver;
	private bddDriver DriverInstance;
	public LoginFunctions login;
	public AccountDashBoardFunctions dashBoard;
	String EmailID=null;
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
	xmlreader loginLoct=new xmlreader("src\\test\\resources\\locators\\Login.xml");
	xmlreader regiLoct=new xmlreader("src\\test\\resources\\locators\\CustomerRegistration.xml");
	PropertyReader prpertyreader = new PropertyReader();
	
	public LogOutPageHelper(WebDriver driver)  
	{
		webDriver=new baseDriverHelper(driver);
		System.out.println("First Constructor");
		login=new LoginFunctions(webDriver);
		dashBoard=new AccountDashBoardFunctions(webDriver);
	}
	
	public LogOutPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		login=new LoginFunctions(webDriver);
		dashBoard=new AccountDashBoardFunctions(webDriver);
		
	}
	
	@And("^I Logout from SW Portal$")
	public void i_Logout_from_SW_Portal() throws Throwable 
	{
		dashBoard.LogoutClick(); 
		dashBoard.LogoutSuccessfully();    
	}

	@When("^Relogin with Using Login Credentials ([^\"]*) and ([^\"]*)$")
	public void relogin_with_Using_Login_Credentials(String email, String password) throws Throwable 
	{
		login.EnterEmailAndPassword(email, password); 
		login.ClickOnLogin();
	}

	
}