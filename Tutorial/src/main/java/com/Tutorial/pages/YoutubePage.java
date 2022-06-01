package com.Tutorial.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.Tutorial.base.PageBase;

import io.qameta.allure.Step;

public class YoutubePage extends PageBase{
	
	public WebDriver driver;
	
	public YoutubePage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    //Locators 
	@FindBy(xpath="//input[@id='search']")
	WebElement searchField;
	
	@FindBy(id="search-icon-legacy")
	WebElement searchIcon;
	
	@FindBy(xpath="//div[@id='filter-menu']//tp-yt-paper-button")
	WebElement filterBtn;
	
	@FindBy(xpath="//div[@title='Search for Video']")
	WebElement videoType;
	
	@FindBy(xpath="//a[@id='video-title']")
	List<WebElement> videoTitle;
	
	@FindBy(xpath="//div[@id='container']//h1")
	WebElement selectedVideoTitle;

	
	//Methods
	@Step("Search with text")
	private void searchWithValue(String name) {
		searchField.sendKeys(name);
		searchField.sendKeys(Keys.ENTER);
	}
	
	@Step("press on filter and select video tab")
	private void filterAndSelectTab() {
	waitUntilElementDisplayed(driver,filterBtn);
		filterBtn.click();
	waitUntilElementDisplayed(driver,videoType);

		videoType.click();
	}

	@Step("get video title from list")
	private String getSpecificVideoTitle(int videoNum) {
		waitUntilPageLoading(driver);
	    String title=videoTitle.get(videoNum).getText();
		return title;
	}
	
	@Step("click on video number videoNum: {0} ")
	private void clickOnSpecificVideo(int videoNum) {
		waitUntilPageLoading(driver);
		videoTitle.get(videoNum).click();
	}
	
	@Step("get video title under the displayed video")
	private String getVideoTitle() {
		waitUntilElementDisplayed(driver,selectedVideoTitle);

		return selectedVideoTitle.getText();
	}
	
	public boolean checkVideoTitles(String searchValue, String videoNum) {
		searchWithValue(searchValue);
		filterAndSelectTab();
		
		//cast and get number
		String[] arrOfStr = videoNum.split("[.]", 0);
		int num=Integer.parseInt(arrOfStr[0]);
		
	    String expectedName=getSpecificVideoTitle(num);
		Reporter.log("Expected video title: "+expectedName);
	   clickOnSpecificVideo(num);
	   String actualName=getVideoTitle();
	   Reporter.log("Actual video title: "+actualName);

	if (expectedName.equals(actualName)) {
		return true;
	}else {
		return false;
	  }
	}
}
