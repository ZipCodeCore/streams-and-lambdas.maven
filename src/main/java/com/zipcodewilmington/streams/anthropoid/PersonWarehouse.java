package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

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
        loggerHandler.disablePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeople() {
        return ( people.stream().collect(
                                        Collectors.toMap(
                                                        Person::getName,//Our key for this map is the Person's name.
                                                                            //Keys must be unique identifiers
                                                        p->p,           //Our value is the Person instance itself.
                                                        (p,q) ->p)      //If two values have the same key, choose the
                                                                            //first encountered
                                        ).values().stream() );          //Get the values from the map and stream them
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return (getUniquelyNamedPeople().filter(p -> p.name.charAt(0)==character));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        return (getUniquelyNamedPeople().limit(n));
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public static Map<Long, String> getIdToNameMap() {
        return (getUniquelyNamedPeople().collect(Collectors.toMap(Person::getPersonalId, Person::getName)));
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public static Stream<Stream<String>> getNestedAliases() {

        Stream < Stream<String> > streamOfStreamStrings = Stream.of(people.stream().flatMap(Person::getAliases).distinct());

        return streamOfStreamStrings;
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public static Stream<String> getAllAliases() {

//        Stream<Person> p = people.stream().filter(u -> u.getAliases().length>0);
//        Stream<String> s = p.map(o->o.getAliases());//(o -> o.getAliases());
//        return (s);
        return null;
        //
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public static List<String> getNames() {
        return null;
    }

    /**
     * @return ArrayList of all Person objects in this warehouse
     */
    public static ArrayList<Person> getPeople() {
        return people;
    }

}
