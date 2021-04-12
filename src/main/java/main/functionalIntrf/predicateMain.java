package main.functionalIntrf;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class predicateMain {

    public static boolean validPhoneNumber(String phoneNum){
        return phoneNum.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    public static void main(String[] args) {
        System.out.println(validPhoneNumber("123-456-7890"));
        System.out.println(validPhoneNumber("CheeSE"));

        //predicate = 1 param, returns bool
        Predicate<String> isValid = num -> num.matches("\\d{3}-\\d{3}-\\d{4}");

        System.out.println(isValid.test("123-456-7891"));
        System.out.println(isValid.test("John Wayne"));

        //chaining predicates
        Predicate<String> hasQueensAreaCode = num -> num.matches("^718-\\d{3}-\\d{4}");

        System.out.println("---");
        System.out.println(isValid.and(hasQueensAreaCode).test("718-111-9863"));
        System.out.println(isValid.and(hasQueensAreaCode).test("718-cheese"));
        System.out.println(isValid.and(hasQueensAreaCode).test("Cheddar-cheese"));

        //bipredicates
        BiPredicate<String, Boolean> isValidMobileNum = (num, isCell) -> isCell && num.matches("\\d{3}-\\d{3}-\\d{4}");

        System.out.println("---");
        System.out.println(isValidMobileNum.test("123-456-7890", true));
        System.out.println(isValidMobileNum.test("123-456-7890", false));
        System.out.println(isValidMobileNum.test("X", true));
        System.out.println(isValidMobileNum.test("p", false));
    }
}
