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
import org.openqa.selenium.WebElement as WebElement

WebUI.navigateToUrl(GlobalVariable.url_Checkout_pdp)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Accept All Cookies'))

// pilih size dulu 
WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 39'))

// ambil sebelum
String before = WebUI.getText(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart')).trim()

int beforeCount = before == '' ? 0 : Integer.parseInt(before)

// klik add to cart
WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Add to Cart'))

WebUI.verifyElementVisible(findTestObject('SportsStation - Checkout/PDP - SportStation/msg_SuccessAddtoCart'))

// tunggu sampai berubah
WebUI.waitForElementVisible(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart'), 5)

// ambil setelah
String after = WebUI.getText(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart')).trim()

int afterCount = after == '' ? 0 : Integer.parseInt(after)

// verify
assert afterCount > beforeCount

