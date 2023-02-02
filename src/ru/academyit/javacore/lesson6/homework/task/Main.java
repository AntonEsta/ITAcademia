package ru.academyit.javacore.lesson6.homework.task;

import ru.academyit.javacore.lesson6.homework.task.employee.Employee;
import ru.academyit.javacore.lesson6.homework.task.employee.EmployeeInform;
import ru.academyit.javacore.lesson6.homework.task.properties.SafeProperties;
import ru.academyit.javacore.lesson6.homework.task.rate.DoubleRate;
import ru.academyit.javacore.lesson6.homework.task.rate.FourfoldRate;
import ru.academyit.javacore.lesson6.homework.task.rate.Rates;

public class Main {

    public static final SafeProperties mainProperties = new SafeProperties(); // главные параметры программы

    public static void main(String[] args) {


        mainProperties.setSafeProperty("Base Salary", "20000"); // устанавливаем базовую ставку

        // Заводим должности
        Position programmerPosition = new Position("Программист", new FourfoldRate()); // задаем четырехкратный тариф для сотрудника;
        Position economistPosition = new Position("Экономист", new DoubleRate()); // задаем двухкратный тариф для сотрудника;
        Position directorPosition = new Position("Директор", Rates.getRateWithIndex(10)); // задаем десятикратный тариф для сотрудника;
        Position technicPosition = new Position("Техник", Rates.getSpecifiedRate(rate -> rate * 2.5)); // задаем произвольный тариф для сотрудника

        // Создаём сотрудников
        Employee programmer = new Employee(
                new Person("Василий", "Васильевич", "Васильев"),
                programmerPosition);

        Employee economist = new Employee(
                new Person("Василиса", "Васильевна", "Васильева"),
                economistPosition);

        Employee director = new Employee(
                new Person("Степан", "Степанович", "Степанов"),
                directorPosition);

        Employee technic = new Employee(
                new Person("Николай", "Николаевич", "Николаев"),
                technicPosition);

        // Выводим подробную информацию о сотрудниках
        EmployeeInform.showAllInfo(programmer);
        EmployeeInform.showAllInfo(economist);
        EmployeeInform.showAllInfo(director);
        EmployeeInform.showAllInfo(technic);

    }

}
