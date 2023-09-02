package org.example.enums;

/**
 * This class contains all the authors of test cases.
 * <p>
* 2023/8/28
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public enum Author {
    OSCAR("Oscar"),
    LEE("Lee"),
    JARRY("Jarry");

    private final String author;
    private Author(String author) {
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }
}
