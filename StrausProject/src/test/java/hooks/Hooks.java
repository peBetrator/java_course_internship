package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.LoggerFactory;
import testContext.TestContext;
import utilities.Logger;

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    Scenario scenario;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        logger.info("Scenario name:\n" + scenario.getName());
    }

    @After
    public void AfterSteps() throws IOException {
        testContext.getWebDriverManager().closeDriver();
    }

}
