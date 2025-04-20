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
    private Person[] peopleArray = super.objectSequence;

    public ArrayConverter(Person... people) {
        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
//        this,objectSequence.

        return toStream()
                .collect(Collectors.toList());
    }

    //TODO
    public Stream<Person> toStream() {
        return Arrays.stream(peopleArray);
    }

    @Override
    public Person[] toArray() {
        return peopleArray;
    }
}
