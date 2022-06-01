package com.Tutorial.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

public class PageBase {

	@FindBy(id="ticker")
	WebElement loadingTicker;
	
	//methods
	public void waitUntilElementDisplayed(WebDriver driver, WebElement elementname) {
	      WebDriverWait w = new WebDriverWait(driver,30);
	      w.until(ExpectedConditions.elementToBeClickable(elementname));
	}
	
	public void waitUntilPageLoading(WebDriver driver) {
		if(loadingTicker.isDisplayed()) {
			new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOf(loadingTicker));
		}
	}
	
}
