package com.zipcodewilmington.lambdas;

import com.zipcodewilmington.lambdas.tools.ReflectionUtils;
import com.zipcodewilmington.lambdas.anthropoid.Person;
import com.zipcodewilmington.lambdas.anthropoid.PersonFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 */
public class TestPersonFactory {
    int collectionSize = 1000;

    @Test
    public void testCreateRandomPersonList() {
        checkStream(PersonFactory.createPersonList(collectionSize).stream());
    }

    @Test
    public void testCreateRandomPersonArray() {
        checkStream(Stream.of(PersonFactory.createPersonArray(collectionSize)));
    }

    @Test
    public void testCreateRandomPersonStream() {
        checkStream(PersonFactory.createPersonStream(collectionSize));
    }

    private void checkStream(Stream<Person> personStream) {
        String messageCheckSize = "Ensuring appropriately sized stream was produced.";
        String messageCheckKey = "Ensuring field is non-null";
        String messageCheckValue = "Ensuring field-value is non-null";

        Person[] personArray = personStream.toArray(Person[]::new);
        Assert.assertEquals(messageCheckSize, collectionSize, personArray.length);
        for (Person person : personArray) {
            HashMap<Field, String> fieldMap = ReflectionUtils.getFieldMap(person);
            for (Map.Entry<Field, String> entry : fieldMap.entrySet()) {
                Field key = entry.getKey();
                String value = entry.getValue();

                Assert.assertTrue(messageCheckKey, key != null);
                Assert.assertTrue(messageCheckValue, value != null);
            }
        }
    }
}
