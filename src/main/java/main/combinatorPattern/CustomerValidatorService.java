package main.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

/**
 * Standard declarative approach. Not very useful - would take too long to add on validation fields, and can't see the error
 */
public class CustomerValidatorService {

    private static boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    private static boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    public static boolean isValid(Customer customer) {
        return isEmailValid(customer.getEmail()) &&
                isPhoneNumberValid(customer.getPhoneNum()) &&
                isAdult(customer.getDob());
    }
}
