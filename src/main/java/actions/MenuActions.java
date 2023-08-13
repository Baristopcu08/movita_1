package actions;

import controls.MenuControl;
import org.openqa.selenium.interactions.Actions;
import webdriver.DriverFactory;
import webdriver.DriverProvider;

public class MenuActions {

    public static void click(String... labels) {

        int max = labels.length - 1;
        for (int i = 0; i < labels.length; i++) {
            if (i < max) {
                new Actions(DriverProvider.getDriver()).moveToElement(MenuControl.fromLabel(labels[i]).get()).pause(100).perform();
            } else {
                MenuControl.fromLabel(labels[i]).click();
            }
        }
    }
}
