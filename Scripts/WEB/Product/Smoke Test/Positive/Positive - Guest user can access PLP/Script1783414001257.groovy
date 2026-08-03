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
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

println("======================================")
println("TEST CASE : POSITIVE - GUEST USER CAN ACCESS PLP")
println("======================================")

//====================================================
// OPEN HOME PAGE
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

println("HOME PAGE OPENED")

//====================================================
// OPEN CATEGORY / PLP
//====================================================
waitForElementVisible(
	findTestObject("WEB/Home/Navbar/menu_Men"),
	20)

mouseOver(
	findTestObject("WEB/Home/Navbar/menu_Men"))

delay(2)

waitForElementClickable(
	findTestObject("WEB/Product/PLP/link_running"),
	20)

enhancedClick(
	findTestObject("WEB/Product/PLP/link_running"))


//====================================================
// VERIFY FILTER PANEL
//====================================================

verifyElementVisible(
    findTestObject("WEB/Product/PLP/filter_Price"))

verifyElementVisible(
    findTestObject("WEB/Product/PLP/filter_Gender"))

verifyElementVisible(
    findTestObject("WEB/Product/PLP/filter_Brand"))

println("FILTER VERIFIED")

//====================================================
// VERIFY PRODUCT LIST
//====================================================

verifyElementVisible(
    findTestObject("WEB/Product/PLP/list_Product"))

println("PRODUCT LIST DISPLAYED")

//====================================================
// VERIFY FIRST PRODUCT
//====================================================

verifyElementVisible(
    findTestObject("WEB/Product/PLP/img_Product"))

verifyElementVisible(
    findTestObject("WEB/Product/PLP/lbl_ProductName"))

verifyElementVisible(
    findTestObject("WEB/Product/PLP/lbl_SalePrice"))

println("PRODUCT CARD VERIFIED")

println("======================================")
println("GUEST USER CAN ACCESS PLP")
println("======================================")