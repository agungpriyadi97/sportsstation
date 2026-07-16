package utils

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

class AccountHelper {

	//----------------------------------------------------
	// CREATE TEST OBJECT
	//----------------------------------------------------

	private TestObject byXpath(String xpath){

		TestObject to = new TestObject()

		to.addProperty(
				"xpath",
				ConditionType.EQUALS,
				xpath)

		return to

	}

	//----------------------------------------------------
	// ACCOUNT SETTING TAB
	//----------------------------------------------------

	TestObject accountSetting(){

		return byXpath(
				"//div[contains(@class,'gt-header-mybasic__item') and normalize-space()='Account Setting']"
				)

	}

	//----------------------------------------------------
	// LINK ACCOUNT
	//----------------------------------------------------

	TestObject linkAccount(){

		return byXpath(
				"//button[contains(@class,'account-link__detail-button')]"
				)

	}

	//----------------------------------------------------
	// EDIT BUTTON
	//----------------------------------------------------

	TestObject editFirstName(){

		return byXpath(
				"//div[@class='title' and normalize-space()='First Name']/following-sibling::div//button"
				)

	}

	TestObject editLastName(){

		return byXpath(
				"//div[@class='title' and normalize-space()='Last Name']/following-sibling::div//button"
				)

	}

	TestObject editMobile(){

		return byXpath(
				"//h3[contains(@class,'sp-my-account-setting__item-top')]//span[normalize-space()='Mobile']/following-sibling::button"
				)

	}

	//----------------------------------------------------
	// DIALOG
	//----------------------------------------------------

	TestObject dialog(){

		return byXpath(
				"//div[contains(@class,'account-setting-dialog') and not(contains(@style,'display: none'))]"
				)

	}

	TestObject input(){

		return byXpath(
				"//div[contains(@class,'account-setting-dialog') and not(contains(@style,'display: none'))]//input[contains(@class,'el-input__inner')]"
				)

	}

	TestObject confirm(){

		return byXpath(
				"//div[contains(@class,'account-setting-dialog') and not(contains(@style,'display: none'))]//button[.//span[normalize-space()='Confirm']]"
				)

	}

	TestObject close(){

		return byXpath(
				"//div[contains(@class,'account-setting-dialog') and not(contains(@style,'display: none'))]//button[contains(@class,'el-dialog__headerbtn')]"
				)

	}

	//----------------------------------------------------
	// VERIFY
	//----------------------------------------------------

	TestObject verifyFirstName(String value){

		return byXpath(
				"//div[@class='title' and normalize-space()='First Name']/ancestor::div[contains(@class,'sp-my-account-setting__item')]//*[contains(normalize-space(),'${value}')]"
				)

	}

	TestObject verifyLastName(String value){

		return byXpath(
				"//div[@class='title' and normalize-space()='Last Name']/ancestor::div[contains(@class,'sp-my-account-setting__item')]//*[contains(normalize-space(),'${value}')]"
				)

	}

	TestObject verifyMobile(String value){

		return byXpath(
				"//h3[.//span[normalize-space()='Mobile']]/following-sibling::p[contains(normalize-space(),'${value}')]"
				)

	}

	//----------------------------------------------------
	// WAIT
	//----------------------------------------------------

	TestObject loading(){

		return byXpath(
				"//div[contains(@class,'el-loading-mask') and not(contains(@style,'display: none'))]"
				)

	}

}