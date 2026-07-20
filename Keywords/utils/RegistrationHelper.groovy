package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

// Tambahan import untuk mengatasi masalah Firefox dan Javascript Executor
import org.openqa.selenium.Keys 
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor

import internal.GlobalVariable

class RegistrationHelper {

	/**
	 * Open Registration Page
	 */
	@Keyword
	void openRegistration() {

		WebUI.waitForElementClickable(
				findTestObject('WEB/Common/lnk_SignIn'),
				20)

		WebUI.click(findTestObject('WEB/Common/lnk_SignIn'))

		WebUI.waitForElementClickable(
				findTestObject('WEB/Login/lnk_Register'),
				20)

		WebUI.click(findTestObject('WEB/Login/lnk_Register'))
	}

	/**
	 * Verify Mobile
	 */
	@Keyword
	void verifyMobile(String mobile) {

		WebUI.waitForElementVisible(
				findTestObject('WEB/Registration/txt_MobilePhoneNumber'),
				20)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_MobilePhoneNumber'),
				mobile)

		WebUI.click(
				findTestObject('WEB/Registration/btn_SignUp'))

		WebUI.waitForElementClickable(
				findTestObject('WEB/Registration/btn_Whatsapp'),
				20)

		WebUI.click(
				findTestObject('WEB/Registration/btn_Whatsapp'))

		WebUI.waitForElementVisible(
				findTestObject('WEB/Registration/txt_OTP'),
				20)

		// OTP Bypass
		WebUI.setText(
				findTestObject('WEB/Registration/txt_OTP'),
				"1234")
	}

	/**
	 * Fill Registration Form
	 */
	@Keyword
	void fillRegistrationForm(Map data, String otp) {

		WebUI.waitForElementVisible(
				findTestObject('WEB/Registration/txt_Email'),
				20)

		// ---------------------------------------------------------
		// IMPLEMENTASI JAVASCRIPT EXECUTOR UNTUK MENGATASI BUG FIREFOX
		// ---------------------------------------------------------
		WebElement emailField = WebUiCommonHelper.findWebElement(findTestObject('WEB/Registration/txt_Email'), 10)
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
		
		// Set value secara langsung dan trigger event agar Vue.js / ElementUI mendeteksinya
		js.executeScript("arguments[0].value='${data.email}'; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", emailField)
		WebUI.delay(1)
		// ---------------------------------------------------------

		WebUI.click(
				findTestObject('WEB/Registration/btn_SendValidationCode'))

		WebUI.waitForElementVisible(
				findTestObject('WEB/Registration/txt_ValidationCode'),
				20)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_ValidationCode'),
				otp)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_Password'),
				data.password)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_ConfirmPassword'),
				data.password)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_FirstName'),
				data.firstName)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_LastName'),
				data.lastName)

		WebUI.setText(
				findTestObject('WEB/Registration/txt_DateOfBirth'),
				"04/07/1996")

		// Menutup popup kalender setelah tanggal diisi (Solusi dari isu sebelumnya)
		WebUI.sendKeys(
				findTestObject('WEB/Registration/txt_DateOfBirth'), 
				Keys.chord(Keys.ENTER))
		
		WebUI.delay(1)

		// ---------------------------------------------------------
		// PERBAIKAN: Penanganan animasi dropdown Gender
		// ---------------------------------------------------------
		WebUI.click(
				findTestObject('WEB/Registration/ddl_Gender'))

		// Tunggu opsi Male muncul di layar (menunggu animasi selesai)
		WebUI.waitForElementVisible(
				findTestObject('WEB/Registration/opt_Gender', [('gender') : 'Male']), 
				5)
				
		WebUI.delay(1) // Jeda stabilisasi UI

		WebUI.click(
				findTestObject('WEB/Registration/opt_Gender', [('gender') : 'Male']))
		// ---------------------------------------------------------

		WebUI.scrollToElement(
				findTestObject('WEB/Registration/chk_DataProtectionPolicy'),
				5)

		WebUI.click(
				findTestObject('WEB/Registration/chk_DataProtectionPolicy'))
	}

	/**
	 * Submit Registration
	 */
	@Keyword
	void submitRegistration() {

		WebUI.waitForElementClickable(
				findTestObject('WEB/Registration/btn_SignUp_form'),
				20)

		WebUI.click(
				findTestObject('WEB/Registration/btn_SignUp_form'))
	}

	/**
	 * Verify Success
	 */
	@Keyword
	void verifySuccess() {

		WebUI.waitForPageLoad(20)

		WebUI.delay(5)

		println "====================================="
		println "REGISTER SUCCESS"
		println "====================================="
	}
}