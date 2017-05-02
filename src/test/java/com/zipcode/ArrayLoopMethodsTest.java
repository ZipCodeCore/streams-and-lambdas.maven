package com.zipcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 5/2/17.
 */
public class ArrayLoopMethodsTest {
    private ArrayLoopMethods arrayLoopMethods;

    @Before
    public void setup() {
        arrayLoopMethods = new ArrayLoopMethods();
    }

    @Test
    public void testWhileLoop() {
        arrayLoopMethods.testWhileLoop();
    }

    @Test
    public void testForLoop() {
        arrayLoopMethods.testForLoop();
    }

    @Test
    public void testForEachLoop() {
        arrayLoopMethods.testForEachloop();
    }
}
