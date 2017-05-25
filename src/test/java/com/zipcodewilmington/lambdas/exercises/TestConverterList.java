package com.zipcodewilmington.lambdas.exercises;

/**
 * Created by leon on 5/25/17.
 */
public class TestConverterList extends TestConversionAgent implements TestConstants {
    public TestConverterList() {
        super(new ListConverter(collectionSize));
    }
}