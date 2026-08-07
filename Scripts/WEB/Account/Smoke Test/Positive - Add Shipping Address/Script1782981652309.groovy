import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import utils.AddressHelper as AddressHelper
import utils.RandomDataHelper as RandomDataHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

//====================================================
// GENERATE DUMMY ADDRESS DATA
//====================================================
Map data = CustomKeywords.'utils.DummyData.generateAddressData'()

println('==========================================')

println('TEST CASE : ADD SHIPPING ADDRESS')

println('==========================================')

println("First Name : $data.firstName")

println("Last Name  : $data.lastName")

println("Phone      : $data.phone")

println("Address    : $data.address")

println("Province   : $data.province")

println("City       : $data.city")

println("District   : $data.district")

println('==========================================')

//====================================================
// LOGIN
//====================================================
WebUI.callTestCase(findTestCase('WEB/Authentication/Login/Smoke Test/Positive/Positive - Ensure user can sign in successfully with valid credentials'), 
    [:], FailureHandling.STOP_ON_FAILURE)

//====================================================
// OPEN MY ADDRESS
//====================================================
CustomKeywords.'utils.CommonHelper.closeAllPopup'()

WebUI.mouseOver(findTestObject('WEB/Account/menu_Profile'))

WebUI.waitForElementVisible(findTestObject('WEB/Account/menu_MyAddress'), 10)

WebUI.enhancedClick(findTestObject('WEB/Account/menu_MyAddress'))

WebUI.waitForPageLoad(10)

//====================================================
// OPEN SHIPPING FORM
//====================================================
// Cek apakah tombol Change ada di layar (tunggu maks 5 detik)
boolean isBtnChangePresent = WebUI.verifyElementPresent(findTestObject('WEB/Address/Shipping/btn_Change'), 5, FailureHandling.OPTIONAL)

if (isBtnChangePresent) {
    println('LOG: Tombol Change ditemukan, melakukan klik...')

    WebUI.enhancedClick(findTestObject('WEB/Address/Shipping/btn_Change'))
} else {
    println('LOG: Tombol Change tidak ditemukan, lanjut ke step berikutnya.')
}

// Lanjut ke step berikutnya seperti biasa
WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/card_AddNewAddress'), 10)

WebUI.enhancedClick(findTestObject('WEB/Address/Shipping/card_AddNewAddress'))

//====================================================
// INPUT DATA
//====================================================
WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/txt_FirstName'), 10)

WebUI.setText(findTestObject('WEB/Address/Shipping/txt_FirstName'), data.firstName)

WebUI.setText(findTestObject('WEB/Address/Shipping/txt_LastName'), data.lastName)

WebUI.setText(findTestObject('WEB/Address/Shipping/txt_Mobile'), data.phone)

WebUI.setText(findTestObject('WEB/Address/Shipping/txt_Address'), data.address)

//====================================================
// SELECT PROVINCE
//====================================================
WebUI.click(findTestObject('WEB/Address/Shipping/ddl_Province'))

WebUI.click(findTestObject('WEB/Address/Shipping/opt_province'))

//====================================================
// SELECT CITY
//====================================================
WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/ddl_City'), 10)

WebUI.click(findTestObject('WEB/Address/Shipping/ddl_City'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/opt_city'), 5)

WebUI.click(findTestObject('WEB/Address/Shipping/opt_city'), FailureHandling.STOP_ON_FAILURE)

//====================================================
// SELECT DISTRICT
//====================================================
WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/ddl_District'), 10)

WebUI.click(findTestObject('WEB/Address/Shipping/ddl_District'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/opt_district'), 5)

WebUI.click(findTestObject('WEB/Address/Shipping/opt_district'), FailureHandling.STOP_ON_FAILURE)

//====================================================
// WAIT POSTAL CODE AUTO FILLED
//====================================================
println('WAIT SYSTEM POPULATE POSTAL CODE')

WebUI.delay(3)

//====================================================
// SAVE
//====================================================
WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/btn_Save'), 10)

WebUI.scrollToElement(findTestObject('WEB/Address/Shipping/btn_Save'), 5)

WebUI.enhancedClick(findTestObject('WEB/Address/Shipping/btn_Save'))

//====================================================
// VERIFY
//====================================================
WebUI.waitForElementVisible(findTestObject('WEB/Address/Shipping/btn_Change'), 20)

WebUI.scrollToElement(findTestObject('WEB/Address/Shipping/btn_Change'), 10)

println('==========================================')

println('ADD SHIPPING ADDRESS SUCCESS')

println('==========================================')

println("Name    : $data.firstName $data.lastName")

println("Phone   : $data.phone")

println("Address : $data.address")

println('==========================================')

