package main.optionalsWork;

import java.util.Optional;

public class optionalsMain {

    public static void main(String[] args) {
        //container object for a potentially nullable value
        Object value = Optional.ofNullable(null)
                .orElse("Default value");

        Object stringValue = Optional.ofNullable("Hi!!!")
                .orElseThrow(() -> new IllegalStateException("Exception"));

        System.out.println(value);
        System.out.println(stringValue);

        //.ifPresent() to specify logic if the optional contains something
        Optional.ofNullable("Hello world! (optional)")
                .ifPresent(System.out::println);

        //handle different logic if present or not
        Optional.ofNullable("test@testmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Email failed to send - bad email")
                );

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Email failed to send - bad email")
                );
    }
}
