package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class ProductHelper {

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
    // PDP
    //----------------------------------------------------

    TestObject productName(){

        return byXpath(
                "//h1[contains(@class,'product')]")

    }

    TestObject currentPrice(){

        return byXpath(
                "(//div[contains(@class,'price')]//p)[1]")

    }

    TestObject normalPrice(){

        return byXpath(
                "//p[contains(@style,'line-through')]")

    }

    //----------------------------------------------------
    // ATTRIBUTE
    //----------------------------------------------------

    TestObject size(String value){

        return byXpath(
                "//li[contains(@class,'attr-item') and not(contains(@class,'disabled'))]//span[normalize-space()='${value}']")

    }

    TestObject color(String value){

        return byXpath(
                "//section[.//*[normalize-space()='Color']]//span[normalize-space()='${value}']")

    }

    //----------------------------------------------------
    // BUTTON
    //----------------------------------------------------

    TestObject addToCartButton(){

        return byXpath(
                "//button[contains(@class,'add-btn')]")

    }

    TestObject cartIcon(){

        return byXpath(
                "//i[contains(@class,'icon-cart')]")

    }

    //----------------------------------------------------
    // SUCCESS
    //----------------------------------------------------

    TestObject successToast(){

        return byXpath(
                "//div[contains(@class,'el-message--success')]")

    }

    TestObject successText(){

        return byXpath(
                "//div[contains(@class,'el-message--success')]//p")

    }

    //----------------------------------------------------
    // SMART CLICK
    //----------------------------------------------------

    @Keyword
    void safeClick(TestObject object){

        WebUI.waitForElementClickable(
                object,
                20)

        WebUI.scrollToElement(
                object,
                5)

        WebUI.mouseOver(
                object)

        WebUI.enhancedClick(
                object)

    }

    //----------------------------------------------------
    // SIZE
    //----------------------------------------------------

    @Keyword
    void selectFirstAvailableSize(){

        List<WebElement> sizes =
                DriverFactory
                .getWebDriver()
                .findElements(
                By.xpath(
                "//li[contains(@class,'attr-item') and not(contains(@class,'disabled'))]"))

        if(sizes.isEmpty()){

            throw new Exception(
                    "No available size.")

        }

        TestObject firstSize = byXpath(
                "(//li[contains(@class,'attr-item') and not(contains(@class,'disabled'))])[1]")

        safeClick(firstSize)

        WebUI.comment("FIRST AVAILABLE SIZE SELECTED")

    }

    //----------------------------------------------------
    // COLOR
    //----------------------------------------------------

    @Keyword
    void selectFirstAvailableColor(){

        List<WebElement> colors =
                DriverFactory
                .getWebDriver()
                .findElements(
                By.xpath(
                "//section[.//*[normalize-space()='Color']]//li[not(contains(@class,'disabled'))]"))

        if(colors.isEmpty()){

            WebUI.comment(
                    "NO COLOR VARIANT")

            return

        }

        TestObject firstColor = byXpath(
                "(//section[.//*[normalize-space()='Color']]//li[not(contains(@class,'disabled'))])[1]")

        safeClick(firstColor)

        WebUI.comment("FIRST AVAILABLE COLOR SELECTED")

    }

    //----------------------------------------------------
    // ADD TO CART
    //----------------------------------------------------

    @Keyword
    void addToCart(){

        safeClick(
                addToCartButton())

    }

    //----------------------------------------------------
    // VERIFY SUCCESS
    //----------------------------------------------------

    @Keyword
    void verifySuccessToast(){

        WebUI.waitForElementVisible(
                successToast(),
                20)

        WebUI.verifyElementPresent(
                successToast(),
                20)

        WebUI.verifyElementText(
                successText(),
                "Success")

    }

    //----------------------------------------------------
    // OPEN CART
    //----------------------------------------------------

    @Keyword
    void openCart(){

        safeClick(
                cartIcon())

        WebUI.delay(1)

        WebUI.waitForPageLoad(20)

    }

    //----------------------------------------------------
    // ADD PRODUCT
    //----------------------------------------------------

    @Keyword
    void addProductToCart(){

        selectFirstAvailableSize()

        selectFirstAvailableColor()

        addToCart()

        verifySuccessToast()

    }
	//----------------------------------------------------
	// CART
	//----------------------------------------------------

	TestObject cartProduct(){

		return byXpath(
				"//p[contains(@class,'skuname')]")

	}

	TestObject cartProduct(String product){

		return byXpath(
				"//p[contains(@class,'skuname') and contains(normalize-space(),'${product}')]")

	}

	TestObject cartBadge(){

		return byXpath(
				"//span[contains(@class,'cart-num')]")

	}

	TestObject deleteButton(){

		return byXpath(
				"(//i[contains(@class,'icon-delete')])[1]")

	}

	TestObject qtyInput(){

		return byXpath(
				"(//input[@role='spinbutton'])[1]")

	}

	TestObject increaseButton(){

		return byXpath(
				"(//span[contains(@class,'el-input-number__increase')])[1]")

	}

	TestObject decreaseButton(){

		return byXpath(
				"(//span[contains(@class,'el-input-number__decrease')])[1]")

	}

	TestObject checkoutButton(){

		return byXpath(
				"(//div[contains(@class,'checkout-btn')]//button)[1]")

	}

	//----------------------------------------------------
	// ORDER SUMMARY
	//----------------------------------------------------

	TestObject subtotal(){

		return byXpath(
				"//li[label[normalize-space()='Subtotal']]/span")

	}

	TestObject discount(){

		return byXpath(
				"//li[label[normalize-space()='Discount']]/span")

	}

	TestObject total(){

		return byXpath(
				"//li[contains(@class,'total')]//span")

	}

	//----------------------------------------------------
	// CHECKBOX
	//----------------------------------------------------

	TestObject selectAll(){

		return byXpath(
				"//div[contains(@class,'select-all-box')]//span[contains(@class,'el-checkbox__inner')]")

	}

	TestObject firstProductCheckbox(){

		return byXpath(
				"(//label[contains(@class,'cart-checkbox')]//span[contains(@class,'el-checkbox__inner')])[1]")

	}

	//----------------------------------------------------
	// QUANTITY
	//----------------------------------------------------

	@Keyword
	void increaseQuantity(){

		safeClick(
				increaseButton())

		WebUI.delay(1)

	}

	@Keyword
	void decreaseQuantity(){

		safeClick(
				decreaseButton())

		WebUI.delay(1)

	}

	//----------------------------------------------------
	// DELETE
	//----------------------------------------------------

	@Keyword
	void deleteProduct(){

		safeClick(
				deleteButton())

	}

	//----------------------------------------------------
	// CHECKOUT
	//----------------------------------------------------

	@Keyword
	void checkout(){

		safeClick(
				checkoutButton())

		WebUI.waitForPageLoad(20)

	}

	//----------------------------------------------------
	// VERIFY
	//----------------------------------------------------

	@Keyword
	void verifyCartBadge(String qty){

		WebUI.verifyElementText(
				cartBadge(),
				qty)

	}

	@Keyword
	void verifyProductInCart(){

		WebUI.verifyElementPresent(
				cartProduct(),
				20)

	}

	@Keyword
	void verifyProductInCart(String product){

		WebUI.verifyElementPresent(
				cartProduct(product),
				20)

	}

	@Keyword
	void verifyQuantity(String qty){

		WebUI.verifyElementAttributeValue(
				qtyInput(),
				"aria-valuenow",
				qty,
				20)

	}

	@Keyword
	void verifyOrderSummary(){

		WebUI.verifyElementPresent(
				subtotal(),
				20)

		WebUI.verifyElementPresent(
				discount(),
				20)

		WebUI.verifyElementPresent(
				total(),
				20)

	}
	//----------------------------------------------------
	// DELETE POPUP
	//----------------------------------------------------

	TestObject deleteDialog(){

		return byXpath(
				"//div[contains(@class,'el-message-box')]")

	}

	TestObject yesButton(){

		return byXpath(
				"//button[.//span[normalize-space()='Yes']]")

	}

	TestObject noButton(){

		return byXpath(
				"//button[.//span[normalize-space()='No']]")

	}

	//----------------------------------------------------
	// EMPTY CART
	//----------------------------------------------------

	TestObject emptyCart(){

		return byXpath(
				"//*[contains(normalize-space(),'Shopping Cart is Empty')]")

	}

	//----------------------------------------------------
	// SAFE WAIT
	//----------------------------------------------------

	@Keyword
	void waitLoading(){

		WebUI.waitForPageLoad(20)

		WebUI.delay(1)

	}

	//----------------------------------------------------
	// RETRY CLICK
	//----------------------------------------------------

	@Keyword
	void retryClick(TestObject object){

		for(int i=1;i<=3;i++){

			try{

				safeClick(object)

				return

			}catch(Exception e){

				WebUI.comment(
						"Retry Click : " + i)

				WebUI.delay(1)

			}

		}

		throw new Exception(
				"Unable to click object.")

	}

	//----------------------------------------------------
	// DELETE CONFIRM
	//----------------------------------------------------

	@Keyword
	void confirmDelete(){

		WebUI.waitForElementVisible(
				deleteDialog(),
				20)

		retryClick(
				yesButton())

		waitLoading()

	}

	@Keyword
	void cancelDelete(){

		WebUI.waitForElementVisible(
				deleteDialog(),
				20)

		retryClick(
				noButton())

	}

	//----------------------------------------------------
	// VERIFY PRICE
	//----------------------------------------------------

	@Keyword
	void verifyCurrentPrice(){

		WebUI.verifyElementPresent(
				currentPrice(),
				20)

	}

	@Keyword
	void verifyNormalPrice(){

		WebUI.verifyElementPresent(
				normalPrice(),
				20)

	}

	//----------------------------------------------------
	// VERIFY SUMMARY
	//----------------------------------------------------

	@Keyword
	void verifySubtotal(){

		WebUI.verifyElementPresent(
				subtotal(),
				20)

	}

	@Keyword
	void verifyDiscount(){

		WebUI.verifyElementPresent(
				discount(),
				20)

	}

	@Keyword
	void verifyTotal(){

		WebUI.verifyElementPresent(
				total(),
				20)

	}

	//----------------------------------------------------
	// VERIFY EMPTY CART
	//----------------------------------------------------

	@Keyword
	void verifyEmptyCart(){

		WebUI.verifyElementPresent(
				emptyCart(),
				20)

	}

	//----------------------------------------------------
	// COMPLETE FLOW
	//----------------------------------------------------

	@Keyword
	void addProductAndOpenCart(){

		addProductToCart()

		openCart()

		verifyProductInCart()

	}

	@Keyword
	void deleteFirstProduct(){

		deleteProduct()

		confirmDelete()

	}

	@Keyword
	void increaseQtyTo(String qty){

		while(true){

			String current =
					WebUI.getAttribute(
					qtyInput(),
					"aria-valuenow")

			if(current==qty){

				break

			}

			increaseQuantity()

		}

	}

	@Keyword
	void decreaseQtyTo(String qty){

		while(true){

			String current =
					WebUI.getAttribute(
					qtyInput(),
					"aria-valuenow")

			if(current==qty){

				break

			}

			decreaseQuantity()

		}

	}

	//----------------------------------------------------
	// VERIFY PDP
	//----------------------------------------------------

	@Keyword
	void verifyPDP(){

		WebUI.verifyElementPresent(
				productName(),
				20)

		verifyCurrentPrice()

	}

	//----------------------------------------------------
	// VERIFY CART PAGE
	//----------------------------------------------------

	@Keyword
	void verifyCartPage(){

		verifyProductInCart()

		verifyOrderSummary()

	}

	//----------------------------------------------------
	// READY
	//----------------------------------------------------

	@Keyword
	void waitUntilReady(){

		waitLoading()

		WebUI.waitForPageLoad(20)

	}
	
	@Keyword
	void openFirstProduct() {
	
		TestObject firstProduct = byXpath(
			"(//div[contains(@class,'sp-plp-card')])[1]"
		)
	
		WebUI.waitForElementVisible(firstProduct, 20)
	
		WebUI.scrollToElement(firstProduct, 5)
	
		try {
	
			WebUI.enhancedClick(firstProduct)
	
		} catch (Exception e) {
	
			WebElement element = DriverFactory
					.getWebDriver()
					.findElement(
						By.xpath("(//div[contains(@class,'sp-plp-card')])[1]")
					)
	
			element.click()
		}
	
		WebUI.waitForPageLoad(20)
	
		WebUI.delay(2)
	}
}