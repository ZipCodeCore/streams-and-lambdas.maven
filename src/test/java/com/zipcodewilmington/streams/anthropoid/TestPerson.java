package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import org.junit.Assert;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 5/25/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public final class TestPerson {
    private TestPerson() {
    }

    public static void checkPeople(Person... people) {
        for (Person person : people) {
            checkPerson(person);
        }

    }

    private static void checkPerson(Person person) {
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