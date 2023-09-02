package org.example.selenoid;

import org.example.enums.ConfigProperties;
import org.example.utils.FileNameGenerator;
import org.example.utils.PropertiesUtils;

import java.util.Objects;

/**
 * This class if initializing video url object.
 * <p>
* 2023/9/1
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class VideoUrl {
    private VideoUrl() {

    }

    public static void initVideoUrl(String browser, String version, String testCaseName) {
        if (Objects.isNull(VideoUrlManager.get())) {
            VideoUrlManager.set(PropertiesUtils.getValue(ConfigProperties.VIDEOURL) +
                                FileNameGenerator.getSelenoidVideoFileName(browser, version, testCaseName));
        }
    }

    public static void removeVideoUrl() {
        if (Objects.nonNull(VideoUrlManager.get())) {
            VideoUrlManager.remove();
        }
    }
}
