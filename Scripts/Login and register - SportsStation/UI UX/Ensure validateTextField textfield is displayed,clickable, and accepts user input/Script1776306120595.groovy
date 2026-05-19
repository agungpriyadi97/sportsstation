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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://staging.sportsstation.id/register')

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_acceptAllCookies'))

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/txtField_phoneNumberRegister'), GlobalVariable.noHp)

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_signUp'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_whatsApp'))

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/txtField_otpCode'), '1234')

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_emailRegister'), 
    'ibnu@gmail.com')

WebUI.verifyElementPresent(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_verifyCode'), 
    0)

WebUI.verifyElementClickable(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_verifyCode'))

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_verifyCode'), 
    '234567')

WebUI.verifyElementAttributeValue(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_verifyCode'), 
    'value', '234567', 0)

