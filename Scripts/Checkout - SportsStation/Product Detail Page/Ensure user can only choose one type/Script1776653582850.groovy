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
import org.openqa.selenium.WebElement

WebUI.navigateToUrl(GlobalVariable.url_Checkout_pdp)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Accept All Cookies'))

TestObject size37 = findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 37')
TestObject size38 = findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 38')

TestObject active37 = findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 37_active')
TestObject active38 = findTestObject('SportsStation - Checkout/PDP - SportStation/btn_EUR 38_active')

WebUI.click(size37)
WebUI.verifyElementPresent(active37, 5)

WebUI.click(size38)
WebUI.verifyElementPresent(active38, 5)

WebUI.verifyElementNotPresent(active37, 5)

// ambil semua element active
List<WebElement> activeList = WebUI.findWebElements(
    new TestObject().addProperty("xpath", 
        com.kms.katalon.core.testobject.ConditionType.EQUALS, 
        "//li[contains(@class,'active')]"
    ),
    5
)

// verify cuma 1
assert activeList.size() == 2

