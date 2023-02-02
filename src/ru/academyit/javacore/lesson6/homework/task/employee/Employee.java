package ru.academyit.javacore.lesson6.homework.task.employee;

import ru.academyit.javacore.lesson6.homework.task.Person;
import ru.academyit.javacore.lesson6.homework.task.Position;

/**
 * Класс сотрудника организации
 */
public class Employee {

    private Person person;  // персональные данные сотрудника
    private Position position; // должность сотрудника


    public Employee(Person person, Position position) {
        this.person = person;
        this.position = position;
    }


    // Getters & Setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    // Overrides

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + person + '\'' +
                ", position='" + position + '\'' + '}';
    }

}
