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
println("TEST CASE : UPDATE SHIPPING ADDRESS")
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

mouseOver(findTestObject('WEB/Account/menu_Profile'))

waitForElementClickable(
	findTestObject('WEB/Account/menu_MyAddress'),
	20)

enhancedClick(
	findTestObject('WEB/Account/menu_MyAddress'))

waitForPageLoad(20)

//====================================================
// CHANGE (OPTIONAL)
//====================================================

if(verifyElementPresent(
	helper.change("shipping"),
	2,
	FailureHandling.OPTIONAL)) {

	println("CHANGE FOUND")

	enhancedClick(
		helper.change("shipping"))

	delay(1)

}

//====================================================
// EDIT
//====================================================

println("CLICK EDIT")

waitForElementClickable(
	helper.edit("shipping"),
	20)

enhancedClick(
	helper.edit("shipping"))

waitForPageLoad(20)

delay(1)

//====================================================
// UPDATE DATA
//====================================================

clearText(
	helper.firstName("shipping"))

setText(
	helper.firstName("shipping"),
	data.firstName)

clearText(
	helper.lastName("shipping"))

setText(
	helper.lastName("shipping"),
	data.lastName)

clearText(
	helper.mobile("shipping"))

setText(
	helper.mobile("shipping"),
	data.phone)

clearText(
	helper.address("shipping"))

setText(
	helper.address("shipping"),
	data.address)

//====================================================
// PROVINCE
//====================================================

click(
	helper.province("shipping"))

waitForElementClickable(
	helper.provinceOption(),
	20)

enhancedClick(
	helper.provinceOption())

//====================================================
// CITY
//====================================================

click(
	helper.city("shipping"))

waitForElementClickable(
	helper.cityOption(),
	20)

enhancedClick(
	helper.cityOption())

//====================================================
// DISTRICT
//====================================================

click(
	helper.district("shipping"))

waitForElementClickable(
	helper.districtOption(),
	20)

enhancedClick(
	helper.districtOption())

//====================================================
// WAIT POSTAL CODE
//====================================================

delay(2)

//====================================================
// SAVE
//====================================================

scrollToElement(
    helper.save("shipping"),
    5)

mouseOver(
    helper.save("shipping"))

waitForElementClickable(
    helper.save("shipping"),
    20)

enhancedClick(
    helper.save("shipping"))

//====================================================
// VERIFY
//====================================================

waitForPageLoad(20)

delay(2)

verifyElementPresent(
	helper.verifyName(
		"shipping",
		data.firstName),
	20)

verifyElementPresent(
	helper.verifyPhone(
		"shipping",
		data.phone),
	20)

verifyElementPresent(
	helper.verifyAddress(
		"shipping",
		data.address),
	20)

println("======================================")
println("UPDATE SHIPPING ADDRESS SUCCESS")
println("======================================")