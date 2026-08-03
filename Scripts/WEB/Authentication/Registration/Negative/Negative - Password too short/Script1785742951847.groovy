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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utils.DummyData

Map data = CustomKeywords.'utils.DummyData.generateRegistrationData'()

CustomKeywords.'utils.RegistrationHelper.openRegistration'()
CustomKeywords.'utils.RegistrationHelper.verifyMobile'(data.mobilePhone)

// Password < 6 karakter
WebUI.setText(findTestObject('WEB/Registration/txt_Password'), "123")
WebUI.setText(findTestObject('WEB/Registration/txt_ConfirmPassword'), "123")

CustomKeywords.'utils.RegistrationHelper.submitRegistration'()

// Verifikasi pesan error kriteria password
WebUI.waitForElementVisible(
	findTestObject('WEB/Registration/lbl_FormErrorMessage', [('text') : 'Password must be 6-16 characters including numbers and alphabets']), 10)
WebUI.verifyElementVisible(
	findTestObject('WEB/Registration/lbl_FormErrorMessage', [('text') : 'Password must be 6-16 characters including numbers and alphabets']))