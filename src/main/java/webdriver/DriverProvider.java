package webdriver;

import org.openqa.selenium.WebDriver;
import utils.TestConfig;

public class DriverProvider {

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
    private static final ThreadLocal<TestConfig> testConfig = new ThreadLocal<TestConfig>();

    private static String browser = null;

    public static String getBrowser() {
        return DriverProvider.browser;
    }

    public static void setBrowser(String browser) {
        DriverProvider.browser = browser;
    }

    public static void configure(TestConfig config) {
        testConfig.set(config);
    }


    public static WebDriver getDriver() {
        if(drivers.get() == null) {
            DriverFactory driverFactory = new DriverFactory();
            WebDriver driver = driverFactory.createDriver(testConfig.get());
            drivers.set(driver);
        }
        return drivers.get();
    }

    public static void quit() {
        boolean quitBrowser=true;
        if(quitBrowser && drivers.get() != null) {
            WebDriver driver = drivers.get();
            driver.quit();
            drivers.set(null);
        }
    }
}
