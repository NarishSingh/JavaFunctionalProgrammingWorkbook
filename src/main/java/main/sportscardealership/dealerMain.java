package main.sportscardealership;

import main.person.Color;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class dealerMain {

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Porsche", "911 GT3", LocalDate.of(2020, 1, 1), Color.RED, Transmission.AUTOMATIC, Drive.REAR_WHEEL_DRIVE, 502, 3.2, 197, 161100),
                new Car("Porsche", "911 GT3", LocalDate.of(2019, 1, 1), Color.BLACK, Transmission.MANUAL, Drive.REAR_WHEEL_DRIVE, 502, 3.2, 197, 161100),
                new Car("Porsche", "911 Turbo S Cabriolet", LocalDate.of(2020, 1, 1), Color.GRAY, Transmission.MANUAL, Drive.REAR_WHEEL_DRIVE, 640, 2.7, 205, 219800),
                new Car("Porsche", "718 Spyder", LocalDate.of(2020, 1, 1), Color.WHITE, Transmission.AUTOMATIC, Drive.ALL_WHEEL_DRIVE, 414, 3.7, 187, 98300),
                new Car("Lamborghini", "Aventador SVJ Roadster", LocalDate.of(2020, 1, 1), Color.BEIGE, Transmission.MANUAL, Drive.ALL_WHEEL_DRIVE, 770, 2.9, 217.5, 573966),
                new Car("Lamborghini", "Huracan EVO Spyder", LocalDate.of(2020, 1, 1), Color.GREEN, Transmission.AUTOMATIC, Drive.REAR_WHEEL_DRIVE, 631, 3.1, 202, 287400),
                new Car("Lamborghini", "Sian FKP37", LocalDate.of(2021, 1, 1), Color.ORANGE, Transmission.AUTOMATIC, Drive.ALL_WHEEL_DRIVE, 808, 2.8, 220, 518000),
                new Car("Bugatti", "Chiron Sport", LocalDate.of(2021, 1, 1), Color.RED, Transmission.AUTOMATIC, Drive.ALL_WHEEL_DRIVE, 1479, 2.4, 261, 3237000),
                new Car("Bugatti", "Veyron", LocalDate.of(2014, 1, 1), Color.WHITE, Transmission.AUTOMATIC, Drive.ALL_WHEEL_DRIVE, 987, 2.5, 252, 1788692.75),
                new Car("Toyota", "Supra", LocalDate.of(1995, 1, 1), Color.WHITE, Transmission.MANUAL, Drive.REAR_WHEEL_DRIVE, 320, 5.8, 158, 47500),
                new Car("Nissan", "Skyline GTR", LocalDate.of(2002, 1, 1), Color.BLUE, Transmission.MANUAL, Drive.ALL_WHEEL_DRIVE, 276, 4.9, 155, 55000),
                new Car("Plymouth", "Cuda", LocalDate.of(1972, 1, 1), Color.RED, Transmission.MANUAL, Drive.REAR_WHEEL_DRIVE, 240, 5.4, 113, 30000)
        );

        //Query all Porsche
        System.out.println("All Porsche models:");
        cars.stream()
                .filter(car -> car.getMake().matches("Porsche"))
                .forEach(System.out::println);

        //query all 2020 models
        System.out.println("\nAll 2020 models:");
        cars.stream()
                .filter(car -> car.getModelYear().getYear() == 2020)
                .forEach(System.out::println);

        //all models before 2010
        System.out.println("\nAll pre-2010 models:");
        cars.stream()
                .filter(car -> car.getModelYear().getYear() < 2010)
                .forEach(System.out::println);

        //all white cars
        System.out.println("\nAll white cars:");
        cars.stream()
                .filter(car -> car.getColor().equals(Color.WHITE))
                .forEach(System.out::println);

        //all cars with horsepower > 500
        System.out.println("\nAll cars with 500+ hp:");
        cars.stream()
                .filter(car -> car.getHorsepower() > 500)
                .forEach(System.out::println);

        //fave color
        System.out.print("\nFave color:");
        cars.stream()
                .collect(Collectors.groupingBy(Car::getColor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        //top speed on a rear wheel drive are
        System.out.println("\nTop speed of RWD car:");
        cars.stream()
                .collect(Collectors.groupingBy(Car::getDriveType))
                .get(Drive.REAR_WHEEL_DRIVE).stream()
                .max(Comparator.comparingDouble(Car::getTopSpeed))
                .ifPresent(car -> System.out.println(car.getModelYear().getYear() + " " + car.getMake() + " "
                        + car.getModel() + " | " + car.getTopSpeed() + "mph"));

        //oldest all wheel drive car
        System.out.println("\nOldest AWD car:");
        cars.stream()
                .collect(Collectors.groupingBy(Car::getDriveType))
                .get(Drive.ALL_WHEEL_DRIVE).stream()
                .min(Comparator.comparing(car -> car.getModelYear().getYear()))
                .ifPresent(car -> System.out.println(car.getModelYear().getYear() + " " + car.getMake() + " "
                        + car.getModel()));

        //most expensive stick shift car
        System.out.println("\nPriciest car with manual transmission:");
        cars.stream()
                .collect(Collectors.groupingBy(Car::getTransmission))
                .get(Transmission.MANUAL).stream()
                .max(Comparator.comparingDouble(Car::getPrice))
                .ifPresent(car -> System.out.println(car.getModelYear().getYear() + " " + car.getMake() + " "
                        + car.getModel() + " | $" + String.format("%,.2f", car.getPrice())));

        //counts of Drive types
        System.out.println("\nCars per drive type:");
        cars.stream()
                .collect(Collectors.groupingBy(Car::getDriveType, Collectors.counting()))
                .forEach((driveType, carCount) -> System.out.println(driveType + " - " + carCount));

        //cars with 4.0s and less acceleration to 60
        System.out.println("\nCars that can hit 60mph in below 4s");
        cars.stream()
                .filter(car -> car.getAccelTime() < 4.0)
                .forEach(System.out::println);

        //max horsepower of a non-supercar
        System.out.println("\nMax horsepower of a car that cannot break 4s time for 0-60mph:");
        cars.stream()
                .filter(car -> car.getAccelTime() > 4.0)
                .max(Comparator.comparingDouble(Car::getHorsepower))
                .ifPresent(System.out::println);

        //slowest red car
        System.out.println("\nSlowest red car:");
        cars.stream()
                .collect(Collectors.groupingBy(Car::getColor))
                .get(Color.RED).stream()
                .max(Comparator.comparingDouble(Car::getAccelTime))
                .ifPresent(car -> System.out.println(car.getModelYear().getYear() + " " + car.getMake() + " "
                        + car.getModel() + " | " + car.getAccelTime() + "s"));

        //filter Porsche's and sort by price
        System.out.println("\nPorsche's from least to most expensive:");
        cars.stream()
                .filter(car -> car.getMake().matches("Porsche"))
                .sorted(Comparator.comparingDouble(Car::getPrice))
                .forEach(System.out::println);
    }
}
