package main.functionalIntrf;

import java.util.List;
import java.util.function.Supplier;

public class supplierMain {

    public static void main(String[] args) {
        //simply supplies a result of the type you want
        Supplier<String> nameSupplier = () -> "Narish";
        Supplier<List<String>> studentListSupplier = () -> List.of(
                "A",
                "B",
                "C",
                "D"
        );

        System.out.println(nameSupplier.get());
        System.out.println(studentListSupplier.get());
    }
}
