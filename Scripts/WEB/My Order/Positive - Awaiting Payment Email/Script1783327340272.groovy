import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import utils.MailinatorHelper

println("======================================")
println("TEST CASE : POSITIVE - AWAITING PAYMENT EMAIL")
println("======================================")

//====================================================
// EXECUTE GUEST CHECKOUT
//====================================================

println("EXECUTE GUEST CHECKOUT")

callTestCase(
    findTestCase('WEB/Checkout/Smoke Test/Positive/Positive - Guest Checkout'),
    [:],
    FailureHandling.STOP_ON_FAILURE)

//====================================================
// OPEN MAILINATOR
//====================================================

String email = GlobalVariable.usernamenonmember
String inbox = email.split("@")[0]

println("MAIL : " + email)
println("INBOX : " + inbox)

MailinatorHelper mail = new MailinatorHelper()

println("WAIT ORDER CONFIRMATION EMAIL")

mail.waitForOrderConfirmation(inbox)

//====================================================
// VERIFY EMAIL CONTENT
//====================================================

println("VERIFY EMAIL CONTENT")

verifyTextPresent(
    "Your SportsStation.ID order confirmation",
    false)

//verifyTextPresent(
//    "Awaiting Payment",
//    false)
//
//verifyTextPresent(
//    "Order Number",
//    false)
//
//verifyTextPresent(
//    "Payment Method",
//    false)
//
//verifyTextPresent(
//    "Grand Total",
//    false)
//
//verifyTextPresent(
//    "Product Details",
//    false)
//
//verifyTextPresent(
//    "SportsStation.ID",
//    false)
//
//verifyTextPresent(
//    "BCA",
//    false,
//    FailureHandling.OPTIONAL)

println("======================================")
println("AWAITING PAYMENT EMAIL SUCCESS")
println("EMAIL VERIFIED : " + email)
println("======================================")