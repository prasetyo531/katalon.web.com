import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

WebUI.openBrowser('')
try {
    WebUI.maximizeWindow()
    WebUI.navigateToUrl(GlobalVariable.BASE_URL)
    WebUI.waitForElementVisible(findTestObject('Pages/Login/input_Username'), 10)

    CustomKeywords.'saucedemo.LoginKeywords.login'(GlobalVariable.LOCKED_OUT_USERNAME, GlobalVariable.DEMO_PASSWORD)

    WebUI.waitForElementVisible(findTestObject('Pages/Login/message_Error'), 10)
    WebUI.verifyElementText(
        findTestObject('Pages/Login/message_Error'),
        'Epic sadface: Sorry, this user has been locked out.'
    )
} finally {
    WebUI.closeBrowser()
}
