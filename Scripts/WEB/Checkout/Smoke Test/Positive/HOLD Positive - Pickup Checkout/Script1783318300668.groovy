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
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*
import utils.DummyData as DummyData
import utils.ProductHelper as ProductHelper

//====================================================
// INITIALIZE
//====================================================
ProductHelper product = new ProductHelper()

DummyData dummy = new DummyData()

Map data = dummy.generateRegistrationData()

println('======================================')

println('TEST CASE : PICKUP CHECKOUT')

println('======================================')

//====================================================
// OPEN PRODUCT PDP
//====================================================
navigateToUrl('https://staging.sportsstation.id/pdp/Airwalk-Elwin-Women\'s-Skate-Shoes-Blue/SP251110878544')

product.waitUntilReady()

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

product.verifyPDP()

//====================================================
// ADD PRODUCT
//====================================================
println('ADD PRODUCT')

product.addProductToCart()

product.verifySuccessToast()

product.openCart()

product.verifyCartPage()

//====================================================
// CHECKOUT
//====================================================
println('OPEN CHECKOUT')

waitForElementClickable(findTestObject('WEB/Cart/btn_Checkout'), 20)

scrollToElement(findTestObject('WEB/Cart/btn_Checkout'), 5)

enhancedClick(findTestObject('WEB/Cart/btn_Checkout'))

waitForPageLoad(20)

//====================================================
// GUEST EMAIL
//====================================================
println('INPUT GUEST EMAIL')

setText(findTestObject('WEB/Checkout/Guest/txt_Email'), data.email)

enhancedClick(findTestObject('WEB/Checkout/Guest/btn_Continue'))

waitForPageLoad(20)

//====================================================
// STORE PICKUP
//====================================================
println('SELECT STORE PICKUP')

waitForElementClickable(findTestObject('WEB/Checkout/Pickup/rdo_StorePickup'), 20)

scrollToElement(findTestObject('WEB/Checkout/Pickup/rdo_StorePickup'), 5)

waitForElementClickable(findTestObject('WEB/Checkout/Pickup/rdo_StorePickup'), 20)

scrollToElement(findTestObject('WEB/Checkout/Pickup/rdo_StorePickup'), 5)

enhancedClick(findTestObject('WEB/Checkout/Pickup/rdo_StorePickup'))

WebUI.delay(5)

// Province
click(findTestObject('WEB/Checkout/Pickup/ddl_Province'))

click(findTestObject('WEB/Checkout/Pickup/opt_Province_Banten'))

// City
click(findTestObject('WEB/Checkout/Pickup/ddl_City'))

click(findTestObject('WEB/Checkout/Pickup/opt_City_KotaTangerang'))

//// Store
//click(findTestObject('WEB/Checkout/Pickup/ddl_Store'))
//
//click(findTestObject('WEB/Checkout/Pickup/opt_FirstStore'))
//
//println('STORE PICKUP SELECTED')

//====================================================
// PAYMENT
//====================================================
println('SELECT MIDTRANS')

enhancedClick(findTestObject('WEB/Payment/rdo_Midtrans'))

enhancedClick(findTestObject('WEB/Payment/lbl_VirtualAccount'))

enhancedClick(findTestObject('WEB/Payment/rdo_BCA'))

verifyElementPresent(findTestObject('WEB/Payment/rdo_BCA'), 20)

//====================================================
// BILLING ADDRESS
//====================================================
println('FILL BILLING ADDRESS')

setText(findTestObject('WEB/Checkout/Billing/txt_FirstName'), data.firstName)

setText(findTestObject('WEB/Checkout/Billing/txt_LastName'), data.lastName)

setText(findTestObject('WEB/Checkout/Billing/txt_Mobile'), data.mobilePhone)

setText(findTestObject('WEB/Checkout/Billing/txt_Address'), 'Automation Pickup Address')

// Province
click(findTestObject('WEB/Checkout/Billing/ddl_Province'))

click(findTestObject('WEB/Checkout/Billing/opt_Province_Banten'))

// City
click(findTestObject('WEB/Checkout/Billing/ddl_City'))

click(findTestObject('WEB/Checkout/Billing/opt_City_KotaTangerang'))

// District
click(findTestObject('WEB/Checkout/Billing/ddl_District'))

click(findTestObject('WEB/Checkout/Billing/opt_District_Larangan'))

// Postal Code
click(findTestObject('WEB/Checkout/Billing/ddl_PostalCode'))

click(findTestObject('WEB/Checkout/Billing/opt_PostalCode'))

//====================================================
// ACCEPT TERMS
//====================================================
println('ACCEPT TERMS')

click(findTestObject('WEB/Checkout/OrderSummary/chk_PrivacyPolicy'))

//====================================================
// PLACE ORDER
//====================================================
println('PLACE ORDER')

scrollToElement(findTestObject('WEB/Cart/btn_Checkout'), 5)

enhancedClick(findTestObject('WEB/Cart/btn_Checkout'))

//====================================================
// SUCCESS PAGE
//====================================================
switchToWindowIndex(1)

waitForElementVisible(findTestObject('WEB/Checkout/Success/lbl_OrderSuccess'), 30)

verifyElementVisible(findTestObject('WEB/Checkout/Success/lbl_OrderSuccess'))

verifyTextPresent('Your order has been placed successfully.', false)

println('======================================')

println('PICKUP CHECKOUT SUCCESS')

println('======================================')

