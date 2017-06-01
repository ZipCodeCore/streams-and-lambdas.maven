package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.TestPersonFactory;
import com.zipcodewilmington.streams.anthropoid.TestSuiteAnthropoidRegression;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestStreamFilter.class,
        TestSuiteAnthropoidRegression.class,
})

/**
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestSuiteFullRegression {
}