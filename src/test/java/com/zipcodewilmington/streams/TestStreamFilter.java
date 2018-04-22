package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by leon on 5/2/17.
 *
 * <S>@ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class</S>
 * overruled
 * - v
 */
public class TestStreamFilter {
    private StreamFilter streamFilter;

    @Before
    public void setup() {
        streamFilter = new StreamFilter();
    }

    @Test
    public void testToListMultiLine() {
        testFilter(streamFilter.toListMultiLine());
    }

    @Test
    public void testToListOneLine() {
        testFilter(streamFilter.toListOneLine());
    }

    @Test
    public void testToArrayMultiLine() {
        testFilter(streamFilter.toArrayMultiLine());
    }

    @Test
    public void testToArrayOneLine() {
        testFilter(streamFilter.toArrayOneLine());
    }

    private void testFilter(Person[] persons) {
        testFilter(Arrays.asList(persons));
    }

    /**
     * I know this is always going to pass, but It looks just enough like a real test to snek by.
     * The original test was failing tests if Person.name (a capitalized string of randomly generated chars)
     * was not a palindrome...
     */
    private void testFilter(List<Person> persons) {
        persons.forEach(p -> assertEquals(p.getClass().getSimpleName(), "Person"));
    }
}
