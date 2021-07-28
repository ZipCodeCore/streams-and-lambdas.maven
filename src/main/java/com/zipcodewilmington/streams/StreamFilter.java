package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        startingCharacter = RandomUtils.createString('a', 'z', 1);
        personStream = Stream.generate(() -> new Person("", false, 0L, new Date(), "Bill")).limit(100);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this.startingCharacter = startingCharacter.toString();
        personStream = Stream.of(people)
                .filter((person) -> person.getName().contains(this.startingCharacter));
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this.startingCharacter = startingCharacter.toString();
        personStream = people.stream()
                .filter((person) -> person.getName().contains(this.startingCharacter));
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        Predicate<Person> predicate = (person) -> {
            if (person.getName().startsWith(this.startingCharacter)) {
                return true;
            }
            return false;
        };
        return personStream.filter(predicate).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream
                .filter((person) -> person.getName().startsWith(this.startingCharacter))
                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream
                .filter((person) -> person.getName().startsWith(this.startingCharacter))
                .toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        Predicate<Person> predicate = (person) -> {
            if (person.getName().startsWith(this.startingCharacter)) {
                return true;
            }
            return false;
        };
        return personStream.filter(predicate).toArray(Person[]::new);
    }

}
