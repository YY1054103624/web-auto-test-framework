package org.example.constants;

import org.example.enums.ConfigProperties;
import org.example.utils.PropertiesUtils;

import java.io.File;

/**
 * Framework constants.
 * <p>
* 2023/8/28
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class FrameworkConstants {
    private static final String RESOURCE_DIR_PATH = System.getProperty("user.dir") + File.separator + "src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_DIR_PATH + File.separator + "config/config.properties";

    private static final int EXPLICITLY_DURATION = 10;
    private static final long TIMESTAMP = System.currentTimeMillis();
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "target/generated-reports";
    private static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + File.separator +"src/test/resources/excels/testdata.xlsx";
    private static final String RUNMANAGER_SHEET_NAME = "RUNMANAGER";
    private static final String DATA_SHEET_NAME = "DATA";
    private FrameworkConstants() {

    }
    public static String getExtentReportPath(ConfigProperties configProperties) {
        if (PropertiesUtils.getValue(configProperties).equalsIgnoreCase("yes")) {
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

    public static String getManagerSheetName() {
        return RUNMANAGER_SHEET_NAME;
    }

    public static String getDataSheetName() {
        return DATA_SHEET_NAME;
    }
}
