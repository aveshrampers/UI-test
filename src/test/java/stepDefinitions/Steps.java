package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.FixturesPage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;
    FixturesPage fixturesPage;
    SearchPage searchPage;
    SignInPage signInPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        fixturesPage = new FixturesPage(driver);
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
        fixturesPage.fnOutputMatches();
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
    public void display_error_messages() {
        signInPage.blank_credential_message();
    }

    @Then("Incorrect error message must be displayed")
    public void login_with_incorrect_password_message() {
        signInPage.incorrect_password();
    }

    @Then("Special characters not allowed error message must be displayed")
    public void login_with_special_characters() {
        signInPage.using_special_characters_message();
    }

    @Then("Username too short error message must be displayed")
    public void login_with_a_single_character() {
        signInPage.single_character_error_message();
    }

    @Then("Email does not look right error message must be displayed")
    public void login_with_incomplete_email() {
        signInPage.incomplete_email_error_message();
    }

    @Then("Username too long error message must be displayed")
    public void login_with_username_too_long() {
        signInPage.username_too_long_error_message();
    }

    @Then("Password too short error message must be displayed")
    public void login_with_password_too_short() {
        signInPage.password_too_short_error_message();
    }

    @Then("Password isn't valid error message must be displayed")
    public void login_with_only_numeric_password() {
        signInPage.numeric_error_message();
    }

    @Then("Invalid password error message must be displayed")
    public void login_with_only_alphabets_as_password() {
        signInPage.alphabets_error_message();
    }

    @Then("Password is too long error message must be displayed")
    public void login_with_password_too_long() {
        signInPage.password_too_long_error_message();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
