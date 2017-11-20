package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.TestConstants;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestPersonFactory implements TestConstants {

    @Test
    public final void testCreateRandomPersonList() {
        checkStream(PersonFactory.createPersonList(collectionSize).stream());
    }

    @Test
    public final void testCreateRandomPersonArray() {
        checkStream(Stream.of(PersonFactory.createPersonArray(collectionSize)));
    }

    @Test
    public final void testCreateRandomPersonStream() {
        checkStream(PersonFactory.createPersonStream(collectionSize));
    }

    private final void checkStream(Stream<Person> personStream) {
        String messageCheckSize = "Ensuring appropriately sized stream was produced.";

        Person[] personArray = personStream.toArray(Person[]::new);
        Assert.assertEquals(messageCheckSize, collectionSize, personArray.length);
        TestPerson.checkPeople(personArray);
    }
}
