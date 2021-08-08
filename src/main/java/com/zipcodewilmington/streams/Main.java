package com.zipcodewilmington.streams;
import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        PersonFactory taco = new PersonFactory();
        List<Person> pizza = new ArrayList<Person>();
        Person[] myPerson = new Person[10];

        //pizza = taco.createPersonList(20);
        myPerson = taco.createPersonArray(myPerson.length);

        for (int i = 0; i < myPerson.length; i++) {
            System.out.println(myPerson[i]);
            System.out.println(i);

        }



        System.out.println("This is the size of list: " + myPerson.length);

//        These two are the same essentially
//        tutel ->
//        public void meFunc(int tutel)

//        List<Person> meList = new ArrayList<>();
//
//        IntStream.range(1, 8)
//                .forEach(tutel -> {
//                    meList.add(taco.createRandomPerson());
//                });
//        System.out.println("This is the size of list: " + meList.size());
//        meList.forEach(x -> {
//            System.out.println(x);
//        });
    }
}
