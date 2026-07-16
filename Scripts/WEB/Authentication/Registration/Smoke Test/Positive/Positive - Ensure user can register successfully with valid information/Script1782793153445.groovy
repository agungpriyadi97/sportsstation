import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import utils.MailinatorHelper
import utils.MailSubject

//====================================================
// GENERATE TEST DATA
//====================================================

Map data = CustomKeywords.'utils.DummyData.generateRegistrationData'()

println("==========================================")
println("TEST CASE : REGISTRATION SUCCESS")
println("==========================================")
println("Inbox        : ${data.inbox}")
println("Email        : ${data.email}")
println("Mobile       : ${data.mobilePhone}")
println("Password     : ${data.password}")
println("First Name   : ${data.firstName}")
println("Last Name    : ${data.lastName}")
println("==========================================")

//====================================================
// OPEN REGISTRATION
//====================================================

CustomKeywords.'utils.RegistrationHelper.openRegistration'()

//====================================================
// VERIFY MOBILE
//====================================================

CustomKeywords.'utils.RegistrationHelper.verifyMobile'(
	data.mobilePhone)

//====================================================
// INPUT EMAIL
//====================================================

WebUI.waitForElementVisible(
	findTestObject("WEB/Registration/txt_Email"),
	20)

WebUI.setText(
	findTestObject("WEB/Registration/txt_Email"),
	data.email)

WebUI.waitForElementClickable(
	findTestObject("WEB/Registration/btn_SendValidationCode"),
	20)

WebUI.enhancedClick(
	findTestObject("WEB/Registration/btn_SendValidationCode"))

println("VERIFICATION EMAIL SENT")

//====================================================
// GET OTP FROM MAILINATOR
//====================================================

MailinatorHelper mail =
	new MailinatorHelper()

String otp =
	mail.getOTPBySubject(
		data.inbox,
		MailSubject.REGISTRATION)

println("OTP : ${otp}")

//====================================================
// FILL REGISTRATION FORM
//====================================================

CustomKeywords.'utils.RegistrationHelper.fillRegistrationForm'(
	data,
	otp)

println("REGISTRATION FORM FILLED")

//====================================================
// SUBMIT REGISTRATION
//====================================================

CustomKeywords.'utils.RegistrationHelper.submitRegistration'()

println("REGISTRATION SUBMITTED")

//====================================================
// VERIFY SUCCESS
//====================================================

CustomKeywords.'utils.RegistrationHelper.verifySuccess'()

println("REGISTRATION SUCCESS VERIFIED")

//====================================================
// SAVE USER SESSION
//====================================================

GlobalVariable.RegisteredEmail = data.email
GlobalVariable.RegisteredPassword = data.password
GlobalVariable.RegisteredMobile = data.mobilePhone
GlobalVariable.RegisteredFullName = data.fullName

// Optional, bila dipakai test Guest Checkout
GlobalVariable.usernamenonmember = data.email

//====================================================
// LOG
//====================================================

println("==========================================")
println("REGISTER SUCCESS")
println("==========================================")
println("EMAIL      : ${GlobalVariable.RegisteredEmail}")
println("PASSWORD   : ${GlobalVariable.RegisteredPassword}")
println("MOBILE     : ${GlobalVariable.RegisteredMobile}")
println("FULL NAME  : ${GlobalVariable.RegisteredFullName}")
println("==========================================")