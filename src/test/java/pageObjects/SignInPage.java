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
}
