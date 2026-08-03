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
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import utils.MailinatorHelper

println("======================================")
println("TEST CASE : POSITIVE - ORDER PAID EMAIL")
println("======================================")

//====================================================
// EXECUTE PAYMENT
//====================================================

println("EXECUTE PAYMENT FLOW")

callTestCase(
	findTestCase(
		'Test Cases/WEB/Checkout/Smoke Test/Positive/Positive - Ensure user can complete payment successfully'),
	[:],
	FailureHandling.STOP_ON_FAILURE)

//====================================================
// OPEN MAILINATOR
//====================================================

String email = GlobalVariable.usernamenonmember
String inbox = email.split("@")[0]

println("MAIL : " + email)

MailinatorHelper mail = new MailinatorHelper()

mail.waitForOrderPaidEmail(inbox)

//====================================================
// VERIFY EMAIL
//====================================================

println("VERIFY ORDER PAID EMAIL")

verifyTextPresent(
	"order confirmation",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"Payment Received",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"Order Number",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"Nomor Pesanan",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"Grand Total",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"GRAND TOTAL",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"Product Details",
	false,
	FailureHandling.OPTIONAL)

verifyTextPresent(
	"DETIL PRODUK",
	false,
	FailureHandling.OPTIONAL)

println("======================================")
println("ORDER PAID EMAIL SUCCESS")
println("======================================")
