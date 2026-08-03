import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

println("======================================")
println("TEST CASE : POSITIVE - GUEST USER CAN ACCESS PDP")
println("======================================")

//====================================================
// OPEN PDP
//====================================================

navigateToUrl(
    "https://staging.sportsstation.id/pdp/Converse-Chuck-70-Ox-Men's-Sneakers-Navy/SP220620159143")

waitForPageLoad(30)

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

println("PDP OPENED")

//====================================================
// VERIFY PRODUCT IMAGE
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/img_Product"))

//====================================================
// VERIFY BRAND
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Brand"))

println("Brand : " + getText(findTestObject("WEB/Product/PDP/lbl_Brand")))

//====================================================
// VERIFY PRODUCT NAME
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_ProductName"))

println("Product : " + getText(findTestObject("WEB/Product/PDP/lbl_ProductName")))

//====================================================
// VERIFY SKU
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_SKU"))

println("SKU : " + getText(findTestObject("WEB/Product/PDP/lbl_SKU")))

//====================================================
// VERIFY PRICE
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_ProductPrice"))

println("Price : " + getText(findTestObject("WEB/Product/PDP/lbl_ProductPrice")))

//====================================================
// VERIFY SIZE
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/opt_SizeSelected"))

println("Size : " + getText(findTestObject("WEB/Product/PDP/opt_SizeSelected")))

//====================================================
// VERIFY COLOR
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Color"))
verifyElementVisible(findTestObject("WEB/Product/PDP/opt_ColorSelected"))

println("Color : " + getText(findTestObject("WEB/Product/PDP/opt_ColorSelected")))

//====================================================
// VERIFY ADD TO CART
//====================================================

verifyElementVisible(findTestObject("WEB/Product/PDP/btn_AddToCart"))

println("ADD TO CART VERIFIED")

//====================================================
// VERIFY DESCRIPTION
//====================================================

scrollToElement(findTestObject("WEB/Product/PDP/lbl_Description"), 5)

verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Description"))
//
//verifyElementVisible(findTestObject("WEB/Product/PDP/lbl_Disclaimer"))

println("DESCRIPTION VERIFIED")

println("======================================")
println("GUEST USER CAN ACCESS PDP SUCCESS")
println("======================================")