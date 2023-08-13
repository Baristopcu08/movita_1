package controls;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverProvider;

import java.time.Duration;

public class WebElementHelper {

    private final static Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(30);

    public static WebElement waitForControl(By locator) {

        WebDriver driver = DriverProvider.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(locator));

        return element;
    }


    public static WebElement waitForControlElement(WebElement control, By locator) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), DEFAULT_WAIT_TIME);
        WebElement element = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(control, locator));
        return element;
    }


    public static void clear(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), DEFAULT_WAIT_TIME);
        wait.until((driver) -> {
            try {
                WebElement elem = driver.findElement(locator);
                elem.clear();
                return true;
            } catch (InvalidElementStateException | NoSuchElementException ice) {
                return false;
            }
        });
    }

    public static void click(By locator) {

        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), DEFAULT_WAIT_TIME, Duration.ofMillis(20));
        WebElement element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch(ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until((driver) -> {
                try {
                    WebElement element2 = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                    wait.until(ExpectedConditions.elementToBeClickable(element2));
                    element2.click();
                    return true;
                } catch (ElementClickInterceptedException | StaleElementReferenceException ice) {
                    return false;
                }
            });
        }
    }

    public static void click(final WebElement rootElement, By locator) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), DEFAULT_WAIT_TIME);
        wait.until((driver) -> {
            try {
                WebElement elem = rootElement.findElement(locator);
                if (elem.isDisplayed() && elem.isEnabled()) {
                    elem.click();
                    return true;
                }
                return false;
            } catch (ElementClickInterceptedException | StaleElementReferenceException ice) {
                return false;
            }
        });
    }


    public static void waitMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
        }
    }


    private static void waitUntilJSReady() {
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) DriverProvider.getDriver())
                    .executeScript("return document.readyState").toString().equals("complete");
            JavascriptExecutor jsExec = (JavascriptExecutor) DriverProvider.getDriver();
            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals(
                    "complete");
            WebDriverWait jsWait = new WebDriverWait(DriverProvider.getDriver(),
                    Duration.ofSeconds(10));
            if (!jsReady) {
                jsWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }


    public static void waitAllRequest() {

        waitUntilJSReady();
    }

    public static void scrollIntoView(By locator){
        WebDriver driver = DriverProvider.getDriver();
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(false);", driver.findElement(locator)
        );
    }

    public static void scrollDownUntilVisible(WebElement panel, By itemLocator){
        WebDriver driver = DriverProvider.getDriver();
        new Actions(driver)
                .moveToElement(panel)
                .click()
                .perform();
        int i = 0;
        while (!driver.findElement(itemLocator).isDisplayed()) {
            new Actions(driver)
                    .sendKeys(Keys.PAGE_DOWN)
                    .build()
                    .perform();
            if (i++>20)
                break;
        }
    }

}
