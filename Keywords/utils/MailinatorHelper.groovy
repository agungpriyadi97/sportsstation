package utils

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class MailinatorHelper {

	private static final String MAILINATOR_URL =
	"https://www.mailinator.com/v4/public/inboxes.jsp?to="

	private String appWindow

	//====================================================
	// OPEN INBOX
	//====================================================

	@Keyword
	void openInbox(String inbox) {

		WebDriver driver = DriverFactory.getWebDriver()

		appWindow = driver.getWindowHandle()

		boolean opened = false

		driver.getWindowHandles().each { window ->

			driver.switchTo().window(window)

			if(driver.currentUrl.contains("mailinator.com")) {
				opened = true
			}
		}

		if(!opened) {

			WebUI.executeJavaScript(
				"window.open('about:blank','_blank');",
				null)

			driver.switchTo().window(
				driver.windowHandles.last())
		}

		driver.get(MAILINATOR_URL + inbox)

		WebUI.waitForPageLoad(20)

		WebUI.delay(3)
	}

	//====================================================
	// OPEN EMAIL BY SUBJECT
	//====================================================

	@Keyword
	void openLatestEmailBySubject(
		String inbox,
		String subject,
		int retry = 20) {

		openInbox(inbox)

		boolean found = false

		for(int i=1;i<=retry;i++) {

			println("Checking Email (${i}/${retry})")

			TestObject email = new TestObject()

			email.addProperty(
				"xpath",
				ConditionType.EQUALS,
				"//td[contains(normalize-space(.),\"${subject}\")]")

			if(WebUI.verifyElementPresent(
				email,
				3,
				FailureHandling.OPTIONAL)) {

				WebUI.enhancedClick(email)

				WebUI.waitForPageLoad(10)

				WebUI.delay(2)

				found = true

				break
			}

			WebUI.refresh()

			WebUI.waitForPageLoad(10)

			WebUI.delay(3)
		}

		assert found :
		"Email dengan subject '${subject}' tidak ditemukan."
	}

	//====================================================
	// GET EMAIL BODY
	//====================================================

	@Keyword
	String getEmailBody() {

		WebUI.switchToDefaultContent()

		WebUI.waitForElementPresent(
			findTestObject("WEB/Mailinator/iframe_EmailBody"),
			20)

		WebUI.switchToFrame(
			findTestObject("WEB/Mailinator/iframe_EmailBody"),
			20)

		WebUI.waitForElementVisible(
			findTestObject("WEB/Mailinator/htmlMessageFrame"),
			20)

		String body =
		WebUI.getText(
			findTestObject("WEB/Mailinator/htmlMessageFrame"))

		WebUI.switchToDefaultContent()

		return body
	}

	//====================================================
	// EXTRACT OTP
	//====================================================

	@Keyword
	String extractOTP(String body) {

		def matcher =
		(body =~ /\b\d{6}\b/)

		assert matcher.find() :
		"OTP tidak ditemukan."

		return matcher.group()
	}

	//====================================================
	// GET OTP
	//====================================================

	@Keyword
	String getOTPBySubject(
		String inbox,
		String subject) {

		openLatestEmailBySubject(
			inbox,
			subject)

		String body =
		getEmailBody()

		println(body)

		String otp =
		extractOTP(body)

		println("OTP : " + otp)

		switchToApplication()

		return otp
	}

	//====================================================
	// BACK TO APPLICATION
	//====================================================

	@Keyword
	void switchToApplication() {

		if(appWindow != null) {

			DriverFactory.getWebDriver()
				.switchTo()
				.window(appWindow)
		}
	}

}