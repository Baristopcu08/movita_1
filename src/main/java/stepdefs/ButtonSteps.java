package stepdefs;

import actions.ButtonActions;
import io.cucumber.java.en.When;

public class ButtonSteps {

    @When("user clicks the {string} button")
    public void clickButton(String label) {
        ButtonActions.click(label);
    }

}
