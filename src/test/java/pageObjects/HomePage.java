package pageObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.with;
import static org.junit.Assert.assertEquals;

public class HomePage {
    private static final String Base_Url = "https://push.api.bbci.co.uk";
    private static Response response;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"orb-nav-links\"]/ul/li[3]/a")
    @CacheLookup
    WebElement menuItemSport;

    @FindBy(xpath = "//*[@id=\"u4362927169702628\"]/div/nav/div[1]/div/ul/li[2]/a")
    @CacheLookup
    WebElement menuItemFootball;

    @FindBy(xpath = "//*[@id=\"sp-nav-secondary\"]/li[2]/a")
    @CacheLookup
    WebElement menuItemScoresAndFixtures;

    public void NavigateToSportPage() {
        menuItemSport.click();
    }

    public void NavigateToFootballPage() {
        menuItemFootball.click();
    }

    public void NavigateToScoresAndFixturesPage() {
        menuItemScoresAndFixtures.click();
    }

    public void fnOutputMatches() {
        RestAssured.baseURI = Base_Url;
        Response teams = given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("t","/data/bbc-morph-football-scores-match-list-data/endDate/2021-06-18/startDate/2021-06-18/todayDate/2021-06-18/tournament/full-priority-order/version/2.4.6?timeout=5")
                .get("/batch")
                .then().extract().response();
        assertEquals(200, teams.getStatusCode());
        String jsonString = teams.asString();
        System.out.println(jsonString);

        List<Map> otpGateway = with(jsonString)
                .get("tournamentDatesWithEvents.findAll {it -> it.Friday-18th-June.events != nullValue}.collect{[it.id]}");
        /*List<String> names = teams.jsonPath().("$.payload[0].body.matchData[0]");

        for(String i:names)
        {
            System.out.println(i);
        }*/
    }
}
