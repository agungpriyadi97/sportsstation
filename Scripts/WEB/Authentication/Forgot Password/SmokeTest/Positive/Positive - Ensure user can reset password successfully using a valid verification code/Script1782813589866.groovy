import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import internal.GlobalVariable

import utils.ForgotPasswordHelper
import utils.MailinatorHelper
import utils.MailSubject

println("======================================")
println("TEST CASE : RESET PASSWORD SUCCESSFULLY")
println("======================================")

//====================================================
// REGISTER IF ACCOUNT NOT EXISTS
//====================================================

if (!GlobalVariable.RegisteredEmail?.trim()) {

	callTestCase(
		findTestCase("Test Cases/WEB/Authentication/Registration/Smoke Test/Positive/Positive - Ensure user can register successfully with valid information"),
		[:])

	println("REGISTER SUCCESS")
}

//====================================================
// RESET PASSWORD
//====================================================

String newPassword = "Laskar654321"

ForgotPasswordHelper helper = new ForgotPasswordHelper()

helper.openForgotPassword()

helper.sendVerificationCode(
	GlobalVariable.RegisteredEmail)

println("VERIFICATION CODE SENT")

//====================================================
// GET OTP FROM MAILINATOR
//====================================================

String inbox =
	GlobalVariable.RegisteredEmail.split("@")[0]

MailinatorHelper mail =
	new MailinatorHelper()

String otp =
	mail.getOTPBySubject(
		inbox,
		MailSubject.FORGOT_PASSWORD)

println("OTP : " + otp)

//====================================================
// INPUT RESET PASSWORD
//====================================================

helper.fillResetPasswordForm(
	otp,
	newPassword)

println("RESET PASSWORD FORM FILLED")

//====================================================
// SUBMIT RESET PASSWORD
//====================================================

helper.submitResetPassword()

//====================================================
// VERIFY SUCCESS
//====================================================

helper.verifyResetPasswordSuccess()

println("RESET PASSWORD SUCCESS VERIFIED")

//====================================================
// UPDATE GLOBAL PASSWORD
//====================================================

GlobalVariable.RegisteredPassword = newPassword

println("======================================")
println("RESET PASSWORD SUCCESS")
println("EMAIL        : " + GlobalVariable.RegisteredEmail)
println("NEW PASSWORD : " + newPassword)
println("======================================")