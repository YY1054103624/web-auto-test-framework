package org.example.enums;

/**
 * This class all the categories of test cases.
 * <p>
* 2023/8/28
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
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
