package models;

public class Person {
    private int id;
    private String name = "";
    private String surname = "";
    private int age = 0;
    public Person() { }
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public int getId() {
        return this.id;
    }
    public Person setId(int id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return this.name;
    }
    public Person setName(String name) {
        this.name = name;
        return this;
    }
    public String getSurname() {
        return this.surname;
    }
    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public int getAge() {
        return this.age;
    }
    public Person setAge(int age) {
        this.age = age;
        return this;
    }
}
