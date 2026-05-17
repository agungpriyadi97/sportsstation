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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ================== GENERATE DATA ==================
String phone = CustomKeywords.'globalFunction.generatePhone'()

String email = CustomKeywords.'globalFunction.generateEmail'()

WebUI.delay(2)

WebUI.navigateToUrl('https://staging.sportsstation.id/register')

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_acceptAllCookies'))

// isi form awal
WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/txtField_phoneNumberRegister'), phone)

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_signUp'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_whatsApp'))

// OTP dummy WA
WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/txtField_otpCode'), '1234')

// isi email
WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_emailRegister'), 
    email)

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/btn_sendOtpEmail'))

// ================== AMBIL OTP DARI YOPMAIL ==================
def otpKeyword = new com.yourproject.email.GetOTPFromYopmail()

String otp = otpKeyword.getOTP(email, 90 // timeout 90 detik
    )

KeywordUtil.logInfo('OTP yang didapat dari Yopmail: ' + otp)

if (((otp == '') || (otp == null)) || (otp.length() != 6)) {
    KeywordUtil.markFailed('❌ OTP kosong atau tidak valid')

    return null // stop test case
}

// ================== INPUT OTP & LANJUTKAN REGISTER ==================
WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_otpEmail'), 
    30)

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_otpEmail'), 
    otp)

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_password'), 
    GlobalVariable.password)

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_confirmPassword'), 
    GlobalVariable.confrim_password)

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_firstName'), 
    GlobalVariable.firstName)

WebUI.setText(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_lastName'), 
    GlobalVariable.lastName)

// Date of Birth
WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_dateOfBirth'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/btn_thun'))

WebUI.doubleClick(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/button_thnSebelumnya'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/thn_2001'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/bln_Apr'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/tgl_21'))

// Gender
WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txtField_gender'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/opt_male'))

// Checkbox
WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/btn_privacyPolicy'))

WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/btn_newsletter'))

// Submit
WebUI.click(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/btn_signUp'))

WebUI.waitForElementPresent(findTestObject('SportStation-RegisterLogin/sportStation_RegisterObject/Page_Sports Station/txt_Your registration is successful'), 
    0)

return email

