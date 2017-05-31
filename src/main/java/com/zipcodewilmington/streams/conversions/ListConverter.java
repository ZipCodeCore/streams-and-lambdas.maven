package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ListConverter extends PersonConversionAgent<List<Person>> {
    public ListConverter(List<Person> people) {
        super(people);
    }

    public ListConverter(int collectionSize) {
        this(PersonFactory.createPersonList(collectionSize));
        /** Implementation of adapter pattern for testing purposes
         *  @param collectionSize  - size of List to be generated */
    }

    @Override
    public List<Person> toList() {
        return super.objectSequence;
    }

    //TODO
    public Stream<Person> toStream() {
        return toList().stream();
    }

    //TODO
    public Person[] toArray() {
        Long collectionSize = toStream().count();
        Person[] personArray = new Person[collectionSize.intValue()];
        return toList().toArray(personArray);
    }
}
