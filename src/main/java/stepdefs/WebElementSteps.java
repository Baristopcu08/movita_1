package stepdefs;

import actions.WebElementActions;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class WebElementSteps {

    @When("user clicks with locator type {string} and locator value {string}")
    public void clickButtonLocator(String type, String value) {
        By locator;
        switch (type.toLowerCase()) {
            case "xpath" -> locator = By.xpath(value);
            case "css", "cssselector" -> locator = By.cssSelector(value);
            case "id" -> locator = By.id(value);
            case "tagname" -> locator = By.tagName(value);
            case "class", "classname" -> locator = By.className(value);
            case "linktext" -> locator = By.linkText(value);
            case "partial", "partiallinktext" -> locator = By.partialLinkText(value);
            default -> throw new RuntimeException("unrecogrized locator definition");

        }
        WebElementActions.click(locator);
    }
}
