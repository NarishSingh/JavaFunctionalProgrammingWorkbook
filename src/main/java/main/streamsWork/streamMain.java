package main.streamsWork;

import main.Person.Color;
import main.Person.Person;

import java.util.List;
import java.util.stream.Collectors;

public class streamMain {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Bobby", Color.GREEN),
                new Person("Johnny", Color.YELLOW),
                new Person("Carmilla", Color.RED),
                new Person("Felicia", Color.RED),
                new Person("Alexa", Color.BLUE),
                new Person("Wayne", Color.VIOLET),
                new Person("Tim", Color.INDIGO),
                new Person("Samantha", Color.ORANGE)
        );

        /*MAPPERS*/
        //distinct set of colors favorited
        people.stream()
                .map(Person::getFaveColor)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-------");

        //length of each name
        people.stream()
                .map(Person::getName)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println("-------");

        /*MATCH*/
        boolean onlyRedLovers = people.stream()
                .allMatch(person -> Color.RED.equals(person.getFaveColor()));
        System.out.println(onlyRedLovers);

        boolean anyRedLovers = people.stream()
                .anyMatch(person -> Color.RED.equals(person.getFaveColor()));
        System.out.println(anyRedLovers);

        boolean noIndigoLovers = people.stream()
                .noneMatch(person -> Color.INDIGO.equals(person.getFaveColor()));
        System.out.println(noIndigoLovers);

        System.out.println("-------");


    }
}
