package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object noHp
     
    /**
     * <p></p>
     */
    public static Object email
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object url_loginRegister
     
    /**
     * <p></p>
     */
    public static Object confrim_password
     
    /**
     * <p></p>
     */
    public static Object firstName
     
    /**
     * <p></p>
     */
    public static Object lastName
     
    /**
     * <p></p>
     */
    public static Object userMongoDB
     
    /**
     * <p></p>
     */
    public static Object passMongoDB
     
    /**
     * <p></p>
     */
    public static Object mongoHost
     
    /**
     * <p></p>
     */
    public static Object portMongoDB
     
    /**
     * <p></p>
     */
    public static Object MongoDatabase
     
    /**
     * <p></p>
     */
    public static Object MongoCollection
     
    /**
     * <p></p>
     */
    public static Object url_Checkout_pdp
     
    /**
     * <p></p>
     */
    public static Object address
     
    /**
     * <p></p>
     */
    public static Object noCreditCard
     
    /**
     * <p></p>
     */
    public static Object expireddate
     
    /**
     * <p></p>
     */
    public static Object CVV
     
    /**
     * <p></p>
     */
    public static Object EmailCO
     
    /**
     * <p></p>
     */
    public static Object G_1
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables('default')
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
    
            noHp = selectedVariables['noHp']
            email = selectedVariables['email']
            password = selectedVariables['password']
            url_loginRegister = selectedVariables['url_loginRegister']
            confrim_password = selectedVariables['confrim_password']
            firstName = selectedVariables['firstName']
            lastName = selectedVariables['lastName']
            userMongoDB = selectedVariables['userMongoDB']
            passMongoDB = selectedVariables['passMongoDB']
            mongoHost = selectedVariables['mongoHost']
            portMongoDB = selectedVariables['portMongoDB']
            MongoDatabase = selectedVariables['MongoDatabase']
            MongoCollection = selectedVariables['MongoCollection']
            url_Checkout_pdp = selectedVariables['url_Checkout_pdp']
            address = selectedVariables['address']
            noCreditCard = selectedVariables['noCreditCard']
            expireddate = selectedVariables['expireddate']
            CVV = selectedVariables['CVV']
            EmailCO = selectedVariables['EmailCO']
            G_1 = selectedVariables['G_1']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
