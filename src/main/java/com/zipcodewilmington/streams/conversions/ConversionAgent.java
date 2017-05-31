package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 * ConversionAgent is responsible for conversion between different object sequent data types
 * Object sequent data types include: collections, arrays, lists, maps, iterators
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public abstract class ConversionAgent<T, R> {
    protected T personSequence;

    public ConversionAgent(T objectSequence) {
        this.personSequence = objectSequence;
    }

    /**
     * @return list representation of this object sequence
     */
    abstract public List<Person> toList();

    /**
     * @return stream representation of this object sequence
     */
    abstract public Stream<Person> toStream();

    /**
     * @return array representation of this object sequence
     */
    abstract public Person[] toArray();

    /**
     * @param predicate Represents a predicate (boolean-valued function) of one argument
     * @return stream representation of respectively filtered
     */
    public Stream<Person> filter(Predicate<? super Person> predicate) {
        return toStream().filter(predicate);
    }

    public Stream<Person> flatMap(Function<? super Person, ? extends Stream<Person>> predicate) {
        return toStream().flatMap(predicate);
    }
}
