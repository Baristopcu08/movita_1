package utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestConfig {
    public final static String BROWSER_CHROME = "chrome";
    public final static String BROWSER_EDGE = "edge";
    public final static String BROWSER_FIREFOX = "firefox";

    Application application;
    Tests tests;


    @Getter
    @Setter
    @ToString
    public class Application {
        String name;
        String url;
        String user;
        String password;
        String admin;
        String adminpassword;

    }

    @Getter
    @Setter
    @ToString
    public class Tests {
        String browser = "chrome";
        ScreenshotMode screenshots = ScreenshotMode.failure;
    }

    public enum ScreenshotMode {
        all, failure
    }

}
