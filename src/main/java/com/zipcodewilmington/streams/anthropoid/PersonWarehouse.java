package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonWarehouse implements Iterable<Person> {
    private final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private final List<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public List<String> getNames() {
        List<String> list = new ArrayList<>();
        people.stream().forEach((person) -> list.add(person.getName()));
        return list;

    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {
        List<String> listOfUniqueNames = people.stream()
                .map((person) -> person.getName())
                .distinct()
                .collect(Collectors.toList());
        return people.stream()
                .filter((person) -> {
                    if (listOfUniqueNames.contains(person.getName())) {
                        listOfUniqueNames.remove(person.getName());
                        return true;
                    }
                    return false;
                });
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return people.stream().filter((firstLetterOfName) -> firstLetterOfName.equals(character));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        List<String> listOfUniqueNames = people.stream()
                .map((person) -> person.getName())
                .distinct()
                .collect(Collectors.toList());
        return people.stream()
                .filter((person) -> {
                    if (listOfUniqueNames.contains(person.getName())) {
                        listOfUniqueNames.remove(person.getName());
                        return true;
                    }
                    return false;
                })
                .limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {
        Map<Long, String> map = new HashMap<>();
        people.stream().forEach((person) -> map.put(person.getPersonalId(), person.getName()));
        return map;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {
        Stream<String> nestedStream = people.stream().map((person) -> person.getAliases().toString());
        return Stream.of(nestedStream);
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        return people.stream().map((person) -> person.getAliases().toString());
    }

    // DO NOT MODIFY
    public Boolean contains(Person p) {
        return people.contains(p);
    }

    // DO NOT MODIFY
    public void clear() {
        people.clear();
    }

    // DO NOT MODIFY
    public int size() {
        return people.size();
    }

    @Override // DO NOT MODIFY
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
