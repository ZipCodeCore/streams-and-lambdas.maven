package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.conversions.StreamConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 */
public class StreamMap {
    /**
     * Section 8.3
     * @param someWord - word to convert to Stream<String>
     * @return - a Stream of single characters
     */ //TODO
    public static Stream<String> letters(String someWord) {
        return Stream.of(someWord);
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO
    public static Stream<Stream<String>> wordsMap(String... someWords) {
        return Stream.of(someWords).map(Stream::of);
        //return Stream.of(Stream.of(someWords)); //Is this more elegant? Does it do the same thing?
    }

    /**
     * @param stringArray - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO
    public static Stream<String> wordsFlatMap(String... stringArray) {
        return Stream.of(stringArray).flatMap(Stream::of);
    }
}