package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageHelper.web.homePageHelper;
import pageHelper.web.CustomerRegistrationPageHelper;
import pageHelper.web.LogOutPageHelper;
import pageHelper.web.LoginPageHelper;
import pageHelper.web.SouthernWater_PayBill_Steps;
import pageHelper.web.SubmitMeterReadings;
import pageHelper.api.EmployeeHelper;
import pageHelper.api.SPQR;



public class pageController {

		public static final ThreadLocal<homePageHelper> HomePage= new InheritableThreadLocal<>();
		public static final ThreadLocal<SPQR> SP= new InheritableThreadLocal<>();
		public static final ThreadLocal<SouthernWater_PayBill_Steps> Southern= new InheritableThreadLocal<>();
		public static final ThreadLocal<SubmitMeterReadings> Meter= new InheritableThreadLocal<>();
		public static final ThreadLocal<LoginPageHelper> Login= new InheritableThreadLocal<>();
		public static final ThreadLocal<LogOutPageHelper> Logout= new InheritableThreadLocal<>();
		public static final ThreadLocal<CustomerRegistrationPageHelper> Register= new InheritableThreadLocal<>();
		public static final ThreadLocal<EmployeeHelper> EmployeeService= new InheritableThreadLocal<>();
		
		
		public void initPage(WebDriver driver) throws IOException
		{
			homePageHelper FP= new homePageHelper(driver);
			HomePage.set(FP);
			
			SouthernWater_PayBill_Steps SU= new SouthernWater_PayBill_Steps(driver);
			Southern.set(SU);
			
			SubmitMeterReadings ME= new SubmitMeterReadings(driver);
			Meter.set(ME);
			
			CustomerRegistrationPageHelper RE= new CustomerRegistrationPageHelper(driver);
			Register.set(RE);
				
			LoginPageHelper LG=new LoginPageHelper(driver);
			Login.set(LG);
			
			LogOutPageHelper LO=new LogOutPageHelper(driver);
			Logout.set(LO);
		}
		public void initPage(RequestSpecification dr,Response respoence)
		{
			EmployeeHelper EH= new EmployeeHelper(dr,respoence);
			EmployeeService.set(EH);
			
			SPQR SP1= new SPQR(dr,respoence);
			SP.set(SP1);
				
		}
		
}


