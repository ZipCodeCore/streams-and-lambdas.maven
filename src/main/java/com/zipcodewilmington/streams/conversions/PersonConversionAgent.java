package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;

/**
 * Created by leon on 5/31/17.
 * The purpose of this class is to convert between different types of Person Collections
 * @param <ObjectSequentDataType> some sequence of Person objects
 */
abstract public class PersonConversionAgent<ObjectSequentDataType> extends ConversionAgent<ObjectSequentDataType, Person> {
    public PersonConversionAgent(ObjectSequentDataType personObjectSequence) {
        super(personObjectSequence);
    }
}
