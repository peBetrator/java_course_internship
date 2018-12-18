package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

public class Main {
    @Given("^User has a file$")
    public void user_has_a_file() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        boolean exist = ReadFromFile.existFile();
        assertEquals(exist, true);
    }

    @Given("^User has a \"([^\"]*)\" class$")
    public void user_has_a_class(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        boolean exists = CheckClass.ifExists(arg1);
        assertEquals(exists, false);
    }

    @When("^User reads file$")
    public void user_reads_file() throws Exception {
        new ReadFromFile().ReadFile();
    }

    @When("^User splits data$")
    public void user_splits_data() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        new ReadFromFile().ReadFromFile();
    }

    @When("^User parses data to class$")
    public void user_parses_data_to_class() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        boolean exists = User.IfObjectWasCreated();
        assertEquals(exists, true);
    }

    @Then("^Data is displayed$")
    public void data_is_displayed() throws Exception {
        boolean exist = ReadFromFile.dataExists();
        assertEquals(exist, false);
    }

    @Then("^Class data is displayed$")
    public void class_data_is_displayed() throws Exception {
        new ReadFromFile().DisplayData();
    }

}
