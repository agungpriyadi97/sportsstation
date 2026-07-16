package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class DeleteHelper {

    AddressHelper helper = new AddressHelper()

    //----------------------------------------------------
    // DELETE ADDRESS
    //----------------------------------------------------

	@Keyword
	def deleteLastAddress(String type){
	
		WebUI.comment("======================================")
		WebUI.comment("DELETE ${type.toUpperCase()} ADDRESS")
		WebUI.comment("======================================")
	
		//------------------------------------------------
		// CHANGE (Optional)
		//------------------------------------------------
	
		if(WebUI.verifyElementPresent(
				helper.change(type),
				2,
				FailureHandling.OPTIONAL)){
	
			WebUI.comment("CHANGE BUTTON FOUND")
	
			WebUI.scrollToElement(
					helper.change(type),
					5)
	
			WebUI.waitForElementClickable(
					helper.change(type),
					10)
	
			WebUI.enhancedClick(
					helper.change(type))
	
			WebUI.delay(1)
	
		}else{
	
			WebUI.comment("ALREADY EDIT MODE")
	
		}
	
		//------------------------------------------------
		// DELETE
		//------------------------------------------------
	
		WebUI.scrollToElement(
				helper.delete(type),
				5)
	
		WebUI.waitForElementClickable(
				helper.delete(type),
				20)
	
		WebUI.enhancedClick(
				helper.delete(type))
	
		//------------------------------------------------
		// WAIT DIALOG
		//------------------------------------------------
	
		WebUI.waitForElementVisible(
				helper.dialog(),
				20)
	
		//------------------------------------------------
		// YES
		//------------------------------------------------
	
		WebUI.waitForElementClickable(
				helper.confirm(),
				20)
	
		WebUI.enhancedClick(
				helper.confirm())
	
		//------------------------------------------------
		// FINISH
		//------------------------------------------------
	
		WebUI.waitForPageLoad(20)
	
		WebUI.delay(2)
	
		WebUI.comment("DELETE SUCCESS")
	
	}
}