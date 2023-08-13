package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.TestConfig;

import java.text.MessageFormat;

public class DriverFactory {

    private WebDriver newChromeDriver(TestConfig config) {
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    private WebDriver newEdgeDriver(TestConfig config) {
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver(options);
        return driver;
    }

    private WebDriver newFirefoxDriver(TestConfig config) {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        return driver;
    }

    public WebDriver createDriver(TestConfig config)  {
        WebDriver driver;
        String browser = config.getTests().getBrowser().toLowerCase();
        switch (browser) {
            case TestConfig.BROWSER_CHROME:
                driver = newChromeDriver(config);
                break;
            case TestConfig.BROWSER_EDGE:
                driver = newEdgeDriver(config);
                break;
            case TestConfig.BROWSER_FIREFOX:
                driver = newFirefoxDriver(config);
                break;
            default:
                throw new IllegalArgumentException(MessageFormat.format("browser {0} not supported", browser));
        }
        driver.manage().deleteAllCookies();
        return driver;
    }
}
