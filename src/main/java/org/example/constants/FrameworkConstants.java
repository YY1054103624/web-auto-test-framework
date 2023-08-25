package org.example.constants;

import org.example.enums.ConfigProperties;

import java.io.File;

public final class FrameworkConstants {
    private static final String RESOURCE_DIR_PATH = System.getProperty("user.dir") + File.separator + "src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_DIR_PATH + File.separator + "config/config.properties";

    private static final int EXPLICITLY_DURATION = 10;
    private static final long TIMESTAMP = System.currentTimeMillis();
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "target/generated-reports";
    private static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + File.separator +"src/test/resources/excels/testdata.xlsx";
    private FrameworkConstants() {

    }
    public static String getExtentReportPath(ConfigProperties configProperties) {
        if (configProperties.name().toLowerCase().equalsIgnoreCase("yes")) {
            return EXTENT_REPORT_FOLDER_PATH + File.separator + "index.html";
        } else {
            return EXTENT_REPORT_FOLDER_PATH + File.separator + TIMESTAMP + "-index.html";
        }
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitlyDuration() {
        return EXPLICITLY_DURATION;
    }

    public static String getExcelFilePath() {
        return EXCEL_FILE_PATH;
    }
}
