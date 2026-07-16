package utils

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

class CheckoutHelper {

    //----------------------------------------------------
    // CREATE TEST OBJECT
    //----------------------------------------------------

    private TestObject byXpath(String xpath){

        TestObject to = new TestObject()

        to.addProperty(
                "xpath",
                ConditionType.EQUALS,
                xpath
        )

        return to
    }

    //----------------------------------------------------
    // GUEST CHECKOUT
    //----------------------------------------------------

    TestObject guestEmail(){

        return byXpath(
                "//h2[normalize-space()='Guest Checkout']/following::input[@placeholder='Email'][1]"
        )

    }

    TestObject continueButton(){

        return byXpath(
                "//h2[normalize-space()='Guest Checkout']/following::button[.//span[normalize-space()='Continue']][1]"
        )

    }

    //----------------------------------------------------
    // SHIPPING METHOD
    //----------------------------------------------------

    TestObject homeDelivery(){

        return byXpath(
                "//h4[normalize-space()='Home Delivery']/ancestor::li"
        )

    }

    TestObject storePickup(){

        return byXpath(
                "//h4[normalize-space()='Store Pickup']/ancestor::li"
        )

    }

    //----------------------------------------------------
    // PAYMENT METHOD
    //----------------------------------------------------

    TestObject midtrans(){

        return byXpath(
                "//*[contains(normalize-space(),'Midtrans')]/ancestor::*[@role='radio' or self::label][1]"
        )

    }

    TestObject virtualAccount(){

        return byXpath(
                "//*[contains(normalize-space(),'Virtual Account')]"
        )

    }

    TestObject bcaVA(){

        return byXpath(
                "//*[contains(normalize-space(),'BCA')]/ancestor::label[1]"
        )

    }

    TestObject bniVA(){

        return byXpath(
                "//*[contains(normalize-space(),'BNI')]/ancestor::label[1]"
        )

    }

    TestObject briVA(){

        return byXpath(
                "//*[contains(normalize-space(),'BRI')]/ancestor::label[1]"
        )

    }

    TestObject permataVA(){

        return byXpath(
                "//*[contains(normalize-space(),'Permata')]/ancestor::label[1]"
        )

    }

    TestObject mandiriVA(){

        return byXpath(
                "//*[contains(normalize-space(),'Mandiri')]/ancestor::label[1]"
        )

    }

    //----------------------------------------------------
    // ORDER SUMMARY
    //----------------------------------------------------

    TestObject subtotal(){

        return byXpath(
                "//span[normalize-space()='Subtotal']/following-sibling::*[1]"
        )

    }

    TestObject discount(){

        return byXpath(
                "//span[normalize-space()='Discount']/following-sibling::*[1]"
        )

    }

    TestObject shippingFee(){

        return byXpath(
                "//span[contains(normalize-space(),'Shipping')]/following-sibling::*[1]"
        )

    }

    TestObject total(){

        return byXpath(
                "//span[normalize-space()='Total']/following-sibling::*[1]"
        )

    }

    //----------------------------------------------------
    // CHECKBOX
    //----------------------------------------------------

    TestObject termsCheckbox(){

        return byXpath(
                "(//label[contains(@class,'el-checkbox')])[last()]"
        )

    }

    TestObject newsletterCheckbox(){

        return byXpath(
                "(//label[contains(@class,'el-checkbox')])[1]"
        )

    }

    //----------------------------------------------------
    // BUTTON
    //----------------------------------------------------

    TestObject checkoutButton(){

        return byXpath(
                "//button[.//span[normalize-space()='Checkout']]"
        )

    }

    //----------------------------------------------------
    // CHECKOUT SUCCESS
    //----------------------------------------------------

    TestObject successTitle(){

        return byXpath(
                "//*[contains(text(),'Your order has been placed successfully')]"
        )

    }

    TestObject viewDetailButton(){

        return byXpath(
                "//button[.//span[contains(normalize-space(),'View Details')]]"
        )

    }

    TestObject orderNumber(){

        return byXpath(
                "//*[contains(text(),'Order Number')]/following::*[1]"
        )

    }

