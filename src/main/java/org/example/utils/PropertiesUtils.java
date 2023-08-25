package org.example.utils;

import org.example.constants.FrameworkConstants;
import org.example.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtils {
    private PropertiesUtils() {

    }

    private static final Properties properties = new Properties();;
    // HashTable - little slow, thread safe
    // HashMap - faster, but not thread safe, and converting properties to hashMap needs some time

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(ConfigProperties keyEnum) throws Exception {
        return properties.getProperty(keyEnum.name().toLowerCase()).trim();
    }
}
