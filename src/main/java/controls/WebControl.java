package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverProvider;

import java.time.Duration;

abstract class WebControl {

    By controlRootLocator;
    WebDriver driver;
    WebDriverWait wait;
    String label = "";

    public WebControl(By locator) {
        controlRootLocator = locator;
        label = locator.toString();
        driver = DriverProvider.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
    }

    WebElement getRootElement() {
        WebElementHelper.waitAllRequest();
        WebElement rootElement = WebElementHelper.waitForControl(this.controlRootLocator);
        return rootElement;
    }


}
