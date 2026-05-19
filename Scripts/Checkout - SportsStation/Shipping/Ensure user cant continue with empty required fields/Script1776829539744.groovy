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

String phone = CustomKeywords.'globalFunction.generatePhone'()

WebUI.navigateToUrl(GlobalVariable.url_Checkout_pdp)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Accept All Cookies'))

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart'))

WebUI.click(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/button_Checkout'))

WebUI.setText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txtField_Email'), GlobalVariable.EmailCO)

WebUI.setText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txtField_password'), GlobalVariable.password)

WebUI.click(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/button_Sign In'))

WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_Checkout'))

