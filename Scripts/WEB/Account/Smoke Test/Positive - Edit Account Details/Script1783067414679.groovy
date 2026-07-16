import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling

import utils.AccountHelper
import utils.DummyData

//====================================================
// INITIALIZE
//====================================================

AccountHelper helper = new AccountHelper()

DummyData dummy = new DummyData()

Map data = dummy.generateRegistrationData()

println("======================================")
println("TEST CASE : EDIT ACCOUNT DETAILS")
println("======================================")

println("FIRST NAME : " + data.firstName)
println("LAST NAME  : " + data.lastName)
println("MOBILE     : " + data.mobilePhone)

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
// OPEN ACCOUNT SETTING
//====================================================

mouseOver(findTestObject('WEB/Account/menu_Profile'))

waitForElementClickable(
	findTestObject('WEB/Account/menu_AccountSetting'),
	20)

enhancedClick(
	findTestObject('WEB/Account/menu_AccountSetting'))

waitForPageLoad(20)


//====================================================
// EDIT FIRST NAME
//====================================================

println("EDIT FIRST NAME")

scrollToElement(
	helper.editFirstName(),
	5)

waitForElementClickable(
	helper.editFirstName(),
	20)

enhancedClick(
	helper.editFirstName())

waitForElementVisible(
	helper.input(),
	20)

clearText(
	helper.input())

setText(
	helper.input(),
	data.firstName)

enhancedClick(
	helper.confirm())

waitForPageLoad(20)

delay(2)

verifyElementPresent(
	helper.verifyFirstName(data.firstName),
	20)


//====================================================
// EDIT LAST NAME
//====================================================

println("EDIT LAST NAME")

scrollToElement(
	helper.editLastName(),
	5)

waitForElementClickable(
	helper.editLastName(),
	20)

enhancedClick(
	helper.editLastName())

waitForElementVisible(
	helper.input(),
	20)

clearText(
	helper.input())

setText(
	helper.input(),
	data.lastName)

enhancedClick(
	helper.confirm())

waitForPageLoad(20)

delay(2)

verifyElementPresent(
	helper.verifyLastName(data.lastName),
	20)


//====================================================
// EDIT MOBILE
//====================================================

println("EDIT MOBILE")

scrollToElement(
	helper.editMobile(),
	5)

waitForElementClickable(
	helper.editMobile(),
	20)

enhancedClick(
	helper.editMobile())

waitForElementVisible(
	helper.input(),
	20)

clearText(
	helper.input())

setText(
	helper.input(),
	data.mobilePhone)

enhancedClick(
	helper.confirm())

waitForPageLoad(20)

delay(2)

verifyElementPresent(
	helper.verifyMobile(data.mobilePhone),
	20)


//====================================================
// DONE
//====================================================

println("======================================")
println("EDIT ACCOUNT DETAILS SUCCESS")
println("======================================")