    TestObject paymentMethod(){

        return byXpath(
                "//*[contains(text(),'Payment Method')]/following::*[1]"
        )

    }

    TestObject virtualAccountNumber(){

        return byXpath(
                "//*[contains(text(),'Virtual Account')]/following::*[1]"
        )

    }

    //----------------------------------------------------
    // ORDER DETAIL
    //----------------------------------------------------

    TestObject continueToPay(){

        return byXpath(
                "//button[.//span[contains(normalize-space(),'Continue To Pay')]]"
        )

    }

    TestObject orderStatus(){

        return byXpath(
                "//span[normalize-space()='Order Status']/following::span[1]"
        )

    }
	//----------------------------------------------------
	// GUEST CHECKOUT
	//----------------------------------------------------

	void inputGuestEmail(String email){

		WebUI.waitForElementVisible(
				guestEmail(),
				20)

		WebUI.clearText(
				guestEmail())

		WebUI.setText(
				guestEmail(),
				email)

	}

	void continueGuest(){

		WebUI.waitForElementClickable(
				continueButton(),
				20)

		WebUI.scrollToElement(
				continueButton(),
				5)

		WebUI.enhancedClick(
				continueButton())

		WebUI.waitForPageLoad(20)

		WebUI.delay(2)

	}

	//----------------------------------------------------
	// SHIPPING
	//----------------------------------------------------

	void selectHomeDelivery(){

		if(WebUI.verifyElementPresent(
				homeDelivery(),
				3,
				FailureHandling.OPTIONAL)){

			WebUI.scrollToElement(
					homeDelivery(),
					5)

			WebUI.enhancedClick(
					homeDelivery())
		}

	}

	void selectStorePickup(){

		WebUI.waitForElementClickable(
				storePickup(),
				20)

		WebUI.scrollToElement(
				storePickup(),
				5)

		WebUI.enhancedClick(
				storePickup())

	}

	//----------------------------------------------------
	// PAYMENT
	//----------------------------------------------------

	void selectMidtrans(){

		WebUI.waitForElementClickable(
				midtrans(),
				20)

		WebUI.scrollToElement(
				midtrans(),
				5)

		WebUI.mouseOver(
				midtrans())

		WebUI.enhancedClick(
				midtrans())

		WebUI.delay(1)

	}

	void selectVirtualAccount(){

		WebUI.waitForElementClickable(
				virtualAccount(),
				20)

		WebUI.scrollToElement(
				virtualAccount(),
				5)

		WebUI.enhancedClick(
				virtualAccount())

		WebUI.delay(1)

	}

	void selectBCA(){

		WebUI.waitForElementClickable(
				bcaVA(),
				20)

		WebUI.scrollToElement(
				bcaVA(),
				5)

		WebUI.enhancedClick(
				bcaVA())

	}

	void selectBNI(){

		WebUI.waitForElementClickable(
				bniVA(),
				20)

		WebUI.scrollToElement(
				bniVA(),
				5)

		WebUI.enhancedClick(
				bniVA())

	}

	void selectBRI(){

		WebUI.waitForElementClickable(
				briVA(),
				20)

		WebUI.scrollToElement(
				briVA(),
				5)

		WebUI.enhancedClick(
				briVA())

	}

	void selectPermata(){

		WebUI.waitForElementClickable(
				permataVA(),
				20)

		WebUI.scrollToElement(
				permataVA(),
				5)

		WebUI.enhancedClick(
				permataVA())

	}

	void selectMandiri(){

		WebUI.waitForElementClickable(
				mandiriVA(),
				20)

		WebUI.scrollToElement(
				mandiriVA(),
				5)

		WebUI.enhancedClick(
				mandiriVA())

	}

	//----------------------------------------------------
	// CHECKBOX
	//----------------------------------------------------

	void acceptTerms(){

		if(WebUI.verifyElementPresent(
				termsCheckbox(),
				2,
				FailureHandling.OPTIONAL)){

			WebUI.scrollToElement(
					termsCheckbox(),
					5)

			WebUI.enhancedClick(
					termsCheckbox())
		}

	}

	void subscribeNewsletter(){

		if(WebUI.verifyElementPresent(
				newsletterCheckbox(),
				2,
				FailureHandling.OPTIONAL)){

			WebUI.enhancedClick(
					newsletterCheckbox())
		}

	}

