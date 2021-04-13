package main.person;

public class Person {
    private String name;
    private int age;
    private Color faveColor;

    public Person(String name, int age, Color faveColor) {
        this.name = name;
        this.age = age;
        this.faveColor = faveColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Color getFaveColor() {
        return faveColor;
    }

    public void setFaveColor(Color faveColor) {
        this.faveColor = faveColor;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", faveColor=" + faveColor +
                '}';
    }
}
