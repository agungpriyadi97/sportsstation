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

WebUI.waitForElementVisible(findTestObject('SportsStation - Checkout/PDP - SportStation/msg_SuccessAddtoCart'), 10)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart'))

WebUI.click(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/button_Checkout'))

WebUI.delay(3)

WebUI.setText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txtField_Email'), GlobalVariable.EmailCO)

WebUI.setText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txtField_password'), GlobalVariable.password)

WebUI.click(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/button_Sign In'))

WebUI.waitForElementPresent(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txt_Checkout'), 
    0)

if (WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_Change'), 
    3, FailureHandling.OPTIONAL)) {
    println('Address already exists → skip input form')
} else {
    println('Address not found → fill form')

    WebUI.setText(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_Firstname'), 
        GlobalVariable.firstName)

    WebUI.setText(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_Lastname'), 
        GlobalVariable.lastName)

    WebUI.setText(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_Phonenumber'), 
        phone)

    WebUI.setText(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_Addres'), 
        GlobalVariable.address)

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_Province'))

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_banten'))

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_City'))

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_Kab. Tangerang'))

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/txtField_District'))

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_Cikupa'))

    WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_save'))

    WebUI.delay(3)
}

WebUI.waitForElementPresent(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/radio_shippingRegulas'), 
    0)

WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/radio_shippingRegulas'))

WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_midTrans'))

WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_CreditCard'))

WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/Checkbox_dataPolicy'))

WebUI.click(findTestObject('SportsStation - Checkout/Shipping - SportStation/Page_Sports Station/btn_Checkout'))

WebUI.waitForPageLoad(10)

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

WebUI.waitForElementClickable(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/txtField_CardNumbers'), 
    0)

WebUI.click(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/txtField_CardNumbers'))

WebUI.sendKeys(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/txtField_CardNumbers'), 
    GlobalVariable.noCreditCard)

WebUI.setText(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/txtField_Expiration date_card'), 
    GlobalVariable.expireddate)

WebUI.setText(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/txtField_card-CVV'), 
    GlobalVariable.CVV)

WebUI.click(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/btn_Pay now'))

WebUI.delay(3)

WebUI.setText(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/txtField_Password_otp'), 
    '112233')

WebUI.click(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_SNAP - Midtrans/btn_OK'))

WebUI.waitForElementPresent(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_Sports Station/msg_Thanks for your purchase'), 
    0)

assert WebUI.verifyElementPresent(findTestObject('SportsStation - Checkout/Payment - Sports Station/Page_Sports Station/msg_Thanks for your purchase'), 10)

