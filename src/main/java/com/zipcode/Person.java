package com.zipcode;

import java.util.Date;

/**
 * Created by leon on 5/1/17.
 */
public class Person {
    private String name;
    private int age;
    private boolean isMale;
    private long personalId;
    private Date birthDate;

    public Person(String name, int age, boolean isMale, long personalId, Date birthDate) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.personalId = personalId;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }

    public long getPersonalId() {
        return personalId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setPersonalId(long personalId) {
        this.personalId = personalId;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
