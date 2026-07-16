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

import internal.GlobalVariable

println("======================================")
println("TEST CASE : POSITIVE - LOGIN VIA MAPCLUB")
println("======================================")

//====================================================
// OPEN LOGIN PAGE
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

println("LOGIN PAGE OPENED")

//====================================================
// CLICK SIGN IN WITH MAPCLUB
//====================================================

waitForElementClickable(
	findTestObject("WEB/MAPCLUB/btn_SignInWithMAPCLUB"),
	20)

enhancedClick(
	findTestObject("WEB/MAPCLUB/btn_SignInWithMAPCLUB"))

println("MAPCLUB POPUP OPENED")

//====================================================
// INPUT MOBILE
//====================================================

waitForElementVisible(
	findTestObject("WEB/MAPCLUB/txt_MobileNumber"),
	20)

setText(
	findTestObject("WEB/MAPCLUB/txt_MobileNumber"),
	GlobalVariable.nomormembermapclub)

println("MOBILE INPUTTED")

//====================================================
// INPUT PASSWORD
//====================================================

setText(
	findTestObject("WEB/MAPCLUB/txt_Password"),
	GlobalVariable.passwordmembermapclub)

println("PASSWORD INPUTTED")

//====================================================
// LOGIN
//====================================================

enhancedClick(
	findTestObject("WEB/MAPCLUB/btn_SignIn"))

println("LOGIN BUTTON CLICKED")

waitForPageLoad(20)

delay(5)

//====================================================
// VERIFY LOGIN SUCCESS
//====================================================

verifyTextPresent(
	GlobalVariable.RegisteredFullName,
	false)

println("LOGIN SUCCESS")

println("======================================")
println("LOGIN VIA MAPCLUB SUCCESS")
println("======================================")
