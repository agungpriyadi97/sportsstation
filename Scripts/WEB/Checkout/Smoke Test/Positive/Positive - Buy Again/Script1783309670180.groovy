import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import utils.ProductHelper

ProductHelper product = new ProductHelper()

println("======================================")
println("TEST CASE : BUY AGAIN")
println("======================================")

//====================================================
// LOGIN
//====================================================

callTestCase(
    findTestCase("Test Cases/WEB/Authentication/Login/Smoke Test/Positive/Positive - Ensure user can sign in successfully with valid credentials"),
    [:]
)

println("LOGIN SUCCESS")

//====================================================
// CLOSE POPUP
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

//====================================================
// OPEN MY ORDER
//====================================================

enhancedClick(
    findTestObject("WEB/Account/menu_Profile"))

waitForElementClickable(
    findTestObject("Object Repository/WEB/Account/menu_MyOrders"),
    20)

enhancedClick(
    findTestObject("Object Repository/WEB/Account/menu_MyOrders"))

waitForPageLoad(20)

println("MY ORDER OPENED")

//====================================================
// VERIFY STATUS
//====================================================

WebUI.waitForElementVisible(
	findTestObject("Object Repository/WEB/Order Detail/lbl_OrderStatus"),
	20
)

String status = WebUI.getText(
	findTestObject("Object Repository/WEB/Order Detail/lbl_OrderStatus")
).trim()

println("Order Status : ${status}")

assert status in [
    "Processing",
    "Canceled",
    "Completed",
    "Delivered",
    "Shipped"
] : "Unexpected status : ${status}"

println("ORDER STATUS VERIFIED")

//====================================================
// BUY AGAIN
//====================================================

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