import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class globalFunction {

	@Keyword
	def generateEmail() {
		def timestamp = System.currentTimeMillis()
		return "qagtech${timestamp}@yopmail.com"
	}

	@Keyword
	def generatePhone() {
		def random = new Random()
		return "8" + (100000000 + random.nextInt(900000000))
	}

	@Keyword
	def generateUserData() {
		def timestamp = System.currentTimeMillis()
		def random = new Random()
		
		def email = "user${timestamp}@mail.com"
		def phone = "8" + (100000000 + random.nextInt(900000000))
		
		return [
			email: email,
			phone: phone
		]
	}
}
