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

//Get User by ID 
def respGetid = WS.sendRequest(findTestObject('GETbyid', [('id') : 22]))
	//verify status code
WS.verifyResponseStatusCode(respGetid, 200)
	//verify schema
def userid = WS.getElementPropertyValue(respGetid, '[0].id')
println('User id : '+ userid)

//Update data user 
def respUpdateuser = WS.sendRequest(findTestObject('UPDATE'))
	//verify status code
WS.verifyResponseStatusCode(respUpdateuser, 200)
 	//verify schema
def userjob = WS.getElementPropertyValue(respGetid, '[0].job_level')
println('Job level: '+userjob)
def usersalary = WS.getElementPropertyValue(respGetid, '[0].salary')
println('Job level: '+usersalary)

//Tambah data user
def resAdduser = WS.sendRequest(findTestObject('POSTuser'))
 	//verify status code
WS.verifyResponseStatusCode(resAdduser, 201)
	//verify skema
def adduserid = WS.getElementPropertyValue(resAdduser, '[0].id')
def addusername =  WS.getElementPropertyValue(resAdduser, '[0].username')
println('User id : '+ adduserid)
println('Username : '+ addusername)

//Hapus data user
def reshapususer= WS.sendRequest(findTestObject('DELETEuser'))
	//verify status code
WS.verifyResponseStatusCode(reshapususer, 204)
	//verify skema
//Get Username  invalid (respon 200 tapi data kosong, menampilkan comment data tidak ditemukan)
def respGetinv = WS.sendRequest(findTestObject('GETbyUsername', [('username') : 'shintaummah']))
WS.verifyResponseStatusCode(respGetinv, 200)
	// verify skema
def username = WS.getElementPropertyValue(respGetinv, 'username')
// Cek apakah data kosong
if (username==[]) {
    println('Data tidak ditemukan')
} else {
    println('Data ditemukan')
	 println(username)
}
