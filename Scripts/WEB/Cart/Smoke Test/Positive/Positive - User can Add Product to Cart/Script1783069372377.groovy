import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*

import utils.ProductHelper

//====================================================
// INITIALIZE
//====================================================

ProductHelper helper = new ProductHelper()

println("======================================")
println("TEST CASE : ADD PRODUCT TO CART")
println("======================================")

//====================================================
// OPEN PDP
//====================================================

navigateToUrl(
    "https://staging.sportsstation.id/pdp/Converse-Chuck-70-Ox-Men's-Sneakers-Navy/SP220620159143"
)

helper.waitUntilReady()

//====================================================
// CLOSE POPUP
//====================================================

CustomKeywords.'utils.CommonHelper.closeAllPopup'()

helper.waitUntilReady()

//====================================================
// VERIFY PDP
//====================================================

println("VERIFY PRODUCT DETAIL PAGE")

helper.verifyPDP()

//====================================================
// ADD PRODUCT
//====================================================

println("ADD PRODUCT TO CART")

helper.addProductToCart()

//====================================================
// VERIFY SUCCESS TOAST
//====================================================

println("VERIFY SUCCESS")

helper.verifySuccessToast()

//====================================================
// VERIFY CART BADGE
//====================================================

println("VERIFY CART BADGE")

helper.verifyCartBadge("1")

//====================================================
// OPEN CART
//====================================================

println("OPEN CART")

helper.openCart()

//====================================================
// VERIFY CART
//====================================================

println("VERIFY CART PAGE")

helper.verifyCartPage()

println("======================================")
println("ADD PRODUCT TO CART SUCCESS")
println("======================================")