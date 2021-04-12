package main.functionalIntrf;

public class Customer {
    private String name;
    private String phoneNum;

    public Customer(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
