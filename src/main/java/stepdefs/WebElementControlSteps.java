package stepdefs;

import controls.WebElementControl;
import io.cucumber.java.en.Then;

public class WebElementControlSteps {
    @Then("should be visible {string}")
    public void shouldBeVisible(String value) {
        WebElementControl.fromLabel(value,1).isVisible();
    }
}
