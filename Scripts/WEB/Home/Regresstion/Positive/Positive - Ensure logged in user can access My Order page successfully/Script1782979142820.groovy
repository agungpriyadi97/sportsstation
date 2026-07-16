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

CustomKeywords.'utils.LoginHelper.login'('agungpriyadi88@mailinator.com', 'Laskar123456')

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

WebUI.delay(10)

println('===================================')

println('TRACK ORDER MEMBER')

println('===================================')

WebUI.click(findTestObject('WEB/TrackOrder/lnk_TrackOrder'))

WebUI.waitForPageLoad(20)

WebUI.verifyMatch(WebUI.getUrl(), '.*/account/order.*', true)

WebUI.verifyElementVisible(findTestObject('WEB/My Order/menu_MyOrder'))

WebUI.verifyElementVisible(findTestObject('WEB/My Order/tab_AllOrders'))

WebUI.verifyElementVisible(findTestObject('WEB/My Order/btn_HomeDelivery'))

