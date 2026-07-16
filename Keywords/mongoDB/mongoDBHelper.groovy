package mongoDB

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
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class mongoDBHelper {
	@Keyword
	String getLatestOTPEmail(String email) {
	
	    String mongoUri = "mongodb://" + GlobalVariable.userMongoDB + ":" + GlobalVariable.passMongoDB + "@" +
	            GlobalVariable.mongoHost + ":" + GlobalVariable.portMongoDB + "/" +
	            GlobalVariable.MongoDatabase + "?authSource=" + GlobalVariable.MongoDatabase
	
	    def client = MongoClients.create(mongoUri)
	
	    try {
	        MongoDatabase database = client.getDatabase(GlobalVariable.MongoDatabase)
	        MongoCollection<Document> collection = database.getCollection(GlobalVariable.MongoCollection)
	
	        KeywordUtil.logInfo("Connecting to MongoDB")
	        KeywordUtil.logInfo("Database: " + GlobalVariable.MongoDatabase)
	        KeywordUtil.logInfo("Collection: " + GlobalVariable.MongoCollection)
	
	        Document query = new Document("email", email)
	        Document sort = new Document("_modified", -1)
	
	        Document result = collection.find(query).sort(sort).first()
	
	        if (result == null) {
	            KeywordUtil.logInfo("⚠️ No OTP found for email: " + email)
	            return null
	        }
	
	        KeywordUtil.logInfo("Query Result: " + result.toJson())
	
	        String otp = result.getString("code")
	        KeywordUtil.logInfo("✅ Retrieved OTP: " + otp)
	
	        return otp
	
	    } finally {
	        client.close()
	    }
	}
	
	
	@Keyword
	String getOldestOTP(String phoneNumber) {
	
	    String mongoUri = "mongodb://" + GlobalVariable.userMongoDB + ":" + GlobalVariable.passMongoDB + "@" +
	            GlobalVariable.mongoHost + ":" + GlobalVariable.portMongoDB + "/" +
	            GlobalVariable.MongoDatabase + "?authSource=" + GlobalVariable.MongoDatabase
	
	    def client = MongoClients.create(mongoUri)
	
	    try {
	        MongoDatabase database = client.getDatabase(GlobalVariable.MongoDatabase)
	        MongoCollection<Document> collection = database.getCollection(GlobalVariable.MongoCollection)
	
	        KeywordUtil.logInfo("Connecting to MongoDB")
	        KeywordUtil.logInfo("Database: " + GlobalVariable.MongoDatabase)
	        KeywordUtil.logInfo("Collection: " + GlobalVariable.MongoCollection)
	
	        // 🔥 FIX: oldest harus ASC (1), bukan -1
	        Document query = new Document("msisdn", phoneNumber)
	        Document sort = new Document("_modified", 1)
	
	        Document result = collection.find(query).sort(sort).first()
	
	        if (result == null) {
	            KeywordUtil.logInfo("⚠️ No OTP found for MSISDN: " + phoneNumber)
	            return null
	        }
	
	        KeywordUtil.logInfo("✅ Query Result: " + result.toJson())
	
	        String otp = result.getString("code")
	        KeywordUtil.logInfo("✅ Retrieved OTP: " + otp)
	
	        return otp
	
	    } finally {
	        client.close()
	    }
	}
}
