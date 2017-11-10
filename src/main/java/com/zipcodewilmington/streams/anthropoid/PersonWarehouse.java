package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.stream.Collector;
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
     */
    public static Stream<Person> getUniquelyNamedPeople() {
        /*
        HashMap<String, Person> uniqueMap = new HashMap<>();
        people.stream().forEach(p -> uniqueMap.put(p.getName(), p));
        return uniqueMap.entrySet().stream().map(e -> uniqueMap.get(e.getKey())).collect(Collectors.toList()).stream();
        */
        /*
        List<Person> allNames = people.stream().map(p -> p.getName()).collect(Collectors.toList());
        allNames = allNames.stream().distinct().collect(Collectors.toList());
        */

        return people.stream().collect(Collectors.toMap(Person::getName, p -> p, (p1, p2) -> p1)).values().stream();
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */
    public static Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        String startsWithChar = Character.toString(character);
        return getUniquelyNamedPeople().filter(p -> (p.getName().startsWith(startsWithChar)));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */
    public static Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        return getUniquelyNamedPeople().limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */
    public static Map<Long, String> getIdToNameMap() {
        return people.stream().collect(Collectors.toMap(p -> p.getPersonalId(), p -> p.getName()));
    }


    /**
     * @return Stream of Stream of Aliases
     */
    public static Stream<Stream<String>> getNestedAliases() {
        return people.stream().map(p -> Stream.of(p.getAliases()));
    }


    /**
     * @return Stream of all Aliases
     */
    public static Stream<String> getAllAliases() {
        return people.stream().flatMap(p -> Stream.of(p.getAliases()));
    }

    /**
     * @return list of names of Person objects
     */
    public static List<String> getNames() {
        return people.stream().map(p -> p.getName()).collect(Collectors.toList());
    }

    /**
     * @return ArrayList of all Person objects in this warehouse
     */
    public static ArrayList<Person> getPeople() {
        return people;
    }

}
