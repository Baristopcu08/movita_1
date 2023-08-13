package stepdefs;

import actions.ApplicationActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ApplicationSteps {

    @Given("user opens the homepage")
    public void openWebSite() throws IOException {
        (new ApplicationActions()).gotoHomeSite();
    }

    @Given("user login to site")
    public void logonToSite() throws IOException {
        (new ApplicationActions()).login();
    }

    @When("sleep {int}")
    public void sleep(int s) {
        try {
            Thread.sleep(s * 1000);
        } catch (Exception e) {
        }
    }
}
