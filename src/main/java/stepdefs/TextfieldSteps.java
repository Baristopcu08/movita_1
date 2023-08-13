package stepdefs;

import actions.TextfieldActions;
import io.cucumber.java.en.When;

public class TextfieldSteps {

    @When("user into the field {string} enters the value {string}")
    public void enterValueToField(String name, String value) {
        TextfieldActions.setText(name, value);
    }

    @When("user into the {int}. field {string} enters the value {string}")
    public void enterValueToFieldNumber(int no, String name, String wert) {
        TextfieldActions.setText(name, wert, no);
    }

}