	//----------------------------------------------------
	// CHECKOUT
	//----------------------------------------------------

	void clickCheckout(){

		WebUI.waitForElementClickable(
				checkoutButton(),
				20)

		WebUI.scrollToElement(
				checkoutButton(),
				5)

		WebUI.mouseOver(
				checkoutButton())

		WebUI.enhancedClick(
				checkoutButton())

		WebUI.waitForPageLoad(20)

	}

	//----------------------------------------------------
	// SUCCESS
	//----------------------------------------------------

	void verifyCheckoutSuccess(){

		WebUI.waitForElementVisible(
				successTitle(),
				30)

		WebUI.verifyElementVisible(
				successTitle())

	}

	void openOrderDetail(){

		WebUI.waitForElementClickable(
				viewDetailButton(),
				20)

		WebUI.scrollToElement(
				viewDetailButton(),
				5)

		WebUI.enhancedClick(
				viewDetailButton())

		WebUI.waitForPageLoad(20)

	}

	//----------------------------------------------------
	// ORDER DETAIL
	//----------------------------------------------------

	void continuePayment(){

		WebUI.waitForElementClickable(
				continueToPay(),
				20)

		WebUI.scrollToElement(
				continueToPay(),
				5)

		WebUI.enhancedClick(
				continueToPay())

		WebUI.waitForPageLoad(20)

	}

	//----------------------------------------------------
	// VERIFY
	//----------------------------------------------------

	void verifyOrderSummary(){

		WebUI.verifyElementPresent(
				subtotal(),
				20)

		WebUI.verifyElementPresent(
				total(),
				20)

	}

	void verifyOrderStatus(String status){

		WebUI.verifyElementText(
				orderStatus(),
				status)

	}
	
	//----------------------------------------------------
	// MIDTRANS
	//----------------------------------------------------

	TestObject midtransVA(){

		return byXpath(
			"//input[@placeholder='Virtual account number']"
		)

	}

	TestObject inquireButton(){

		return byXpath(
			"//button[contains(.,'Inquire')]"
		)

	}

	TestObject payButton(){

		return byXpath(
			"//button[contains(.,'Pay')]"
		)

	}

	TestObject paymentSuccess(){

		return byXpath(
			"//*[contains(text(),'successful')]"
		)

	}

	//----------------------------------------------------
	// ORDER DETAIL
	//----------------------------------------------------

	TestObject virtualAccountLabel(){

		return byXpath(
			"//span[normalize-space()='Virtual Bank Account']/following::span[1]"
		)

	}

	//----------------------------------------------------
	// GET VA
	//----------------------------------------------------

	String getVirtualAccount(){

		WebUI.waitForElementVisible(
			virtualAccountLabel(),
			20)

		return WebUI.getText(
			virtualAccountLabel())
			.replaceAll("\\s+","")
			.trim()

	}

	//----------------------------------------------------
	// OPEN MIDTRANS
	//----------------------------------------------------

	void openMidtransSimulator(){

		WebUI.executeJavaScript(
			"window.open('https://simulator.sandbox.midtrans.com/bca/va/index');",
			null)

		WebUI.delay(3)

		WebUI.switchToWindowIndex(2)

		WebUI.waitForPageLoad(20)

	}

	//----------------------------------------------------
	// INPUT VA
	//----------------------------------------------------

	void inputVirtualAccount(String va){

		WebUI.waitForElementVisible(
			midtransVA(),
			20)

		WebUI.clearText(
			midtransVA())

		WebUI.setText(
			midtransVA(),
			va)

	}

	//----------------------------------------------------
	// INQUIRE
	//----------------------------------------------------

	void inquirePayment(){

		WebUI.waitForElementClickable(
			inquireButton(),
			20)

		WebUI.enhancedClick(
			inquireButton())

		WebUI.waitForElementVisible(
			payButton(),
			20)

	}

	//----------------------------------------------------
	// PAY
	//----------------------------------------------------

	void pay(){

		WebUI.waitForElementClickable(
			payButton(),
			20)

		WebUI.enhancedClick(
			payButton())

	}

