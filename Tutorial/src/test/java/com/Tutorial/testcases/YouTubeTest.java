package com.Tutorial.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Tutorial.base.TestBase;
import com.Tutorial.pages.YoutubePage;
import com.Tutorial.testdata.TestData;

import allurerReports.AllureListener;
import io.qameta.allure.Description;


@Listeners({AllureListener.class})
public class YouTubeTest extends TestBase{
	
	 public YouTubeTest(){
			super();
			// TODO Auto-generated constructor stub
		      }

	 YoutubePage youtubePageObj;
	 
	 @BeforeTest
	    public void beforeTest() {
	    	 
	    }
	    
	    @AfterTest
	    public void afterTest() {
	    	
	    }
	    
		@BeforeMethod
		@Parameters(value={"browser"})
		public void beforeMethod(String browser) {
			setup(browser);
			youtubePageObj= new YoutubePage(driver);
		}
		
		@AfterMethod
		public void afterMethod() {
		   tearDown() ;
		}
		
		@DataProvider(name = "testDataEx")
		public  Object[][] testDataEx() throws IOException{
			Object[][] data= TestData.getExcelData();
			return data;
		}
		
		@Test(dataProvider="testDataEx")
		@Description("Validate Video Title")
		public void checkVideoTitle(String videoNum, String videoName) {
			Reporter.log("Start test check video title");
	     	Assert.assertTrue(youtubePageObj.checkVideoTitles(videoName,videoNum));
			Reporter.log("check video title test end");
		}
}
