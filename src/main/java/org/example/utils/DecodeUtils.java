package org.example.utils;

import java.util.Base64;

/**
 * This class is for decoding string.
 * <p></p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class DecodeUtils {
    private DecodeUtils() {

    }

    /**
     * Decode string with Base64.
     * @param encodedString The string that is encoded.
     * @return Decoded string.
     */
    public static String getDecodedString(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString));
    }
}
