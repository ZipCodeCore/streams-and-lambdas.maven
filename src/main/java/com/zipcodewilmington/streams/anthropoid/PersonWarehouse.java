package com.zipcodewilmington.streams.anthropoid;

import Mohammed.Abrar.tools.ReflectionUtils;
import Mohammed.Abrar.tools.logging.LoggerHandler;
import Mohammed.Abrar.tools.logging.LoggerWarehouse;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonWarehouse {
    private static final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private static final ArrayList<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public static void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeople() {
        Map<String, Person> personMap = getPeople().stream()
                .collect(Collectors.toMap(Person::getName, person -> person, (a, b) -> a));

        return personMap.values().parallelStream();


    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        Stream<Person> personStreamWithUniqueName = getUniquelyNamedPeople().
                filter(person -> character.equals(person.getName().charAt(0)));

        return personStreamWithUniqueName;
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getFirstNUniquelyNamedPeople(int n) {


        return getUniquelyNamedPeople().limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public static Stream<Stream<String>> getNestedAliases() {

        Stream<Stream<String>> stringStreamStream = Stream.of(getAllAliases());
        return stringStreamStream;


    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public static Stream<String> getAllAliases() {
        return getPeople().stream().flatMap(aliases -> Arrays.stream(aliases.getAliases()));
    }

    /*
}

/**
 * @return list of names of Person objects
 */ // TODO
    public static List<String> getNames() {

        List<String> names = getPeople().stream().map(Person::getName).collect(toList());
        return names;
    }

    /**
     * @return ArrayList of all Person objects in this warehouse
     */
    public static ArrayList<Person> getPeople() {
        return people;
    }


}
