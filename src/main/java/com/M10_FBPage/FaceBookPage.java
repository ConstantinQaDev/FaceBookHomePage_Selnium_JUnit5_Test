package com.M10_FBPage;

import com.M10_FBPage.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FaceBookPage extends PageBase {

    public FaceBookPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    public WebElement emailField;
    @FindBy(how = How.XPATH, using = "//input[@data-testid='royal_pass']")
    public WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement logInButtonField;
    @FindBy(how = How.XPATH, using = "//button[@name='websubmit']")
    public WebElement logInButtonField2;
    @FindBy(how = How.XPATH, using = "//a[text()='Forgot password?']")
    public WebElement forgotPassField;
    @FindBy(how = How.XPATH, using = "//*[text()='Create new account']")
    public WebElement createNewAccountField;
    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    public WebElement firstNameField;
    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    public WebElement lastNameField;
    @FindBy(how = How.XPATH, using = "//input[@name='reg_email__']")
    public WebElement newEmailField;
    @FindBy(how = How.XPATH, using = "//input[@name='reg_passwd__']")
    public WebElement newPasswordField;
}





