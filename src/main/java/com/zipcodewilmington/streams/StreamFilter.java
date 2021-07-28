package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Arrays;
import java.util.List;
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
        PersonFactory factory = new PersonFactory();
        this.personStream = factory.createPersonStream(100);
        this.startingCharacter = "A";
        //this(Stream.empty(), null);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this.startingCharacter = startingCharacter.toString();
        this.personStream = Arrays.stream(people)
                .filter(person -> person.getName()
                        .startsWith(this.startingCharacter));

        //this(Stream.empty(), null);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this.startingCharacter = String.valueOf(startingCharacter);
        this.personStream = people
                .stream()
                .filter(person -> person.getName()
                        .startsWith(this.startingCharacter));

        //this(Stream.empty(), null);
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
        return personStream
                .filter(person -> {
                    if(startingCharacter.equals(person.getName().charAt(0))){
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream
                .filter(person -> startingCharacter.equals(person.getName().charAt(0)))
                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        //return toArrayMultiLine();
        return personStream
                .filter(person -> startingCharacter.equals(person.getName().charAt(0)))
                .toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        return personStream
                .filter(person -> {
                            if(startingCharacter.equals(person.getName().charAt(0))){
                                return true;
                            }
                            return false;
                        })
                .toArray(Person[]::new);
    }

}
