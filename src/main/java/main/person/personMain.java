package main.person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static main.person.Color.*;


public class personMain {
    public static void main(String[] args) {
        //initializes a List
        List<Person> people = List.of(
                new Person("Bobby", 18, GREEN),
                new Person("Johnny", 18, YELLOW),
                new Person("Carmilla", 18, RED),
                new Person("Felicia", 18, RED),
                new Person("Alexa", 18, BLUE),
                new Person("Wayne", 18, VIOLET),
                new Person("Tim", 18, INDIGO),
                new Person("Samantha", 18, ORANGE)
        );

        //imperative
        System.out.println("People who like red:");
        for (Person p : people) {
            if (RED.equals(p.getFaveColor())) {
                System.out.println(p);
            }
        }

        //declarative
        Predicate<Person> likeGreen = person -> GREEN.equals(person.getFaveColor());

        System.out.println("\nPeople who like green:");
        people.stream()
//                .filter(person -> GREEN.equals(person.getFaveColor())) //this lambda is a predicate
                .filter(likeGreen)
                .forEach(System.out::println); //filter then print each

        System.out.println("\nPeople who like violet:");
        List<Person> violetFaved = people.stream()
                .filter(person -> VIOLET.equals(person.getFaveColor()))
                .collect(Collectors.toList()); //collect to a list

        violetFaved.forEach(System.out::println);
    }
}
