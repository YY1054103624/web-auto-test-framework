package org.example.utils;

/**
 * This class is for processing locators of {@link org.openqa.selenium.WebElement}.
 * <p></p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class LocatorUtils {
    private LocatorUtils() {

    }

    /**
     * Replace a part of xpath string by String.format()
     * @param dynamicXpath Original string.
     * @param strToReplace The string that is going to put into original string.
     * @return Replaced string.
     */
    public static String dynamicReplace(String dynamicXpath, String strToReplace) {
        return String.format(dynamicXpath, strToReplace);
    }
}
