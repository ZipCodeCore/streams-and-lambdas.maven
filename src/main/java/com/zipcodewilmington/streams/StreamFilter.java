package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

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
        this.personStream = new PersonFactory().createPersonStream(100);
        this.startingCharacter = RandomUtils.createCharacter('A','Z').toString();
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(Person[] people, Character startingCharacter) {

        this.personStream = Stream.of(people);
        this.startingCharacter = startingCharacter.toString();
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(List<Person> people, Character startingCharacter) {

        this.personStream = people.stream();
        this.startingCharacter = startingCharacter.toString();
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
     */
    public List<Person> toListMultiLine() {

        return this.personStream
                .filter(person -> person.getName()
                .startsWith(this.startingCharacter))
                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */
    public List<Person> toListOneLine() {

        return toListMultiLine();
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */
    public Person[] toArrayOneLine() {

        return toArrayMultiLine();
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */
    public Person[] toArrayMultiLine() {

        return this.personStream
                .filter(person -> person.getName()
                .startsWith(this.startingCharacter))
                .toArray(Person[]::new);
    }

}
