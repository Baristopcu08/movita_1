package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.MessageFormat;

public class TextfieldControl extends WebControl {

    public static final String INPUT = "//input[@name=\"{0}\"]";
    public static final String SPAN = "//span[contains(.,\"{0}\")]";

    public TextfieldControl(By locator) {
        super(locator);
    }

    public static TextfieldControl fromLabel(String label) {
        return fromLabel(label, 1);
    }
    public static TextfieldControl fromLabel(String label, int no) {

        String xpath = "((" +
                MessageFormat.format(INPUT, label) +
                ") | (" +
                MessageFormat.format(SPAN, label) +
                "))[" + no +"]";


        By textFieldLocator = By.xpath(xpath);
        TextfieldControl control = new TextfieldControl(textFieldLocator);
        control.label = label;
        return control;
    }


    public static TextfieldControl fromLocator(By locator) {
        TextfieldControl control = new TextfieldControl(locator);
        return control;
    }

    public void setText(String text){
        setText(text, true);
    }

    public void setText(String text, boolean clear){

        WebElement rootElement = getRootElement();
        if (clear) {
            rootElement.clear();
        }
        WebElementHelper.click(this.controlRootLocator);
        rootElement.sendKeys(text);
    }

    public String getText() {
        WebElement rootElement = getRootElement();
        return rootElement.getAttribute("value");
    }

    public void waitForValue(String waitForValue){
        WebElement rootElement = getRootElement();
        String finalWaitForValue = waitForValue;
        try {
            wait.until((driver) -> {
                String value = rootElement.getAttribute("value");
                value = value == null ? "" : value.trim();
                boolean eq = finalWaitForValue.equals(value);
                return eq;
            });
        } catch (TimeoutException toe) {
            Assert.fail("Field has not been initialized with the required value.");
        }
    }

    public void waitForNotEmpty() {
        WebElement rootElement = getRootElement();
        wait.until((driver) -> {
            String value = rootElement.getAttribute("value");
            value = value == null ? "" : value.trim();
            boolean eq = value.trim().length() > 0;
            return eq;
        });
    }

    public void waitForContainsValue(String waitForValue) {
        WebElement rootElement = getRootElement();
        String finalWaitForValue = waitForValue;
        wait.until((driver) -> {
            String value = rootElement.getAttribute("value");
            value = value == null ? "" : value.trim();
            boolean eq = value.contains(finalWaitForValue);
            return eq;
        });
    }

}
