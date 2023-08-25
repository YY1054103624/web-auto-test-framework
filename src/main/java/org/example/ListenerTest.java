package org.example;

import org.testng.Assert;
import org.testng.annotations.*;

public class ListenerTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }
    @Test(invocationCount = 5)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(invocationCount = 2)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test
    public void test3() {
        System.out.println("Test 3");
        Assert.assertTrue(false);
    }
}
