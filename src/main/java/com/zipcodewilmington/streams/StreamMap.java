package com.zipcodewilmington.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 */
public class StreamMap {
    /**
     * Section 8.3
     *
     * @param someWord - word to convert to Stream<String>
     * @return - a Stream of single characters
     */
    public static Stream<String> letters(String someWord) {
        return Stream.of(someWord);
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */
    public static Stream<Stream<String>> wordsMap(String... someWords) {
        return Arrays.stream(someWords).map(StreamMap::letters);
    }

    /**
     * @param stringArray - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */
    public static Stream<String> wordsFlatMap(String... stringArray) {
        return Arrays.stream(stringArray).flatMap(StreamMap::letters);
    }
}