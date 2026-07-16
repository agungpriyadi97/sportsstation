import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//====================================================
// GENERATE DUMMY DATA
//====================================================

Map data = CustomKeywords.'utils.DummyData.generateAddressData'()

println("==========================================")
println("TEST CASE : ADD BILLING ADDRESS")
println("==========================================")
println("First Name : ${data.firstName}")
println("Last Name  : ${data.lastName}")
println("Phone      : ${data.phone}")
println("Address    : ${data.address}")
println("Province   : ${data.province}")
println("City       : ${data.city}")
println("District   : ${data.district}")
println("==========================================")

//====================================================
// LOGIN
//====================================================

WebUI.callTestCase(
    findTestCase('WEB/Authentication/Login/Smoke Test/Positive/Positive - Ensure user can sign in successfully with valid credentials'),
    [:],
    FailureHandling.STOP_ON_FAILURE
)

//====================================================
// OPEN MY ADDRESS
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

WebUI.mouseOver(findTestObject('WEB/Account/menu_Profile'))

WebUI.waitForElementVisible(
    findTestObject('WEB/Account/menu_MyAddress'),
    10)

WebUI.enhancedClick(
    findTestObject('WEB/Account/menu_MyAddress'))

WebUI.waitForPageLoad(10)

//====================================================
// OPEN BILLING FORM
//====================================================

WebUI.waitForElementVisible(
    findTestObject('WEB/Address/Billing/card_billing_AddNewAddress'),
    10)

WebUI.enhancedClick(
    findTestObject('WEB/Address/Billing/card_billing_AddNewAddress'))

//====================================================
// INPUT DATA
//====================================================

WebUI.waitForElementVisible(
    findTestObject('WEB/Address/Billing/txt_billing_FirstName'),
    10)

WebUI.setText(
    findTestObject('WEB/Address/Billing/txt_billing_FirstName'),
    data.firstName)

WebUI.setText(
    findTestObject('WEB/Address/Billing/txt_billing_LastName'),
    data.lastName)

WebUI.setText(
    findTestObject('WEB/Address/Billing/txt_billing_Mobile'),
    data.phone)

WebUI.setText(
    findTestObject('WEB/Address/Billing/txt_billing_Address'),
    data.address)

//====================================================
// SELECT PROVINCE
//====================================================

WebUI.enhancedClick(
    findTestObject('WEB/Address/Billing/ddl_billing_Province'))

WebUI.enhancedClick(
    findTestObject('WEB/Address/Billing/opt_billing_province'))

//====================================================
// SELECT CITY
//====================================================

WebUI.waitForElementVisible(findTestObject('WEB/Address/Billing/ddl_billing_City'), 10)

WebUI.enhancedClick(findTestObject('WEB/Address/Billing/ddl_billing_City'), FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('WEB/Address/Billing/opt_billing_city'), FailureHandling.STOP_ON_FAILURE)

//====================================================
// SELECT DISTRICT
//====================================================

WebUI.waitForElementVisible(findTestObject('WEB/Address/Billing/ddl_billing_District'), 10)

WebUI.enhancedClick(findTestObject('WEB/Address/Billing/ddl_billing_District'), FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('WEB/Address/Billing/opt_billing_district'), FailureHandling.STOP_ON_FAILURE)

//====================================================
// WAIT SYSTEM POPULATE POSTAL CODE
//====================================================

println("WAIT SYSTEM POPULATE POSTAL CODE")

WebUI.delay(3)

//====================================================
// SAVE
//====================================================

WebUI.waitForElementVisible(
    findTestObject('WEB/Address/Billing/btn_billing_Save'),
    10)

WebUI.scrollToElement(
    findTestObject('WEB/Address/Billing/btn_billing_Save'),
    5)

WebUI.enhancedClick(
    findTestObject('WEB/Address/Billing/btn_billing_Save'))

//====================================================
// VERIFY
//====================================================

WebUI.waitForElementVisible(
    findTestObject('WEB/Address/Shipping/btn_Change'),
    20)

WebUI.scrollToElement(
    findTestObject('WEB/Address/Shipping/btn_Change'),
    10)

println("==========================================")
println("ADD BILLING ADDRESS SUCCESS")
println("==========================================")
println("Name    : ${data.firstName} ${data.lastName}")
println("Phone   : ${data.phone}")
println("Address : ${data.address}")
println("==========================================")