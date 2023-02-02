package ru.academyit.javacore.lesson6.homework.task.properties;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Класс для хранения параметров с возможностью защиты от записи.
 */
public class SafeProperties {

    private final Properties properties = new Properties();
    private final Set<String> safeProperties = new HashSet<>();

    public String setProperty(String key, String value, boolean isSafe) {
        if (safeProperties.contains(key)) {
            return null;
        }
        if (!properties.containsKey(key)) {
            if (isSafe) {
                safeProperties.add(key);
            }
            return (String) properties.setProperty(key, value);
        }
        return null;
    }

    public String setProperty(String key, String value) {
        return setProperty(key, value, false);
    }

    public String setSafeProperty(String key, String value) {
        return setProperty(key, value, true);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getPropertyOrDefault(String key, String defaultValue) {
        String s = getProperty(key);
        return (s == null) ? defaultValue : s;
    }

}
