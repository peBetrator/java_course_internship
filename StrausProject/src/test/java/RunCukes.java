import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-reports",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html",
        "json:target/cucumber-report.json"},
        tags = {"@asserts"}, // add here scenarios you want to run
        glue = {"hooks","stepDefinition"},
        monochrome = true
)
public class RunCukes {
}