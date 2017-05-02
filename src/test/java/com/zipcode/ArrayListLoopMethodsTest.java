package com.zipcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 5/2/17.
 */
public class ArrayListLoopMethodsTest {
    private ArrayListLoopMethods arrayListLoopMethods;
    @Before
    public void setup() {
        arrayListLoopMethods = new ArrayListLoopMethods();
    }

    @Test
    public void testWhileLoop() {
        arrayListLoopMethods.testWhileLoop();
    }

    @Test
    public void testForLoop() {
        arrayListLoopMethods.testForLoop();
    }

    @Test
    public void testForEachLoop() {
        arrayListLoopMethods.testForEachloop();
    }
}
