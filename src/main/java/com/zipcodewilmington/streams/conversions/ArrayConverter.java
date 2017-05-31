package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {
    public ArrayConverter(Person... people) {
        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(PersonFactory.createPersonArray(collectionSize));
        /** Implementation of adapter pattern for testing purposes
         *  @param collectionSize  - length of Array to be generated */
    }

    //TODO
    public List<Person> toList() {
        return null;
    }

    //TODO
    public Stream<Person> toStream() {
        return null;
    }

    @Override
    public Person[] toArray() {
        return super.objectSequence;
    }
}
