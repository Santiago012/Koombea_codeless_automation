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

WS.comment('Story: Verify if a given activity is part of the type social ')

WS.comment('Given a random activity to a user ')

response = WS.sendRequest(findTestObject('Bored API Requests/Get a random activity'))

WS.verifyResponseStatusCode(response, 200)

WS.comment('When I check the type attribute ')

String tipo= WS.getElementPropertyValue(response, 'type')

assert tipo != null

println(tipo)

WS.comment('Then the user will know if the activty type is social ')

CustomKeywords.'kms.turing.katalon.plugins.assertj.StringAssert.equals'(tipo,"social" , true, "contains", FailureHandling.STOP_ON_FAILURE)

