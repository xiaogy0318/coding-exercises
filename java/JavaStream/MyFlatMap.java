/*
FlatMap

We've already learned how to transform the objects of a stream into another type of objects by utilizing the map operation.
Map is kinda limited because every object can only be mapped to exactly one other object.
But what if we want to transform one object into multiple others or none at all?

This is where flatMap comes to the rescue.

In this example, Person Class has Child class as its children
3 persons will be created first, with each assigned with 3 children.
Print out all the childrens at the end by using FlatMap, i.e. 1 person --> multiple children
*/
import java.util.*;
import java.util.stream.*;

public class MyFlatMap {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        // Create persons
        IntStream.range(1, 4).forEach( i -> people.add(new Person("Person " + i)));

        //Create children
        people.forEach(p -> IntStream.range(1, 4).forEach(i -> p.children.add(new Child("Child " + i + "< -" + p.name))));
        people.stream().flatMap(p -> p.children.stream()).forEach(c -> System.out.println(c.name));
    }
}

class Person {
    String name;
    List<Child> children = new ArrayList<>();

    Person(String name) {
        this.name = name;
    }
}

class Child {
    String name;

    Child(String name) {
        this.name = name;
    }
}

