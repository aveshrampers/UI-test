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

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

        List<Map> names = with(jsonString)
                .get("tournamentDatesWithEvents.findAll {it -> it.Friday-18th-June.events != nullValue}.collect{[it.id]}");
        /*List<String> names = teams.jsonPath().("$.payload[0].body.matchData[0]");

        for(String i:names)
        {
            System.out.println(i);
        }*/
    }
}
