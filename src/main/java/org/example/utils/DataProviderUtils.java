package org.example.utils;

import org.example.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is for providing test data for each test case.
 * <p></p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class DataProviderUtils {
    private DataProviderUtils() {

    }

    /**
     * This variable contains test data from Excel as list of map.
     */
    private static final List<Map<String, String>> allTestCases = ExcelUtils.getTestDataAsMapList(FrameworkConstants.getDataSheetName());

    /**
     * Filter test case by the Test method name that this test data is for and if it's marked as "execute".
     * @param methodObject Represent the Test method object the test data for.
     * @return Array of Object.
     */
    @DataProvider(parallel = true)
    public static Object[] getTestData(Method methodObject) {
        String methodName = methodObject.getName();
        List<Map<String, String>> filterCases = new ArrayList<>();
        for (int i = 0; i < allTestCases.size(); i++) {
            if (allTestCases.get(i).get("testname").equalsIgnoreCase(methodName)) {
                if (allTestCases.get(i).get("execute").equalsIgnoreCase("yes")) {
                    filterCases.add(allTestCases.get(i));
                }
            }
        }
        return filterCases.toArray();
    }
}
