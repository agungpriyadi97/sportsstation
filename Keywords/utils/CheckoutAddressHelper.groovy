package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CheckoutAddressHelper {

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
    // INPUT
    //----------------------------------------------------

    TestObject firstName(){

        return byXpath(
                "(//input[@placeholder='Your First Name'])[1]"
        )

    }

    TestObject lastName(){

        return byXpath(
                "(//input[@placeholder='Your Last Name'])[1]"
        )

    }

    TestObject mobile(){

        return byXpath(
                "(//input[@placeholder='Your mobile phone'])[1]"
        )

    }

    TestObject address(){

        return byXpath(
                "(//input[@placeholder='Address'])[1]"
        )

    }

    //----------------------------------------------------
    // DROPDOWN
    //----------------------------------------------------

    TestObject province(){

        return byXpath(
                "(//input[@placeholder='Select Province'])[1]"
        )

    }

    TestObject city(){

        return byXpath(
                "(//input[@placeholder='Select County/City'])[1]"
        )

    }

    TestObject district(){

        return byXpath(
                "(//input[@placeholder='Districts'])[1]"
        )

    }

    TestObject postalCode(){

        return byXpath(
                "(//input[@placeholder='Postal Code'])[1]"
        )

    }

    //----------------------------------------------------
    // OPTION
    //----------------------------------------------------

    TestObject provinceOption(){

        return byXpath(
                "(//li[@label='Banten'])[last()]"
        )

    }

    TestObject cityOption(){

        return byXpath(
                "(//li[@label='Kab. Lebak'])[last()]"
        )

    }

    TestObject districtOption(){

        return byXpath(
                "(//li[@label='Banjarsari'])[last()]"
        )

    }

    //----------------------------------------------------
    // BUTTON
    //----------------------------------------------------

    TestObject save(){

        return byXpath(
                "//button[.//span[normalize-space()='Save']]"
        )

    }

    //----------------------------------------------------
    // HIGH LEVEL
    //----------------------------------------------------

    @Keyword
    void fillAddress(
            String first,
            String last,
            String phone,
            String addr){

        WebUI.waitForElementVisible(
                firstName(),
                20)

        WebUI.clearText(
                firstName())

        WebUI.setText(
                firstName(),
                first)

        WebUI.clearText(
                lastName())

        WebUI.setText(
                lastName(),
                last)

        WebUI.clearText(
                mobile())

        WebUI.setText(
                mobile(),
                phone)

        WebUI.clearText(
                address())

        WebUI.setText(
                address(),
                addr)

        //------------------------------------------------
        // PROVINCE
        //------------------------------------------------

        WebUI.enhancedClick(
                province())

        WebUI.waitForElementClickable(
                provinceOption(),
                20)

        WebUI.enhancedClick(
                provinceOption())

        WebUI.delay(1)

        //------------------------------------------------
        // CITY
        //------------------------------------------------

        WebUI.enhancedClick(
                city())

        WebUI.waitForElementClickable(
                cityOption(),
                20)

        WebUI.enhancedClick(
                cityOption())

        WebUI.delay(1)

        //------------------------------------------------
        // DISTRICT
        //------------------------------------------------

        WebUI.enhancedClick(
                district())

        WebUI.waitForElementClickable(
                districtOption(),
                20)

        WebUI.enhancedClick(
                districtOption())

        //------------------------------------------------
        // WAIT POSTAL CODE AUTO
        //------------------------------------------------

        WebUI.delay(2)

        //------------------------------------------------
        // SAVE
        //------------------------------------------------

        WebUI.scrollToElement(
                save(),
                5)

        WebUI.waitForElementClickable(
                save(),
                20)

        WebUI.enhancedClick(
                save())

        WebUI.waitForPageLoad(20)

        WebUI.delay(2)

    }

}