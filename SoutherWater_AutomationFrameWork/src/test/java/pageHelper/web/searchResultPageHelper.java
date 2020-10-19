package pageHelper.web;
import org.openqa.selenium.WebDriver;
import core.apiHelper;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import pageHelper.bddDriver;
public class searchResultPageHelper {
private webHelper webDriver;
private bddDriver DriverInstance;
	public searchResultPageHelper(WebDriver driver)
	{
		webDriver=new baseDriverHelper(driver);
		
	}
	
	public searchResultPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		
		System.out.println(this.DriverInstance);
		webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		//webDriver=new baseDriverHelper()
	}
	public void SearchTesting()
	{
		webDriver.GetURL("https://facebook.com/");
		System.out.println(webDriver.GetTitle());
	}
	@Then("^Search will displayed the \"([^\"]*)\"$") 
	public void Verify_Search(String s) throws InterruptedException
	{
		//webDriver.GetURL("https://facebook.com/");
		//Thread.sleep(10000);
		System.out.println("This method used in TDD");
		System.out.println(webDriver.GetTitle());
		webDriver.VerifyText(webDriver.getwebelement("//*[@id='rso']/div/div/div[1]/a/h3[1]"), s);
		
	}
}
