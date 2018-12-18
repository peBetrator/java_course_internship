import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-reports" },
        tags = {"@mnegal"}, // add here scenarios you want to run
        glue = {"StepDefinition"}
)
public class RunCukes {
}
