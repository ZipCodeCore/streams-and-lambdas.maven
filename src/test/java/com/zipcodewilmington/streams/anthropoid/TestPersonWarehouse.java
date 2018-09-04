package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by leon on 5/31/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestPersonWarehouse {

    @Before
    public void setup() {
        PersonWarehouse.getPeople().clear();
        PersonFactory.createPersonStream(999);
    }

    @Test
    public void testAddPerson() {
        int startSize = PersonWarehouse.getPeople().size();
        int expectedEndSize = startSize + 1;
        PersonFactory.createRandomPerson();

        int actualEndSize = PersonWarehouse.getPeople().size();

        Assert.assertEquals(expectedEndSize, actualEndSize);
    }

    @Test
    public void testGetUniquelyNamedPeople() {
        List<Person> uniquelyNamedPeople = PersonWarehouse.getUniquelyNamedPeople().collect(Collectors.toList());
        List<String> uniqueNames = new ArrayList<>();
        for (Person person : PersonWarehouse.getPeople()) {
            String personName = person.getName();
            boolean isUnique = !uniqueNames.contains(personName);
            if (isUnique) {
                uniqueNames.add(personName);
            }
        }

        Assert.assertEquals(uniqueNames.size(), uniquelyNamedPeople.size());
    }

    @Test
    public void testGetFirstNUniquelyNamedPeople() {
        int expectedSize = RandomUtils.createInteger(1, 3);
        int actualSize = (int)PersonWarehouse.getFirstNUniquelyNamedPeople(expectedSize).count();
        Assert.assertTrue(expectedSize > actualSize);
    }

    @Test
    public void testGetUniquelyNamedPeopleStartingWith() {
        Character startingCharacter = RandomUtils.createCharacter('A', 'Z');
        List<Person> people = PersonWarehouse.getUniquelyNamedPeopleStartingWith(startingCharacter).collect(Collectors.toList());
        for (Person person : people) {
            String personName = person.getName();
            Assert.assertTrue(personName.startsWith(startingCharacter.toString()));
        }
    }

    @Test
    public void testGetIdToNameMap() {
        Map<Long, String> warehouseNameMap = PersonWarehouse.getIdToNameMap();
        Map<Long, String> localNameMap = new HashMap<>();
        for (Person person : PersonWarehouse.getPeople()) {
            long id = person.getPersonalId();
            String name = person.getName();
            localNameMap.put(id, name);
        }

        Iterator<Map.Entry<Long, String>> it = localNameMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, String> pair = it.next();
            long pairKey = pair.getKey();
            String pairValue = pair.getValue();
            String mapValue = warehouseNameMap.get(pairKey);

            Assert.assertTrue(mapValue.equals(pairValue));
        }
    }


    @Test
    public void testGetNames() {
        List<String> warehouseNames = PersonWarehouse.getNames();
        ArrayList<String> localNames = new ArrayList<>();
        for (Person person : PersonWarehouse.getPeople()) {
            localNames.add(person.getName());
        }
        Assert.assertEquals(localNames.size(), warehouseNames.size());
    }
}
