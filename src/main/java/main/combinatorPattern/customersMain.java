package main.combinatorPattern;

import java.time.LocalDate;

public class customersMain {

    public static void main(String[] args) {
        Customer c1 = new Customer("John Doe", "718-999-9999", "sv@testmail.com", LocalDate.of(1989, 12, 30));

        /*DECLARATIVE*/
        System.out.println(CustomerValidatorService.isValid(c1));

        /*COMBINATOR APPROACH*/
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(c1);

        System.out.println(result);

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

        //is done lazily, will only trigger on .apply()
        CustomerRegistrationValidator result2 = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumValid())
                .and(CustomerRegistrationValidator.isAdult());

        System.out.println(result2.apply(c1));
    }
}
