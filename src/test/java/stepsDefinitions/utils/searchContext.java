package stepsDefinitions.utils;

import java.util.HashMap;
import java.util.Map;

public class searchContext {
    private static final Map<String, Object> scenarioContext = new HashMap<>();

    // Store a value in context
    public static void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    // Retrieve a value from context
    public static String getContext(String key) {
        return (String) scenarioContext.get(key);
    }
}