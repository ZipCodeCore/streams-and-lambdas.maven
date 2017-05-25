package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.TestConstants;

/**
 * Created by leon on 5/25/17.
 */
public class TestConverterArray extends TestConversionAgent implements TestConstants {
    public TestConverterArray() {
        super(new ArrayConverter(collectionSize));
    }
}