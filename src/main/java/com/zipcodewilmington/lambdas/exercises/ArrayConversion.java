package com.zipcodewilmington.lambdas;

import com.zipcodewilmington.lambdas.anthropoid.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public class ArrayConversions {
    public Stream<Person> getStream() {
        return null;
    }

    public static List<Person> getList() {
        return null;
    }

    public Stream<Person> filter(Predicate<? super Person> predicate) {
        return getStream().filter(predicate);
    }

}
