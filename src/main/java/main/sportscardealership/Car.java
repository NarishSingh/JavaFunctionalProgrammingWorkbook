package main.sportscardealership;

import main.person.Color;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private String make; //== brand, like Toyota
    private String model;
    private LocalDate year; //will use XXXX-01-01, only year is important
    private Color color;
    private Transmission transmission;
    private Drive driveType;
    private double horsepower;
    private double accelTime; //0-60 mph time in s
    private double topSpeed;
    private double price;

    public Car(String make, String model, LocalDate year, Color color, Transmission transmission, Drive driveType,
               double horsepower, double accelTime, double topSpeed, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.transmission = transmission;
        this.driveType = driveType;
        this.horsepower = horsepower;
        this.accelTime = accelTime;
        this.topSpeed = topSpeed;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Drive getDriveType() {
        return driveType;
    }

    public void setDriveType(Drive driveType) {
        this.driveType = driveType;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }

    public double getAccelTime() {
        return accelTime;
    }

    public void setAccelTime(double accelTime) {
        this.accelTime = accelTime;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.getHorsepower(), getHorsepower()) == 0 && Double.compare(car.getAccelTime(), getAccelTime()) == 0 && Double.compare(car.getTopSpeed(), getTopSpeed()) == 0 && Double.compare(car.getPrice(), getPrice()) == 0 && Objects.equals(getMake(), car.getMake()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getYear(), car.getYear()) && getColor() == car.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getYear(), getColor(), getHorsepower(), getAccelTime(), getTopSpeed(), getPrice());
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color=" + color +
                ", horsepower=" + horsepower +
                ", accelTime=" + accelTime +
                ", topSpeed=" + topSpeed +
                ", price=" + price +
                '}';
    }
}
