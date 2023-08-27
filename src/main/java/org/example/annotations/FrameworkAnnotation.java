package org.example.annotations;

import org.example.enums.Author;
import org.example.enums.Category;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface FrameworkAnnotation {
    public Author[] authors();
    public Category[] categories();
}
