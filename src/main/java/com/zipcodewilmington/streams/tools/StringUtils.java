package com.zipcodewilmington.streams.tools;

/**
 * Created by leon on 5/24/17.
 */
public class StringUtils {
    /**
     * @param string - String to capitalize
     * @return - input String with first character capitalized
     */

    public static String capitalizeFirstChar(String string) {
        String firstChar = new Character(string.charAt(0)).toString();
        return string.replaceFirst(firstChar, firstChar.toUpperCase());
    }

    /**
     * @param numberOfRepeats - number of times to repeat this string
     * @param val - value of string to repeat
     * @return - `people` concatenated with itself `numberOfRepeats` times
     */
    public static String repeatString(int numberOfRepeats, String val) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numberOfRepeats; i++) {
            sb.append(val);
        }
        return sb.toString();
    }
}
