package main.combinatorPattern;

import java.time.LocalDate;

public class Customer {

    private String name;
    private String phoneNum;
    private String email;
    private LocalDate dob;

    public Customer(String name, String phoneNum, String email, LocalDate dob) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
