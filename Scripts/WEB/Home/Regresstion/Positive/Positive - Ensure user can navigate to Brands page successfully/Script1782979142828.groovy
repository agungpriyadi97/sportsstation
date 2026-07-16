import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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

println('======================================')

println('NAVIGATE TO BRANDS PAGE')

println('======================================')

WebUI.waitForElementClickable(findTestObject('WEB/Home/Navbar/btn_Brands'), 20)

println(WebUI.getUrl())

WebUI.click(findTestObject('WEB/Home/Navbar/btn_Brands'))

WebUI.click(findTestObject('WEB/Common/txt_Search'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(20)

WebUI.verifyElementVisible(findTestObject('WEB/Home/Page Sports/lbl_Title'))

WebUI.verifyElementVisible(findTestObject('WEB/Home/Page Sports/section_Filter'))

WebUI.verifyElementVisible(findTestObject('WEB/Home/Page Sports/section_ProductGrid'))

WebUI.waitForPageLoad(20)

WebUI.waitForElementVisible(findTestObject('WEB/Home/Page Brands/section_Filter'), 20)

WebUI.verifyElementVisible(findTestObject('WEB/Home/Page Brands/section_Filter'))

WebUI.verifyElementVisible(findTestObject('WEB/Home/Page Brands/txt_SearchResult'))

WebUI.verifyElementVisible(findTestObject('WEB/Home/Page Brands/first_Product'))

println('Current URL : ' + WebUI.getUrl())

println('======================================')

println('SUCCESS NAVIGATE TO BRANDS PAGE')

println('======================================')

