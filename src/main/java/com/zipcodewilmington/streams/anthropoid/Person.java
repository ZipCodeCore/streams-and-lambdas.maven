package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.DateUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Created by leon on 5/1/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class Person {
    public final String name;
    public final int age;
    public final boolean isMale;
    public final long personalId;
    public final Date birthDate;
    public final String[] aliases;

    Person(String name, int age, boolean isMale, long personalId, Date birthDate, String... aliases) {
        this.name = name;
        this.isMale = isMale;
        this.personalId = personalId;
        this.birthDate = birthDate;
        this.age = DateUtils.yearsBetween(birthDate, LocalDate.now());
        this.aliases = aliases;
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

    public String[] getAliases() {
        return aliases;
    }
}
