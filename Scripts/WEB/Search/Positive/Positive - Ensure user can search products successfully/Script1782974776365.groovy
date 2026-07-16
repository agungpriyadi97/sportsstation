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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

println("===================================")
println("SEARCH PRODUCT")
println("===================================")

String keyword = "Reebok"

WebUI.waitForElementVisible(findTestObject('WEB/Common/txt_Search'),20)

WebUI.click(findTestObject('WEB/Common/txt_Search'))

WebUI.setText(findTestObject('WEB/Common/txt_Search'), keyword)

WebUI.sendKeys(findTestObject('WEB/Common/txt_Search'),
        Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(10)

WebUI.verifyMatch(
        WebUI.getUrl(),
        ".*search.*|.*keyword.*",
        true)

WebUI.waitForElementVisible(
        findTestObject('WEB/Search/lbl_FirstProductName'),
        20)

String productName = WebUI.getText(
        findTestObject('WEB/Search/lbl_FirstProductName'))

println("First Product : " + productName)

WebUI.verifyMatch(
        productName.toLowerCase(),
        ".*${keyword.toLowerCase()}.*",
        true)