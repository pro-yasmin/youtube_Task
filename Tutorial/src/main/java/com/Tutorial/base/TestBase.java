package com.Tutorial.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal <WebDriver> tdriver= new ThreadLocal <WebDriver>();
	
	public TestBase(){
		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Yasmi\\eclipse-workspace\\Tutorial\\src\\main\\java\\com\\Tutorial\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setup(String browser) {
		 //open chrome browser
		if(browser.equalsIgnoreCase("chrome")){
		     System.setProperty("webdriver.chrome.driver","C:\\Users\\Yasmi\\eclipse-workspace\\SeleniumCourseFramework1\\chromedriver.exe");
			  driver= new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")){
				 //open firefox browser
				  System.setProperty("webdriver.gecko.driver","C:\\Users\\Yasmi\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
				   driver= new FirefoxDriver();
			}
			  
		  driver.manage().window().maximize();
		  //launch URL
		  driver.get(prop.getProperty("url"));
		  tdriver.set(driver);
	}

	public void tearDown() {
		 driver.quit();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}
