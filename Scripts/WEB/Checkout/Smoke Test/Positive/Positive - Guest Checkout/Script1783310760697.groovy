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
DummyData dummy = new DummyData()

Map data = dummy.generateRegistrationData()

//====================================================
// USE MAILINATOR EMAIL
//====================================================

data.email = GlobalVariable.usernamenonmember
GlobalVariable.RegisteredEmail = GlobalVariable.usernamenonmember

println("======================================")
println("TEST CASE : POSITIVE - GUEST CHECKOUT")
println("EMAIL : ${GlobalVariable.usernamenonmember}")
println("======================================")

//====================================================
// OPEN PRODUCT PDP
//====================================================

navigateToUrl(
    "https://staging.sportsstation.id/pdp/Converse-Chuck-70-Ox-Men's-Sneakers-Navy/SP220620159143"
)

product.waitUntilReady()

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

product.verifyPDP()

//====================================================
// ADD PRODUCT TO CART
//====================================================

println("ADD PRODUCT TO CART")

product.addProductToCart()

product.verifySuccessToast()

product.openCart()

product.verifyCartPage()

//====================================================
// OPEN CHECKOUT
//====================================================

println("OPEN CHECKOUT")

waitForElementClickable(
    findTestObject('WEB/Cart/btn_Checkout'),
    20)

scrollToElement(
    findTestObject('WEB/Cart/btn_Checkout'),
    5)

enhancedClick(
    findTestObject('WEB/Cart/btn_Checkout'))

waitForPageLoad(20)

//====================================================
// INPUT GUEST EMAIL
//====================================================

println("INPUT GUEST EMAIL")

waitForElementVisible(
    findTestObject('WEB/Checkout/Guest/txt_Email'),
    20)

clearText(
    findTestObject('WEB/Checkout/Guest/txt_Email'))

setText(
    findTestObject('WEB/Checkout/Guest/txt_Email'),
    GlobalVariable.usernamenonmember)

enhancedClick(
    findTestObject('WEB/Checkout/Guest/btn_Continue'))

waitForPageLoad(20)

//====================================================
// SHIPPING ADDRESS
//====================================================

println("FILL SHIPPING ADDRESS")

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
    "Automation Guest Address " + System.currentTimeMillis())

// --- Province ---
waitForElementClickable(findTestObject('WEB/Checkout/Guest/ddl_Province'), 20)
click(findTestObject('WEB/Checkout/Guest/ddl_Province'))

waitForElementVisible(findTestObject('WEB/Checkout/Guest/opt_Province_Banten'), 10)
delay(1)
click(findTestObject('WEB/Checkout/Guest/opt_Province_Banten'))

// --- City ---
waitForElementClickable(findTestObject('WEB/Checkout/Guest/ddl_City'), 20)
click(findTestObject('WEB/Checkout/Guest/ddl_City'))

waitForElementVisible(findTestObject('WEB/Checkout/Guest/opt_City_Tangerang'), 10)
delay(1)
click(findTestObject('WEB/Checkout/Guest/opt_City_Tangerang'))

// --- District ---
waitForElementClickable(findTestObject('WEB/Checkout/Guest/ddl_District'), 20)
click(findTestObject('WEB/Checkout/Guest/ddl_District'))

waitForElementVisible(findTestObject('WEB/Checkout/Guest/opt_District_Larangan'), 10)
delay(1)
click(findTestObject('WEB/Checkout/Guest/opt_District_Larangan'))

// --- Postal Code ---
waitForElementClickable(findTestObject('WEB/Checkout/Guest/ddl_PostalCode'), 20)
click(findTestObject('WEB/Checkout/Guest/ddl_PostalCode'))

waitForElementVisible(findTestObject('WEB/Checkout/Guest/opt_PostalCode'), 10)
delay(1)
click(findTestObject('WEB/Checkout/Guest/opt_PostalCode'))

// Save Address

println("SAVE ADDRESS")

enhancedClick(
    findTestObject('WEB/Checkout/Guest/btn_Save'))

waitForPageLoad(20)

//====================================================
// SHIPPING METHOD
//====================================================

println("SELECT SHIPPING METHOD")

