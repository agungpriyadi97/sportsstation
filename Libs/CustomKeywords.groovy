
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.Map

import com.kms.katalon.core.testobject.TestObject



def static "utils.MailinatorHelper.openInbox"(
    	String inbox	) {
    (new utils.MailinatorHelper()).openInbox(
        	inbox)
}


def static "utils.MailinatorHelper.openLatestEmailBySubject"(
    	String inbox	
     , 	String subject	
     , 	int retry	) {
    (new utils.MailinatorHelper()).openLatestEmailBySubject(
        	inbox
         , 	subject
         , 	retry)
}


def static "utils.MailinatorHelper.getEmailBody"() {
    (new utils.MailinatorHelper()).getEmailBody()
}


def static "utils.MailinatorHelper.extractOTP"(
    	String body	) {
    (new utils.MailinatorHelper()).extractOTP(
        	body)
}


def static "utils.MailinatorHelper.getOTPBySubject"(
    	String inbox	
     , 	String subject	) {
    (new utils.MailinatorHelper()).getOTPBySubject(
        	inbox
         , 	subject)
}


def static "utils.MailinatorHelper.switchToApplication"() {
    (new utils.MailinatorHelper()).switchToApplication()
}


def static "utils.MailinatorHelper.openLatestEmailBySubject"(
    	String inbox	
     , 	String subject	) {
    (new utils.MailinatorHelper()).openLatestEmailBySubject(
        	inbox
         , 	subject)
}


def static "utils.DummyData.generateRegistrationData"() {
    (new utils.DummyData()).generateRegistrationData()
}


def static "utils.DummyData.generateAddressData"() {
    (new utils.DummyData()).generateAddressData()
}


def static "mongoDB.mongoDBHelper.getLatestOTPEmail"(
    	String email	) {
    (new mongoDB.mongoDBHelper()).getLatestOTPEmail(
        	email)
}


def static "mongoDB.mongoDBHelper.getOldestOTP"(
    	String phoneNumber	) {
    (new mongoDB.mongoDBHelper()).getOldestOTP(
        	phoneNumber)
}


def static "utils.EditHelper.openEdit"(
    	String type	) {
    (new utils.EditHelper()).openEdit(
        	type)
}


def static "utils.EditHelper.save"(
    	String type	) {
    (new utils.EditHelper()).save(
        	type)
}


def static "utils.EditHelper.verify"(
    	String type	
     , 	Map data	) {
    (new utils.EditHelper()).verify(
        	type
         , 	data)
}

 /**
	 * Open Registration Page
	 */ 
def static "utils.RegistrationHelper.openRegistration"() {
    (new utils.RegistrationHelper()).openRegistration()
}

 /**
	 * Verify Mobile
	 */ 
def static "utils.RegistrationHelper.verifyMobile"(
    	String mobile	) {
    (new utils.RegistrationHelper()).verifyMobile(
        	mobile)
}

 /**
	 * Fill Registration Form
	 */ 
def static "utils.RegistrationHelper.fillRegistrationForm"(
    	Map data	
     , 	String otp	) {
    (new utils.RegistrationHelper()).fillRegistrationForm(
        	data
         , 	otp)
}

 /**
	 * Submit Registration
	 */ 
def static "utils.RegistrationHelper.submitRegistration"() {
    (new utils.RegistrationHelper()).submitRegistration()
}

 /**
	 * Verify Success
	 */ 
def static "utils.RegistrationHelper.verifySuccess"() {
    (new utils.RegistrationHelper()).verifySuccess()
}


def static "utils.ProductHelper.safeClick"(
    	TestObject object	) {
    (new utils.ProductHelper()).safeClick(
        	object)
}


def static "utils.ProductHelper.selectFirstAvailableSize"() {
    (new utils.ProductHelper()).selectFirstAvailableSize()
}


def static "utils.ProductHelper.selectFirstAvailableColor"() {
    (new utils.ProductHelper()).selectFirstAvailableColor()
}


def static "utils.ProductHelper.addToCart"() {
    (new utils.ProductHelper()).addToCart()
}


def static "utils.ProductHelper.verifySuccessToast"() {
    (new utils.ProductHelper()).verifySuccessToast()
}


