package run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@bookmark",
        plugin = {"pretty", "html:target/cucumber", "junit:target/surefire-reports/junit-report.xml"}
)

public class RunnerTestB {
}
