package pageFunctions.web;

import org.dom4j.DocumentException;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import core.webHelper;
import utils.PropertyReader;
import utils.xmlreader;

public class AssertionExceptionManager 
{
	public  webHelper ExceptionDriver;

	public AssertionExceptionManager(webHelper dr)
	{
		System.out.println("I am in Exception Page");
		ExceptionDriver=  dr;
	}
	
	public void IsTrue(boolean Condition, String ExMessage ) 
	{
		try
		{
		Assert.assertTrue(Condition, ExMessage);
		}
		catch(AssertionError e)
		{
			Reporter.addStepLog(ExMessage);
			Reporter.addStepLog("Below is the Technical Exception");
			//Assert.fail();
			throw e; 		
		}
	}
	
}
