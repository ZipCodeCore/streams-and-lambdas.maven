package com.zipcode.tools;
import com.zipcode.Person;

import java.util.ArrayList;
import java.util.Date;

/** Created by leon on 5/1/17. */
public class PersonFactory {
    public static Person createRandomPerson() {
        String name = RandomUtils.createString('a', 'z', 10);
        int age = RandomUtils.createInteger(0, 99);
        boolean isMale = RandomUtils.chance(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);
        Person randomPerson = new Person(name, age, isMale, personalId, birthDate);
        return randomPerson;
    }

    public static ArrayList<Person> createPersonArrayList(int personCount) {
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<people.size();i++) {
            people.add(PersonFactory.createRandomPerson());
        }
        return people;
    }


    public static Person[] createPersonArray(int personCount) {
        Person[] people = new Person[personCount];
        for(int i=0;i<people.length;i++) {
            people[i] = PersonFactory.createRandomPerson();
        }
        return people;
    }
}
