package com.zipcodewilmington.lambdas.tools.anthropoid;

import java.util.Date;

/**
 * Created by leon on 5/1/17.
 */
public class Person {
    public final PersonProperty<String> name;
    public final PersonProperty<Integer> age;
    public final PersonProperty<Boolean> isMale;
    public final PersonProperty<Long> personalId;
    public final PersonProperty<Date> birthDate;

    /**
     * @param name - name of person
     * @param age - age of person
     * @param isMale - gender flag
     * @param personalId - unique id
     * @param birthDate - date of birth
     */
    public Person(String name, int age, boolean isMale, long personalId, Date birthDate) {
        this.name = new PersonProperty<>(name);
        this.age = new PersonProperty<>(age);
        this.isMale = new PersonProperty<>(isMale);
        this.personalId = new PersonProperty<>(personalId);
        this.birthDate = new PersonProperty<>(birthDate);
    }

    /** the purpose of this class is compress verbose getter and setter logic
     * @param <E> the type of data to store */
    public class PersonProperty<E> {
        private E val; // value of the data

        /** @param val - value of data for this object to store */
        public PersonProperty(E val) {
            this.val = val;
        }

        /** @return value this object is storing*/
        public E getValue() {
            return val;
        }
    }
}
