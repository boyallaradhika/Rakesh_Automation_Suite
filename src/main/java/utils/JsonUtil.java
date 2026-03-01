package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.testdata.LoginTestData;

import java.io.InputStream;

public class JsonUtil {
    private static final LoginTestData LOGIN_TEST_DATA;
    static {
        try {

            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonUtil.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/LoginPageTestData.json");

            LOGIN_TEST_DATA= mapper.readValue(
                    is,
                    new TypeReference<LoginTestData>() {}
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
    public static LoginTestData getloginTestData() {
        return LOGIN_TEST_DATA;
    }
}

