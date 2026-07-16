import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling

import utils.AddressHelper
import utils.RandomDataHelper

//====================================================
// INITIALIZE
//====================================================

AddressHelper helper = new AddressHelper()

RandomDataHelper random = new RandomDataHelper()

Map data = random.generateAddressData()

println("======================================")
println("TEST CASE : UPDATE BILLING ADDRESS")
println("======================================")

random.printAddressData(data)

//====================================================
// LOGIN
//====================================================

callTestCase(
	findTestCase(
	'WEB/Authentication/Login/Smoke Test/Positive/Positive - Ensure user can sign in successfully with valid credentials'),
	[:],
	FailureHandling.STOP_ON_FAILURE)

//====================================================
// CLOSE POPUP
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

//====================================================
// OPEN MY ADDRESS
//====================================================

mouseOver(
	findTestObject('WEB/Account/menu_Profile'))

waitForElementClickable(
	findTestObject('WEB/Account/menu_MyAddress'),
	20)

enhancedClick(
	findTestObject('WEB/Account/menu_MyAddress'))

waitForPageLoad(20)

//====================================================
// CHANGE (OPTIONAL)
//====================================================

if (verifyElementPresent(
	helper.change("billing"),
	2,
	FailureHandling.OPTIONAL)) {

	println("CHANGE FOUND")

	enhancedClick(
		helper.change("billing"))

	delay(1)

} else {

	println("ALREADY EDIT MODE")

}

//====================================================
// EDIT
//====================================================

println("CLICK EDIT")

waitForElementClickable(
	helper.edit("billing"),
	20)

enhancedClick(
	helper.edit("billing"))

waitForPageLoad(20)

delay(1)

//====================================================
// UPDATE DATA
//====================================================

println("UPDATE FIRST NAME")

clearText(
	helper.firstName("billing"))

setText(
	helper.firstName("billing"),
	data.firstName)

println("UPDATE LAST NAME")

clearText(
	helper.lastName("billing"))

setText(
	helper.lastName("billing"),
	data.lastName)

println("UPDATE PHONE")

clearText(
	helper.mobile("billing"))

setText(
	helper.mobile("billing"),
	data.phone)

println("UPDATE ADDRESS")

clearText(
	helper.address("billing"))

setText(
	helper.address("billing"),
	data.address)

//====================================================
// SAVE
//====================================================

println("SAVE ADDRESS")

scrollToElement(
	helper.save("billing"),
	5)

mouseOver(
	helper.save("billing"))

waitForElementClickable(
	helper.save("billing"),
	20)

enhancedClick(
	helper.save("billing"))

waitForPageLoad(20)

delay(2)

//====================================================
// VERIFY
//====================================================

println("VERIFY UPDATED ADDRESS")

verifyElementPresent(
	helper.verifyName(
		"billing",
		data.firstName),
	20)

verifyElementPresent(
	helper.verifyPhone(
		"billing",
		data.phone),
	20)

verifyElementPresent(
	helper.verifyAddress(
		"billing",
		data.address),
	20)

println("======================================")
println("UPDATE BILLING ADDRESS SUCCESS")
println("======================================")