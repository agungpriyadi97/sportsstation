package utils

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

class AddressHelper {

    //----------------------------------------------------
    // CREATE TEST OBJECT
    //----------------------------------------------------

    private TestObject byXpath(String xpath) {

        TestObject to = new TestObject()

        to.addProperty(
                "xpath",
                ConditionType.EQUALS,
                xpath)

        return to
    }

    //----------------------------------------------------
    // ROOT
    //----------------------------------------------------

    private String root(String type) {

        switch (type.toLowerCase()) {

            case "shipping":
                return "//section[contains(@class,'address-item')][.//span[normalize-space()='Shipping Address']]"

            case "billing":
                return "//section[contains(@class,'address-item')][.//span[normalize-space()='Billing Address']]"

            default:
                throw new Exception("Unknown Address Type : " + type)
        }
    }

    //----------------------------------------------------
    // ACTIVE FORM
    //----------------------------------------------------

    private String form(String type) {

        return root(type) +
                "//div[contains(@class,'address-edit_container') and not(contains(@class,'display-none'))]"
    }

    //----------------------------------------------------
    // INPUT
    //----------------------------------------------------

    TestObject firstName(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Your First Name']")
    }

    TestObject lastName(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Your Last Name']")
    }

    TestObject mobile(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Your mobile phone']")
    }

    TestObject address(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Address']")
    }

    TestObject postalCode(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Postal Code']")
    }

    //----------------------------------------------------
    // DROPDOWN
    //----------------------------------------------------

    TestObject province(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Select Province']")
    }

    TestObject city(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Select County/City']")
    }

    TestObject district(String type) {

        return byXpath(
                form(type) +
                "//input[@placeholder='Districts']")
    }

    //----------------------------------------------------
    // DROPDOWN OPTION
    //----------------------------------------------------

    TestObject provinceOption() {

        return byXpath(
                "(//li[@label='Banten'])[last()]")
    }

    TestObject cityOption() {

        return byXpath(
                "(//li[@label='Kab. Lebak'])[last()]")
    }

    TestObject districtOption() {

        return byXpath(
                "(//li[@label='Banjarsari'])[last()]")
    }

    //----------------------------------------------------
    // MAIN BUTTON
    //----------------------------------------------------

    TestObject addNewAddress(String type) {

        return byXpath(
                root(type) +
                "//div[@name='add']//div[contains(@class,'add-new')]")
    }

    TestObject change(String type) {

        return byXpath(
                root(type) +
                "//button[.//span[normalize-space()='Change']]")
    }

    TestObject save(String type) {

        return byXpath(
                form(type) +
                "//button[.//span[normalize-space()='Save']]")
    }

    TestObject cancel(String type) {

        return byXpath(
                form(type) +
                "//button[.//span[normalize-space()='Cancel']]")
    }

    //----------------------------------------------------
    // CARD ACTION
    //----------------------------------------------------

    TestObject edit(String type) {

        return byXpath(
                "(" +
                root(type) +
                "//button[.//span[normalize-space()='Edit']])[1]")
    }

    TestObject delete(String type) {

        return byXpath(
                "(" +
                root(type) +
                "//button[.//span[normalize-space()='Delete']])[1]")
    }

    //----------------------------------------------------
    // DELETE POPUP
    //----------------------------------------------------

    TestObject dialog() {

        return byXpath(
                "//div[contains(@class,'el-message-box')]")
    }

    TestObject confirm() {

        return byXpath(
                "//div[contains(@class,'el-message-box')]//button[.//span[normalize-space()='Yes']]")
    }

    TestObject cancelDelete() {

        return byXpath(
                "//div[contains(@class,'el-message-box')]//button[.//span[normalize-space()='No']]")
    }

    TestObject closeDialog() {

        return byXpath(
                "//div[contains(@class,'el-message-box')]//button[contains(@class,'el-message-box__headerbtn')]")
    }

    //----------------------------------------------------
    // VERIFY
    //----------------------------------------------------

    TestObject verifyName(String type, String value) {

        return byXpath(
                root(type) +
                "//*[contains(normalize-space(.),'" + value + "')]")
    }

    TestObject verifyPhone(String type, String value) {

        return byXpath(
                root(type) +
                "//*[contains(normalize-space(.),'" + value + "')]")
    }

    TestObject verifyAddress(String type, String value) {

        return byXpath(
                root(type) +
                "//*[contains(normalize-space(.),'" + value + "')]")
    }

}