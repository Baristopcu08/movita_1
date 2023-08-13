package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;
import java.time.Duration;



public class ButtonControl extends WebControl {

    // site icindeki button locator türleri buraya yazilmali
    public static final String BUTTON = "//button[contains(., \"{0}\")]";
    public static final String LINK = "//a[contains(., \"{0}\")]";

    public ButtonControl(By locator) {
        super(locator);
    }

    public static ButtonControl fromLabel(String label) {
        return fromLabel(label, 1);
    }

    public static ButtonControl fromLabel(String label, int index)  {
        String buttonXpath = MessageFormat.format(BUTTON, label);
        String linkXpath = MessageFormat.format(LINK, label);

        String xpath = "((" +
                MessageFormat.format(buttonXpath, label) +
                ") | (" +
                MessageFormat.format(linkXpath, label) +
                "))[" + index +"]";

        By locator = By.xpath(xpath);
        ButtonControl control = new ButtonControl(locator);
        control.label = label;
        return control;
    }



    // button ile ilgili ihtiyac duyulan methodlar instance olarak bu class icine yazilmali
    // click, isVisible, isClickable, isInvisible, .......


    public void click() {
        WebElementHelper.click(controlRootLocator);
    }

    public boolean isVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(this.controlRootLocator));
            return true;
        } catch(Exception e) {
            return false;
        }
    }


}
