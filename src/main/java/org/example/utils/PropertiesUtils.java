package org.example.utils;

import org.example.constants.FrameworkConstants;
import org.example.enums.ConfigProperties;
import org.example.exceptions.ConfigFileIOException;
import org.example.exceptions.ConfigFileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * This class is for processing {@link java.util.Properties}.
 * <p></p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class PropertiesUtils {
    private PropertiesUtils() {

    }

    /**
     * The {@link java.util.Properties} object which is being processed.
     */
    private static final Properties properties = getPropertiesFromConfigFile();
    // HashTable - little slow, thread safe
    // HashMap - faster, but not thread safe, and converting properties to hashMap needs some time

    /**
     * Load config.properties file into properties object.
     * @return The Properties object.
     */
    public static Properties getPropertiesFromConfigFile() {
        Properties configProperties = new Properties();
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());){
            configProperties.load(fis);
        } catch (FileNotFoundException e) {
            throw new ConfigFileNotFoundException("config.properties is not found, please check the file path.", e);
        } catch (IOException e) {
            throw new ConfigFileIOException("There's an io exception with config file.", e);
        }
        return configProperties;
    }

    /**
     * Get value config.properties by properties object.
     * @param keyEnum {@link org.example.enums.ConfigProperties}
     * @return Value from config.properties as String.
     */
    public static String getValue(ConfigProperties keyEnum) {
        if (Objects.isNull(keyEnum)) {
            throw new NullPointerException("The key provided is null.");
        }
        return properties.getProperty(keyEnum.name().toLowerCase()).trim();
    }
}
