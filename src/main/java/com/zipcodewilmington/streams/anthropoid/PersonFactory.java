package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonFactory {
    private PersonFactory() {
        /** this class is not to be instantiated */
    }

    /**
     * @return a new instance of a person with fields of random values
     */
    public static Person createRandomPerson() {
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString('a', 'z', 4));
        String[] aliases = RandomUtils.createStrings('a', 'z', 5, 5);
        int age = RandomUtils.createInteger(0, 99);
        boolean isMale = RandomUtils.createBoolean(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);

        Person randomPerson = new Person(name, age, isMale, personalId, birthDate, aliases);
        PersonWarehouse.addPerson(randomPerson);
        return randomPerson;
    }

    /**
     * Section 8.8
     * @param listSize - number of Person objects to create
     * @return - ArrayList of Person objects
     */ // TODO
    public static List<Person> createPersonList(int listSize) {
        return createPersonStream(listSize).collect(Collectors.toList());
    }


    /**
     * @param arrayLength - number of Person objects to create
     * @return - Array of Person objects
     */ // TODO
    public static Person[] createPersonArray(int arrayLength) {
        return createPersonStream(arrayLength).toArray(Person[]::new);
    }


    /**
     * Section 8.2
     * @param streamCount - number of Person objects to create
     * @return - Stream representation of collection of Person objects
     */ // TODO
    public static Stream<Person> createPersonStream(int streamCount) {
        return Stream.generate(PersonFactory::createRandomPerson).limit(streamCount);
    }
}
