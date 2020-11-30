package testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utils.driver;

public class Accessibility extends driver {
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SoutherWaterLogin_withAccessibility(String Browser) throws Throwable {

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_Accessibility(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			Run_AccessibilityTest();
			PayBill.get().StartButtonofPage();
			Run_AccessibilityTest();
			PayBill.get().IEnterCustDetailWithPaymentRef("13417979", "4050614612", "Vardy",
					"devesh.kumar@southernwater.co.uk");
			PayBill.get().ContinueButtonofDetailStep();
			Run_AccessibilityTest();
			PayBill.get().ContinueCheckDetailPage();
			Run_AccessibilityTest();
			PayBill.get().SelectPayAnotherAmount();
			PayBill.get().EnterPartialAmount("1");
			PayBill.get().ClickMakePayment();
			Run_AccessibilityTest();
			PayBill.get().EnterPaymentCardDetails("122000000000003", "Fiona Vardy", "08", "27", "453");
			PayBill.get().ClickPayNow();
			Run_AccessibilityTest();
			PayBill.get().PyamentConfirmationMessage();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void MoveIn_Accessibility(String Browser) throws Throwable {
		// MoveIn

		try {
			MoveIn.get().NavigateToMoveInAccountPage();
			Run_AccessibilityTest();
			MoveIn.get().ClickOnStartButton();
			Run_AccessibilityTest();
			MoveIn.get().FillCustomerMoveInDetails();
			Run_AccessibilityTest();
			MoveIn.get().CustomerPaymentDetails();
			Run_AccessibilityTest();
			MoveIn.get().CustomerIsAbleToMoveIn();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Registration_Accessibility(String Browser) throws Throwable {
		// Registration
		try {
			Register.get().OpenCustomerRegistrationPage();
			Run_AccessibilityTest();
			Register.get().I_AgreeTesrAndConditions();
			Register.get().IClickStartButtonOnWebPage();
			Run_AccessibilityTest();
			Register.get().EnterMyCustomerDetail("22129519", "Testone", "wecoyif894@5y5u.com");
			Register.get().ClickContinueButtonOnPage();
			Run_AccessibilityTest();
			Register.get().ClickOnConfirmContinue();
			Run_AccessibilityTest();
			Register.get().SetPassword("360@Logica");
			Register.get().SetFirstQuestionAnswer("What was the model of the first car you owned?", "Ford");
			Register.get().SetSecondQuestionAnswer("What is the name of your first pet?", "Dog");
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBillAuth_Accessibility(String Browser) throws Throwable {
		try {
			PayBill.get().LoginWithYouAccountCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Run_AccessibilityTest();
			PayBill.get().MakePaymentFromDashBoard();
			Run_AccessibilityTest();
			PayBill.get().SelectPayAnotherAmountOption();
			PayBill.get().EnterPartialAmountForPayment("1");
			PayBill.get().MakePaymentLink();
			Run_AccessibilityTest();
			PayBill.get().EnterPaymentcardDetails("122000000000003", "Fiona Vardy", "08", "27", "453");
			PayBill.get().IClickPayNowOnMakePayment();
			Run_AccessibilityTest();
			PayBill.get().PaymentConfirmationMessages();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_Accessibility(String Browser) throws Throwable {
		try {
			UnRegisterUser.get().I_have_Open_UnRegisterd_User_Close_Account_Page();
			Run_AccessibilityTest();
			UnRegisterUser.get().I_Click_on_Start_Button_of_Close_Account_Page();
			Run_AccessibilityTest();
			UnRegisterUser.get().I_Enter_CustomerNumer_Payment_Reference_LastName("10470201", "0004012407196",
					"DOWNHYLL");
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Your_Detail_Step();
			Run_AccessibilityTest();
			UnRegisterUser.get().I_Enter_Moving_Out_Date_of_Close_Account();
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Moving_Date_Step();
			Run_AccessibilityTest();
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Final_Bill_Step();
			UnRegisterUser.get().I_Enter_Post_Code_as_on_Forwarding_Address("CT16 3NR");
			UnRegisterUser.get().I_Click_on_Find_Address_Forwarding_Address();
			UnRegisterUser.get()
					.I_Select_from_Address_List_on_Forwarding_Address("18 WITLEY WALK, WHITFIELD, CT16 3NR");
			UnRegisterUser.get().I_Click_Continue_on_Forwarding_Address();
			Run_AccessibilityTest();
			UnRegisterUser.get().I_Click_Confirm_and_Close_Account_on_check_and_confirm_step();
			Run_AccessibilityTest();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SubmitMeterReading_Accessibility(String Browser) throws Throwable {

		try {
			Meter.get().I_am_on_Unregistered_Submit_meter_Reading_page();
			Run_AccessibilityTest();
			Meter.get().I_Click_on_Start_Button();
			Run_AccessibilityTest();
			Meter.get().I_Enter_CustomerNumber_Payment_Reference__and_LastName("10470201", "0004012407196", "DOWNHYLL");
			Meter.get().I_Click_on_Continue();

			Run_AccessibilityTest();
			Meter.get().I_Click_again_on_Continue();
			Run_AccessibilityTest();
			Meter.get().I_Can_Enter_Updated_Meter_Reading();
			Meter.get().I_can_click_to_continue_Button_of_Your_meter_reading_page();
			Run_AccessibilityTest();
			Meter.get().I_can_view_updated_meter_reading_on_Confirm_meter_reading();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Login_Accessibility(String Browser) throws Throwable {
		try {
			Login.get().ResetPasswordPage();
			Run_AccessibilityTest();
			Login.get().EnterEmailForgotPassword("abc@yahoo.com");
			Login.get().ClickContinue();
			Login.get().ResetPasswordLinkVerification();
			Login.get().I_am_at_login_page();
			Run_AccessibilityTest();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Run_AccessibilityTest();
			Login.get().LoginCompleted();
			Logout.get().ClickOnLogOut();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
}

//Run_AccessibilityTest();