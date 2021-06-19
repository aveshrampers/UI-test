package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;

public class Steps {

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    SignInPage signInPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Given("User navigates to {string}")
    public void open_url(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }

    @Then("All team names with a match today must be outputted")
    public void output_all_fixtures() {
        homePage.fnOutputMatches();
    }

    //Output the first and last heading from search results
    @When("User clicks on search bar and searches for sports")
    public void user_clicks_on_search_bar_and_searches_for_sports() {
        searchPage.search();
    }

    @Then("First and Last heading must be outputted")
    public void first_and_last_heading_must_be_outputted() {
        searchPage.fn_return_headings();
    }

    //Negative Login Scenarios
    @When("User clicks on Sign In link")
    public void user_clicks_on_sign_in_link() throws InterruptedException {
        signInPage.NavigateToSignPage();
    }

    @And("^User enters a non registered (.*) and a (.*)$")
    public void user_enters_invalid_credentials(String userId, String password) {
        signInPage.enter_login_credentials(userId, password);
    }

    @Then("Cant find email message must be displayed")
    public void cant_find_email_message() {
        signInPage.cant_find_email_message();
    }

    @Then("Cant find username message must be displayed")
    public void cant_find_username_message() {
        signInPage.cant_find_username_message();
    }

    @Then("Error messages must be displayed")
    public void display_error_messages(){
        signInPage.blank_credential_message();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
