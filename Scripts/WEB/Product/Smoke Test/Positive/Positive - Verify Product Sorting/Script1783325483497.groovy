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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import org.openqa.selenium.Keys as Keys

println("======================================")
println("TEST CASE : VERIFY PRODUCT SORTING")
println("======================================")

String keyword = "Airwalk"

//====================================================
// OPEN HOMEPAGE
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

//====================================================
// SEARCH PRODUCT
//====================================================

println("SEARCH PRODUCT")

waitForElementVisible(
	findTestObject("WEB/Common/txt_Search"),
	20)

setText(
	findTestObject("WEB/Common/txt_Search"),
	keyword)

sendKeys(
	findTestObject("WEB/Common/txt_Search"),
	Keys.chord(Keys.ENTER))

waitForPageLoad(20)

//====================================================
// VERIFY RESULT
//====================================================

waitForElementVisible(
    findTestObject("WEB/Search/lbl_SearchResult"),
    20
)

String result = getText(
    findTestObject("WEB/Search/lbl_SearchResult")
)

println("SEARCH RESULT : " + result)

verifyMatch(
    result.toLowerCase(),
    ".*${keyword.toLowerCase()}.*",
    true)
//====================================================
// SORT
//====================================================

println("OPEN SORT")

waitForElementClickable(
    findTestObject("WEB/Search/ddl_Sort"),
    20
)

enhancedClick(
    findTestObject("WEB/Search/ddl_Sort")
)

println("SELECT PRICE LOW TO HIGH")

waitForElementVisible(
    findTestObject("WEB/Search/opt_PriceLowHigh"),
    20
)

enhancedClick(
    findTestObject("WEB/Search/opt_PriceLowHigh")
)

waitForPageLoad(10)
delay(2)

//====================================================
// VERIFY
//====================================================

verifyElementPresent(
	findTestObject("WEB/Search/opt_PriceLowHigh"),
	20)

println("======================================")
println("VERIFY PRODUCT SORTING SUCCESS")
println("======================================")