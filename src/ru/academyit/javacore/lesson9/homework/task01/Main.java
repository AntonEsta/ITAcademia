package ru.academyit.javacore.lesson9.homework.task01;

import ru.academyit.javacore.lesson9.homework.task01.util.PersonGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int INIT_STUDENT_LIST_SIZE = 10;
    private static final List<Student> students = new ArrayList<>(INIT_STUDENT_LIST_SIZE);

    enum helpMessages {
        MAIN,
        SORT
    }

    private static final Comparator<Student> studentComparatorByFio = Comparator.comparing(o -> (o.getPerson().getLastName() +
            o.getPerson().getFirstName() +
            o.getPerson().getPatronymic()));

    private static final Comparator<Student> studentComparatorByGrade = Comparator.comparing(Student::getGrade);

    private static final Comparator<Student> studentComparatorByGradeDesc = Comparator.comparing(o -> (o.getGrade() * -1));

    public static void main(String[] args) throws IOException {

        fillingStudentList();

        System.out.println("Добро пожаловать!\nЯ готов с Вами работать:) Введите команду (LIST/SORT)");

        for (boolean exit = false; !exit; ) {
            System.out.print(" > ");
            switch (reader.readLine().toLowerCase().trim()) {
                case "list", "ls":
                    showAllStudentsList();
                    break;
                case "sort", "s":
                    System.out.println("По какому полю требуется сортировка?");
                    for (boolean sortExit = false; !sortExit; ) {
                        System.out.print("sort > ");
                        switch (reader.readLine().toLowerCase().trim()) {
                            case "fio", "f":
                                sortListByPerson();
                                System.out.println("Сортировка завершена.");
                                sortExit = true;
                                break;
                            case "grade", "g":
                                sortListByGradeDesc();
                                System.out.println("Сортировка завершена.");
                                sortExit = true;
                                break;
                            case "!grade", "!g":
                                sortListByGradeAsc();
                                System.out.println("Сортировка завершена.");
                                sortExit = true;
                                break;
                            case "help", "h":
                                showHelpMessage(helpMessages.SORT);
                                break;
                            case "quit", "q":
                                sortExit = true;
                                break;
                            default:
                                System.out.println("Данное поле не найдено. Введите fio/grade/!grade или 'help' для вывода справки по меню.");
                        }
                    }
                    break;
                case "help", "h":
                    showHelpMessage(helpMessages.MAIN);
                    break;
                case "quit", "q":
                    exit = true;
                    break;
                default:
                    System.out.println("Команда не найдена. Повторите ввод команды или воспользуйтесь справкой (help)");
            }

        }

    }

    /**
     * Выводит справку по командам по разделам.
     *
     * @param m раздел справки.
     */
    private static void showHelpMessage(helpMessages m) {
        String prefix = """
                \n-----------------------------
                Справка по командам программы.
                                
                Понять что Вы находитесь в основном меню программы можно по приветствию в начале строки ввода команды.
                В главном меню отсутствует указание подменю программы ( > ),
                тогда как, например, в подменю сортировки будет отображаться название подменю (sort > ).
                                
                """;
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        switch (m) {
            case MAIN:
                builder.append(""" 
                        В главном меню доступны следующие команды:
                        list (ls) - вывод списка студентов;
                        sort (s) - вход в меню сортировки списка студентов;
                        help (h) - вывод справки по разделу;
                        quit (q) -завершение работы с программой."""
                );
                break;
            case SORT:
                builder.append(""" 
                        В меню сортировки доступны следующие команды:
                        fio (f) - сортировка списка студентов по ФИО;
                        grade (g) - сортировка списка студентов по среднему баллу по убыванию значания;
                        !grade (!g) - сортировка списка студентов по среднему баллу по возрастанию значения;
                        help (h) - вывод справки по разделу;
                        quit (q) -завершение работы с программой."""
                );
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + m);
        }
        builder.append("\n-----------------------------\n");
        System.out.println(builder);
    }

    /**
     * Сортировка списка студентов по ФИО
     */
    private static void sortListByPerson() {
        students.sort(studentComparatorByFio);
    }

    /**
     * Сортировка списка студентов по ср. балу
     */
    private static void sortListByGradeAsc() {
        students.sort(studentComparatorByGrade);
    }

    /**
     * Сортировка списка студентов по ср. балу (по убыванию)
     */
    private static void sortListByGradeDesc() {
        students.sort(studentComparatorByGradeDesc);
    }

    /**
     * Выводит список студдентов и их рейтинги
     */
    private static void showAllStudentsList() {
        StringBuilder builder = new StringBuilder();
        for (Student student : Main.students) {
            builder.append(student.getPerson().getLastName());
            builder.append(" ");
            builder.append(student.getPerson().getFirstName());
            builder.append(" ");
            builder.append(student.getPerson().getPatronymic());
            builder.append(" ");
            builder.append(String.format("grade = %.2f", student.getGrade()));
            builder.append("\n");
        }
        System.out.println(builder);
    }

    /**
     * Запонение таблицы студентов тестовыми данными
     */
    private static void fillingStudentList() {
        System.out.println("Запонение таблицы студентов тестовыми данными...");
        for (int i = 1; i < Main.INIT_STUDENT_LIST_SIZE + 1; i++) {
            System.out.print("\rЗаполнение " + (int) ((double) i / Main.INIT_STUDENT_LIST_SIZE * 100) + '%');
            Main.students.add(new Student(new PersonGenerator().generate(), Math.random() * (5 - 1) + 1));
        }
        System.out.println("\n");
    }

}
