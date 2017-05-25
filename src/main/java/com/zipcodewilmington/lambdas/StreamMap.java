package com.zipcodewilmington.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 */
public class StreamMap {
    /**
     * @param someWord - word to convert to Stream<String>
     * @return - a Stream of single characters
     */
    public static Stream<String> letters(String someWord) {
        return Stream.of(someWord.split(""));
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */
    public static Stream<Stream<String>> wordsMap(String... someWords) {
        return Stream.of(someWords).map(w -> letters(w));
    }

    public static Stream<Stream<String>> wordsFlatMap(String... someWords) {
        return null;//Arrays.asList(someWords).stream().flatMap(w -> letters(w));
    }
}