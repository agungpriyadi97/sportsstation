import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utils.DummyData

Map data = CustomKeywords.'utils.DummyData.generateRegistrationData'()

CustomKeywords.'utils.RegistrationHelper.openRegistration'()
CustomKeywords.'utils.RegistrationHelper.verifyMobile'(data.mobilePhone)

// Pastikan field email kosong
WebUI.waitForElementVisible(findTestObject('WEB/Registration/txt_Email'), 20)
WebUI.clearText(findTestObject('WEB/Registration/txt_Email'))

// Verifikasi tombol Send Validation Code berada dalam kondisi DISABLED / NOT CLICKABLE
WebUI.verifyElementHasAttribute(
    findTestObject('WEB/Registration/btn_SendValidationCode'), 
    'disabled', 
    10)