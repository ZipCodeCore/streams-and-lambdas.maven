package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.anthropoid.Person;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ListConversion extends ConversionAgent {
    private final List<Person> people;

    public ListConversion(List<Person> people) {
        this.people = people;
    }

    @Override
    public List<Person> toList() {
        return this.people;
    }

    //TODO
    public Stream<Person> toStream() {
        return null;
    }

    //TODO
    public Person[] toArray() {
        return null;
    }
}
