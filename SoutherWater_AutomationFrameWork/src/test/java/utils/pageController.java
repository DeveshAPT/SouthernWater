package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageHelper.web.homePageHelper;
import pageHelper.web.SouthernWater_PayBill_Steps;
import pageHelper.api.EmployeeHelper;



public class pageController {

		public static final ThreadLocal<homePageHelper> HomePage= new InheritableThreadLocal<>();
		public static final ThreadLocal<SouthernWater_PayBill_Steps> Southern= new InheritableThreadLocal<>();
		public static final ThreadLocal<EmployeeHelper> EmployeeService= new InheritableThreadLocal<>();
		
		
		public void initPage(WebDriver driver) throws IOException
		{
			homePageHelper FP= new homePageHelper(driver);
			HomePage.set(FP);
			SouthernWater_PayBill_Steps SU= new SouthernWater_PayBill_Steps(driver);
			Southern.set(SU);
				
		}
		public void initPage(RequestSpecification dr,Response respoence)
		{
			EmployeeHelper EH= new EmployeeHelper(dr,respoence);
			EmployeeService.set(EH);
				
		}
		
}


