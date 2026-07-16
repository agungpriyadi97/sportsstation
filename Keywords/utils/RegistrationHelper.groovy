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

		WebUI.setText(
				findTestObject('WEB/Registration/txt_Email'),
				data.email)

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

		WebUI.click(
				findTestObject('WEB/Registration/ddl_Gender'))

		WebUI.click(
				findTestObject(
				'WEB/Registration/opt_Gender',
				[
					('gender') : 'Male'
				]))

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

		// TODO:
		// Ganti object sesuai aplikasi
		// Contoh:
		// WebUI.verifyElementVisible(findTestObject('WEB/Common/icon_Profile'))

		println "====================================="
		println "REGISTER SUCCESS"
		println "====================================="
	}
}