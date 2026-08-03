import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement
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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable
import internal.GlobalVariable

import utils.DummyData
import utils.ProductHelper

//====================================================
// INITIALIZE
//====================================================

ProductHelper product = new ProductHelper()

println("======================================")
println("TEST CASE : POSITIVE - UNLINK MAPCLUB")
println("======================================")

///====================================================
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
// VERIFY LINKED ACCOUNT
//====================================================

verifyElementVisible(
	findTestObject("Object Repository/WEB/Checkout/MAPClub/btn_LinkAccount"))

verifyElementVisible(
	findTestObject("Object Repository/WEB/Checkout/MAPClub/btn_LinkAccount"))

println("LINKED ACCOUNT VERIFIED")

//====================================================
// CLICK UNLINK
//====================================================

enhancedClick(
	findTestObject("Object Repository/WEB/Checkout/MAPClub/btn_LinkAccount"))

println("CLICK LINK")
//====================================================
// VERIFY UNLINK DIALOG
//====================================================

verifyElementVisible(
	findTestObject("Object Repository/WEB/Checkout/MAPClub/btn_LinkAccount"))

//====================================================
// INPUT MOBILE
//====================================================

waitForElementVisible(
	findTestObject("WEB/MAPCLUB/txt_MobileNumber"),
	20)

setText(
	findTestObject("WEB/MAPCLUB/txt_MobileNumber"),
	GlobalVariable.nomormembermapclub)

println("MOBILE INPUTTED")

//====================================================
// INPUT PASSWORD
//====================================================

setText(
	findTestObject("WEB/MAPCLUB/txt_Password"),
	GlobalVariable.passwordmembermapclub)

println("PASSWORD INPUTTED")

//====================================================
// Link Account MAPCLUB
//====================================================

TestObject btnContinue = findTestObject("Object Repository/WEB/Checkout/MAPClub/btn_Continue")
TestObject btnSwitch = findTestObject("Object Repository/WEB/Checkout/MAPClub/btn_SwitchToThisAccount")

WebUI.waitForElementVisible(btnContinue, 20)
WebUI.scrollToElement(btnContinue, 5)
WebUI.waitForElementClickable(btnContinue, 20)

boolean success = false

for (int i = 1; i <= 5; i++) {

    println("CLICK CONTINUE ATTEMPT : " + i)

    try {

        WebUI.click(btnContinue)

    } catch (Exception e) {

        println("Normal click failed, trying JavaScript click...")

        WebElement element = WebUiCommonHelper.findWebElement(btnContinue, 10)

        WebUI.executeJavaScript(
            "arguments[0].click();",
            Arrays.asList(element)
        )
    }

    WebUI.delay(2)

    if (WebUI.waitForElementVisible(btnSwitch, 3, FailureHandling.OPTIONAL)) {

        success = true
        println("Switch dialog appeared.")
        break
    }
}

assert success : "Continue button clicked but Switch dialog never appeared."

WebUI.enhancedClick(btnSwitch)

WebUI.waitForPageLoad(20)

WebUI.delay(2)

delay(5)

waitForElementVisible(
	findTestObject("Object Repository/WEB/Account/AccountSetting/btn_Yes"),
	20)

enhancedClick(
	findTestObject("Object Repository/WEB/Account/AccountSetting/btn_Yes"))

waitForPageLoad(20)

delay(5)