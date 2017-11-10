package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return people.stream().collect(Collectors.toMap(Person::getName, person -> person, (person, person2) -> person)).values().stream();
    }

    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return getUniquelyNamedPeople().filter(x -> x.getName().substring(0, 1).equals(character));
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
    public static Map<Long, String> getIdToNameMap() {
        return people.parallelStream().collect(Collectors.toMap(p -> p.getPersonalId(), p -> p.getName()));
        //this works but they want us to do it using the above way.
//        Stream<Person> personStream = people.stream();
//        Map<Long, String> myMap = new HashMap<>();
//        personStream.forEach(x -> myMap.put(x.getPersonalId(), x.getName()));
//        return myMap;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public static Stream<Stream<String>> getNestedAliases() {
        return null;
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public static Stream<String> getAllAliases() {
        return null;
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public static List<String> getNames() {
        return people.stream().map(Person::getName).collect(Collectors.toList());
    }

    /**
     * @return ArrayList of all Person objects in this warehouse
     */
    public static ArrayList<Person> getPeople() {
        return people;
    }

}
