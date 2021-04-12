package main.person;

public class Person {
    private String name;
    private Color faveColor;

    public Person(String name, Color faveColor) {
        this.name = name;
        this.faveColor = faveColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getFaveColor() {
        return faveColor;
    }

    public void setFaveColor(Color faveColor) {
        this.faveColor = faveColor;
    }

    @Override
    public String toString() {
        return "main.Person{" +
                "name='" + name + '\'' +
                ", faveColor=" + faveColor +
                '}';
    }
}
