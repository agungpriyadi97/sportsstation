import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling

import utils.DeleteHelper

//====================================================
// INITIALIZE
//====================================================

DeleteHelper deleteHelper = new DeleteHelper()

println("======================================")
println("TEST CASE : DELETE BILLING ADDRESS")
println("======================================")

//====================================================
// LOGIN
//====================================================

callTestCase(
	findTestCase(
	'WEB/Authentication/Login/Smoke Test/Positive/Positive - Ensure user can sign in successfully with valid credentials'),
	[:],
	FailureHandling.STOP_ON_FAILURE
)

//====================================================
// CLOSE POPUP
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

//====================================================
// OPEN MY ADDRESS
//====================================================

println("OPEN MY ADDRESS")

mouseOver(
	findTestObject('WEB/Account/menu_Profile'))

waitForElementClickable(
	findTestObject('WEB/Account/menu_MyAddress'),
	20)

enhancedClick(
	findTestObject('WEB/Account/menu_MyAddress'))

waitForPageLoad(20)

//====================================================
// DELETE BILLING ADDRESS
//====================================================

println("DELETE BILLING ADDRESS")

deleteHelper.deleteLastAddress("billing")

//====================================================
// VERIFY
//====================================================

println("VERIFY DELETE")

waitForPageLoad(20)

delay(2)

verifyElementPresent(
	findTestObject('WEB/Address/Billing/card_billing_AddNewAddress'),
	20)

println("======================================")
println("DELETE BILLING ADDRESS SUCCESS")
println("======================================")