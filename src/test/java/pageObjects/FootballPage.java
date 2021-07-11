package pageObjects;

import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FootballPage {


    public FootballPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"orb-nav-links\"]/ul/li[3]/a")
    @CacheLookup
    WebElement navSport;

    @FindBy(xpath = "/html/body/div[8]/div[1]/div/nav/div[1]/div/ul/li[2]/a")
    @CacheLookup
    WebElement navFootball;

    public void navigateToFootball() {
        navSport.click();
        navFootball.click();
    }
}