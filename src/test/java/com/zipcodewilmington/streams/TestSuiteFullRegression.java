package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.exercises.TestSuiteConversionRegression;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestStreamFilter.class,
        TestStreamMap.class,
        TestPersonFactory.class,
        TestSuiteConversionRegression.class
})

public class TestSuiteFullRegression {
}
