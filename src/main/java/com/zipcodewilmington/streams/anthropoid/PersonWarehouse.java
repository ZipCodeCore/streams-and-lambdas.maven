package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
        return stream().filter(distinctByKey(Person::getName));
    }

    /**
     * All mother, are you awake?
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyEntityExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyEntityExtractor.apply(t));
    }

    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ // if you insist this must be a char comparison, I wish you well during the trials to come.
    public static Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return getUniquelyNamedPeople().filter(p -> p.getName().charAt(0) == character);
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
        return stream().collect(Collectors.toMap(Person::getPersonalId, Person::getName));
    }


    /**
     * @return Stream of Stream of Aliases
     */
    public static Stream<Stream<String>> getNestedAliases() {
        return stream().map(p -> Stream.of(p.getAliases()));
    }


    /**
     * @return Stream of all Aliases
     */
    public static Stream<String> getAllAliases() {
        return stream().flatMap(p -> Stream.of(p.getAliases()));
    }

    /**
     * @return list of names of Person objects
     */
    public static List<String> getNames() {
        return stream().map(Person::getName).collect(Collectors.toList());
    }

    /**
     * @return ArrayList of all Person objects in this warehouse
     */
    public static ArrayList<Person> getPeople() {
        return people;
    }

    public static Stream<Person> stream() {
        return people.stream();
    }
}