def static "utils.ProductHelper.openCart"() {
    (new utils.ProductHelper()).openCart()
}


def static "utils.ProductHelper.addProductToCart"() {
    (new utils.ProductHelper()).addProductToCart()
}


def static "utils.ProductHelper.increaseQuantity"() {
    (new utils.ProductHelper()).increaseQuantity()
}


def static "utils.ProductHelper.decreaseQuantity"() {
    (new utils.ProductHelper()).decreaseQuantity()
}


def static "utils.ProductHelper.deleteProduct"() {
    (new utils.ProductHelper()).deleteProduct()
}


def static "utils.ProductHelper.checkout"() {
    (new utils.ProductHelper()).checkout()
}


def static "utils.ProductHelper.verifyCartBadge"(
    	String qty	) {
    (new utils.ProductHelper()).verifyCartBadge(
        	qty)
}


def static "utils.ProductHelper.verifyProductInCart"() {
    (new utils.ProductHelper()).verifyProductInCart()
}


def static "utils.ProductHelper.verifyProductInCart"(
    	String product	) {
    (new utils.ProductHelper()).verifyProductInCart(
        	product)
}


def static "utils.ProductHelper.verifyQuantity"(
    	String qty	) {
    (new utils.ProductHelper()).verifyQuantity(
        	qty)
}


def static "utils.ProductHelper.verifyOrderSummary"() {
    (new utils.ProductHelper()).verifyOrderSummary()
}


def static "utils.ProductHelper.waitLoading"() {
    (new utils.ProductHelper()).waitLoading()
}


def static "utils.ProductHelper.retryClick"(
    	TestObject object	) {
    (new utils.ProductHelper()).retryClick(
        	object)
}


def static "utils.ProductHelper.confirmDelete"() {
    (new utils.ProductHelper()).confirmDelete()
}


def static "utils.ProductHelper.cancelDelete"() {
    (new utils.ProductHelper()).cancelDelete()
}


def static "utils.ProductHelper.verifyCurrentPrice"() {
    (new utils.ProductHelper()).verifyCurrentPrice()
}


def static "utils.ProductHelper.verifyNormalPrice"() {
    (new utils.ProductHelper()).verifyNormalPrice()
}


def static "utils.ProductHelper.verifySubtotal"() {
    (new utils.ProductHelper()).verifySubtotal()
}


def static "utils.ProductHelper.verifyDiscount"() {
    (new utils.ProductHelper()).verifyDiscount()
}


def static "utils.ProductHelper.verifyTotal"() {
    (new utils.ProductHelper()).verifyTotal()
}


def static "utils.ProductHelper.verifyEmptyCart"() {
    (new utils.ProductHelper()).verifyEmptyCart()
}


def static "utils.ProductHelper.addProductAndOpenCart"() {
    (new utils.ProductHelper()).addProductAndOpenCart()
}


def static "utils.ProductHelper.deleteFirstProduct"() {
    (new utils.ProductHelper()).deleteFirstProduct()
}


def static "utils.ProductHelper.increaseQtyTo"(
    	String qty	) {
    (new utils.ProductHelper()).increaseQtyTo(
        	qty)
}


def static "utils.ProductHelper.decreaseQtyTo"(
    	String qty	) {
    (new utils.ProductHelper()).decreaseQtyTo(
        	qty)
}


def static "utils.ProductHelper.verifyPDP"() {
    (new utils.ProductHelper()).verifyPDP()
}


def static "utils.ProductHelper.verifyCartPage"() {
    (new utils.ProductHelper()).verifyCartPage()
}


def static "utils.ProductHelper.waitUntilReady"() {
    (new utils.ProductHelper()).waitUntilReady()
}


def static "utils.ProductHelper.openFirstProduct"() {
    (new utils.ProductHelper()).openFirstProduct()
}


def static "utils.CommonHelper.closeMapClubPopup"() {
    (new utils.CommonHelper()).closeMapClubPopup()
}


def static "utils.CommonHelper.acceptCookies"() {
    (new utils.CommonHelper()).acceptCookies()
}


def static "utils.CommonHelper.closeAllPopup"() {
    (new utils.CommonHelper()).closeAllPopup()
}


