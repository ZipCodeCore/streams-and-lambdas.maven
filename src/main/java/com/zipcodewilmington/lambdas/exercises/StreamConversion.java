package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.anthropoid.Person;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class StreamConversion extends ConversionAgent {
    private final Stream<Person> people;

    public StreamConversion(Stream<Person> people) {
        this.people = people;
    }

    // TODO
    public List<Person> toList() {
        return null;
    }

    // TODO
    public Stream<Person> toStream() {
        return this.people;
    }

    // TODO
    public Person[] toArray() {
        return null;
    }
}
