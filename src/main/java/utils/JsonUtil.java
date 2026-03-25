package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static <T> T getJsonData(String path, TypeReference<T> typeReference) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonUtil.class
                    .getClassLoader()
                    .getResourceAsStream(path);

            return mapper.readValue(
                    is,
                    typeReference
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }

    public static <T> T getTestDataFromList(Map<String, T> testDataList, String testCaseName) {
        return testDataList.get(testCaseName);
    }
}

