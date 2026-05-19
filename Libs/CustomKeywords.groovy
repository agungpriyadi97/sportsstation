
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String



def static "globalFunction.generateEmail"() {
    (new globalFunction()).generateEmail()
}


def static "globalFunction.generatePhone"() {
    (new globalFunction()).generatePhone()
}


def static "globalFunction.generateUserData"() {
    (new globalFunction()).generateUserData()
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
