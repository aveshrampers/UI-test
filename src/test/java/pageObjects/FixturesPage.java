package pageObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FixturesPage {


    public FixturesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[8]/div[3]/div/div[3]/div/div/span/div/div[1]/ul/li/a/article/div/span[1]/span/span")
    @CacheLookup
    WebElement names;

    public void fnOutputMatches() {

        List<WebElement> n = names.findElements(By.xpath("/html/body/div[8]/div[3]/div/div[3]/div/div/span/div/div[1]/ul/li/a/article/div/span[1]/span/span"));
        for (WebElement e : n) {
            System.out.println(e.getText());
        }
    }
}