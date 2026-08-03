package utils

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Arrays

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CommonHelper {

	//----------------------------------------------------
	// CREATE TEST OBJECT
	//----------------------------------------------------

	private TestObject byXpath(String xpath) {
		TestObject to = new TestObject()
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		return to
	}

	//----------------------------------------------------
	// MAPCLUB POPUP
	//----------------------------------------------------

	@Keyword
	def closeMapClubPopup() {

		TestObject btnClose = findTestObject("WEB/Common/btn_ClosePopup")

		if (!WebUI.verifyElementPresent(btnClose, 3, FailureHandling.OPTIONAL)) {
			return
		}

		WebUI.comment("MAPCLUB POPUP FOUND")

		try {
			WebUI.waitForElementClickable(btnClose, 5)
			WebUI.enhancedClick(btnClose)
			WebUI.delay(1)
		}
		catch(Exception e) {
			try {
				WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(btnClose, 5)))
				WebUI.delay(1)
			}
			catch(Exception ex) {
				// FORCE REMOVE + RESTORE BODY SCROLL & OVERLAY
				WebUI.executeJavaScript("""
					document.querySelectorAll('.el-dialog, .el-dialog__wrapper, .v-modal, .el-message-box__wrapper').forEach(e => e.remove());
					document.body.style.overflow = 'auto';
					document.body.classList.remove('el-popup-parent--hidden');
				""", null)
				WebUI.delay(1)
			}
		}

		WebUI.comment("MAPCLUB CLOSED")
	}

	//----------------------------------------------------
	// COOKIE BANNER
	//----------------------------------------------------

	@Keyword
	def acceptCookies() {

		// XPath fleksibel mencakup Bahasa Indonesia dan Inggris
		TestObject btnCookie = byXpath("//button[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'accept') or contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'terima')]")

		if (!WebUI.verifyElementPresent(btnCookie, 3, FailureHandling.OPTIONAL)) {
			return
		}

		WebUI.comment("COOKIE BANNER FOUND")

		try {
			WebUI.waitForElementClickable(btnCookie, 5)
			WebUI.enhancedClick(btnCookie)
			WebUI.delay(1)
		}
		catch(Exception e) {
			try {
				WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(btnCookie, 5)))
				WebUI.delay(1)
			}
			catch(Exception ex) {
				WebUI.executeJavaScript("""
					document.querySelectorAll('#CybotCookiebotDialog, .cookie-banner, .cookie-consent, #onetrust-banner-sdk').forEach(e => e.remove());
					document.body.style.overflow = 'auto';
				""", null)
				WebUI.delay(1)
			}
		}

		WebUI.comment("COOKIE ACCEPTED")
	}

	//----------------------------------------------------
	// CLOSE ALL POPUP
	//----------------------------------------------------

	@Keyword
	def closeAllPopup() {
		acceptCookies()
		closeMapClubPopup()

		// Sapu bersih opsional jika ada backdrop tersisa yang bikin halaman terhalang
		try {
			WebUI.executeJavaScript("""
				document.querySelectorAll('.v-modal, .el-popup-parent--hidden').forEach(el => {
					if (el.classList.contains('el-popup-parent--hidden')) {
						el.classList.remove('el-popup-parent--hidden');
					} else {
						el.remove();
					}
				});
				document.body.style.overflow = 'auto';
			""", null)
		} catch (Exception ignored) {}

		WebUI.delay(1)
	}
}