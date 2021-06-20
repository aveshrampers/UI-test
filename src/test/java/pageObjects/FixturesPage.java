package pageObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FixturesPage {
    private static final String Base_Url = "https://push.api.bbci.co.uk";

    public FixturesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fnOutputMatches() {
        RestAssured.baseURI = Base_Url;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = formatter.format(date);

        Response teams = given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("t", "/data/bbc-morph-football-scores-match-list-data/endDate/" + currentDate + "/startDate/" + currentDate + "/todayDate/" + currentDate + "/tournament/full-priority-order/version/2.4.6?timeout=5")
                .get("/batch")
                .then().extract().response();

    }
}