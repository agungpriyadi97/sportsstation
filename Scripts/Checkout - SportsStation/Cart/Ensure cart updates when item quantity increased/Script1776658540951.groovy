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

def parsePrice(String text) {
    return text.replaceAll('[^0-9]', '').toInteger()
}

def getQty() {
    def val = WebUI.getAttribute(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_quantity'), 'value')
    assert val != null && val != ''
    return val.toInteger()
}


WebUI.navigateToUrl(GlobalVariable.url_Checkout_pdp)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Accept All Cookies'))
WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Add to Cart'))

WebUI.delay(3)
WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart'))

WebUI.waitForElementVisible(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_subtotal'), 10)

int price = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_harga-cart')))
int qty = getQty()
int subtotal = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_subtotal')))
int discount = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_discount')))
int total = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_harga-total')))

int expectedSubtotal = price * qty
int expectedTotal = expectedSubtotal - discount

println("=== INITIAL ===")
println("QTY: " + qty)
println("EXPECTED SUBTOTAL: " + expectedSubtotal)
println("ACTUAL SUBTOTAL: " + subtotal)

WebUI.verifyEqual(subtotal, expectedSubtotal)
WebUI.verifyEqual(total, expectedTotal)

int oldQty = qty

WebUI.click(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/btn_plusQuantity'))

// tunggu qty berubah
WebUI.waitForElementAttributeValue(
    findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_quantity'),
    'value',
    (oldQty + 1).toString(),
    10
)

// ambil ulang data
int newQty = getQty()
int newSubtotal = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_subtotal')))
int newDiscount = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_discount')))
int newTotal = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_harga-total')))

// expected
int expectedSubtotalAfterIncrease = price * newQty
int expectedTotalAfterIncrease = expectedSubtotalAfterIncrease - newDiscount

println("=== AFTER INCREASE ===")
println("QTY: " + newQty)
println("EXPECTED SUBTOTAL: " + expectedSubtotalAfterIncrease)
println("ACTUAL SUBTOTAL: " + newSubtotal)

WebUI.verifyEqual(newSubtotal, expectedSubtotalAfterIncrease)
WebUI.verifyEqual(newTotal, expectedTotalAfterIncrease)

int beforeDecreaseQty = newQty

WebUI.click(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/btn_minsQuantity'))

WebUI.waitForElementAttributeValue(
    findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_quantity'),
    'value',
    (beforeDecreaseQty - 1).toString(),
    10
)

// ambil ulang data
int decQty = getQty()
int decSubtotal = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_subtotal')))
int decDiscount = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_discount')))
int decTotal = parsePrice(WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_harga-total')))

// expected
int expectedSubtotalAfterDecrease = price * decQty
int expectedTotalAfterDecrease = expectedSubtotalAfterDecrease - decDiscount

println("=== AFTER DECREASE ===")
println("QTY: " + decQty)
println("EXPECTED SUBTOTAL: " + expectedSubtotalAfterDecrease)
println("ACTUAL SUBTOTAL: " + decSubtotal)

WebUI.verifyEqual(decSubtotal, expectedSubtotalAfterDecrease)
WebUI.verifyEqual(decTotal, expectedTotalAfterDecrease)