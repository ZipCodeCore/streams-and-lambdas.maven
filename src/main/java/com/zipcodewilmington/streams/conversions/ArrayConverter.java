package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {

    private Person[] personList;

    public ArrayConverter(Person... people) {
        super(people);
        personList = super.objectSequence;
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
        return Arrays.stream(personList).collect(Collectors.toList());
    }

    //TODO
    public Stream<Person> toStream() {
        return Arrays.stream(personList);
    }

    @Override
    public Person[] toArray() {
        return Arrays.stream(super.objectSequence).toArray(Person[]::new);
    }
}