	//----------------------------------------------------
	// VERIFY SUCCESS
	//----------------------------------------------------

	void verifyPaymentSuccess(){

		WebUI.waitForElementVisible(
			paymentSuccess(),
			30)

		WebUI.verifyTextPresent(
			"successful",
			false)

	}

	//----------------------------------------------------
	// COMPLETE PAYMENT
	//----------------------------------------------------

	void completeMidtransPayment(){

		String va = getVirtualAccount()

		println("================================")
		println("VA NUMBER : " + va)
		println("================================")

		openMidtransSimulator()

		inputVirtualAccount(va)

		inquirePayment()

		pay()

		verifyPaymentSuccess()

	}

	//----------------------------------------------------
	// BACK TO ORDER
	//----------------------------------------------------

	void backToOrder(){

		WebUI.switchToWindowIndex(1)

		WebUI.waitForPageLoad(20)

	}

	//----------------------------------------------------
	// WAIT UNTIL PAID
	//----------------------------------------------------

	void waitUntilPaid(){

		boolean paid = false

		for(int i=1;i<=20;i++){

			WebUI.refresh()

			WebUI.waitForPageLoad(10)

			WebUI.waitForElementVisible(
				orderStatus(),
				10)

			String status =
				WebUI.getText(
					orderStatus())
				.trim()

			println(
				"CHECK STATUS ("+i+") : "+status)

			if(status.equalsIgnoreCase("Paid")){

				paid = true

				break

			}

			WebUI.delay(3)

		}

		assert paid

		println("================================")
		println("ORDER STATUS : PAID")
		println("================================")

	}
	//----------------------------------------------------
	// HIGH LEVEL
	// GUEST CHECKOUT
	//----------------------------------------------------

	void guestCheckout(Map data){

		inputGuestEmail(
			data.email)

		continueGuest()

	}

	//----------------------------------------------------
	// HIGH LEVEL
	// SHIPPING
	//----------------------------------------------------

	void shipping(){

		selectHomeDelivery()

	}

	//----------------------------------------------------
	// HIGH LEVEL
	// PAYMENT
	//----------------------------------------------------

	void paymentBCA(){

		selectMidtrans()

		selectVirtualAccount()

		selectBCA()

	}

	void paymentBNI(){

		selectMidtrans()

		selectVirtualAccount()

		selectBNI()

	}

	void paymentBRI(){

		selectMidtrans()

		selectVirtualAccount()

		selectBRI()

	}

	void paymentPermata(){

		selectMidtrans()

		selectVirtualAccount()

		selectPermata()

	}

	void paymentMandiri(){

		selectMidtrans()

		selectVirtualAccount()

		selectMandiri()

	}

	//----------------------------------------------------
	// HIGH LEVEL
	// PLACE ORDER
	//----------------------------------------------------

	void placeOrder(){

		acceptTerms()

		verifyOrderSummary()

		clickCheckout()

		verifyCheckoutSuccess()

	}

	//----------------------------------------------------
	// HIGH LEVEL
	// COMPLETE PAYMENT
	//----------------------------------------------------

	void payWithMidtrans(){

		openOrderDetail()

		continuePayment()

		completeMidtransPayment()

		backToOrder()

		waitUntilPaid()

	}

	//----------------------------------------------------
	// HIGH LEVEL
	// END TO END
	//----------------------------------------------------

	void checkoutEndToEnd(Map data){

		guestCheckout(data)

		shipping()

		paymentBCA()

		placeOrder()

		payWithMidtrans()

	}

	//----------------------------------------------------
	// VERIFY
	//----------------------------------------------------

	void verifyPaymentInformation(){

		WebUI.verifyElementPresent(
			orderNumber(),
			20)

		WebUI.verifyElementPresent(
			paymentMethod(),
			20)

		WebUI.verifyElementPresent(
			virtualAccountNumber(),
			20)

		WebUI.verifyElementPresent(
			orderStatus(),
			20)

	}

	//----------------------------------------------------
	// COMPLETE VERIFY
	//----------------------------------------------------

	void verifyPaid(){

		verifyOrderStatus(
			"Paid")

		verifyPaymentInformation()

	}

}