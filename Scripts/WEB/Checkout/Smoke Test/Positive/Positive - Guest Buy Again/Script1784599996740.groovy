import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

import utils.DummyData
import utils.ProductHelper

//====================================================
// INITIALIZE
//====================================================

ProductHelper product = new ProductHelper()
import utils.ProductHelper

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


callTestCase(
	findTestCase("Test Cases/WEB/Checkout/Smoke Test/Positive/Positive - Ensure user can complete payment successfully"),
	[:]
)
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

waitForElementVisible(
	findTestObject('Object Repository/WEB/My Order/btn_BuyAgain'),
	20
)

scrollToElement(
	findTestObject('Object Repository/WEB/My Order/btn_BuyAgain'),
	5
)

waitForElementClickable(
	findTestObject('Object Repository/WEB/My Order/btn_BuyAgain'),
	20
)

enhancedClick(
	findTestObject('Object Repository/WEB/My Order/btn_BuyAgain')
)

println("BUY AGAIN CLICKED")

//====================================================
// VERIFY TOAST
//====================================================

waitForElementVisible(
	findTestObject("WEB/Common/lbl_SuccessToast"),
	20)

verifyTextPresent(
	"Successfully added to the shopping cart",
	false)

println("PRODUCT ADDED TO CART")

//====================================================
// OPEN CART
//====================================================

product.openCart()

product.verifyCartPage()

//====================================================
// CHECKOUT
//====================================================

scrollToElement(
	findTestObject("WEB/Cart/btn_Checkout"),
	5)

enhancedClick(
	findTestObject("WEB/Cart/btn_Checkout"))

waitForPageLoad(20)

//====================================================
// SHIPPING METHOD
//====================================================

enhancedClick(
	findTestObject("WEB/Checkout/Shipping/rdo_Regular"))

println("REGULAR SHIPPING")


scrollToElement(
	findTestObject("Object Repository/WEB/Checkout/Billing/chk_SameAsShipping"),
	7)
//====================================================
// PAYMENT
//====================================================

waitForElementVisible(
	findTestObject('Object Repository/WEB/Payment/rdo_Midtrans'),
	20
)

scrollToElement(
	findTestObject('Object Repository/WEB/Payment/rdo_Midtrans'),
	5
)

waitForElementClickable(
	findTestObject('Object Repository/WEB/Payment/rdo_Midtrans'),
	20
)

enhancedClick(
	findTestObject('Object Repository/WEB/Payment/rdo_Midtrans')
)

enhancedClick(
	findTestObject("WEB/Payment/lbl_VirtualAccount"))

enhancedClick(
	findTestObject("WEB/Payment/rdo_BCA"))

println("MIDTRANS BCA")

//====================================================
// TERMS
//====================================================

click(
	findTestObject("WEB/Checkout/OrderSummary/chk_PrivacyPolicy"))

//====================================================
// PLACE ORDER
//====================================================

scrollToElement(
	findTestObject("WEB/Cart/btn_Checkout"),
	5)

enhancedClick(
	findTestObject("WEB/Cart/btn_Checkout"))

//====================================================
// SUCCESS
//====================================================

switchToWindowIndex(1)

waitForElementVisible(
	findTestObject("WEB/Checkout/Success/lbl_OrderPlacedSuccessfully"),
	30)

verifyTextPresent(
	"Your order has been placed successfully.",
	false)

println("======================================")
println("BUY AGAIN SUCCESS")
println("======================================")
