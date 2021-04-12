package main.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

/**
 * Uses the combinator pattern
 */
public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_INVALID;
    }

    static CustomerRegistrationValidator isPhoneNumValid() {
        return customer -> customer.getPhoneNum().matches("\\d{3}-\\d{3}-\\d{4}") ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_INVALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ?
                ValidationResult.SUCCESS : ValidationResult.NOT_ADULT;
    }

    /**
     * Combinator pattern
     * @param other
     * @return
     */
    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ?
                    other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_INVALID,
        EMAIL_INVALID,
        NOT_ADULT
    }
}
