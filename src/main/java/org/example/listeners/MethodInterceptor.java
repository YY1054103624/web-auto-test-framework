package org.example.listeners;

import org.example.constants.FrameworkConstants;
import org.example.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.*;

/**
 * Implementation of {@link IMethodInterceptor}
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class MethodInterceptor implements IMethodInterceptor {
    /**
     * Filter test cases that are going to be executed with Excel file.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> testSet = new ArrayList<>();
        List<Map<String, String>> methods = ExcelUtils.getTestDataAsMapList(FrameworkConstants.getManagerSheetName());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < methods.size(); j++) {
                if (list.get(i).getMethod().getMethodName().equalsIgnoreCase(methods.get(j).get("testname")) &&
                methods.get(j).get("execute").equalsIgnoreCase("yes")) {
                    list.get(i).getMethod().setInvocationCount(Integer.parseInt(methods.get(j).get("count")));
                    list.get(i).getMethod().setDescription(methods.get(j).get("testdescription"));
                    list.get(i).getMethod().setPriority(Integer.parseInt(methods.get(j).get("priority")));
                    testSet.add(list.get(i));
                }
            }
        }
        return testSet;
    }
}
