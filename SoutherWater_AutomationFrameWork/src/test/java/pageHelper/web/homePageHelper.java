package pageHelper.web;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import core.apiHelper;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import pageHelper.bddDriver;
import utils.driver;
public class homePageHelper {
public  webHelper webDriver;
private bddDriver DriverInstance;
	public homePageHelper(WebDriver driver)
	{
		webDriver=new baseDriverHelper(driver);
		System.out.println("First Constructor");
	}
	
	public homePageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
	}

	@Given("^I am on the Homepage of Google$") 
	public void SearchTesting() throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println("This method used in TDD");
		System.out.println(webDriver.GetTitle());
		webDriver.VerifyTitle("Google");
		
	}
	@Given("^I enter the \"([^\"]*)\" into Search box$") 
	public void EnterSerchKey(String s) throws InterruptedException, IOException
	{
		System.out.println("This method used in TDD");
		System.out.println(webDriver.GetTitle());
		webDriver.SendKeys(webDriver.getwebelement("//*[@name='q']"), s);
		
	}
	@When("^I select the \"([^\"]*)\" from the suggestion list$") 
	public void Click_on_Suggestion(String s) throws Exception
	{
		System.out.println("This method used in TDD");
		System.out.println(webDriver.GetTitle());
		webDriver.VerifyTitle("Google");
		webDriver.Clickon(webDriver.getwebelement("//*[contains(text(),'"+s.toLowerCase()+"')]"));
		
	}

	@Then("^Search output will displayed the \"([^\"]*)\"$") 
	public void Verify_Search(String s) throws InterruptedException
	{
		System.out.println("This method used in TDD");
		System.out.println(webDriver.GetTitle());
		webDriver.VerifyText(webDriver.getwebelement("//*[@id='rso']/div/div/div[1]/a/h3[1]"), s);
		
	}
	

}
