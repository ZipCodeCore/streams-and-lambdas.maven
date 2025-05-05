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
     */ // TODO - done
    public List<String> getNames() {
        return people.stream().map(Person::getName).collect(Collectors.toList());
    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO - done
    public Stream<Person> getUniquelyNamedPeople() {
        List<String> nameList = getNames().stream().distinct().collect(Collectors.toList());
        List<Person> uniquePersons = new ArrayList<>();
        people.stream().forEach(element -> {
                    if(nameList.contains(element.getName())){
                        uniquePersons.add(element);
                        nameList.remove(element.getName());
                    }});
        return uniquePersons.stream();
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO - done
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return getUniquelyNamedPeople()
                .filter(person -> person.getName()
                        .startsWith(String.valueOf(character)));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO - done
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        return getUniquelyNamedPeople().limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO - done
    public Map<Long, String> getIdToNameMap() {
        return people.stream()
                .collect(Collectors.toMap(Person::getPersonalId,Person::getName));
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO - done
    public Stream<Stream<String>> getNestedAliases() {
        return Stream.of(getAllAliases());
    }


    /**
     * @return Stream of all Aliases
     */ // TODO - done
    public Stream<String> getAllAliases() {
        return people.stream()
                .flatMap(person -> Arrays.stream(person.getAliases()));
//                .collect(Collectors.toList())
//                .stream();
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
