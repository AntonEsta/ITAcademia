package ru.academyit.javacore.lesson6.homework.task.employee;

import java.util.Objects;

public final class EmployeeInform {

    /**
     * Выводит подробную информацию о сотруднике
     *
     * @param e сотрудник организации информацию о котором необходимо вывести информацию.
     */
    public static void showAllInfo(Employee e) {
        if (Objects.isNull(e)) {
            System.out.println("Нет данных для вывода");
            return;
        }
        System.out.printf("ФИО: %s\n" +
                            "Должность: %s\n" +
                            "Ставка: %.2f\n" +
                            "\n",
                String.join(" ", e.getPerson().getLastName(), e.getPerson().getFirstName(), e.getPerson().getPatronymic()),
                e.getPosition().getTitle(),
                e.getPosition().getRate().getRate());
    }

}
