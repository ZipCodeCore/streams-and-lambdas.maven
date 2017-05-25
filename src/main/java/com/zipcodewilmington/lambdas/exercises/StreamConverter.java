package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.anthropoid.Person;
import com.zipcodewilmington.lambdas.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Created by leon on 5/25/17.
 */
public final class StreamConverter extends ConversionAgent<Stream<Person>> {
    List<Person> personList;
    public StreamConverter(Stream<Person> people) {
        super(people);
        this.personList = super.people.collect(Collectors.toList());
    }

    public StreamConverter(int collectionSize) {
        this(PersonFactory.createPersonStream(collectionSize));
        /** Implementation of adapter pattern for testing purposes
         *  @param collectionSize  - count of Stream to be generated */
    }

    // TODO
    public List<Person> toList() {
        return this.personList;
    }

    // TODO
    public Stream<Person> toStream() {
        return this.personList.stream();
    }

    // TODO
    public Person[] toArray() {
        return toStream().toArray(Person[]::new);
    }
}
