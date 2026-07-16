package com.yourproject.email;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.*
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import java.time.Duration
import internal.GlobalVariable

public class GetOTPFromYopmail {
		
	@Keyword
	def getOTP(String email, int timeoutSeconds = 60) {
	    String username = email.split('@')[0]
	    String otp = ""
	    boolean otpFound = false
	
	    // JANGAN openBrowser lagi. Buka tab baru di browser yang sudah ada.
	    WebUI.executeJavaScript('window.open("https://yopmail.com/en/?login=' + username + '", "_blank");', [])
	    
	    // Pindah fokus ke tab Yopmail (biasanya index 1)
	    WebUI.switchToWindowIndex(1)
	    WebUI.delay(2)
	
	    WebDriver driver = DriverFactory.getWebDriver()
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25))
	    int maxRetry = timeoutSeconds / 4
	
	    for(int i = 0; i < maxRetry; i++) {
	        try {
	            WebUI.delay(3)
	            driver.switchTo().defaultContent()
	            driver.findElement(By.id("refresh")).click()
	            
	            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifinbox"))
	            
	            List<WebElement> emailList = driver.findElements(By.xpath(
	                "//div[contains(@class,'m') or contains(@class,'lm')][contains(., 'Verification code') or contains(., 'SpeedShop')]"
	            ))
	            
	            if (emailList.size() > 0) {
	                emailList.get(0).click()
	            } else {
	                continue
	            }
	            
	            WebUI.delay(5)
	            driver.switchTo().defaultContent()
	            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"))
	            
	            WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")))
	            String bodyText = body.getText()
	            
	            def matcher = (bodyText =~ /\b(\d{6})\b/)
	            if (matcher.find()) {
	                otp = matcher.group(1)
	                otpFound = true
	                break
	            }
	        } catch (Exception e) {
	            KeywordUtil.logInfo("Retry ${i+1} error: " + e.getMessage())
	        }
	    }
	
	    // TUTUP TAB YOPMAIL SAJA, JANGAN closeBrowser()
	    WebUI.closeWindowIndex(1)
	    
	    // BALIK KE TAB UTAMA (Sports Station)
	    WebUI.switchToWindowIndex(0)
	
	    return otp
	}
}
