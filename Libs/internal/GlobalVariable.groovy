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
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object username
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object RegisteredEmail
     
    /**
     * <p></p>
     */
    public static Object RegisteredPassword
     
    /**
     * <p></p>
     */
    public static Object RegisteredMobile
     
    /**
     * <p></p>
     */
    public static Object RegisteredFullName
     
    /**
     * <p></p>
     */
    public static Object usernamenonmember
     
    /**
     * <p></p>
     */
    public static Object VirtualAccount
     
    /**
     * <p></p>
     */
    public static Object TotalPrice
     
    /**
     * <p></p>
     */
    public static Object PaymentMethod
     
    /**
     * <p></p>
     */
    public static Object OrderNumber
     
    /**
     * <p></p>
     */
    public static Object OrderStatus
     
    /**
     * <p></p>
     */
    public static Object nomormembermapclub
     
    /**
     * <p></p>
     */
    public static Object passwordmembermapclub
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables('default')
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
    
            URL = selectedVariables['URL']
            username = selectedVariables['username']
            password = selectedVariables['password']
            RegisteredEmail = selectedVariables['RegisteredEmail']
            RegisteredPassword = selectedVariables['RegisteredPassword']
            RegisteredMobile = selectedVariables['RegisteredMobile']
            RegisteredFullName = selectedVariables['RegisteredFullName']
            usernamenonmember = selectedVariables['usernamenonmember']
            VirtualAccount = selectedVariables['VirtualAccount']
            TotalPrice = selectedVariables['TotalPrice']
            PaymentMethod = selectedVariables['PaymentMethod']
            OrderNumber = selectedVariables['OrderNumber']
            OrderStatus = selectedVariables['OrderStatus']
            nomormembermapclub = selectedVariables['nomormembermapclub']
            passwordmembermapclub = selectedVariables['passwordmembermapclub']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
