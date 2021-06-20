package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "idcta-link")
    @CacheLookup
    WebElement btnSigin;

    @FindBy(id = "user-identifier-input")
    @CacheLookup
    WebElement txtUserIdentifier;

    @FindBy(id = "password-input")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(id = "submit-button")
    @CacheLookup
    WebElement btnSubmit;

    @FindBy(id = "form-message-username")
    @CacheLookup
    WebElement msgUserID;

    @FindBy(id = "form-message-password")
    @CacheLookup
    WebElement msgPassword;

    public void NavigateToSignPage() throws InterruptedException {
        btnSigin.click();
        Thread.sleep(5000);
    }

    public void enter_login_credentials(String userId, String password) {
        txtUserIdentifier.click();
        txtUserIdentifier.sendKeys(userId);
        txtPassword.click();
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }

    public void cant_find_email_message() {
        String errMsg = msgUserID.getText();
        System.out.println(errMsg);
        Assert.assertEquals("Sorry, we can’t find an account with that email. You can register for a new account or get help here.", errMsg);
    }

    public void cant_find_username_message() {
        String errMsg = msgUserID.getText();
        System.out.println(errMsg);
        Assert.assertEquals("Sorry, we can’t find an account with that username. If you're over 13, try your email address instead or get help here.", errMsg);
    }

    public void blank_credential_message() {
        String errMsgUser = msgUserID.getText();
        String errMsgPass = msgPassword.getText();
        Assert.assertEquals("Something's missing. Please check and try again.", errMsgUser);
        Assert.assertEquals("Something's missing. Please check and try again.", errMsgPass);
    }

    public void incorrect_password() {
        String errMsgPass = msgPassword.getText();
        Assert.assertEquals("Uh oh, that password doesn’t match that account. Please try again.", errMsgPass);
    }

    public void using_special_characters_message() {
        String errMsg = msgUserID.getText();
        Assert.assertEquals("Usernames can only include... Letters, numbers and these characters: ?/|}{+=_-^~`%$#", errMsg);
    }

    public void single_character_error_message() {
        String errMsg = msgUserID.getText();
        Assert.assertEquals("Sorry, that username's too short. It needs to be at least two characters.", errMsg);
    }

    public void incomplete_email_error_message() {
        String errMsg = msgUserID.getText();
        Assert.assertEquals("Sorry, that email doesn’t look right. Please check it's a proper email.", errMsg);
    }

    public void username_too_long_error_message() {
        String errMsg = msgUserID.getText();
        Assert.assertEquals("Sorry, that username's too long. It can't be more than 50 characters.", errMsg);
    }

    public void password_too_short_error_message() {
        String errMsg = msgPassword.getText();
        Assert.assertEquals("Sorry, that password is too short. It needs to be eight characters or more.", errMsg);
    }

    public void numeric_error_message() {
        String errMsg = msgPassword.getText();
        Assert.assertEquals("Sorry, that password isn't valid. Please include a letter.", errMsg);
    }

    public void alphabets_error_message() {
        String errMsg = msgPassword.getText();
        Assert.assertEquals("Sorry, that password isn't valid. Please include something that isn't a letter.", errMsg);
    }

    public void password_too_long_error_message() {
        String errMsg = msgPassword.getText();
        Assert.assertEquals("Sorry, that password is too long. It can't be more than 50 characters.", errMsg);
    }
}
