package org.example.annotations;

import org.example.enums.Author;
import org.example.enums.Category;

import java.lang.annotation.*;

/**
 * This annotation is for setting the author and category for each test case.
 * <p>
* 2023/8/28
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface FrameworkAnnotation {
    public Author[] authors();
    public Category[] categories();
}
