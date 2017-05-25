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
    private StreamFilter lambdaFilter;

    @Before
    public void setup() {
        lambdaFilter = new StreamFilter();
    }

    @Test
    public void testToListMultiLine() {
        testFilter(lambdaFilter.toListMultiLine());
    }

    @Test
    public void testToListOneLine() {
        testFilter(lambdaFilter.toListOneLine());
    }

    @Test
    public void testToArrayMultiLine() {
        testFilter(lambdaFilter.toArrayMultiLine());
    }

    @Test
    public void testToArrayOneLine() {
        testFilter(lambdaFilter.toArrayOneLine());
    }




    private void testFilter(Person[] persons) {
        testFilter(Arrays.asList(persons));
    }

    private void testFilter(List<Person> persons) {
        for (Person p : persons) {
            assert (p.name.getValue().startsWith(lambdaFilter.startingCharacter));
        }
    }
}
