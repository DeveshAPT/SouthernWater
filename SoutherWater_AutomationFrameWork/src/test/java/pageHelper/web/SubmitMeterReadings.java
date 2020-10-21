package pageHelper.web;
import java.io.IOException;
import java.util.Iterator;
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

public class SubmitMeterReadings 
{

	public  webHelper webDriver;
	private bddDriver DriverInstance;
	PropertyReader prpertyreader = new PropertyReader();
	xmlreader payBillLoct=new xmlreader("src\\test\\resources\\locators\\PayBill.xml");
		public SubmitMeterReadings(WebDriver driver) throws IOException 
		{
			webDriver=new baseDriverHelper(driver);
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
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.OpenURL(prpertyreader.readproperty("MeterReading"));
			webDriver.WaitforPageToBeReady();
			System.out.println(webDriver.GetTitle());
			webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
		}
		
		@When("^I click on Having trouble link$") 
		public void TroubleLinkverification() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/TroubleLink")));
			webDriver.WaitforPageToBeReady();
		}
		
		@Then("^I Should move to how to find your meter page$") 
		public void VerifyHowtofindYourMeterPageOpen() throws InterruptedException, DocumentException
		{
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/FindMeter")), "How to find your water meter");
			
		}
		
		@Given("^I am on how to find your meter page$") 
		public void VerifySubmitonline() throws Exception
		{
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/AcceptCokies")));
			webDriver.OpenURL(prpertyreader.readproperty("MeterReading"));
			webDriver.WaitforPageToBeReady();
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/TroubleLink")));
			webDriver.WaitforPageToBeReady();
			webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator("//locators/FindMeter")), "How to find your water meter");
		}
		
		@When("^I click on Submit Meter link") 
		public void ClickSubmitonline() throws Exception
		{
			
			webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator("//locators/SubmitOnline")));
			webDriver.WaitforPageToBeReady();
			
		}
		
		@Then("^I Should move to Submit meter reading page") 
		public void VerifySumbitMeterReadingOpen() throws Exception
		{
			webDriver.WaitforPageToBeReady();
			Thread.sleep(5000);
			webDriver.VerifyTitle("Submit Meter Read - Southern Water: Water for life, Water and wastewater services for Kent, Sussex, Hampshire and the Isle of Wight");
			
		}
}
