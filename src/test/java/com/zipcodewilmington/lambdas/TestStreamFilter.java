package com.zipcodewilmington.lambdas;

import com.zipcodewilmington.lambdas.anthropoid.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 5/2/17.
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

    private void testFilter(List<Person> persons) {
        for (Person p : persons) {
            assert (p.name.getValue().startsWith(streamFilter.startingCharacter));
        }
    }
}
