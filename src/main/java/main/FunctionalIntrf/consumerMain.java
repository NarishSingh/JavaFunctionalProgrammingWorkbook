package main.FunctionalIntrf;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class consumerMain {

    public static void thankCustomer(Customer c) {
        System.out.println("Hello " + c.getName() + ", thanks for registering phone number " + c.getPhoneNum());
    }

    public static void main(String[] args) {
        thankCustomer(new Customer("Mary", "555-555-5555"));

        //consumer = a void function
        Consumer<Customer> thanks = c -> System.out.println("Hello " + c.getName() + ", thanks for registering phone number "
                + c.getPhoneNum());

        thanks.accept(new Customer("Luke", "111-111-1111"));

        //Biconsumer = a 2 param function that returns void
        BiConsumer<Customer, Boolean> thankDisplayNumber = (c, show) -> System.out.println("Hello " + c.getName()
                + ", thanks for registering phone number " + (show ? c.getPhoneNum() : "***-***-****"));

        thankDisplayNumber.accept(new Customer("Will", "987-654-1234"), false);
    }
}
