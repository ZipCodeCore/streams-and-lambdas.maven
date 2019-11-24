package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
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

       return people.stream().map(Person::getName).collect(Collectors.toList());

    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream <Person> getUniquelyNamedPeople() {
        Set<String> mySet = new HashSet<>((people.size()));

        return people.stream().filter(p -> mySet.add(p.getName()));

//        uniqueNames =  people.stream().collect(Collectors.map(Person, getNames())
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1)
//                .map(Map.Entry::getKey);
////                .collect(Collectors.toList());
//
       //return  people.stream().map(e -> e.getName());
//
//stream.of(linked)
//        return uniqueNames;
//        return null;
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return people.stream().filter(thePerson -> (thePerson.getName().indexOf(character) == 0));

//        String myChar = String.valueOf(character);
//        Predicate<String> predicate = new Predicate <String> (){
//
//            @Override
//            public boolean test(String o) {
//               return (o.startsWith(myChar));
//            }
//        };
        //people.stream().filter(predicate::apply);
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        return getUniquelyNamedPeople().limit(n);
    }

   //
    // uniqueNames =  people.stream().collect(Collectors.map(Person, getNames())
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1)
//                .map(Map.Entry::getKey);
////                .collect(Collectors.toList());
//

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {
       return people.stream().collect(Collectors.toMap(Person::getPersonalId, Person::getName));
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases()
    {
       return people.stream().map(x -> Stream.of(x.getAliases()));

    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        return getNestedAliases().flatMap(Function.identity());
        //or inside flatMap( v -> v)
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

    public static <T> Predicate <T> distinctByKey (Function <? super T, Object > keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE == null);
    }

}
