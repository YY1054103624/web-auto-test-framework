package org.example.enums;

public enum Category {
    SMOKE("Smoke"),
    REGRESSION("Regression"),
    MINIREGRESSION("MiniRegression");
    private final String category;

    private Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
