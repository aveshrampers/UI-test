package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Steps {

    WebDriver driver;

    HomePage homePage;
    SearchPage searchPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Given("User open url {string}")
    public void open_url(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }

    @When("User clicks on Sport menu")
    public void user_clicks_on_sport_menu() {
        homePage.NavigateToSportPage();
    }

    @Then("User clicks on Football menu")
    public void user_clicks_on_football_menu() {
        homePage.NavigateToFootballPage();
    }

    @Then("User clicks on Scores&Fixtures link")
    public void user_clicks_on_scores_fixtures_link() {
        homePage.NavigateToScoresAndFixturesPage();
    }

    @And("All team names with a match today must be outputted")
    public void output_all_fixtures() {
        homePage.fnOutputMatches();
    }

    //Output the first and last heading from search results
    @Then("User clicks on search bar and searches for sports")
    public void user_clicks_on_search_bar_and_searches_for_sports() {
        searchPage.search();
    }

    @Then("First and Last heading must be outputted")
    public void first_and_last_heading_must_be_outputted() {
        searchPage.fn_return_headings();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
