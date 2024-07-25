package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps", "utils"},
        plugin = {"json:target/cucumber.json", "pretty"},
        tags = "@regressionTest"
)
public class testRunner extends AbstractTestNGCucumberTests {
}
