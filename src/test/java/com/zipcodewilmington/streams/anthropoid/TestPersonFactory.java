package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.TestConstants;
import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
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

    //8.1 - 8.6; 8.7 - rest
    private final void checkStream(Stream<Person> personStream) {
        String messageCheckSize = "Ensuring appropriately sized stream was produced.";

        Person[] personArray = personStream.toArray(Person[]::new);
        Assert.assertEquals(messageCheckSize, collectionSize, personArray.length);
        for (Person person : personArray) {
           checkPerson(person);
        }
    }

    private final void checkPerson(Person person) {
        String messageCheckKey = "Ensuring field is non-null";
        String messageCheckValue = "Ensuring field-value is non-null";

        HashMap<Field, String> fieldMap = ReflectionUtils.getFieldMap(person);
        for (Map.Entry<Field, String> entry : fieldMap.entrySet()) {
            Field key = entry.getKey();
            String value = entry.getValue();

            Assert.assertTrue(messageCheckKey, key != null);
            Assert.assertTrue(messageCheckValue, value != null);
        }
    }
}
