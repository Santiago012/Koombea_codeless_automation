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

WS.comment('Story: Verify if a given activity is between my price range')

DecimalFormat df = new DecimalFormat()

df.setMaximumFractionDigits(2)

Random random = new Random()

double rangeMin = 0.0

double rangeMax = 1.0

WS.comment(' Given two random values that are between 0.0 and 1.0 and each represent the minimum and maximum amount a person have for the activity ')

float_1 = df.format((random.nextDouble() * (rangeMax - rangeMin)) + rangeMin)

float_2 = df.format((random.nextDouble() * (rangeMax - rangeMin)) + rangeMin)

println(float_1)

println(float_2)

if(float_1 > float_2) {
	minprice=float_2
	maxprice=float_1
}
else {
	minprice=float_1
	maxprice=float_2
}

String min_price = String.valueOf(minprice)

String max_price = String.valueOf(maxprice)

WS.comment(' When an ctivity between that price range is requested ')

response = WS.sendRequest(findTestObject('Bored API Requests/Get activity between a price range', [('minprice') : min_price, ('maxprice') : max_price]))

WS.verifyResponseStatusCode(response, 200)

String activity_price = WS.getElementPropertyValue(response, 'price')

WS.comment('And that activity exist ')

assert activity_price != null

String activity_name= WS.getElementPropertyValue(response, 'activity')

println(activity_name)

WS.comment(' Then user will know if that activity price is between his cost range ')

CustomKeywords.'kms.turing.katalon.plugins.assertj.NumberAssert.greaterThanOrEqual'(activity_price, float_1, "Verify number of members", FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'kms.turing.katalon.plugins.assertj.NumberAssert.lessThanOrEqual'(activity_price, float_2, "Verify number of members", FailureHandling.CONTINUE_ON_FAILURE)




