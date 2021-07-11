package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/searchSports.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-report"}
)
public class Runner {
}