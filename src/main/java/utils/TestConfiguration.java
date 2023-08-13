package utils;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileReader;
import java.io.IOException;

public final class TestConfiguration {
    private static TestConfiguration instance;
    public static String ymlFilePath = "testconfig.yml";
    private TestConfig appConfig;

    private TestConfiguration() throws IOException {

        try {
            FileReader fileReader = new FileReader(ymlFilePath);
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            appConfig = om.readValue(fileReader, TestConfig.class);
            System.out.println(appConfig);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }


    public static TestConfiguration instance() throws IOException {
        instance = instance == null ? new TestConfiguration() : instance;
        return instance;
    }

    public TestConfig getTestConfiguration() {
        return appConfig;
    }
}
