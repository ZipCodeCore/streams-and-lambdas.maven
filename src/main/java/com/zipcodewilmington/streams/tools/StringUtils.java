package com.zipcodewilmington.streams.tools;

/**
 * Created by leon on 5/24/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
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
     * @param val             - value of string to repeat
     * @return - `people` concatenated with itself `numberOfRepeats` times
     */
    public static String repeatString(int numberOfRepeats, String val) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numberOfRepeats; i++) {
            sb.append(val);
        }
        return sb.toString();
    }

    /**
     * @param s the String to pad
     * @param n the padding amount
     * @return the padded-left String
     */
    public static String padLeft(Object s, int n) {
        return String.format("%1$" + n + "s", s);
    }


    /**
     * @param s the String to pad
     * @param n the padding amount
     * @return the padded-left String
     */
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
