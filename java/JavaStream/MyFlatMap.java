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

        // Create persons of 3
        IntStream.range(1, 4).forEach( i -> people.add(new Person("Person " + i, i)));

        //Create children
        people.forEach(p -> IntStream.range(1, 4).forEach(i -> p.children.add(new Child("Child " + i + "< -" + p.name))));

        //Flat map would convert one stream to flat out all its elements to another bigger stream in this case
        //Key word: one to many
        people.stream().flatMap(p -> p.children.stream()).forEach(c -> System.out.println(c.name));

        // Reduce to find the oldest person using a binary function
        // Key word: use binary function to reduce
        people.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(p -> System.out.println(p.name));
    }
}

class Person {
    String name;
    int age;
    List<Child> children = new ArrayList<>();

    Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Child {
    String name;

    Child(String name) {
        this.name = name;
    }
}

