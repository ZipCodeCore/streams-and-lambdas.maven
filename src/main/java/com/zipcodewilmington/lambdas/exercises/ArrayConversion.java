package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.anthropoid.Person;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConversion extends ConversionAgent {
    private final Person[] people;

    public ArrayConversion(Person... people) {
        this.people = people;
    }

    //TODO
    public Stream<Person> toStream() {
        return null;
    }

    @Override
    public Person[] toArray() {
        return this.people;
    }

    //TODO
    public List<Person> toList() {
        return null;
    }
}
