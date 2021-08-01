package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class StreamConverter extends PersonConversionAgent<Stream<Person>> {
    private final List<Person> personList;
    public StreamConverter(Stream<Person> people) {
        super(people);
        this.personList = super.objectSequence.collect(Collectors.toList());
    }

    public StreamConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize));
    }

    // TODO
    public List<Person> toList() {
        return personList;
    }
//        List<Person> po = personList;
//
//        return po;
//    }

    // TODO
    public Stream<Person> toStream() {
        return personList.stream();
    }
//        Stream<Person> po = personList
//                .stream();
//        return po;
//    }

    // TODO
    public Person[] toArray() {

        return personList.toArray(new Person[0]);
    }
//       Person[] po = personList
//               .stream()
//               .toArray(Person[]::new);
//       return po;
//    }
}
