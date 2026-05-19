import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.*
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import java.time.Duration

String email = email
String username = email.split('@')[0]

KeywordUtil.logInfo("🔍 Membuka Yopmail untuk ambil OTP: " + email)

WebUI.navigateToUrl("https://yopmail.com/en/?login=" + username)
WebUI.maximizeWindow()

WebDriver driver = DriverFactory.getWebDriver()
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25))

String otp = ""
boolean otpFound = false

for(int i = 0; i < 20; i++) {
    try {
        WebUI.delay(3)
        
        driver.switchTo().defaultContent()
        driver.findElement(By.id("refresh")).click()
        
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifinbox"))
        
        List<WebElement> emailList = driver.findElements(By.xpath(
            "//div[contains(@class,'m') or contains(@class,'lm')]" +
            "[contains(., 'Verification code') or contains(., 'SpeedShop')]"
        ))
        
        if (emailList.size() > 0) {
            emailList.get(0).click()
            KeywordUtil.logInfo("✅ Email Verification code diklik")
        } else {
            continue
        }
        
        WebUI.delay(5)
        driver.switchTo().defaultContent()
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"))
        
        WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")))
        String bodyText = body.getText()
        
        KeywordUtil.logInfo("=== BODY TEXT Retry ${i+1} ===\n${bodyText}\n================================")
        
        def matcher = (bodyText =~ /\b(\d{6})\b/)
        if (matcher.find()) {
            otp = matcher.group(1)
            otpFound = true
            KeywordUtil.logInfo("✅ OTP DITEMUKAN: " + otp)
            break
        }
    } catch (Exception e) {
        KeywordUtil.logInfo("Retry ${i+1} error: " + e.getMessage())
    } finally {
        driver.switchTo().defaultContent()
    }
}

// TUTUP BROWSER YOPMAIL
WebUI.closeBrowser()

if (otpFound) {
    return otp
} else {
    KeywordUtil.markFailed("Gagal ambil OTP dari Yopmail")
    return ""
}