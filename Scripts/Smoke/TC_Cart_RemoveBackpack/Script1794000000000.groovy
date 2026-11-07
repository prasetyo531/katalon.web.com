import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

WebUI.openBrowser('')
try {
    WebUI.maximizeWindow()
    WebUI.navigateToUrl(GlobalVariable.BASE_URL)
    WebUI.waitForElementVisible(findTestObject('Pages/Login/input_Username'), 10)
    CustomKeywords.'saucedemo.LoginKeywords.login'(GlobalVariable.STANDARD_USERNAME, GlobalVariable.DEMO_PASSWORD)

    WebUI.waitForElementVisible(findTestObject('Pages/Inventory/button_AddBackpack'), 10)
    WebUI.click(findTestObject('Pages/Inventory/button_AddBackpack'))
    WebUI.verifyElementText(findTestObject('Pages/Inventory/cartBadge'), '1')
    WebUI.waitForElementVisible(findTestObject('Pages/Inventory/button_RemoveBackpack'), 10)
    WebUI.click(findTestObject('Pages/Inventory/button_RemoveBackpack'))
    WebUI.verifyElementNotPresent(findTestObject('Pages/Inventory/cartBadge'), 5)

    WebUI.click(findTestObject('Pages/Inventory/link_Cart'))
    WebUI.waitForElementVisible(findTestObject('Pages/Inventory/pageTitle'), 10)
    WebUI.verifyElementText(findTestObject('Pages/Inventory/pageTitle'), 'Your Cart')
    WebUI.verifyElementNotPresent(findTestObject('Pages/Cart/itemName'), 5)
} finally {
    WebUI.closeBrowser()
}
