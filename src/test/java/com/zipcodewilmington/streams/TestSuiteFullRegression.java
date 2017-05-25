package com.zipcodewilmington.streams;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestStreamFilter.class,
        TestStreamMap.class,
        TestPersonFactory.class
})

public class TestSuiteFullRegression {
}
