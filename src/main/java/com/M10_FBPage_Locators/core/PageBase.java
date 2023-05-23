package com.M10_FBPage_Locators.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageBase {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final By firstNameLocator = By.xpath("//input[@name='firstname']");
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    protected WebElement waitForElementVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForFirstNameElementVisibility() {
        return waitForElementVisibility(firstNameLocator);
    }
}

