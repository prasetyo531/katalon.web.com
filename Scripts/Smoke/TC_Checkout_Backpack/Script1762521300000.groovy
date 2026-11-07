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
    WebUI.click(findTestObject('Pages/Inventory/link_Cart'))

    WebUI.waitForElementVisible(findTestObject('Pages/Cart/itemName'), 10)
    WebUI.verifyElementText(findTestObject('Pages/Cart/itemName'), 'Sauce Labs Backpack')
    WebUI.click(findTestObject('Pages/Cart/button_Checkout'))

    WebUI.waitForElementVisible(findTestObject('Pages/Checkout/input_FirstName'), 10)
    WebUI.setText(findTestObject('Pages/Checkout/input_FirstName'), 'Test')
    WebUI.setText(findTestObject('Pages/Checkout/input_LastName'), 'User')
    WebUI.setText(findTestObject('Pages/Checkout/input_PostalCode'), '12345')
    WebUI.click(findTestObject('Pages/Checkout/button_Continue'))

    WebUI.waitForElementVisible(findTestObject('Pages/Checkout/label_ItemTotal'), 10)
    WebUI.verifyElementText(findTestObject('Pages/Checkout/label_ItemTotal'), 'Item total: $ 29.99')
    WebUI.click(findTestObject('Pages/Checkout/button_Finish'))

    WebUI.waitForElementVisible(findTestObject('Pages/Checkout/label_CompleteHeader'), 10)
    WebUI.verifyElementText(findTestObject('Pages/Checkout/label_CompleteHeader'), 'Thank you for your order!')
} finally {
    WebUI.closeBrowser()
}
