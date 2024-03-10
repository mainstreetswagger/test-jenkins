package dto;

import models.Person;

public class PersonDto {
    private String name;
    private String surname;
    private int age;
    public PersonDto() { }
    public PersonDto(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public PersonDto setName(String name) {
        this.name = name;
        return this;
    }
    public String getSurname() {
        return this.surname;
    }
    public PersonDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public int getAge() {
        return this.age;
    }
    public PersonDto setAge(int age) {
        this.age = age;
        return this;
    }
}
