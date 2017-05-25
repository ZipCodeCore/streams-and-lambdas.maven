package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.anthropoid.Person;
import com.zipcodewilmington.lambdas.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ListConverter extends ConversionAgent<List<Person>> {
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
        return this.people;
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
