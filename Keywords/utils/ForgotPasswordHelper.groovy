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

class ForgotPasswordHelper {

	/**
	 * Open Forgot Password Page
	 */
	@Keyword
	void openForgotPassword() {

		// Tambahkan FailureHandling.OPTIONAL agar tes tidak gagal jika elemen tidak ditemukan
		if (!WebUI.verifyElementPresent(
				findTestObject('WEB/Login/txt_Email'),
				3, 
				FailureHandling.OPTIONAL)) {
            
			// Tambahkan wait agar lebih stabil sebelum klik
			WebUI.waitForElementClickable(
				findTestObject('WEB/Common/lnk_SignIn'),
				10,
				FailureHandling.OPTIONAL)

			WebUI.click(
				findTestObject('WEB/Common/lnk_SignIn'))
		}

		WebUI.waitForElementClickable(
			findTestObject('WEB/Login/lnk_ForgotPassword'),
			20)

		WebUI.click(
			findTestObject('WEB/Login/lnk_ForgotPassword'))

		WebUI.waitForPageLoad(20)
	}

	/**
	 * Send Verification Code
	 */
	@Keyword
	void sendVerificationCode(String email) {

		WebUI.waitForElementVisible(
			findTestObject('WEB/ForgotPassword/txt_Email'),
			20)

		WebUI.setText(
			findTestObject('WEB/ForgotPassword/txt_Email'),
			email)

		WebUI.click(
			findTestObject('WEB/ForgotPassword/btn_SendValidationCode'))

		println("Verification Email Sent")
	}

	/**
	 * Fill Reset Password Form
	 */
	@Keyword
	void fillResetPasswordForm(String otp,
			String newPassword) {

		WebUI.waitForElementVisible(
			findTestObject('WEB/ForgotPassword/txt_ValidationCode'),
			20)

		WebUI.setText(
			findTestObject('WEB/ForgotPassword/txt_ValidationCode'),
			otp)

		WebUI.setText(
			findTestObject('WEB/ForgotPassword/txt_Password'),
			newPassword)

		WebUI.setText(
			findTestObject('WEB/ForgotPassword/txt_ConfirmPassword'),
			newPassword)
	}

	/**
	 * Submit Reset Password
	 */
	@Keyword
	void submitResetPassword() {

		WebUI.click(
			findTestObject('WEB/ForgotPassword/btn_ResetPassword'))
	}

	/**
	 * Verify Reset Password Success
	 */
	@Keyword
	void verifyResetPasswordSuccess() {

		WebUI.waitForPageLoad(20)

		WebUI.verifyElementVisible(
			findTestObject('WEB/Login/btn_sign_in'))

		println("================================")
		println("RESET PASSWORD SUCCESS")
		println("================================")
	}
}