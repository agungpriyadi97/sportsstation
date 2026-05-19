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

WebUI.navigateToUrl(GlobalVariable.url_Checkout_pdp)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Accept All Cookies'))

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Add to Cart'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 37'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 38'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 39'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 40'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/div_Sports_left'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/ID_Product'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/img_product'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/span_Add To Cart'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/txt_Harga'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/txt_Product'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/span_Airwalk'), 0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/txt_Shop More To earn Free Gift'), 
    0)

WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/PDP - SportStation/Page_Jual Airwalk Elwin Womens Skate Shoes - Blue  Sports Station/btn_Size Guide'), 
    0)

