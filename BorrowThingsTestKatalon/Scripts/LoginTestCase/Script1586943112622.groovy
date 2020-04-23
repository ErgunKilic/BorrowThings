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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://192.168.56.103:8080/login')

WebUI.setText(findTestObject('Object Repository/Login with admin/Login with admin/input_User Name_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Object Repository/Login with admin/Login with admin/input_Password_password'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/Login with admin/Login with admin/button_Submit'))

WebUI.click(findTestObject('Object Repository/Login with admin/Page_BorrowThings/a_BorrowThings'))

WebUI.click(findTestObject('Object Repository/Login with admin/Page_BorrowThings/h1_This is home page'))

WebUI.closeBrowser()

