package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestConfig;
import utils.TestConfiguration;
import webdriver.DriverProvider;

import java.io.IOException;

public class Hooks {


    @Before
    public void before() throws IOException {
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        DriverProvider.configure(config);
    }

    @After
    public void after(Scenario scenario) {
        DriverProvider.quit();
    }

}
