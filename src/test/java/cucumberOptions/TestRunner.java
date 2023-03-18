package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue="stepDefinations", tags = {"@DeletePlace"})

public class TestRunner {

}

// plugin = {"pretty","html:target/cucumber-reports"}