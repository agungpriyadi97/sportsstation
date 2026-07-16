package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.util.Random

class RandomDataHelper {

	Random random = new Random()

	//====================================================
	// RANDOM FIRST NAME
	//====================================================
	private String[] firstNames = [
		"An",
		"Bao",
		"Binh",
		"Cuong",
		"Duc",
		"Hai",
		"Hieu",
		"Hung",
		"Khanh",
		"Long",
		"Minh",
		"Nam",
		"Phong",
		"Quan",
		"Son",
		"Thanh",
		"Thang",
		"Tuan",
		"Viet"
	]

	//====================================================
	// RANDOM LAST NAME
	//====================================================
	private String[] lastNames = [
		"Nguyen",
		"Tran",
		"Le",
		"Pham",
		"Hoang",
		"Vo",
		"Dang",
		"Bui",
		"Do",
		"Phan"
	]

	//====================================================
	// RANDOM STREET
	//====================================================
	private String[] streets = [
		"Nguyen Trai",
		"Tran Hung Dao",
		"Le Loi",
		"Vo Nguyen Giap",
		"Pham Van Dong",
		"Hai Ba Trung",
		"Nguyen Hue",
		"Ly Thuong Kiet",
		"Lac Long Quan",
		"Ho Tung Mau",
		"Pham Hung",
		"Dien Bien Phu"
	]

	//====================================================
	// VIETNAM PHONE PREFIX
	//====================================================
	private String[] phonePrefixes = [
		"032","033","034","035","036","037","038","039",
		"056","058","059",
		"070","076","077","078","079",
		"081","082","083","084","085","086",
		"088","089",
		"090","091","092","093","094",
		"096","097","098","099"
	]

	//====================================================
	// FIRST NAME
	//====================================================
	@Keyword
	String firstName() {

		return firstNames[random.nextInt(firstNames.length)]

	}

	//====================================================
	// LAST NAME
	//====================================================
	@Keyword
	String lastName() {

		return lastNames[random.nextInt(lastNames.length)]

	}

	//====================================================
	// PHONE
	//====================================================
	@Keyword
	String phone() {

		String phone = phonePrefixes[random.nextInt(phonePrefixes.length)]

		while (phone.length() < 10) {

			phone += random.nextInt(10)

		}

		return phone

	}

	//====================================================
	// EMAIL
	//====================================================
	@Keyword
	String email(String firstName, String lastName) {

		long ts = System.currentTimeMillis()

		return firstName.toLowerCase() +
				"." +
				lastName.toLowerCase() +
				"." +
				ts +
				"@gmail.com"

	}

	//====================================================
	// ADDRESS
	//====================================================
	@Keyword
	String address() {

		int houseNumber = random.nextInt(999) + 1

		String street = streets[random.nextInt(streets.length)]

		return houseNumber + " " + street

	}

	//====================================================
	// ZIP CODE
	//====================================================
	@Keyword
	String zipCode() {

		return "100000"

	}

	//====================================================
// GENERATE ALL DATA
//====================================================

@Keyword
Map generateAddressData() {

    String first = firstName()
    String last  = lastName()

    return [

        firstName : first,
        lastName  : last,
        phone      : phone(),
        email      : email(first,last),
        address    : address(),
        zipCode    : zipCode(),

        //==============================
        // DEFAULT ADDRESS
        //==============================
        province   : "Banten",
        city       : "Kab. Tangerang",
        district   : "Balaraja"

    ]
}

	//====================================================
	// PRINT DATA
	//====================================================
@Keyword
	void printAddressData(Map data) {

    println("=========================================")

    println("FIRST NAME : " + data.firstName)

    println("LAST NAME  : " + data.lastName)

    println("PHONE      : " + data.phone)

    println("EMAIL      : " + data.email)

    println("ADDRESS    : " + data.address)

    println("PROVINCE   : " + data.province)

    println("CITY       : " + data.city)

    println("DISTRICT   : " + data.district)

    println("ZIP CODE   : " + data.zipCode)

    println("=========================================")
}
}