waitForElementClickable(
    findTestObject('WEB/Checkout/Shipping/rdo_Regular'),
    20)

scrollToElement(
    findTestObject('WEB/Checkout/Shipping/rdo_Regular'),
    5)

enhancedClick(
    findTestObject('WEB/Checkout/Shipping/rdo_Regular'))

println("REGULAR SHIPPING SELECTED")

//====================================================
// PAYMENT METHOD
//====================================================

println("SELECT MIDTRANS")

waitForElementClickable(
    findTestObject('WEB/Payment/rdo_Midtrans'),
    20)

enhancedClick(
    findTestObject('WEB/Payment/rdo_Midtrans'))

println("SELECT VIRTUAL ACCOUNT")

enhancedClick(
    findTestObject('WEB/Payment/lbl_VirtualAccount'))

println("SELECT BCA")

enhancedClick(
    findTestObject('WEB/Payment/rdo_BCA'))

verifyElementPresent(
    findTestObject('WEB/Payment/rdo_BCA'),
    20)

//====================================================
// ACCEPT TERMS
//====================================================

println("ACCEPT PRIVACY POLICY")

click(
    findTestObject('WEB/Checkout/OrderSummary/chk_PrivacyPolicy'))

//====================================================
// PLACE ORDER
//====================================================

println("PLACE ORDER")

scrollToElement(
    findTestObject('WEB/Cart/btn_Checkout'),
    5)

enhancedClick(
    findTestObject('WEB/Cart/btn_Checkout'))

//====================================================
// VERIFY SUCCESS PAGE
//====================================================

println("VERIFY SUCCESS PAGE")

switchToWindowIndex(1)

waitForElementVisible(
    findTestObject('Object Repository/WEB/Checkout/Checkout Success/lbl_OrderSuccess'),
    30)

verifyElementVisible(
    findTestObject('Object Repository/WEB/Checkout/Checkout Success/lbl_OrderSuccess'))

verifyTextPresent(
    "Your order has been placed successfully.",
    false)

//====================================================
// GET ORDER INFORMATION
//====================================================

println("GET ORDER INFORMATION")

String orderStatus = getText(
	findTestObject("Object Repository/WEB/Checkout/Checkout Success/lbl_OrderStatus")
).trim()

String orderNumber = getText(
	findTestObject("Object Repository/WEB/Checkout/Checkout Success/lbl_OrderNumber")
).trim()

String paymentMethod = getText(
	findTestObject("Object Repository/WEB/Checkout/Checkout Success/lbl_PaymentMethod")
).trim()

String totalPrice = getText(
	findTestObject("Object Repository/WEB/Checkout/Checkout Success/lbl_TotalPrice")
).trim()

String virtualAccount = getText(
	findTestObject("Object Repository/WEB/Checkout/Checkout Success/lbl_VirtualAccount")
).replaceAll("\\s+", "").trim()

//====================================================
// SAVE TO GLOBAL VARIABLE
//====================================================

GlobalVariable.OrderStatus = orderStatus
GlobalVariable.OrderNumber = orderNumber
GlobalVariable.PaymentMethod = paymentMethod
GlobalVariable.TotalPrice = totalPrice
GlobalVariable.VirtualAccount = virtualAccount

//====================================================
// VERIFY DATA
//====================================================

assert GlobalVariable.OrderStatus != ""
assert GlobalVariable.OrderNumber != ""
assert GlobalVariable.PaymentMethod != ""
assert GlobalVariable.TotalPrice != ""
assert GlobalVariable.VirtualAccount != ""

//====================================================
// LOG
//====================================================

println("======================================")
println("ORDER INFORMATION")
println("======================================")
println("Status           : " + GlobalVariable.OrderStatus)
println("Order Number     : " + GlobalVariable.OrderNumber)
println("Payment Method   : " + GlobalVariable.PaymentMethod)
println("Total Price      : " + GlobalVariable.TotalPrice)
println("Virtual Account  : " + GlobalVariable.VirtualAccount)
println("======================================")

println("======================================")
println("GUEST CHECKOUT SUCCESS")
println("ORDER EMAIL : ${GlobalVariable.RegisteredEmail}")
println("======================================")