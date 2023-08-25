package org.example.listeners;

import org.example.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.*;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> testSet = new ArrayList<>();
        List<Map<String, String>> methods = ExcelUtils.getTestDataAsMapList();
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
