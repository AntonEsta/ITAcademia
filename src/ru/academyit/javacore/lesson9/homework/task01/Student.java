package ru.academyit.javacore.lesson9.homework.task01;

import java.util.Objects;

public class Student {
    private final Person person;
    private final Double grade;

    public Student(Person person, Double grade) {
        this.person = person;
        this.grade = grade;
    }

    public Person getPerson() {
        return person;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Student{" +
                "person=%s " +
                "grade=%.2f" +
                '}', person, grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return person.equals(student.person) && grade.equals(student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, grade);
    }

}
