import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

println("========================================================")
println("TEST CASE : " + testCaseName)
println("MENU      : " + menu)
println("========================================================")

// Scroll ke footer
WebUI.scrollToElement(findTestObject(testObject), 20)

// Klik menu footer
WebUI.click(findTestObject(testObject))

WebUI.delay(2)

// ==========================================
// Handle New Tab / Same Tab
// ==========================================
if (newTab.equalsIgnoreCase("Y")) {

    println("Open in New Tab")

    WebUI.switchToWindowIndex(1)

    WebUI.waitForPageLoad(20)

    String currentUrl = WebUI.getUrl()

    println("Current URL : " + currentUrl)

    WebUI.verifyMatch(
            currentUrl,
            ".*${expectedUrl}.*",
            true)

    println("RESULT : PASSED")

    // Tutup tab baru
    WebUI.closeWindowIndex(1)

    // Kembali ke tab utama
    WebUI.switchToWindowIndex(0)

} else {

    println("Open in Same Tab")

    WebUI.waitForPageLoad(20)

    String currentUrl = WebUI.getUrl()

    println("Current URL : " + currentUrl)

    WebUI.verifyMatch(
            currentUrl,
            ".*${expectedUrl}.*",
            true)

    println("RESULT : PASSED")

    // Kembali ke Homepage agar iterasi berikutnya bisa berjalan
    WebUI.back()

    WebUI.waitForPageLoad(20)
}

println("========================================================")
println(testCaseName + " COMPLETED")
println("========================================================")