import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

println("======================================")
println("TEST CASE : POSITIVE - CHECK ORDER DETAIL")
println("======================================")

//====================================================
// DYNAMIC XPATH
//====================================================

def byXpath(String xpath) {

	TestObject to = new TestObject()

	to.addProperty(
		"xpath",
		ConditionType.EQUALS,
		xpath)

	return to
}

//====================================================
// GUEST CHECKOUT
//====================================================

callTestCase(
	findTestCase("WEB/Checkout/Smoke Test/Positive/Positive - Guest Checkout"),
	[:],
	FailureHandling.STOP_ON_FAILURE)

println("CHECKOUT SUCCESS")

println("ORDER STATUS    : ${GlobalVariable.OrderStatus}")
println("ORDER NUMBER    : ${GlobalVariable.OrderNumber}")
println("PAYMENT METHOD  : ${GlobalVariable.PaymentMethod}")
println("TOTAL PRICE     : ${GlobalVariable.TotalPrice}")
println("VIRTUAL ACCOUNT : ${GlobalVariable.VirtualAccount}")

//====================================================
// OPEN ORDER DETAIL
//====================================================

waitForElementClickable(
	findTestObject("WEB/Checkout/Success/btn_ViewDetails"),
	30)

scrollToElement(
	findTestObject("WEB/Checkout/Success/btn_ViewDetails"),
	5)

enhancedClick(
	findTestObject("WEB/Checkout/Success/btn_ViewDetails"))

waitForPageLoad(20)

println("ORDER DETAIL OPENED")

//====================================================
// VERIFY PAGE
//====================================================

verifyElementVisible(
	byXpath("//div[contains(@class,'order-detail')]"))

println("ORDER DETAIL PAGE VERIFIED")

//====================================================
// VERIFY ORDER STATUS
//====================================================

verifyElementPresent(
	byXpath("//div[contains(@class,'status')]//*[contains(normalize-space(),'${GlobalVariable.OrderStatus}')]"),
	20)

println("ORDER STATUS VERIFIED")

//====================================================
// VERIFY ORDER NUMBER
//====================================================

verifyElementPresent(
	byXpath("//p[normalize-space()='Order No.']/following-sibling::p[contains(.,'${GlobalVariable.OrderNumber}')]"),
	20)

println("ORDER NUMBER VERIFIED")

//====================================================
// VERIFY PAYMENT METHOD
//====================================================

verifyElementPresent(
	byXpath("//p[normalize-space()='Payment Method']/following-sibling::span[contains(normalize-space(),'${GlobalVariable.PaymentMethod}')]"),
	20)

println("PAYMENT METHOD VERIFIED")

//====================================================
// VERIFY TOTAL PRICE
//====================================================

verifyElementPresent(
	byXpath("//span[contains(text(),'Total (VAT incl.)')]/following-sibling::span[contains(normalize-space(),'${GlobalVariable.TotalPrice}')]"),
	20)

println("TOTAL PRICE VERIFIED")

//====================================================
// VERIFY CREATED TIME
//====================================================

verifyElementVisible(
	byXpath("//p[normalize-space()='Created Time']/following-sibling::p"))

println("CREATED TIME VERIFIED")

//====================================================
// VERIFY DELIVERY METHOD
//====================================================

verifyElementVisible(
	byXpath("//p[normalize-space()='Delivery Method']/following-sibling::p/span"))

println("DELIVERY METHOD VERIFIED")

//====================================================
// VERIFY DELIVERY ADDRESS
//====================================================

verifyElementVisible(
	byXpath("//p[normalize-space()='Delivery Address']/parent::li"))

println("DELIVERY ADDRESS VERIFIED")

//====================================================
// VERIFY BILLING ADDRESS
//====================================================

verifyElementVisible(
	byXpath("//p[normalize-space()='Billing Address']/parent::li"))

println("BILLING ADDRESS VERIFIED")

//====================================================
// VERIFY CONTINUE TO PAY BUTTON
//====================================================

verifyElementVisible(
	byXpath("//button[.//span[normalize-space()='Continue to Pay']]"))

println("CONTINUE TO PAY BUTTON VERIFIED")

println("======================================")
println("CHECK ORDER DETAIL SUCCESS")
println("======================================")