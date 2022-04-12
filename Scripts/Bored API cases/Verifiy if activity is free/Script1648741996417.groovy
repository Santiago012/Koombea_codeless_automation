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
import java.text.DecimalFormat as DecimalFormat

WS.comment('Story: Verify if a given activity is free')

DecimalFormat df = new DecimalFormat()

df.setMaximumFractionDigits(2)

Random random = new Random()

double rangeMin = 0.0

double rangeMax = 1.0

WS.comment(' Given a random value between 0.0 and 1.0 that represents a price ')

float_1 = df.format((random.nextDouble() * (rangeMax - rangeMin)) + rangeMin)

println(float_1)

String price = String.valueOf(float_1)

WS.comment(' When an ctivity with that price is requested  ')

response = WS.sendRequest(findTestObject('Bored API Requests/Get activity based on price', [('price') : price]))

WS.verifyResponseStatusCode(response, 200) 

String activity_price = WS.getElementPropertyValue(response, 'price')

WS.comment('And that activity exist ')

assert activity_price != null

println(activity_price)

WS.comment(' Then user will know if that activity price is 0.0 in other words free  ')

CustomKeywords.'kms.turing.katalon.plugins.assertj.NumberAssert.equals'(activity_price, 0, 'Verify number of members', FailureHandling.STOP_ON_FAILURE)

