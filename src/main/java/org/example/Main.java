package org.example;

import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String s = "admin123";
        String encodedStr = Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedStr);
        String decodedStr = new String(Base64.getDecoder().decode(encodedStr));
        System.out.println(decodedStr);
    }
}

