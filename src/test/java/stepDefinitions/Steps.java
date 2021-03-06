package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.FootballPage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;
    FootballPage fixturesPage;
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

        fixturesPage = new FootballPage(driver);
        searchPage = new SearchPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Given("User navigates to {string}")
    public void open_url(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }

    @Then("All team names with a match today must be outputted")
    public void navigateToFootballPage() {
        fixturesPage.navigateToFootball();
        Assert.assertEquals("Football - BBC Sport", driver.getTitle());

    }

    //Output the first and last heading from search results
    @When("User clicks on search bar and searches for {string}")
    public void user_clicks_on_search_bar_and_searches_for_sports(String arg0) {
        searchPage.search(arg0);
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

    @After
    public void tearDown() {
        driver.quit();
    }

    @Then("Cant find email message must be displayed")
    public void cantFindEmailMessageMustBeDisplayed() {
        signInPage.cant_find_email_message();
    }
}
