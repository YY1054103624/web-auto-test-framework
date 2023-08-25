package org.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssertJExampleTest {
    @Test
    public void stringTest() {
        String temp = "";

        Assertions.assertThat(temp)
                .withFailMessage("String is empty!").isNotEmpty()
                .isNotBlank()
                .contains("Hello")
                .isEqualTo("Hello world")
                .containsWhitespaces()
                .containsIgnoringCase("world")
                .matches(".*" + " world")
                .hasSizeGreaterThan(10)
                .hasSize(11)
                .endsWith("world");
    }

    @Test
    public void numberTest() {
        int a = 10;
        Assertions.assertThat(a)
                .isEqualTo(10)
                .isBetween(3, 15)
                .isPositive()
                .isGreaterThan(5);
    }

    @Test
    public void listTest() {
        List<String> list = Arrays.asList("Testing", "Mini", "Bytes");

        Assertions.assertThat(list)
                .hasSize(3)
                .hasSizeBetween(2, 15)
                .isNotEmpty()
                .contains("Testing")
                .doesNotContainSequence("Automation")
                .startsWith("Testing")
                .containsExactly("Testing", "Mini", "Bytes");
    }

    @Test
    public void mapTest() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Amuthan");

        Assertions.assertThat(map)
                .containsEntry("name", "Amuthan")
                .hasSize(3)
                .isNotEmpty()
                .doesNotContainEntry("Fav", "football")
                .containsKey("channel")
                .containsValue("Cricket");
    }

    @Test
    public void objectTest() {

    }

    @Test
    public void assertSoftlyTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat("Hello world")
                .isNotEmpty()
                .hasSize(5)
                .contains("Hello");

        softAssertions.assertAll();
    }
}
