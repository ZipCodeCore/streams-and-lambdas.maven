package com.zipcodewilmington.lambdas.tools.anthropoid;

import com.zipcodewilmington.lambdas.tools.RandomUtils;
import com.zipcodewilmington.lambdas.tools.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 */
public class PersonFactory {
    /**
     * @return a new instance of a person with randomized fields
     */
    public static Person createRandomPerson() {
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString('a', 'z', 10));
        int age = RandomUtils.createInteger(0, 99);
        boolean isMale = RandomUtils.chance(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);

        Person randomPerson = new Person(name, age, isMale, personalId, birthDate);
        return randomPerson;
    }

    /**
     * @param personCount - number of Person objects to create
     * @return - ArrayList of Person objects
     */
    public static List<Person> createPersonList(int personCount) {
        return createPersonStream(personCount).collect(Collectors.toList());
    }


    /**
     * @param personCount - number of Person objects to create
     * @return - Array of Person objects
     */
    public static Person[] createPersonArray(int personCount) {
        return createPersonStream(personCount).toArray(Person[]::new);
    }


    /**
     * @param personCount - number of Person objects to create
     * @return - Stream representation of collection of Person objects
     */
    public static Stream<Person> createPersonStream(int personCount) {
        return Stream.generate(PersonFactory::createRandomPerson).limit(personCount);
    }
}
