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
        List<String> list =
        this.people
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        return list;
    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {
        List<String> namesList = getNames()
                .stream()
                .distinct()
                .collect(Collectors.toList());
        List<Person> uniquelyNamePeople = new ArrayList<>();

        people.stream()
                .forEach(person ->{
                    if(namesList.contains(person.getName())){
                        uniquelyNamePeople.add(person);
                        namesList.remove(person.getName());
                    }
                });
        Stream<Person> resultStream = uniquelyNamePeople.stream();
        return resultStream;
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        List<Person> uniquelyNamedPeople = getUniquelyNamedPeople()
                .collect(Collectors.toList());
        return uniquelyNamedPeople.stream()
                .filter(person -> person.getName().charAt(0) == character);
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        return getUniquelyNamedPeople()
                .limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {
        return people
                .stream()
                .collect(Collectors.toMap(Person::getPersonalId, Person::getName));
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {
//        //List<String[]> aliases = people
//        String[] aliases = people
//                .stream()
//                .map(Person::getAliases)
//                //.collect(Collectors.toList());
//                //.toArray(new String[0]);
//                .toArray(String[]::new);
//        Stream<String[]> resultStream = (Stream<String[]>) Stream.of(aliases)//Arrays.stream(aliases)
//                .map(element -> Stream.of(element));
        return Stream.of(getAllAliases());
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        return people
                .stream()
                .map(Person::getAliases)
                //.forEach(alias -> alias.);
                .collect(Collectors.toList())
                //.toArray(new String[0])
                .stream()
                .flatMap(index -> Stream.of(index));
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
