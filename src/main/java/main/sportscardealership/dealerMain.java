package main.sportscardealership;

import main.person.Color;

import java.time.LocalDate;
import java.util.List;

public class dealerMain {

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Porsche", "911 GT3", LocalDate.of(2020, 1, 1), Color.RED, Transmission.AUTOMATIC, Drive.REAR_WHEEL_DRIVE, 502, 3.2, 197, 161100),
                new Car("Porsche", "911 Turbo S Cabriolet", LocalDate.of(2020, 1, 1), Color.GRAY, Transmission.MANUAL, Drive.REAR_WHEEL_DRIVE, 640, 2.7, 205, 219800),
                new Car("Porsche", "718 Spyder", LocalDate.of(2020, 1, 1), Color.WHITE, Transmission.AUTOMATIC, Drive.ALL_WHEEL_DRIVE, 414, 3.7, 187, 98300),
        );
    }
}
