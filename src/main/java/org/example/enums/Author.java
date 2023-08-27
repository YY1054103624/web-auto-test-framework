package org.example.enums;

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
