package com.zipcodewilmington.streams.conversions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestConverterList.class,
        TestConverterArray.class,
        TestConverterStream.class
})

public class TestSuiteConversionRegression {
}
