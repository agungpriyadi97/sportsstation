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

println("======================================")
println("TEST CASE : POSITIVE - GUEST USER CAN ACCESS PDP")
println("======================================")

//====================================================
// OPEN PDP
//====================================================

navigateToUrl(
	"https://staging.sportsstation.id/pdp/Converse-Chuck-70-Ox-Men's-Sneakers-Navy/SP220620159143")

waitForPageLoad(30)

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

println("PDP OPENED")

//====================================================
// VERIFY PRODUCT IMAGE
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/img_Product"))

//====================================================
// VERIFY BRAND
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Brand"))

println("Brand : " + getText(findTestObject("WEB/Product/PDP/lbl_Brand")))

//====================================================
// VERIFY PRODUCT NAME
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_ProductName"))

println("Product : " + getText(findTestObject("WEB/Product/PDP/lbl_ProductName")))

//====================================================
// VERIFY SKU
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_SKU"))

println("SKU : " + getText(findTestObject("WEB/Product/PDP/lbl_SKU")))

//====================================================
// VERIFY PRICE
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_ProductPrice"))

println("Price : " + getText(findTestObject("WEB/Product/PDP/lbl_ProductPrice")))

//====================================================
// VERIFY SIZE
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/opt_SizeSelected"))

println("Size : " + getText(findTestObject("WEB/Product/PDP/opt_SizeSelected")))

//====================================================
// VERIFY COLOR
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Color"))
verifyElementVisible(findTestObject("WEB/Product/PDP/opt_ColorSelected"))

println("Color : " + getText(findTestObject("WEB/Product/PDP/opt_ColorSelected")))

//====================================================
// VERIFY ADD TO CART
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/btn_AddToCart"))

println("ADD TO CART VERIFIED")

//====================================================
// VERIFY DESCRIPTION
//====================================================

scrollToElement(findTestObject("WEB/Product/PDP/lbl_Description"), 5)

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Description"))
//
//verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Disclaimer"))

println("DESCRIPTION VERIFIED")

println("======================================")
println("GUEST USER CAN ACCESS PDP SUCCESS")
println("======================================")
