package ru.academyit.javacore.lesson8.homework.task;

import java.util.Objects;

public class Person {

    private String firstName;
    private String patronymic;
    private String lastName;

    public Person(String firstName, String patronymic, String lastName) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && patronymic.equals(person.patronymic) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, patronymic, lastName);
    }
}
