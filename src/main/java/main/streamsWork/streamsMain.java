package main.streamsWork;

import main.person.Color;
import main.person.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class streamsMain {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Bobby", 29, Color.GREEN),
                new Person("Raj", 17, Color.GREEN),
                new Person("Johnny", 8, Color.YELLOW),
                new Person("Harish", 99, Color.YELLOW),
                new Person("Xu", 56, Color.YELLOW),
                new Person("Carmilla", 26, Color.RED),
                new Person("Felicia", 13, Color.RED),
                new Person("Lunamaria", 34, Color.RED),
                new Person("Alexa", 21, Color.BLUE),
                new Person("Juan", 28, Color.BLUE),
                new Person("Maria", 68, Color.BLUE),
                new Person("Lucy", 41, Color.BLUE),
                new Person("Wayne", 3, Color.VIOLET),
                new Person("Tim", 36, Color.INDIGO),
                new Person("Kira", 24, Color.INDIGO),
                new Person("Samantha", 23, Color.ORANGE),
                new Person("Kamille", 18, Color.ORANGE),
                new Person("Lucina", 81, Color.ORANGE)
        );

        /*MAPPERS - let you adjust the stream's T*/
        //distinct set of colors favorited
        System.out.println("Set of all colors from results:");
        people.stream()
                .map(Person::getFaveColor)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-------");

        //length of each name
        System.out.println("Length of names:");
        people.stream()
                .map(Person::getName)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println("-------");

        /*MATCH*/
        System.out.print("Does the group only like red?:");
        boolean onlyRedLovers = people.stream()
                .allMatch(person -> Color.RED.equals(person.getFaveColor()));
        System.out.println(onlyRedLovers);

        System.out.print("\nDoes anyone like red in the group?:");
        boolean anyRedLovers = people.stream()
                .anyMatch(person -> Color.RED.equals(person.getFaveColor()));
        System.out.println(anyRedLovers);

        System.out.print("\nDoes no one like indigo?:");
        boolean noIndigoLovers = people.stream()
                .noneMatch(person -> Color.INDIGO.equals(person.getFaveColor()));
        System.out.println(noIndigoLovers);

        System.out.println("-------");

        /*FILTER*/
        System.out.println("How loves blue?:");
        List<Person> blueLovers = people.stream()
                .filter(person -> Color.BLUE.equals(person.getFaveColor()))
                .collect(Collectors.toList());

        blueLovers.forEach(System.out::println);

        System.out.println("-------");

        /*SORT*/
        System.out.println("Sorted by name:");
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("\nReversed:");
        people.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);

        //chained sorting
        System.out.println("\nSort by name then color:");
        people.stream()
                .sorted(Comparator.comparing(Person::getFaveColor).thenComparing(Person::getFaveColor))
                .forEach(System.out::println);

        System.out.println("-------");

        /*GROUPING*/
        System.out.println("Roster per color:");
        Map<Color, List<Person>> faveColorMap = people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor));

        faveColorMap.forEach((color, peopleList) -> {
            System.out.println(color);
            peopleList.forEach(System.out::println);
        });

        System.out.println("Count of people with this favorite colors:");
        people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor))
                .forEach((color, faveList) -> {
                    System.out.println(color);
                    System.out.println(faveList.size());
                });

        System.out.println("Votes per color:");
        people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor))
                .forEach((color, faveList) -> System.out.println(color + " - " + faveList.size()));

        System.out.println("-------");

        /*MIN/MAX*/
        //min and max returns an optional -> must use .ifPresent and related methods
        System.out.print("Oldest person?: ");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.print("Youngest person?: ");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("-------");

        /*CHAINING*/
        System.out.print("Oldest person who likes blue: ");
        people.stream()
                .filter(person -> Color.BLUE.equals(person.getFaveColor()))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .ifPresent(System.out::println);

        System.out.print("\nMost beloved color: ");
        Map<Color, Long> voteMap = people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor, Collectors.counting())); //counts the elements of group
        voteMap.entrySet().stream() //open new stream of the entry set
                .max(Map.Entry.comparingByValue()) //compare by value then get max
                .ifPresent(System.out::println);

        System.out.print("\nLeast liked color: ");
        people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);


        System.out.println("\nColors that got over 3 votes:");
        people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor))
                .forEach((color, peopleList) -> {
                    if (peopleList.size() >= 3) {
                        System.out.println(color + " - " + peopleList.size());
                    }
                });

        System.out.println("\nColors with less than 2 votes");
        people.stream()
                .collect(Collectors.groupingBy(Person::getFaveColor))
                .forEach((color, peopleList) -> {
                    if (peopleList.size() <= 2) {
                        System.out.println(color + " - " + peopleList.size());
                    }
                });
    }
}
