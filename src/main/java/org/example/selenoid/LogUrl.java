package org.example.selenoid;

import org.example.enums.ConfigProperties;
import org.example.utils.FileNameGenerator;
import org.example.utils.PropertiesUtils;

import java.util.Objects;

/**
 * This class if initializing log url object.
 * <p>
* 2023/9/1
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class LogUrl {
    private LogUrl() {

    }

    public static void initLogUrl(String browser, String version, String testCaseName) {
        if (Objects.isNull(LogUrlManager.get())) {
            LogUrlManager.set(PropertiesUtils.getValue(ConfigProperties.LOGURL) +
                                FileNameGenerator.getSelenoidLogFileName(browser, version, testCaseName));
        }
    }

    public static void removeLogUrl() {
        if (Objects.nonNull(VideoUrlManager.get())) {
            VideoUrlManager.remove();
        }
    }
}
