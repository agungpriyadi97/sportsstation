package utils

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Arrays

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CommonHelper {

	//----------------------------------------------------
	// CREATE TEST OBJECT
	//----------------------------------------------------

	private TestObject byXpath(String xpath) {

		TestObject to = new TestObject()

		to.addProperty(
			"xpath",
			ConditionType.EQUALS,
			xpath
		)

		return to
	}

	//----------------------------------------------------
	// MAPCLUB POPUP
	//----------------------------------------------------

	@Keyword
	def closeMapClubPopup() {

		TestObject btnClose =
				findTestObject("WEB/Common/btn_ClosePopup")

		if (!WebUI.verifyElementPresent(
				btnClose,
				2,
				FailureHandling.OPTIONAL)) {

			return
		}

		WebUI.comment("MAPCLUB POPUP FOUND")

		try {

			WebUI.waitForElementClickable(
				btnClose,
				10)

			WebUI.enhancedClick(
				btnClose)

			WebUI.delay(1)

		}
		catch(Exception e) {

			try {

				WebUI.executeJavaScript(
					"arguments[0].click();",
					Arrays.asList(
						WebUI.findWebElement(btnClose,10)
					)
				)

				WebUI.delay(1)

			}
			catch(Exception ex) {

				WebUI.executeJavaScript("""

document.querySelectorAll('.el-dialog').forEach(e=>e.remove());

document.querySelectorAll('.el-dialog__wrapper').forEach(e=>e.remove());

document.querySelectorAll('.v-modal').forEach(e=>e.remove());

document.body.style.overflow='auto';

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

		TestObject btnCookie = byXpath(
			"//button[normalize-space()='Accept All Cookies']"
		)

		if (!WebUI.verifyElementPresent(
				btnCookie,
				2,
				FailureHandling.OPTIONAL)) {

			return
		}

		WebUI.comment("COOKIE BANNER FOUND")

		try {

			WebUI.waitForElementClickable(
				btnCookie,
				10)

			WebUI.enhancedClick(
				btnCookie)

			WebUI.delay(1)

		}
		catch(Exception e) {

			try {

				WebUI.executeJavaScript(
					"arguments[0].click();",
					Arrays.asList(
						WebUI.findWebElement(btnCookie,10)
					)
				)

				WebUI.delay(1)

			}
			catch(Exception ex) {

				WebUI.executeJavaScript("""

document.querySelectorAll('#CybotCookiebotDialog').forEach(e=>e.remove());

document.querySelectorAll('.cookie-banner').forEach(e=>e.remove());

document.body.style.overflow='auto';

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

		closeMapClubPopup()

		acceptCookies()

		WebUI.delay(1)
	}

}