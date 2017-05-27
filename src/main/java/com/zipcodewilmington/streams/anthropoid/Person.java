package com.zipcodewilmington.streams.anthropoid;

import java.util.Date;

/**
 * Created by leon on 5/1/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class Person {
    public final PersonProperty<String> name;
    public final PersonProperty<Integer> age;
    public final PersonProperty<Boolean> isMale;
    public final PersonProperty<Long> personalId;
    public final PersonProperty<Date> birthDate;
    public final PersonProperty<String[]> aliases;

    /**
     * @param name - name of person
     * @param age - age of person
     * @param isMale - gender flag
     * @param personalId - unique id
     * @param birthDate - date of birth
     */
    public Person(String name, int age, boolean isMale, long personalId, Date birthDate, String... aliases) {
        this.name = new PersonProperty<>(name);
        this.age = new PersonProperty<>(age);
        this.isMale = new PersonProperty<>(isMale);
        this.personalId = new PersonProperty<>(personalId);
        this.birthDate = new PersonProperty<>(birthDate);
        this.aliases = new PersonProperty<>(aliases);
    }

    /** the purpose of this class is to compress verbose getter and setter logic
     * @param <E> the type of data to store */
    public class PersonProperty<E> {
        private E val; // value of the data

        /** @param val - value of data for this object to store */
        public PersonProperty(E val) {
            this.val = val;
        }

        /** @return value this object is storing */
        public E getValue() {
            return val;
        }

        /** set value this object is storing */
        public void setValue(E val) {
            this.val = val;
        }
    }
}
