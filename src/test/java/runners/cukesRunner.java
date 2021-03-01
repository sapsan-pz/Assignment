package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "rerun:target/re-run.txt",
        },
        tags = "@Packages&Flights",
        dryRun = false
)

public class cukesRunner extends AbstractTestNGCucumberTests {

}
