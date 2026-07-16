package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class EditHelper {

    AddressHelper helper = new AddressHelper()

    //----------------------------------------------------
    // OPEN EDIT
    //----------------------------------------------------

    @Keyword
    def openEdit(String type){

        WebUI.comment("======================================")
        WebUI.comment("OPEN ${type.toUpperCase()} EDIT")
        WebUI.comment("======================================")

        //------------------------------------------------
        // CHANGE (OPTIONAL)
        //------------------------------------------------

        if(WebUI.verifyElementPresent(
                helper.change(type),
                2,
                FailureHandling.OPTIONAL)){

            WebUI.comment("CHANGE FOUND")

            WebUI.scrollToElement(
                    helper.change(type),
                    5)

            WebUI.waitForElementClickable(
                    helper.change(type),
                    20)

            WebUI.enhancedClick(
                    helper.change(type))

            WebUI.delay(1)

        }else{

            WebUI.comment("ALREADY EDIT MODE")

        }

        //------------------------------------------------
        // EDIT
        //------------------------------------------------

        WebUI.scrollToElement(
                helper.edit(type),
                5)

        WebUI.waitForElementClickable(
                helper.edit(type),
                20)

        WebUI.enhancedClick(
                helper.edit(type))

        WebUI.waitForPageLoad(20)

        WebUI.delay(1)

    }

    //----------------------------------------------------
    // SAVE
    //----------------------------------------------------

    @Keyword
    def save(String type){

        WebUI.comment("SAVE ADDRESS")

        helper.clickSave(type)

        WebUI.waitForPageLoad(20)

        WebUI.delay(2)

    }

    //----------------------------------------------------
    // VERIFY
    //----------------------------------------------------

    @Keyword
    def verify(String type, Map data){

        WebUI.comment("VERIFY UPDATED ADDRESS")

        WebUI.verifyElementPresent(
                helper.verifyName(
                        type,
                        data.firstName),
                20)

        WebUI.verifyElementPresent(
                helper.verifyPhone(
                        type,
                        data.phone),
                20)

        WebUI.verifyElementPresent(
                helper.verifyAddress(
                        type,
                        data.address),
                20)

        WebUI.comment("======================================")
        WebUI.comment("UPDATE SUCCESS")
        WebUI.comment("======================================")

    }

}