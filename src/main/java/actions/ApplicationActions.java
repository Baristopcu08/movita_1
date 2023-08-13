package actions;

import controls.ButtonControl;
import controls.TextfieldControl;
import org.openqa.selenium.WebDriver;
import utils.TestConfig;
import utils.TestConfiguration;
import webdriver.DriverProvider;

import java.io.IOException;

public class ApplicationActions {

    TestConfig config;

    public void gotoHomeSite() throws IOException {
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        String url = config.getApplication().getUrl();
        DriverProvider.configure(config);
        WebDriver driver = DriverProvider.getDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void login() throws IOException {
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        String username = config.getApplication().getUser();
        String password = config.getApplication().getPassword();
        login(config, username, password);
    }

    private void login(TestConfig config, String username, String password) throws IOException {
        gotoHomeSite();
        TextfieldControl.fromLabel("Username").setText(username);
        TextfieldControl.fromLabel("Password").setText(password);
        ButtonControl.fromLabel("Login").click();

    }
}
