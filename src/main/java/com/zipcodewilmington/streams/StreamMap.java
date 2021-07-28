package com.zipcodewilmington.streams;

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
     */ //TODO - done
    public static Stream<String> letters(String someWord) {
        return Stream.of(someWord.split(""));
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO - done
    public static Stream<Stream<String>> wordsMap(String... someWords) {
        return Stream.of(someWords).map(word -> letters(word));
        //return Stream.of(wordsFlatMap(someWords));

    }

    /**
     * @param stringArray - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO - done
    public static Stream<String> wordsFlatMap(String... stringArray) {
        //return Stream.of(stringArray);
        Stream<String> wordStream = Stream.of(stringArray);
        List<String> wordList = wordStream.collect(Collectors.toList());
        return wordList.stream().flatMap(w -> letters(w));
    }
}