import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

println("======================================")
println("TEST CASE : COMPLETE PAYMENT")
println("======================================")

//====================================================
// GUEST CHECKOUT
//====================================================

callTestCase(
	findTestCase("WEB/Checkout/Smoke Test/Positive/Positive - Guest Checkout"),
	[:],
	FailureHandling.STOP_ON_FAILURE)

println("CHECKOUT SUCCESS")

println("ORDER NUMBER    : " + GlobalVariable.OrderNumber)
println("PAYMENT METHOD  : " + GlobalVariable.PaymentMethod)
println("TOTAL PRICE     : " + GlobalVariable.TotalPrice)
println("VIRTUAL ACCOUNT : " + GlobalVariable.VirtualAccount)

//====================================================
// OPEN ORDER DETAIL
//====================================================

waitForElementClickable(
	findTestObject("WEB/Checkout/Success/btn_ViewDetails"),
	30)

enhancedClick(
	findTestObject("WEB/Checkout/Success/btn_ViewDetails"))

waitForPageLoad(20)

println("ORDER DETAIL OPENED")

//====================================================
// CONTINUE TO PAY
//====================================================

waitForElementClickable(
	findTestObject("Object Repository/WEB/Order Detail/btn_ContinueToPay"),
	20)

scrollToElement(
	findTestObject("Object Repository/WEB/Order Detail/btn_ContinueToPay"),
	5)

enhancedClick(
	findTestObject("Object Repository/WEB/Order Detail/btn_ContinueToPay"))

waitForPageLoad(20)

println("PAYMENT PAGE OPENED")

//====================================================
// OPEN MIDTRANS SIMULATOR
//====================================================

executeJavaScript(
	"window.open('https://simulator.sandbox.midtrans.com/bca/va/index');",
	null)

delay(3)

switchToWindowIndex(2)

println("MIDTRANS OPENED")

//====================================================
// INPUT VA
//====================================================

waitForElementVisible(
	findTestObject("Object Repository/WEB/Midtrans/txt_VirtualAccount"),
	20)

setText(
	findTestObject("Object Repository/WEB/Midtrans/txt_VirtualAccount"),
	GlobalVariable.VirtualAccount)

println("INPUT VA : " + GlobalVariable.VirtualAccount)

//====================================================
// INQUIRE
//====================================================

click(
	findTestObject("WEB/Midtrans/btn_Inquire"))

waitForElementVisible(
	findTestObject("WEB/Midtrans/btn_Pay"),
	20)

println("INQUIRE SUCCESS")

//====================================================
// VERIFY PAYMENT DETAIL
//====================================================

verifyElementVisible(
	findTestObject("Object Repository/WEB/Midtrans/lbl_VANumber"))

verifyElementVisible(
	findTestObject("WEB/Midtrans/txt_AmountToPay"))

verifyElementVisible(
	findTestObject("WEB/Midtrans/btn_Pay"))

println("PAYMENT DETAIL VERIFIED")

//====================================================
// PAY
//====================================================

click(
	findTestObject("WEB/Midtrans/btn_Pay"))

waitForElementVisible(
	findTestObject("WEB/Midtrans/lbl_PaymentSuccess"),
	30)

verifyTextPresent(
	"successful",
	false)

println("PAYMENT SUCCESS")

//====================================================
// BACK TO ORDER DETAIL
//====================================================

switchToWindowIndex(1)

waitForPageLoad(20)

println("BACK TO ORDER DETAIL")

//====================================================
// WAIT UNTIL ORDER STATUS = PAID
//====================================================

TestObject lblStatus = new TestObject()

lblStatus.addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[normalize-space()='Order Status']/following-sibling::span")

boolean paid = false

String status = ""

for(int i=1;i<=20;i++) {

	refresh()

	waitForPageLoad(10)

	waitForElementVisible(lblStatus,10)

	status = getText(lblStatus).trim()

	println("CHECK STATUS (${i}) : ${status}")

	if(status.equalsIgnoreCase("Paid")) {

		paid = true
		break
	}

	delay(3)
}

assert paid : "Order status never changed to Paid."

GlobalVariable.OrderStatus = status

println("ORDER STATUS : " + status)

//====================================================
// VERIFY PAYMENT INFORMATION
//====================================================

verifyTextPresent(
	GlobalVariable.OrderNumber,
	false)

verifyTextPresent(
	GlobalVariable.PaymentMethod,
	false)

verifyTextPresent(
	GlobalVariable.TotalPrice,
	false)

verifyTextPresent(
	GlobalVariable.VirtualAccount,
	false)

println("ORDER NUMBER VERIFIED")
println("PAYMENT METHOD VERIFIED")
println("TOTAL PRICE VERIFIED")
println("VIRTUAL ACCOUNT VERIFIED")

println("======================================")
println("USER CAN COMPLETE PAYMENT SUCCESSFULLY")
println("======================================")