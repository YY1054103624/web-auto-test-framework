package org.example.listeners;

import org.example.constants.FrameworkConstants;
import org.example.utils.ExcelUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class ListenerAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        for(Map<String, String> map: ExcelUtils.getTestDataAsMapList()) {
            System.out.println(map.get("testname"));
            System.out.println(testMethod.getName());
            if (map.get("testname").equals(testMethod.getName()) && map.get("execute").equalsIgnoreCase("yes")) {
                annotation.setEnabled(true);
                annotation.setPriority(Integer.parseInt(map.get("priority")));
                annotation.setInvocationCount(Integer.parseInt(map.get("count")));
                annotation.setDescription(map.get("testdescription"));
            } else {
                annotation.setEnabled(false);
            }
        }
    }
}
