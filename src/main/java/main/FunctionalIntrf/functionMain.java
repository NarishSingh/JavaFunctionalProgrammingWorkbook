package main.FunctionalIntrf;

import java.util.function.Function;

public class functionMain {
    public static void main(String[] args) {
        //literally the same as a one param method
        Function<Integer, Integer> increment = n -> ++n;
        Function<Integer, Integer> multiplyBy10 = n -> n * 10;

        //use .apply to invoke the method
        Integer incr = increment.apply(1);
        System.out.println(incr);

        Integer multipliedAfterIncr = increment.andThen(multiplyBy10).apply(1); //chained
        System.out.println(multipliedAfterIncr);
    }
}
