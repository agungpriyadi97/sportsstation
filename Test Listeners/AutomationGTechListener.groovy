import java.io.File
import java.util.Arrays

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory


class AutomationGTechListener {

    private static boolean browserOpenedByListener = false

    @BeforeTestCase
    def beforeTestCase(TestCaseContext testCaseContext) {

        KeywordUtil.logInfo("================================================")
        KeywordUtil.logInfo("START TEST CASE : ${testCaseContext.getTestCaseId()}")
        KeywordUtil.logInfo("================================================")

        boolean isBrowserActive = false

        try {

            isBrowserActive = (DriverFactory.getWebDriver() != null)

            if (isBrowserActive) {
                WebUI.getUrl()
            }

        } catch (Exception e) {

            isBrowserActive = false
            KeywordUtil.logInfo("Browser detected as inactive : ${e.getMessage()}")
        }

        if (!isBrowserActive && !browserOpenedByListener) {

            try {

                KeywordUtil.logInfo("Opening new browser...")

                WebUI.openBrowser('')
                WebUI.setViewPortSize(1920, 1080)

                if (GlobalVariable.URL == null || GlobalVariable.URL.trim().isEmpty()) {

                    KeywordUtil.markFailedAndStop(
                        "GlobalVariable.URL is not set. Please configure it in Profiles."
                    )
                }

                WebUI.navigateToUrl(GlobalVariable.URL)

                acceptCookieConsent()

                browserOpenedByListener = true

                def width =
                    WebUI.executeJavaScript(
                        "return window.innerWidth",
                        null
                    )

                def height =
                    WebUI.executeJavaScript(
                        "return window.innerHeight",
                        null
                    )

                KeywordUtil.logInfo(
                    "Viewport Size : ${width} x ${height}"
                )

                saveStartPageScreenshot()

            } catch (Exception e) {

                KeywordUtil.markFailed(
                    "Failed to open browser or navigate to URL : ${e.getMessage()}"
                )

                throw e
            }

        } else if (isBrowserActive) {

            KeywordUtil.logInfo(
                "Browser already opened, reusing existing session."
            )

            try {

                if (WebUI.getUrl() != GlobalVariable.URL) {

                    WebUI.navigateToUrl(GlobalVariable.URL)

                    acceptCookieConsent()
                }

            } catch (Exception e) {

                KeywordUtil.logWarning(
                    "Could not verify current URL : ${e.getMessage()}"
                )
            }

        } else {

            KeywordUtil.logInfo(
                "Browser was opened by listener in a previous test case but is now closed. Reopening..."
            )

            browserOpenedByListener = false

            // Membuka ulang browser dengan memanggil sebelumTestCase kembali
            beforeTestCase(testCaseContext)
        }
    }

    private void acceptCookieConsent() {

        try {

            boolean cookieVisible =
                WebUI.verifyElementPresent(
                    findTestObject(
                        'WEB/Common/btn_AcceptAllCookies'
                    ),
                    5,
                    FailureHandling.OPTIONAL
                )

            if (cookieVisible) {

                WebUI.click(
                    findTestObject(
                        'WEB/Common/btn_AcceptAllCookies'
                    )
                )

                KeywordUtil.logInfo(
                    "Cookie consent accepted"
                )
            }

        } catch (Exception e) {

            KeywordUtil.logInfo(
                "Cookie popup not displayed"
            )
        }
    }

    @AfterTestCase
    def afterTestCase(TestCaseContext testCaseContext) {

        try {

            if (DriverFactory.getWebDriver() != null) {

                // ============================================
                // Parsing Test Case ID untuk Subfolder Modul
                // ============================================
                String rawId = testCaseContext.getTestCaseId()
                String cleanPath = rawId.replace("Test Cases/", "") 
                String[] parts = cleanPath.split("/")
                
                String modulePath = "Root"
                String tcName = cleanPath
                
                if (parts.length > 1) {
                    modulePath = String.join("/", Arrays.copyOfRange(parts, 0, parts.length - 1))
                    tcName = parts[parts.length - 1]
                }

                tcName = tcName.replaceAll("[^a-zA-Z0-9_\\-]", "_")
                String status = testCaseContext.getTestCaseStatus()

                // ============================================
                // Screenshot GitLab Artifact
                // ============================================
                String screenshotFolder = RunConfiguration.getProjectDir() + "/Screenshot/" + modulePath
                new File(screenshotFolder).mkdirs() 

                String artifactScreenshot = screenshotFolder + "/" + tcName + "_" + status + ".png"

                try {
                    WebUI.takeScreenshot(artifactScreenshot)
                    KeywordUtil.logInfo("Artifact Screenshot : ${artifactScreenshot}")
                } catch (Exception ignored) {
                }

                // ============================================
                // Screenshot Katalon Report
                // ============================================
                String reportFolder = RunConfiguration.getReportFolder()
                if (reportFolder != null) {
                    String reportSubFolder = reportFolder + "/Screenshot/" + modulePath
                    new File(reportSubFolder).mkdirs()
                    
                    String reportScreenshot = reportSubFolder + "/" + tcName + "_" + status + ".png"

                    try {
                        WebUI.takeScreenshot(reportScreenshot)
                        KeywordUtil.logInfo("Report Screenshot : ${reportScreenshot}")
                    } catch (Exception ignored) {
                    }
                }

                // ============================================
                // Close Browser
                // ============================================
                String tcId = testCaseContext.getTestCaseId()

                if (!tcId.contains("Forgot password verification email")) {

                    WebUI.closeBrowser()
                    browserOpenedByListener = false

                } else {

                    KeywordUtil.logInfo(
                        "Browser kept open for this test case."
                    )
                }

            } else {

                KeywordUtil.logInfo("No browser to close.")
                browserOpenedByListener = false
            }

        } catch (Exception e) {

            KeywordUtil.markWarning(
                "Listener Error : ${e.getMessage()}"
            )

            browserOpenedByListener = false
        }
    }

    private void saveStartPageScreenshot() {
        
        String screenshotFolder = RunConfiguration.getProjectDir() + "/Screenshot"
        new File(screenshotFolder).mkdirs()

        try {
            WebUI.takeScreenshot(screenshotFolder + "/START_PAGE.png")
        } catch (Exception ignored) {
        }

        String reportFolder = RunConfiguration.getReportFolder()
        if (reportFolder != null) {
            try {
                WebUI.takeScreenshot(reportFolder + "/START_PAGE.png")
            } catch (Exception ignored) {
            }
        }
    }
}