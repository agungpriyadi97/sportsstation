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

def normalizePrice(String price) {
	return price.replaceAll('[^0-9]', '')
}

WebUI.navigateToUrl(GlobalVariable.url_Checkout_pdp)

WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Accept All Cookies'))

// Ambil harga di PDP
String pricePDP = WebUI.getText(findTestObject('SportsStation - Checkout/PDP - SportStation/txt_Harga'))

// Add ke cart
WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_Add to Cart'))

WebUI.delay(5)

// Masuk ke cart
WebUI.click(findTestObject('SportsStation - Checkout/PDP - SportStation/btn_cart'))

// Ambil harga di Cart
String priceCart = WebUI.getText(findTestObject('SportsStation - Checkout/Cart - SportStation/Page_Sports Station/txt_harga-cart'))

// Normalisasi (hapus Rp, titik, spasi, dll)
String cleanPDP = normalizePrice(pricePDP)

String cleanCart = normalizePrice(priceCart)

// 🔥 VERIFIKASI
WebUI.verifyMatch(cleanPDP, cleanCart, false)



