package com.zipcode;

import com.zipcode.Person;
import com.zipcode.tools.PersonFactory;

/**
 * Created by leon on 5/2/17.
 */
public class ArrayLoopMethods {
    private Person[] personArray = PersonFactory.createPersonArray(100);

    public void testWhileLoop() {
        int i = 0;
        while(i< personArray.length) {
            Person person = personArray[i];
            String name = person.getName();
            System.out.println(name);
            i++;
        }
    }

    public void testForLoop() {
        for(int i = 0; i< personArray.length; i++) {
            Person person = personArray[i];
            String name = person.getName();
            System.out.println(name);
        }
    }

    public void testForEachloop() {
        for(Person person : personArray) {
            String name = person.getName();
            System.out.println(name);
        }
    }
}