def static "utils.DeleteHelper.deleteLastAddress"(
    	String type	) {
    (new utils.DeleteHelper()).deleteLastAddress(
        	type)
}


def static "utils.LogoutHelper.logout"() {
    (new utils.LogoutHelper()).logout()
}


def static "utils.CheckoutAddressHelper.fillAddress"(
    	String first	
     , 	String last	
     , 	String phone	
     , 	String addr	) {
    (new utils.CheckoutAddressHelper()).fillAddress(
        	first
         , 	last
         , 	phone
         , 	addr)
}

 /**
	 * Open Forgot Password Page
	 */ 
def static "utils.ForgotPasswordHelper.openForgotPassword"() {
    (new utils.ForgotPasswordHelper()).openForgotPassword()
}

 /**
	 * Send Verification Code
	 */ 
def static "utils.ForgotPasswordHelper.sendVerificationCode"(
    	String email	) {
    (new utils.ForgotPasswordHelper()).sendVerificationCode(
        	email)
}

 /**
	 * Fill Reset Password Form
	 */ 
def static "utils.ForgotPasswordHelper.fillResetPasswordForm"(
    	String otp	
     , 	String newPassword	) {
    (new utils.ForgotPasswordHelper()).fillResetPasswordForm(
        	otp
         , 	newPassword)
}

 /**
	 * Submit Reset Password
	 */ 
def static "utils.ForgotPasswordHelper.submitResetPassword"() {
    (new utils.ForgotPasswordHelper()).submitResetPassword()
}

 /**
	 * Verify Reset Password Success
	 */ 
def static "utils.ForgotPasswordHelper.verifyResetPasswordSuccess"() {
    (new utils.ForgotPasswordHelper()).verifyResetPasswordSuccess()
}


def static "com.yourproject.email.GetOTPFromYopmail.getOTP"(
    	String email	
     , 	int timeoutSeconds	) {
    (new com.yourproject.email.GetOTPFromYopmail()).getOTP(
        	email
         , 	timeoutSeconds)
}


def static "com.yourproject.email.GetOTPFromYopmail.getOTP"(
    	String email	) {
    (new com.yourproject.email.GetOTPFromYopmail()).getOTP(
        	email)
}


def static "utils.LoginHelper.login"(
    	String email	
     , 	String password	) {
    (new utils.LoginHelper()).login(
        	email
         , 	password)
}


def static "utils.LoginHelper.verifyLoginSuccess"() {
    (new utils.LoginHelper()).verifyLoginSuccess()
}


def static "globalFunction.generateEmail"() {
    (new globalFunction()).generateEmail()
}


def static "globalFunction.generatePhone"() {
    (new globalFunction()).generatePhone()
}


def static "globalFunction.generateUserData"() {
    (new globalFunction()).generateUserData()
}


def static "myorder.MyOrderKeyword.openFirstUnpaidOrder"() {
    (new myorder.MyOrderKeyword()).openFirstUnpaidOrder()
}


def static "myorder.MyOrderKeyword.cancelOrder"() {
    (new myorder.MyOrderKeyword()).cancelOrder()
}


def static "myorder.MyOrderKeyword.verifyCancelReason"() {
    (new myorder.MyOrderKeyword()).verifyCancelReason()
}


def static "utils.RandomDataHelper.firstName"() {
    (new utils.RandomDataHelper()).firstName()
}


def static "utils.RandomDataHelper.lastName"() {
    (new utils.RandomDataHelper()).lastName()
}


def static "utils.RandomDataHelper.phone"() {
    (new utils.RandomDataHelper()).phone()
}


def static "utils.RandomDataHelper.email"(
    	String firstName	
     , 	String lastName	) {
    (new utils.RandomDataHelper()).email(
        	firstName
         , 	lastName)
}


def static "utils.RandomDataHelper.address"() {
    (new utils.RandomDataHelper()).address()
}


def static "utils.RandomDataHelper.zipCode"() {
    (new utils.RandomDataHelper()).zipCode()
}


def static "utils.RandomDataHelper.generateAddressData"() {
    (new utils.RandomDataHelper()).generateAddressData()
}


def static "utils.RandomDataHelper.printAddressData"(
    	Map data	) {
    (new utils.RandomDataHelper()).printAddressData(
        	data)
}
