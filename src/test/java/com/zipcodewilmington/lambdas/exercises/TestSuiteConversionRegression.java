package com.zipcodewilmington.lambdas.exercises;

import com.zipcodewilmington.lambdas.TestPersonFactory;
import com.zipcodewilmington.lambdas.TestStreamFilter;
import com.zipcodewilmington.lambdas.TestStreamMap;
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
