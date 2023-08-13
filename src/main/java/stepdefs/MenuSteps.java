package stepdefs;

import actions.MenuActions;
import io.cucumber.java.en.Given;

public class MenuSteps {
    @Given("User Clicks Menu {string}")
    public void clickOnMenu(String MenuText){
        MenuActions.click(MenuText);
    }
    @Given("User Clicks Menu {string} , {string}")
    public void clickOnMenu(String MenuText, String MenuText2){
        MenuActions.click(MenuText, MenuText2);
    }
}
