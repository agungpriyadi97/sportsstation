import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

import utils.MailinatorHelper
import utils.MailSubject

println("======================================")
println("TEST CASE : POSITIVE - TRACK ORDER VIA EMAIL OTP")
println("======================================")

//====================================================
// DYNAMIC XPATH
//====================================================

TestObject byXpath(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

//====================================================
// CREATE ORDER
//====================================================

callTestCase(
	findTestCase("WEB/Checkout/Smoke Test/Positive/Positive - Guest Checkout"),
	[:],
	FailureHandling.STOP_ON_FAILURE)

println("CHECKOUT SUCCESS")
println("ORDER NUMBER : ${GlobalVariable.OrderNumber}")

//====================================================
// BACK TO HOME
//====================================================

switchToWindowIndex(0)

navigateToUrl(GlobalVariable.URL)

waitForPageLoad(20)

//====================================================
// OPEN TRACK ORDER
//====================================================

enhancedClick(
	findTestObject("WEB/TrackOrder/lnk_TrackOrder"))

waitForPageLoad(20)

verifyElementVisible(
	findTestObject("WEB/TrackOrder/lbl_TrackYourOrder"))

println("TRACK ORDER PAGE OPENED")

//====================================================
// INPUT EMAIL
//====================================================

setText(
	findTestObject("WEB/TrackOrder/txt_Email"),
	GlobalVariable.usernamenonmember)

println("EMAIL : ${GlobalVariable.usernamenonmember}")

//====================================================
// SEND OTP
//====================================================

enhancedClick(
	findTestObject("WEB/TrackOrder/btn_Send"))

println("OTP SENT")

//====================================================
// GET OTP
//====================================================

String inbox = GlobalVariable.usernamenonmember.split("@")[0]

MailinatorHelper mail = new MailinatorHelper()

String otp = mail.getOTPBySubject(
	inbox,
	MailSubject.TRACK_ORDER)

println("OTP : ${otp}")

//====================================================
// INPUT OTP
//====================================================

setText(
	findTestObject("WEB/TrackOrder/txt_VerificationCode"),
	otp)

println("OTP INPUTTED")

//====================================================
// CONTINUE
//====================================================

enhancedClick(
	findTestObject("WEB/TrackOrder/btn_Continue"))

waitForPageLoad(20)

//====================================================
// VERIFY MY ORDER PAGE
//====================================================

waitForElementVisible(
	byXpath("(//p[contains(@class,'title-panel')])[1]"),
	20)

String orderHeader = getText(
	byXpath("(//p[contains(@class,'title-panel')])[1]"))

println(orderHeader)

//====================================================
// VERIFY ORDER NUMBER
//====================================================

assert orderHeader.contains(GlobalVariable.OrderNumber)

println("ORDER NUMBER VERIFIED")

//====================================================
// VERIFY STATUS
//====================================================

assert orderHeader.contains(GlobalVariable.OrderStatus)

println("ORDER STATUS VERIFIED")

//====================================================
// VERIFY TOTAL
//====================================================

String total = getText(
	byXpath("(//div[contains(@class,'total')]//span)[1]")).trim()

assert total == GlobalVariable.TotalPrice

println("TOTAL VERIFIED : " + total)

//====================================================
// VERIFY PRODUCT
//====================================================

verifyElementVisible(
	byXpath("(//p[contains(@class,'title')])[2]"))

println("PRODUCT VERIFIED")

//====================================================
// VERIFY CONTINUE TO PAY
//====================================================

verifyElementVisible(
	byXpath("(//button[.//span[normalize-space()='Continue to Pay']])[1]"))

println("CONTINUE TO PAY VERIFIED")

//====================================================
// VERIFY VIEW DETAILS
//====================================================

verifyElementVisible(
	byXpath("(//button[.//span[normalize-space()='View Details']])[1]"))

println("VIEW DETAILS VERIFIED")

println("======================================")
println("TRACK ORDER SUCCESS")
println("======================================")