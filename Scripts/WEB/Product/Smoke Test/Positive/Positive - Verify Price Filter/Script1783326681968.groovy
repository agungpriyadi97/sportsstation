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


import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory

println("======================================")
println("TEST CASE : VERIFY PRICE FILTER")
println("======================================")

String keyword = "Airwalk"

//====================================================
// SEARCH PRODUCT
//====================================================

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
// VERIFY SEARCH RESULT
//====================================================

waitForElementVisible(
	findTestObject("WEB/Search/lbl_SearchResult"),
	20)

println("SEARCH RESULT DISPLAYED")

//====================================================
// INPUT PRICE
//====================================================

println("MOVE MIN PRICE")

WebElement minSlider =
	WebUI.findWebElement(
		findTestObject("WEB/Search/slider_Min"),
		20)

Actions actions =
	new Actions(DriverFactory.getWebDriver())

actions
	.clickAndHold(minSlider)
	.moveByOffset(80,0)
	.release()
	.perform()

WebUI.delay(2)

println("MOVE MAX PRICE")

WebElement maxSlider =
	WebUI.findWebElement(
		findTestObject("WEB/Search/slider_Max"),
		20)

actions
	.clickAndHold(maxSlider)
	.moveByOffset(-120,0)
	.release()
	.perform()

WebUI.delay(3)

verifyElementPresent(
	findTestObject("WEB/Search/lbl_SearchResult"),
	20)

println("PRICE FILTER SUCCESS")
