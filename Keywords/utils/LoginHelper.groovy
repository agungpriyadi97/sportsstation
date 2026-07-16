package utils

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Arrays

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class LoginHelper {

	@Keyword
	void login(String email, String password) {

		// Jika belum berada di halaman Login
		if (!WebUI.verifyElementPresent(
				findTestObject('WEB/Login/txt_Email'),
				3,
				FailureHandling.OPTIONAL)) {

			WebUI.waitForElementClickable(
				findTestObject('WEB/Common/lnk_SignIn'),
				20)

			WebUI.enhancedClick(
				findTestObject('WEB/Common/lnk_SignIn'))
		}

		WebUI.waitForElementVisible(
			findTestObject('WEB/Login/txt_Email'),
			20)

		WebUI.setText(
			findTestObject('WEB/Login/txt_Email'),
			email)

		WebUI.setText(
			findTestObject('WEB/Login/txt_Password'),
			password)

		WebUI.enhancedClick(
			findTestObject('WEB/Login/btn_sign_in'))
	}

	@Keyword
	void verifyLoginSuccess() {
	
		WebUI.waitForPageLoad(20)
	
		WebUI.delay(2)
	
		CustomKeywords.'utils.CommonHelper.closeAllPopup'()
	
		WebUI.waitForElementVisible(
			findTestObject('WEB/Common/lbl_UserName'),
			20)
	
		WebUI.verifyElementVisible(
			findTestObject('WEB/Common/lbl_UserName'))
	
		println("================================")
		println("LOGIN SUCCESS")
		println("================================")
	}
}