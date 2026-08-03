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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import utils.DummyData
import utils.ProductHelper

//====================================================
// INITIALIZE
//====================================================

ProductHelper product = new ProductHelper()

DummyData dummy = new DummyData()

Map data = dummy.generateRegistrationData()

println("======================================")
println("TEST CASE : HOME DELIVERY CHECKOUT USING MAAS")
println("======================================")

//====================================================
// OPEN PRODUCT
//====================================================

navigateToUrl(
	"https://staging.sportsstation.id/pdp/Airwalk-Elwin-Women's-Skate-Shoes-Blue/SP251110878544"
)

product.waitUntilReady()

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

product.verifyPDP()

//====================================================
// ADD PRODUCT
//====================================================

product.addProductToCart()

product.verifySuccessToast()

product.openCart()

product.verifyCartPage()

//====================================================
// CHECKOUT
//====================================================

waitForElementClickable(
	findTestObject('WEB/Cart/btn_Checkout'),
	20)

enhancedClick(
	findTestObject('WEB/Cart/btn_Checkout'))

waitForPageLoad(20)

//====================================================
// GUEST EMAIL
//====================================================

setText(
	findTestObject('WEB/Checkout/Guest/txt_Email'),
	data.email)

enhancedClick(
	findTestObject('WEB/Checkout/Guest/btn_Continue'))

waitForPageLoad(20)

//====================================================
// SHIPPING ADDRESS
//====================================================

setText(
	findTestObject('WEB/Checkout/Guest/txt_FirstName'),
	data.firstName)

setText(
	findTestObject('WEB/Checkout/Guest/txt_LastName'),
	data.lastName)

setText(
	findTestObject('WEB/Checkout/Guest/txt_Mobile'),
	data.mobilePhone)

setText(
	findTestObject('WEB/Checkout/Guest/txt_Address'),
	"Automation MAAS Address")

click(findTestObject('WEB/Checkout/Guest/ddl_Province'))
click(findTestObject('WEB/Checkout/Guest/opt_Province_Banten'))

click(findTestObject('WEB/Checkout/Guest/ddl_City'))
click(findTestObject('WEB/Checkout/Guest/opt_City_Tangerang'))

click(findTestObject('WEB/Checkout/Guest/ddl_District'))
click(findTestObject('WEB/Checkout/Guest/opt_District_Larangan'))

click(findTestObject('WEB/Checkout/Guest/ddl_PostalCode'))
click(findTestObject('WEB/Checkout/Guest/opt_PostalCode'))

enhancedClick(
	findTestObject('WEB/Checkout/Guest/btn_Save'))

waitForPageLoad(20)

//====================================================
// SHIPPING METHOD
//====================================================

enhancedClick(
	findTestObject('WEB/Checkout/Shipping/rdo_Regular'))

println("REGULAR SHIPPING SELECTED")

//====================================================
// PAYMENT
//====================================================

println("SELECT MAAS")

waitForElementClickable(
	findTestObject('WEB/Payment/rdo_MAAS'),
	20)

scrollToElement(
	findTestObject('WEB/Payment/rdo_MAAS'),
	5)

enhancedClick(
	findTestObject('WEB/Payment/rdo_MAAS'))

verifyElementPresent(
	findTestObject('WEB/Payment/rdo_MAAS'),
	20)

//====================================================
// ACCEPT TERMS
//====================================================

click(
	findTestObject('WEB/Checkout/OrderSummary/chk_PrivacyPolicy'))

//====================================================
// PLACE ORDER
//====================================================

scrollToElement(
	findTestObject('WEB/Cart/btn_Checkout'),
	5)

enhancedClick(
	findTestObject('WEB/Cart/btn_Checkout'))

//====================================================
// SUCCESS
//====================================================

switchToWindowIndex(1)

waitForElementVisible(
	findTestObject('WEB/Checkout/Success/lbl_OrderPlacedSuccessfully'),
	30)

verifyElementVisible(
	findTestObject('WEB/Checkout/Success/lbl_OrderPlacedSuccessfully'))

verifyTextPresent(
	"Your order has been placed successfully.",
	false)

println("======================================")
println("HOME DELIVERY CHECKOUT USING MAAS SUCCESS")
println("======================================")