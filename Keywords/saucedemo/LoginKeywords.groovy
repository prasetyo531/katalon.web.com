package saucedemo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class LoginKeywords {

    @Keyword
    def login(String username, String password) {
        WebUI.setText(findTestObject('Pages/Login/input_Username'), username)
        WebUI.setText(findTestObject('Pages/Login/input_Password'), password)
        WebUI.click(findTestObject('Pages/Login/button_Login'))
    }
}
