package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.anthropoid.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public abstract class ConversionAgent {

    abstract public List<Person> toList();

    abstract public Stream<Person> toStream();

    abstract public Person[] toArray();

    public Stream<Person> filter(Predicate<? super Person> predicate) {
        return toStream().filter(predicate);
    }
}
