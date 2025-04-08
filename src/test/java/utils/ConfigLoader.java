package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load config file: " + CONFIG_FILE, ex);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static int getDefaultTimeout() {
        return Integer.parseInt(properties.getProperty("default.timeout"));
    }

}
