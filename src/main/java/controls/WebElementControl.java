package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;
import java.time.Duration;

public class WebElementControl extends WebControl {

    private final static String ELEMENT_XPATH = "(//*[. = \"{0}\"])[{1}]";
    public WebElementControl(By locator) {
        super(locator);
    }

    public static WebElementControl fromLabel(String label) {
        return fromLabel(label, 1);
    }

    public static WebElementControl fromLabel(String label, int no) {
        String xpath = MessageFormat.format(ELEMENT_XPATH, label, no);
        By locator = By.xpath(xpath);
        WebElementControl controller = new WebElementControl(locator);
        controller.label = label;
        return controller;        
    }

    public static ButtonControl fromLocator(By locator)  {
        ButtonControl control = new ButtonControl(locator);
        return control;
    }
    public void click() {
        WebElementHelper.click(controlRootLocator);
    }

    public void isVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(controlRootLocator));
    }
    
}
