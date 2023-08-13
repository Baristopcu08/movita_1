package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.MessageFormat;

public class MenuControl extends WebControl {

    public static final String MENU = "//a[@class=\"menu-item\"][contains(., \"{0}\")] | //a[@class=\"menu-link\"][contains(., \"{0}\")]";


    public MenuControl(By locator) {
        super(locator);
    }

    public static MenuControl fromLabel(String label) {
        return fromLabel(label, 1);
    }
    public static MenuControl fromLabel(String label, int no) {

        String xpath = "((" +
                MessageFormat.format(MENU, label) +
                "))[" + no +"]";


        By textFieldLocator = By.xpath(xpath);
        MenuControl control = new MenuControl(textFieldLocator);
        control.label = label;
        return control;
    }


    public static MenuControl fromLocator(By locator) {
        MenuControl control = new MenuControl(locator);
        return control;
    }


    public String getText() {
        WebElement rootElement = getRootElement();
        return rootElement.getAttribute("value");
    }

    public void click() {
        WebElementHelper.click(controlRootLocator);
    }

    public WebElement get(){
        return getRootElement();
    }
}
