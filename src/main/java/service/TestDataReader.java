package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("github");

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
