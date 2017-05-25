package com.zipcodewilmington.streams.exercises;

import com.zipcodewilmington.streams.TestConstants;

/**
 * Created by leon on 5/25/17.
 */
public class TestConverterStream extends TestConversionAgent implements TestConstants {
    public TestConverterStream() {
        super(new StreamConverter(collectionSize));
    }
}