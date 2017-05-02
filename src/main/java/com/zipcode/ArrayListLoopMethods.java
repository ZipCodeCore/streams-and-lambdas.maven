package com.zipcode;

import com.zipcode.tools.PersonFactory;

import java.util.ArrayList;

/**
 * Created by leon on 5/2/17.
 */
public class ArrayListLoopMethods {
    private ArrayList<Person> personArrayList = PersonFactory.createPersonArrayList(100);

    public void testWhileLoop() {
        int i = 0;
        while(i<personArrayList.size()) {
            Person person = personArrayList.get(i);
            String name = person.getName();
            System.out.println(name);
            i++;
        }
    }

    public void testForLoop() {
        for(int i=0; i<personArrayList.size(); i++) {
            Person person = personArrayList.get(i);
            String name = person.getName();
            System.out.println(name);
        }
    }

    public void testForEachloop() {
        for(Person person : personArrayList) {
            String name = person.getName();
            System.out.println(name);
        }
    }
}
