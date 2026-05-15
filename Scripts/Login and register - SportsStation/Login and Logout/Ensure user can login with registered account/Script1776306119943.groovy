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

String emailTerdaftar = WebUI.callTestCase(findTestCase('Test Cases/Login and register - SportsStation/Register/Ensure new user can make a new account with valid Credentials'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://staging.sportsstation.id/login')

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_loginObject/txtField_emailLogin'), emailTerdaftar)

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_loginObject/txtField_passwordLogin'), GlobalVariable.password)

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_loginObject/btn_signIn'))

WebUI.waitForElementPresent(findTestObject('SportStation-RegisterLogin/sportStation_loginObject/txt_hi,username'), 0)

WebUI.verifyElementPresent(findTestObject('SportStation-RegisterLogin/sportStation_loginObject/txt_hi,username'), 0)

