package pageHelper.web;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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

public class SubmitMeterReadings 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	PropertyReader prpertyreader = new PropertyReader();
		public SubmitMeterReadings(WebDriver driver) 
		{
			webDriver=new baseDriverHelper(driver);
			//webDriver.OpenURL("http://eservicesproxydev.southernwater.co.uk/submit-meter-read");
			//System.out.println(prpertyreader.readproperty("PayBill"));
			//webDriver.OpenURL("https://www.southernwater.co.uk/pay-bill");
			System.out.println("First Constructor");
		}
		
		public SubmitMeterReadings(bddDriver contextSteps) throws Exception 
		{
			this.DriverInstance = contextSteps;
			System.out.println(this.DriverInstance);
			webDriver=new baseDriverHelper(DriverInstance.getWebDriver());
		}
		
		@Given("^I am on meter submit reading pages$") 
		public void SouthernWaterSumbitMeterReading() throws Exception
		{
			Thread.sleep(5000);
			webDriver.OpenURL("http://eservicesproxydev.southernwater.co.uk/submit-meter-read");
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
		}
		
		@When("^I click on Having trouble link$") 
		public void TroubleLinkverification() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement("//a[@class='landing-link']"));
			webDriver.WaitforPageToBeReady();
			
		}
		
		@Then("^I move to customer details page") 
		public void VerifyHowtofindYourMeterPageOpen() throws InterruptedException
		{
			
			webDriver.VerifyTitle("How to find your water meter");
			
		}
		@And("^Submit Meter link is theree$") 
		public void VerifySubmitonline() throws Exception
		{
			webDriver.IsPresent("//a[text()='submit it online']");
			webDriver.WaitforPageToBeReady();
			
		}
		
		@When("^I click on Submit Meter link") 
		public void ClickSubmitonline() throws Exception
		{
			
			webDriver.Clickon(webDriver.getwebelement("//a[text()='submit it online']"));
			webDriver.WaitforPageToBeReady();
			
		}
		@Then("^I Should move to Submit meter reading page") 
		public void VerifySumbitMeterReadingOpen() throws InterruptedException
		{
			
			webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			
		}
}
