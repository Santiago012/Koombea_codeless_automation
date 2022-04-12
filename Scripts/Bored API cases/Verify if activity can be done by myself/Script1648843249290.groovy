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

WS.comment('Story: Verify if a given activity can be done by myself')

WS.comment('Given a random value that represents the amout of particiapnts in the activity ')

int participants = new Random().nextInt((10 - 0) + 1) + 0

println(participants)

WS.comment(' When an ctivity with that amount of participants is requested  ')

response = WS.sendRequest(findTestObject('Bored API Requests/Get activty based on the number of participants', [('participants') :participants ]))

WS.verifyResponseStatusCode(response, 200)

participants_amount= WS.getElementPropertyValue(response, 'participants')

WS.comment(' and that activity exist')

assert participants_amount != null

println(WS.getElementPropertyValue(response, 'activity'))

WS.comment(' Then user will know if that activity participants is equal to 1 that means it can be done alone  ')

CustomKeywords.'kms.turing.katalon.plugins.assertj.NumberAssert.greaterThanOrEqual'(participants_amount, 1, "Verify number of members", FailureHandling.CONTINUE_ON_FAILURE)






