import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

//====================================================
// PRE-CONDITION
//====================================================

if (GlobalVariable.RegisteredEmail == null ||
	GlobalVariable.RegisteredEmail.toString().trim().isEmpty() ||
	GlobalVariable.RegisteredPassword == null ||
	GlobalVariable.RegisteredPassword.toString().trim().isEmpty()) {

	println("==========================================")
	println("NO REGISTERED USER FOUND")
	println("REGISTER NEW USER")
	println("==========================================")

	WebUI.callTestCase(
		findTestCase(
			'Test Cases/WEB/Authentication/Registration/Smoke Test/Positive/Positive - Ensure user can register successfully with valid information'
		),
		[:]
	)
}

//====================================================
// LOGIN
//====================================================

println("==========================================")
println("SPORTS STATION - LOGIN")
println("==========================================")
println("Email    : ${GlobalVariable.RegisteredEmail}")
println("Password : ${GlobalVariable.RegisteredPassword}")
println("==========================================")

CustomKeywords.'utils.LoginHelper.login'(
	GlobalVariable.RegisteredEmail.toString(),
	GlobalVariable.RegisteredPassword.toString()
)

//====================================================
// VERIFY LOGIN SUCCESS
//====================================================

CustomKeywords.'utils.LoginHelper.verifyLoginSuccess'()

println("==========================================")
println("LOGIN SUCCESS")
println("==========================================")
println("Email : ${GlobalVariable.RegisteredEmail}")
println("==========================================")